package demo.REST.HTTP.Client;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Test_Base {
	
	public Properties prop;
	
	public final int responseCode200 = 200;
	public final int responseCode201 = 201;
	public final int responseCode400 = 400;
	public final int responseCode500 = 500;
	public final int responseCode401 = 401;
	public final int responseCode404 = 404;
	
	
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