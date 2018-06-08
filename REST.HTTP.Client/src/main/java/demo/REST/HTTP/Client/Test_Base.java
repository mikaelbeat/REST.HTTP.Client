package demo.REST.HTTP.Client;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Test_Base {
	
	public Properties prop;
	
	public Test_Base(){
		prop = new Properties();
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\demo\\REST\\HTTP\\Client\\Config\\config.properties");
			prop.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
