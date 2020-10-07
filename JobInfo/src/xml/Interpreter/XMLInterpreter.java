package xml.Interpreter;

import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
 
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XMLInterpreter {
	
	private ArrayList<String[]> tabledata;
	private ArrayList<String[]> hyperlinkdata;
	private String total = null;
	public XMLInterpreter() {
		this.tabledata = new ArrayList<String[]>();
		this.hyperlinkdata = new ArrayList<String[]>();
	}
	
	public void getjobs(String xmldata) {
		try {
			InputSource is = new InputSource(new StringReader(xmldata));
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
			XPath xpath = XPathFactory.newInstance().newXPath();
			
			NodeList jobs = (NodeList)xpath.evaluate("//job", document, XPathConstants.NODESET);
			Node head = (Node)xpath.evaluate("//jobs", document,XPathConstants.NODE);
			
			this.tabledata.clear();
			this.hyperlinkdata.clear();
			
			for(int i=0; i<jobs.getLength(); i++) {
				this.tabledata.add(new String[]{
						String.valueOf(i+1),																// 순서
						jobs.item(i).getChildNodes().item(10).getChildNodes().item(0).getTextContent(),		// 기업명
						jobs.item(i).getChildNodes().item(11).getChildNodes().item(0).getTextContent(),		// 공고제목
						jobs.item(i).getChildNodes().item(11).getChildNodes().item(1).getTextContent(),		// 지역
						jobs.item(i).getChildNodes().item(11).getChildNodes().item(2).getTextContent(),		// 근무형태
						jobs.item(i).getChildNodes().item(11).getChildNodes().item(7).getTextContent(),	// 경력
						jobs.item(i).getChildNodes().item(11).getChildNodes().item(8).getTextContent(),	// 학력
						jobs.item(i).getChildNodes().item(15).getTextContent()							// 연봉
						});
				this.hyperlinkdata.add(new String[] {
						jobs.item(i).getChildNodes().item(1).getTextContent(),							// 공고정보
						jobs.item(i).getChildNodes().item(10).getChildNodes().item(0).getAttributes().item(0).getTextContent() // 기업정보
				});
			}
			
			this.total = head.getAttributes().item(2).getTextContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String[][] getTabledata() {
		return this.tabledata.toArray(new String[][] {});
	}

	public String getJobInfoDatailLink(int index) {
		String[] temp = this.hyperlinkdata.get(index);
		return temp[0];
	}
	
	public String getCompanyLink(int index) {
		String[] temp = this.hyperlinkdata.get(index);
		return temp[1];
	}

	public String getTotal() {
		return this.total;
	}
}
