package la.foton.sonar.principal.batch;

import java.io.IOException;
import java.util.Map;

import la.foton.sonar.LeitorUtil.LeitorDeClasses;
import la.foton.sonar.inicializador.Inicializador;
import la.foton.sonar.principal.MetricasSonar;
import la.foton.sonar.propriedades.PluginProperties;
import la.foton.sonar.util.AnalyseFileUtil;
import la.foton.sonar.util.SingletonClass;

import org.apache.bcel.classfile.JavaClass;
import org.apache.maven.project.MavenProject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.Decorator;
import org.sonar.api.batch.DecoratorContext;
import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.measures.Measure;
import org.sonar.api.measures.MeasureUtils;
import org.sonar.api.resources.Project;
import org.sonar.api.resources.Resource;
import org.sonar.api.resources.ResourceUtils;

import com.google.gson.Gson;

public class LinesMethodsDecorator implements Decorator {
	private static final Logger LOG = LoggerFactory
			.getLogger(LinesMethodsDecorator.class);
	private String projectGroupId;
	private String produtoGroupId;
	private MavenProject mavenProject;
	private FileSystem fileSystem;
	private Map<String, JavaClass> classMap;

	public LinesMethodsDecorator(FileSystem fileSystem,
			MavenProject mavenProject) {
		this.fileSystem = fileSystem;
		this.mavenProject = mavenProject;
		this.projectGroupId = mavenProject.getGroupId();
		this.produtoGroupId = PluginProperties.getInstance().get(
				this.projectGroupId);
	}

	@Override
	public boolean shouldExecuteOnProject(Project project) {
		return true;
	}

	@Override
	public void decorate(Resource resource, DecoratorContext context) {
		// This method is executed on the whole tree of resources.
		// Bottom-up navigation : Files -> Dirs -> modules -> project
		// inicio do meu código

		InputFile inputFile;
		String fileString = null;
		if (ResourceUtils.isFile(resource)) {
			// Sonar API includes many libraries like commons-lang and
			// google-collections
			try {
				LOG.info("-->Coletando path do arquivo");
				inputFile = fileSystem.inputFile(fileSystem.predicates()
						.hasRelativePath(resource.getPath()));
				if (inputFile != null) {					
					LeitorDeClasses leitorDeClasses = new LeitorDeClasses(inputFile.absolutePath(),this.mavenProject);
					leitorDeClasses.metodoInfo();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			Gson gson = new Gson();
			context.saveMeasure(new Measure<String>(
					MetricasSonar.QTD_LINHAS_METODOS, gson
							.toJson(SingletonClass.getMetodos())));
			SingletonClass.getMetodos().clear();
		}
	}

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}

}
