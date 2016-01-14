package la.foton.sonar.inicializador;



import la.foton.sonar.dao.DependenciaDao;
import la.foton.sonar.dao.FactoryDependenciaDao;
import la.foton.sonar.propriedades.PluginProperties;

import org.apache.maven.model.Dependency;
import org.apache.maven.project.MavenProject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.Initializer;
import org.sonar.api.resources.Project;

public class Inicializador{

	private static final Logger LOG = LoggerFactory.getLogger(Inicializador.class);
	
	private MavenProject mavenProject;
	
	public Inicializador(MavenProject mavenProject) {
		this.mavenProject = mavenProject;
	}
	
	public void execute() {
		DependenciaDao dependencyDAO = FactoryDependenciaDao.createNewDependencyDAO();
		
		LOG.info("---------------------------------------------------");
		LOG.info("Inicio da analise, informações abaixo:");
		LOG.info(mavenProject.getGroupId());
		LOG.info(mavenProject.getArtifactId());
		LOG.info(mavenProject.getVersion());
		LOG.info(mavenProject.getPackaging());
		LOG.info("---------------------------------------------------");		
		LOG.info("Lista de dependencias:");
		for (Dependency dependency : mavenProject.getDependencies()){
			if(dependency.getGroupId().equals(PluginProperties.getInstance().get(mavenProject.getGroupId()))){
				LOG.info(dependency.getArtifactId()+ "...");
				dependencyDAO.saveTempDependency(dependency);
			}
		}
		LOG.info("---------------------------------------------------");
		
		
	}
	
	
}
