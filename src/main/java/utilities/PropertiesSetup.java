package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesSetup {
	Properties prop = new Properties();
	
	public PropertiesSetup() throws FileNotFoundException, IOException {
		prop.load(new FileInputStream("src//main//resources//Properties//config.properties"));
	}
	
	public String getPropertyFromConfig(String p) {
		return prop.getProperty(p, "missing");
	}
	
}
