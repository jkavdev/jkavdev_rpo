package la.foton.sonar.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import la.foton.modelo.Metodo;
import la.foton.sonar.dao.DependenciaArquivoDao;
import la.foton.sonar.dao.DependenciaDao;
import la.foton.sonar.dao.FactoryDependenciaDao;
import la.foton.sonar.principal.batch.LInesMethodsSensor;

import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;
import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SimpleName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnalyseFileUtil {
	private static final Logger LOG = LoggerFactory
			.getLogger(AnalyseFileUtil.class);

	private static final Charset CHARSET = Charset.defaultCharset();

	public static String getStringFromFile(String path) throws IOException {
		if (!(new File(path).exists()))
			return null;
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, CHARSET);
	}

	public static Map<String, JavaClass> populateClassMap(
			MavenProject mavemProject) {
		Map<String, JavaClass> map = new HashMap<String, JavaClass>();

		try {
			DependenciaDao dependencyDAO = FactoryDependenciaDao
					.createNewDependencyDAO();

			for (Dependency dependency : mavemProject.getDependencies()) {
				System.out.println("->>>>>" + dependency.getArtifactId());
				File file = dependencyDAO.getDependency(dependency);
				JarFile jarFile = new JarFile(file);

				Enumeration<JarEntry> entries = jarFile.entries();

				while (entries.hasMoreElements()) {
					JarEntry jarEntry = (JarEntry) entries.nextElement();
					if (!jarEntry.getName().endsWith(".class"))
						continue;

					ClassParser parser = new ClassParser(
							file.getAbsolutePath(), jarEntry.getName());
					JavaClass javaClass = parser.parse();
					// System.out.println(javaClass.getClassName());
					map.put(javaClass.getClassName(), javaClass);
				}

				jarFile.close();
				// }
			}

		} catch (IOException e) {
			// LOG.error("Erro ao realizar a leitura dos artefatos.", e);
		}

		return map;
	}

	public static MavenProject getMavenProjectFromPath(String file)
			throws IOException, XmlPullParserException {
		File pomFile = new File(file);
		MavenProject ret = null;
		MavenXpp3Reader mavenReader = new MavenXpp3Reader();

		if (pomFile != null && pomFile.exists()) {
			FileReader reader = null;

			try {
				reader = new FileReader(pomFile);
				Model model = mavenReader.read(reader);
				model.setPomFile(pomFile);

				ret = new MavenProject(model);
			} finally {
				reader.close();
			}
		}

		return ret;
	}

	public static void calculateAndSaveNumberMethodsFromFile(String path)
			throws IOException {
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		String codigo = Utils.getStringFromFile(path);
		codigo = RegexUtils.removeComments(codigo);

		parser.setSource(codigo.toCharArray());
		LOG.info("-->Iniciando o CompilationUnit");
		final CompilationUnit comp = (CompilationUnit) parser.createAST(null);
		
		comp.accept(new ASTVisitor() {
			public boolean visit(MethodDeclaration node) {
				LOG.info("-->Coletando nome do metodo ");
				SimpleName name = node.getName();
				int qtdLinhas = 0;
				LOG.info("-->Coletando quantidade de linhas do metodo.");
				if (node.getBody() == null) {
					LOG.info("-->Metodo:" + name + " na linha:"
							+ comp.getLineNumber(name.getStartPosition())+ "Linhas: 0");
					qtdLinhas = 0;
				} else {
					qtdLinhas = (node.getBody().toString().split("\n").length - 2);
					LOG.info("-->Metodo:" + name + " na linha:"
							+ comp.getLineNumber(name.getStartPosition())
							+ " Linhas: " + qtdLinhas + "\n");
				}
				Metodo metodo = new Metodo(name.toString(), qtdLinhas);
				SingletonClass.addValue(metodo);
				return false; 
			}
		});
		
	}
	
}
