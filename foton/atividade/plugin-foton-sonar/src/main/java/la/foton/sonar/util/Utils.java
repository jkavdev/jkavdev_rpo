package la.foton.sonar.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Utils {
	
private static final Charset CHARSET = Charset.defaultCharset();
	
	public static String getStringFromFile(String path) throws IOException 
	{
		if (!(new File(path).exists()))
			return null;
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, CHARSET);
	}
	
	public static String convertToNexusPath(String groupId, String artifactId, String version)
	{
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append(groupId.replaceAll("[.]", "/")).append("/")
					 .append(artifactId).append("/")
					 .append(version).append("/")
					 .append(getDefaultJarName(artifactId, version));
		
		return stringBuilder.toString();
	}

	public static String getDefaultJarName(String artifactId, String version)
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(artifactId).append("-").append(version).append(".jar");
		
		return stringBuilder.toString();
	}
}
