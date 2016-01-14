package la.foton.sonar.principal.batch;


import la.foton.sonar.principal.MetricasSonar;
import la.foton.sonar.principal.PluginFotonAnalise;
import la.foton.sonar.util.ProjectNameSplitter;

import org.apache.maven.project.MavenProject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.Sensor;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.config.Settings;
import org.sonar.api.measures.Measure;
import org.sonar.api.resources.Project;

public class LInesMethodsSensor implements Sensor {

  private static final Logger LOG = LoggerFactory.getLogger(LInesMethodsSensor.class);

  private Settings settings;
  private FileSystem fs;
  private MavenProject mavenProject;

  /**
   * Use of IoC to get Settings and FileSystem
   */
  public LInesMethodsSensor(Settings settings, FileSystem fs) {
    this.settings = settings;
    this.fs = fs;
  }

  @Override
  public boolean shouldExecuteOnProject(Project project) {
    // This sensor is executed only when there are Java files
    return fs.hasFiles(fs.predicates().hasLanguage("java"));
  }

  @Override
  public void analyse(Project project, SensorContext sensorContext) {
    // This sensor create a measure for metric MESSAGE on each Java file
    String value = settings.getString(PluginFotonAnalise.MY_PROPERTY);
    LOG.info(PluginFotonAnalise.MY_PROPERTY + "=" + value);
    
    ProjectNameSplitter projectNameSplitter = new ProjectNameSplitter(mavenProject.getName());
 	//if (settings.getString(ExamplePlugin.GROUPID) == null)
 	settings.setProperty(PluginFotonAnalise.GROUPID, mavenProject.getGroupId());
 	value = settings.getString(PluginFotonAnalise.GROUPID);
 	LOG.info(PluginFotonAnalise.GROUPID + "=KKKK " + value);
    
//    for (InputFile inputFile : fs.inputFiles(fs.predicates().hasLanguage("java"))) {
//      sensorContext.saveMeasure(inputFile, new Measure<String>(MetricasSonar.MESSAGE, value));
//    }
//    
    
    
 
//	if (configuracoes.getString(PluginMain.CLIENTE) == null)
//		configuracoes.setProperty(PluginMain.CLIENTE, projectNameSplitter.getCliente());
//	if (configuracoes.getString(PluginMain.PRODUTO) == null)
//		configuracoes.setProperty(PluginMain.PRODUTO, projectNameSplitter.getProduto());

    
  }
  public LInesMethodsSensor(Settings configuracoes, FileSystem sistemaArquivo, MavenProject mavenProject) {
		this.mavenProject = mavenProject;
		this.settings = configuracoes;
		this.fs = sistemaArquivo;
		
		LOG.info("Instanciando novo objeto de ImportsCounterSensor.");
	}

  @Override
  public String toString() {
    return getClass().getSimpleName();
  }

}
