package demo.REST.HTTP.Client;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class HTTP_Client {
	
	public void getCall(String url) throws ClientProtocolException, IOException {
	CloseableHttpClient	httpClient = HttpClients.createDefault();
	// REST GET call
	HttpGet getCall = new HttpGet(url);
	CloseableHttpResponse response = httpClient.execute(getCall);
	int statusCode = response.getStatusLine().getStatusCode();
	System.out.println("Status code is: " + statusCode);
	
	String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
	
	JSONObject responseJSON = new JSONObject(responseString);
	System.out.println("API Response JSON: " + responseJSON);
	
	}

}
