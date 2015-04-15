package applet;

//import it.lisit.siss.http.HTTPUtil;
//import it.lisit.siss.http.client.HTTPClient;

import java.security.AccessController;
import java.security.PrivilegedAction;

import java.text.DateFormat;
import java.util.Date;
import java.applet.Applet;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



public class JSApplet extends Applet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JSApplet () {
	}
		
	public static void Main (String[] args){
	}
	
	public String Test() {
		String ris = DateFormat.getDateInstance().format(new Date());
		ris += " - " + DateFormat.getTimeInstance().format(new Date().getTime());
		return ris;
	}

	public String sendSoapToSebContainer(String inputSoap){
		final String soap = inputSoap;
		return (String) AccessController.doPrivileged(new PrivilegedAction<String>() {
			public String run() {
				String retval = "";
				try {
					URL url = new URL("http://127.0.0.1:8000");
					HttpURLConnection connection = (HttpURLConnection) url.openConnection();
					connection.setDoOutput(true);
					connection.setRequestMethod("POST");
					connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
					connection.setRequestProperty("charset", "UTF-8");
					connection.setRequestProperty("Content-Length", Integer.toString(soap.getBytes().length));
					connection.setUseCaches(false);
					 
					DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
					wr.writeBytes(soap);
					wr.flush();
					wr.close();
					 
					//Get Response	
					InputStream is = connection.getInputStream();
					BufferedReader rd = new BufferedReader(new InputStreamReader(is));
					String line;
					StringBuffer response = new StringBuffer(); 
			     	while((line = rd.readLine()) != null) {
			     		response.append(line);
				        response.append('\r');
			     	}
			     	rd.close();
			     	retval = response.toString();								
				} catch(Throwable e){
					retval = String.valueOf(e.getStackTrace().length);
					for(int j = 0; j < e.getStackTrace().length; j++)
						retval += e.getStackTrace()[j].toString();
					retval += e.getCause();
				}
				
				if(retval == ""){
					retval = "Non Disponibile";
				}
				return retval;
			}
		});
	}
	
/*	public String sendSoapToSebContainer(String inputSoap){
		final String soap = inputSoap;
		return (String) AccessController.doPrivileged(new PrivilegedAction<String>() {
			public String run() {
				String retval = "";
				try {
					//HTTPClient httpClient = new HTTPClient("http://127.0.0.1:8000", inputSoap, null, null, "", null, HTTPUtil.ContentType.TEXT_XML, HTTPUtil.RequestMethod.POST);
					
					HTTPClient httpClient = new HTTPClient("http://127.0.0.1:8000");//, inputSoap, null, null, "", null, HTTPUtil.ContentType.TEXT_XML, HTTPUtil.RequestMethod.POST);
					httpClient.setInputData(soap);
					httpClient.setContentType(HTTPUtil.ContentType.TEXT_XML);
					httpClient.setRequestMethod(HTTPUtil.RequestMethod.POST);
					
					retval = httpClient.executeCall();
							
				} catch(Throwable e){
					retval = String.valueOf(e.getStackTrace().length);
					for(int j = 0; j < e.getStackTrace().length; j++)
						retval += e.getStackTrace()[j].toString();
					retval += e.getCause();
				}
				
				if(retval == ""){
					retval = "Non Disponibile";
				}
				return retval;
			}
		});
	}*/
	
	// HTTP POST request
	/*
	private void sendPost(String soap) throws Exception {
 
		String url = "https://selfsolve.apple.com/wcResults.do";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		//add request header
		con.setRequestMethod("POST");
		 
		String urlParameters = "sn=" + soap;
 
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		System.out.println(response.toString());
 
	}
	*/
	
	/*
	public String sendSoapToSebContainer(String inputSoap){
		final String soap = inputSoap;
				
		String retval = "";
		try {
			
			URL url = new URL("http://127.0.0.1:8000");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("charset", "UTF-8");
			connection.setRequestProperty("Content-Length", Integer.toString(soap.getBytes().length));
			connection.setUseCaches(false);
			 
			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes(soap);
			wr.flush();
			wr.close();
			 
			//Get Response	
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String line;
			StringBuffer response = new StringBuffer(); 
	     	while((line = rd.readLine()) != null) {
	     		response.append(line);
		        response.append('\r');
	     	}
	     	rd.close();
	     	retval = response.toString();			
					
		} catch(Throwable e){
			retval = String.valueOf(e.getStackTrace().length);
			for(int j = 0; j < e.getStackTrace().length; j++)
				retval += e.getStackTrace()[j].toString();
			retval += e.getCause();
		}
		
		if(retval == ""){
			retval = "Non Disponibile";
		}
		return retval;
		
	}
	*/
}
