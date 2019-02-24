package openapi.generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenApiUrlReader {
	private URL url = null;
	private HttpURLConnection huc = null;
	private BufferedReader br = null;
	private StringBuffer xmldata = null;
	public OpenApiUrlReader() {
	}
	
	public OpenApiUrlReader(String str) {
		setUrl(str);
	}
	
	public void generate() {
		try {
			this.br = new BufferedReader(new InputStreamReader(this.huc.getInputStream(),"UTF-8"));
			this.xmldata = new StringBuffer();
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

	public void setUrl(String str) {
		try {
			this.url = new URL(str);
			this.huc = (HttpURLConnection) this.url.openConnection();
			this.huc.setRequestProperty("CONTENT-TYPE","text/xml");
			this.huc.setRequestMethod("GET");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getUrl() {
		return this.url.toString();
	}
}
