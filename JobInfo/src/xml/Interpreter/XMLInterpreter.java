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
	private ArrayList<String[]> detaildata;
	
	public XMLInterpreter() {
		this.tabledata = new ArrayList<String[]>();
		this.detaildata = new ArrayList<String[]>();
	}
	
	public void getjobs(String xmldata) {
		try {
			InputSource is = new InputSource(new StringReader(xmldata));
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
			XPath xpath = XPathFactory.newInstance().newXPath();
			
			Node head = (Node)xpath.evaluate("//jobs", document, XPathConstants.NODE);
			System.out.println(head.getAttributes().item(0).getNodeName()
					+" "+head.getAttributes().item(0).getNodeValue()+" "+
					head.getAttributes().item(1).getNodeName()
					+" "+head.getAttributes().item(1).getNodeValue()+" "+
					head.getAttributes().item(2).getNodeName()
					+" "+head.getAttributes().item(2).getNodeValue()
					);
			NodeList jobs = (NodeList)xpath.evaluate("//job", document, XPathConstants.NODESET);
			
			this.tabledata.clear();
			this.detaildata.clear();
			
			for(int i=0; i<jobs.getLength(); i++) {
				this.tabledata.add(new String[]{
						String.valueOf(i),																	// 순서
						jobs.item(i).getChildNodes().item(8).getChildNodes().item(0).getTextContent(),		// 기업명
						jobs.item(i).getChildNodes().item(9).getChildNodes().item(0).getTextContent(),		// 공고제목
						jobs.item(i).getChildNodes().item(9).getChildNodes().item(1).getTextContent(),		// 지역
						jobs.item(i).getChildNodes().item(9).getChildNodes().item(2).getTextContent(),		// 근무형태
						jobs.item(i).getChildNodes().item(9).getChildNodes().item(6).getTextContent(),	// 경력
						jobs.item(i).getChildNodes().item(9).getChildNodes().item(7).getTextContent(),	// 학력
						jobs.item(i).getChildNodes().item(11).getTextContent()							// 연봉
						});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String[][] getTabledata() {
		return this.tabledata.toArray(new String[][] {});
	}

	public String[][] getDetaildata() {
		return this.detaildata.toArray(new String[][] {});
	}
	
}
