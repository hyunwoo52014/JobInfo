package works.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import works.model.ResultAllData;
import works.model.URLParameter;
import works.model.sub.ResultViewData;
import works.task.sub.command.GetParameterCommand;

public class GetDataFromAPI implements Callable<ResultAllData> {

	private GetParameterCommand processing;
	private URLParameter param;

	public GetDataFromAPI(GetParameterCommand urlParam) {
		this.processing = urlParam;
	}
	
	@Override
	public ResultAllData call() throws Exception {
		ResultAllData result = getData();
		return result;
	}

	public ResultAllData getData() {
		InputStream data = null;
		Document doc = null;
		ResultAllData result = null;
		try {
			data = getStreamData();
			doc = getResultXMLFile(data);
			result = getTargetData(doc);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ResultAllData getTargetData(Document doc){
		Element root = doc.getDocumentElement();
		NodeList list = root.getElementsByTagName("job");
		ResultAllData allData = new ResultAllData();

		allData.setCurrentPos(root.getFirstChild().getAttributes().item(1).getTextContent());
		allData.setTotalCount(root.getFirstChild().getAttributes().item(2).getTextContent());
		allData.setURLParameter(this.param);
		
		for(int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			NodeList childList = node.getChildNodes();
			ResultViewData elementData = new ResultViewData();
			
			for(int j = 0; j < childList.getLength(); j++) {
				Node childNode = childList.item(j);
				
				if(childNode.getNodeName().equalsIgnoreCase("company")) {
					NodeList companyNodeList = childNode.getChildNodes();
					
					elementData.setCompanyName(companyNodeList.item(0).getTextContent());
					
					if(companyNodeList.item(0).getAttributes().getLength() > 0) {
						String url = companyNodeList.item(0).getAttributes().item(0).getTextContent();
						elementData.setCompanyInfoUrl(url);
					} else {
						elementData.setCompanyInfoUrl("");
					}
					
				}
				
				if(childNode.getNodeName().equalsIgnoreCase("position")) {
					NodeList positionNodeList = childNode.getChildNodes();
					
					elementData.setRecruitmentTitle(positionNodeList.item(0).getTextContent());
					elementData.setLocalTag(positionNodeList.item(1).getTextContent().replace("&gt;", ""));
					elementData.setJobType(positionNodeList.item(2).getTextContent());
					elementData.setExperienceLevel(positionNodeList.item(5).getTextContent());
					elementData.setRequiredEducationLevel(positionNodeList.item(6).getTextContent());
					
				}
				
				if(childNode.getNodeName().equalsIgnoreCase("posting-timestamp")) {
					elementData.setPostingTimestamp(childNode.getTextContent());
				}
				
				
				if(childNode.getNodeName().equalsIgnoreCase("expiration-timestamp")) {
					elementData.setExpirationTimestamp(childNode.getTextContent());
				}
				
				if(childNode.getNodeName().equalsIgnoreCase("url")) {
					elementData.setRecruitmentUrl(childNode.getTextContent());
				}
				
			}
			allData.addResultViewData(elementData);
		}
		
		return allData;
	}
	
	public Document getResultXMLFile(InputStream is) throws ParserConfigurationException, SAXException, IOException {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse(is);
		return document;
		
	}
	
	public InputStream getStreamData() throws IOException {
		
		URL url = new URL("https://oapi.saramin.co.kr/job-search?access-key="+getApiKey()+getParameter());
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setConnectTimeout(1000);
		con.setReadTimeout(1000);
		con.setRequestProperty("Accept", "application/xml");
		con.setRequestMethod("GET");
		
		InputStream is = con.getInputStream();
		
		return is;
	}
	
	public String getApiKey() {
		BufferedReader in = null;
		String s = null;
		try {
			in = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/apikey.txt"), "UTF-8"));
			s = in.readLine();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return s;
	}
	
	public String getParameter() throws UnsupportedEncodingException {
		
		this.param = this.processing.getParameter();
		
		return this.param.getURLParameter();
	}
	
}