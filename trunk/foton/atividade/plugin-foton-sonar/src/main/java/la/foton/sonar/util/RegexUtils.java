package la.foton.sonar.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {
	private static final String COMMENT_REGEX = "//.*|(\"(?:\\\\[^\"]|\\\\\"|.)*?\")|(?s)/\\*.*?\\*/";
	private static final String CLASS_DECLARATION_REGEX = "\\s*(public|private)\\s+class\\s+(\\w+)\\s+((extends\\s+\\w+)|(implements\\s+\\w+( ,\\w+)*))?";
	private static final String EXCLUDE_CLASS_NAME_FROM_DECLARATION_REGEX = "(.*class\\s+)|(\\s+implements.*)|(\\s+extends.*)";
	private static final String EXCLUDE_CLASS_NAME_FROM_IMPORT = "(\\s*import\\s+)|(\\s*;)";
	private static final String METHOD_BODY_REGEX = "\\s*\\(";
	
	public static String removeComments (String fileString) 
	{
		return fileString.replaceAll(COMMENT_REGEX, "$1 ");
	}
	
	public static boolean isClassDeclaration (String code) 
	{
		return code.matches(CLASS_DECLARATION_REGEX);
	}
	
	public static String getOnlyClassName (String classDeclaration) 
	{
		return classDeclaration.replaceAll(EXCLUDE_CLASS_NAME_FROM_DECLARATION_REGEX, "");
	}
	
	public static String getImportRegex(String pack) 
	{
		return "import " + pack.replace(".", "[.]") + "[.].*";
	}
	
	public static String getCompleteClassName(String imprt)
	{
		return imprt.replaceAll(EXCLUDE_CLASS_NAME_FROM_IMPORT, "");
	}
	
	public static int getMethodUseCount(String methodName, String fileString) 
	{
		return regexMatchCount(methodName + METHOD_BODY_REGEX, fileString);
	}
	
	public static int regexMatchCount(String regex, String string) 
	{
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(string);
		
		int count = 0;
		while (matcher.find()) 
			++count;
		
		return count;
	}
	
}
