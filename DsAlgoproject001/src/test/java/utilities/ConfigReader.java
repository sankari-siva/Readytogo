package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
static Properties prop;
private static String browserName = null;
public static Properties initializedProperties() throws IOException
{
	prop=new Properties();
	File inputFile=new File("src\\test\\resources\\config\\config.properties");
	FileInputStream fis;
	try {
		fis=new FileInputStream(inputFile);
		prop.load(fis);
	} catch(FileNotFoundException e)
	{
		e.printStackTrace();
	}
	return prop;
}
//public static String getBrowserName()
//{
//	String browserName=prop.getProperty("browser");
//	return browserName;
//}
public static void setBrowserType(String browser)
{
	browserName=browser;
}
public static String getBrowserType() throws Throwable {
	if (browserName != null)
		return browserName;
	else
		throw new RuntimeException("browser not specified in the testng.xml");
}
}
