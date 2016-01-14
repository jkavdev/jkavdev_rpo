package la.foton.sonar.propriedades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PluginProperties {
	private static final Logger LOG = LoggerFactory.getLogger(PluginProperties.class);
	private static final String PROPERTIES_FILE = "projects.properties";
	private static final String FOLDER_NAME = ".sonar";
	private static PluginProperties instance;
	private Properties properties;

	private PluginProperties() {
		try {
			this.properties = new Properties();
			this.properties.load(getFile());
			LOG.info("Arquivo de propriedades lido com sucesso: " + properties);
		} catch (IOException e) {
			LOG.error("Erro ao inicializar propriedades.", e);
		}
	}

	public String get(String key) {
		return getProperties().getProperty(key);
	}

	public void set(String key, String value) { 
		try {
			getProperties().setProperty(key, value);
			save();
		} catch (IOException e) {
			LOG.error("Erro ao salvar propriedade.", e);
		}
	}

	private InputStream getFile() throws IOException {
		File file = new File(getWorkPath() + PROPERTIES_FILE);
		if(!file.exists()){
			File folder = new File(getWorkPath());
			if (!(folder.exists()))
				folder.mkdir();
			file.createNewFile();
		}

		LOG.info("Properties file:" + file.getAbsolutePath());
		return new FileInputStream(file);
	}

	public static PluginProperties getInstance() {
		if (instance == null) {
			instance = new PluginProperties();
		}

		return instance;
	}

	public String getWorkPath(){
		return System.getProperty("user.home") + File.separator + FOLDER_NAME + File.separator;
		//CoreMetrics.
	}
	
	public Properties getProperties() {
		return properties;                                                                                                                                                                                                                                                                                                                                                                                                                                                            
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	public void save() throws IOException{
		OutputStream out = new FileOutputStream(new File(getWorkPath() + PROPERTIES_FILE));
		this.properties.store(out, "");
		out.close();
	}

}
