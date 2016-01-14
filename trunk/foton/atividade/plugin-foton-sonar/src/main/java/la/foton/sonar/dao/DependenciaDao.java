package la.foton.sonar.dao;

import java.io.File;

import org.apache.maven.model.Dependency;

public interface DependenciaDao {
	public File getDependency(Dependency dependency);
	public void saveTempDependency(Dependency dependency);
	public void clear();
}
