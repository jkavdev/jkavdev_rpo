package la.foton.sonar.LeitorUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import la.foton.modelo.Metodo;
import la.foton.sonar.inicializador.Inicializador;
import la.foton.sonar.util.RegexUtils;
import la.foton.sonar.util.SingletonClass;
import la.foton.sonar.util.Utils;

import org.apache.maven.model.Dependency;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SimpleName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LeitorDeClasses {
	private static final Logger LOG = LoggerFactory
			.getLogger(LeitorDeClasses.class);
	private String path;
	private MavenProject mavenProject;
	
	public LeitorDeClasses(String path,MavenProject mavenProject) {
		this.mavenProject = mavenProject;
		this.path = path;
	}

	// Entra nas classes e busca informacoes dos metodos
	public void metodoInfo() throws IOException {
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		String codigo = Utils.getStringFromFile(path);
		codigo = RegexUtils.removeComments(codigo);

		parser.setSource(codigo.toCharArray());
		final CompilationUnit comp = (CompilationUnit) parser.createAST(null);

		comp.accept(new ASTVisitor() {
			public boolean visit(MethodDeclaration node) {
				LOG.info("-->Coletando nome do metodo ");
				SimpleName name = node.getName();
				int qtdLinhas = 0;
				LOG.info("-->Coletando quantidade de linhas do metodo.");
				if (node.getBody() == null) {
					/*LOG.info("-->Metodo:" + name + " na linha:"
							+ comp.getLineNumber(name.getStartPosition())
							+ "Linhas: 0");
					qtdLinhas = 0;
					*/
					File f = new File("C:/Documents and Settings/jhonatan.viana/Desktop/plugin.txt");
					try {
						f.createNewFile();
						FileWriter fw = new FileWriter(f,true);
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(node.getName().toString());
						bw.newLine();
						bw.close();
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}else{					
					qtdLinhas = (node.getBody().toString().split("\n").length - 2);
					LOG.info("-->Metodo:" + name + " na linha:"
							+ comp.getLineNumber(name.getStartPosition())
							+ " Linhas: " + qtdLinhas + "\n");				
					LOG.info("Dependencias \n");
					
					for(Dependency d : mavenProject.getDependencies()){
						LOG.info("Path:"+d.getSystemPath());
						LOG.info("Path:"+d.getArtifactId());
						LOG.info("Path:"+d.getGroupId());
					}					
				}
				Metodo metodo = new Metodo(name.toString(), qtdLinhas);
				SingletonClass.addValue(metodo);
				return false;
			}
		});

	}
}
