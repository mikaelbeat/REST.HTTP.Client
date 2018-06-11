package demo.REST.HTTP.Client;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import demo.REST.HTTP.Client.Utils.Test_Utils;

public class Get_Call_Test extends Test_Base{
	
	Test_Base testBase;
	HTTP_Client driver;
	String APIURI;
	CloseableHttpResponse apiResponse;
	String responseValue;
	
	@BeforeTest
	public void setUp() {
		Test_Base testBase = new Test_Base();
		String URL = prop.getProperty("URI");
		String pathParam = prop.getProperty("ServiceURI");
		APIURI = URL + pathParam;
	}
	
	@Test
	public void Get_Call_Test() throws ClientProtocolException, IOException {
		driver = new HTTP_Client();
		apiResponse = driver.getCall(APIURI);
		System.out.println("Status code is: " + apiResponse.getStatusLine().getStatusCode());
		Assert.assertEquals(apiResponse.getStatusLine().getStatusCode(), responseCode200);
	}
	
	@Test
	public void Get_Call_Response_Test() throws ClientProtocolException, IOException {
		driver = new HTTP_Client();
		apiResponse = driver.getCall(APIURI);
		String responseString = EntityUtils.toString(apiResponse.getEntity(), "UTF-8");
		JSONObject responseJSON = new JSONObject(responseString);
		System.out.println("API Response JSON: " + responseJSON);
		
		responseValue = Test_Utils.getValueByJPath(responseJSON, "/per_page");
		Assert.assertEquals(responseValue, "3");
		Assert.assertEquals(Test_Utils.getValueByJPath(responseJSON, "/data[0]/first_name"), "George");
		Assert.assertEquals(Test_Utils.getValueByJPath(responseJSON, "/data[1]/last_name"), "Weaver");
		Assert.assertEquals(Test_Utils.getValueByJPath(responseJSON, "/data[2]/id"), "3");
	}
}