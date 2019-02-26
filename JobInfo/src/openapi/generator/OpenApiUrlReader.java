package openapi.generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class OpenApiUrlReader {

	public String generate(String str) {
		HttpURLConnection huc = null;
		BufferedReader br = null;
		StringBuffer xmldata = null;
		try {
			URL url = new URL(str);
			huc = (HttpURLConnection) url.openConnection();
			huc.setRequestProperty("CONTENT-TYPE","text/xml");
			huc.setRequestMethod("GET");
			xmldata = new StringBuffer();
			br = new BufferedReader(new InputStreamReader(huc.getInputStream(),"UTF-8"));
			String temp = null;
			while((temp = br.readLine())!=null) {
				xmldata.append(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				huc.disconnect();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return xmldata.toString();
	}
}
