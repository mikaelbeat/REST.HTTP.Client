package demo.REST.HTTP.Client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class HTTP_Client {
	
	public CloseableHttpResponse getCall(String url) throws ClientProtocolException, IOException {
		
	CloseableHttpClient	httpClient = HttpClients.createDefault();
	
	// REST GET call
	HttpGet getCall = new HttpGet(url);
	CloseableHttpResponse response = httpClient.execute(getCall);
	
	return response;
	
//	// Extract response code
//	int statusCode = response.getStatusLine().getStatusCode();
//	System.out.println("Status code is: " + statusCode);
//	
//	String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
//	
//	JSONObject responseJSON = new JSONObject(responseString);
//	System.out.println("API Response JSON: " + responseJSON);
//	
//	
//	// Getting response headers
//	Header[] responseHeaders = response.getAllHeaders();
//	
//	HashMap<String, String> headerAll = new HashMap<String, String>();
//	
//	for (Header header : responseHeaders) {
//		headerAll.put(header.getName(), header.getValue());
//	}
//	
//	System.out.println("All headers are: " + headerAll);
	
	}
}