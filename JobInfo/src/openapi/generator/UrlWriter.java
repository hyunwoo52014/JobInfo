package openapi.generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlWriter {
	private URL url = null;
	private HttpURLConnection huc = null;
	private StringBuffer xmldata = null;
	public UrlWriter(String str) {
		try {
			this.url = new URL(str);
			this.huc.setRequestProperty("CONTENT-TYPE","text/xml");
			this.huc.setRequestMethod("GET");
			this.huc = (HttpURLConnection) this.url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		generate();
	}
	
	public void generate() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(this.huc.getInputStream(),"UTF-8"));
			String temp = null;
			while((temp = br.readLine())!=null) {
				this.xmldata.append(temp);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getXmlData() {
		return this.xmldata.toString();
	}
}
