package batch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
	
	private static final String ES_OPT = "elasticsearch";
	
	public static void main(String[] args) throws IOException {
		
		
		System.out.println("args:" + args.length);
		for (String string : args) {
			System.out.println("arg:" + string);
		}
		
		if (args.length == 0) {
			System.out.println("Hello from batch");
		} else if (args.length == 2 && ES_OPT.equals(args[0])) {
			sendGet(args[1]);
		}
	}
	
	private static void sendGet(String url) throws IOException {
		System.out.println("URL:" + url);

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
			
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			
			//print result
			System.out.println(response.toString());
		}
	}
}