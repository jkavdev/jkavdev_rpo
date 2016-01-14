package la.foton.sonar.dao;



public class FactoryDependenciaDao {
	public static DependenciaDao createNewDependencyDAO() {
		return new DependenciaArquivoDao();
	}
}
