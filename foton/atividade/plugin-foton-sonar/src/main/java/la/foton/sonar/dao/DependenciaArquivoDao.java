package la.foton.sonar.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import la.foton.sonar.propriedades.PluginProperties;
import la.foton.sonar.util.Utils;

import org.apache.commons.io.FileUtils;
import org.apache.maven.model.Dependency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DependenciaArquivoDao implements DependenciaDao{
	private static final Logger LOG = LoggerFactory.getLogger(DependenciaArquivoDao.class);

	public static final String NEXUS_REPO_ADDR = "http://172.25.1.241:8081/nexus/service/local/repositories/internal/content/";
	public static final String TEMP_FOLDER = "temp";
	public static final String TEMP_PATH = PluginProperties.getInstance().getWorkPath() + File.separator + TEMP_FOLDER;

	public DependenciaArquivoDao() {
		verifyFolder();
	}
	
	@Override
	public File getDependency(Dependency dependency) {
		File file = new File(TEMP_PATH + File.separator + Utils.getDefaultJarName(dependency.getArtifactId(), dependency.getVersion()));
		return file;
	}

	@Override
	public void saveTempDependency(Dependency dependency) {
		try {
			String path = NEXUS_REPO_ADDR + Utils.convertToNexusPath(dependency.getGroupId(), dependency.getArtifactId(), dependency.getVersion());
			URL dependencyPath = new URL(path);

			ReadableByteChannel rbc = Channels.newChannel(dependencyPath.openStream());
			File file = getDependency(dependency);
			LOG.info("GGGGGGG----"+path);
			if(!file.exists()) {
				FileOutputStream fos = new FileOutputStream(file.getAbsolutePath());
				fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
				fos.close();
			}
			
			rbc.close();
		} catch (IOException e) {
			LOG.error("Erro ao baixar artefato", e);
		}
	}

	private void verifyFolder() {
		File file = new File(TEMP_PATH);
		if (!file.exists())
			file.mkdir();
	}
	
	@Override
	public void clear() {
		try {
			FileUtils.deleteDirectory(new File(TEMP_PATH));
		} catch (IOException e) {
			LOG.error("Erro ao deletar pasta temporária '" + TEMP_PATH +  "'", e);
		}
	}
}
