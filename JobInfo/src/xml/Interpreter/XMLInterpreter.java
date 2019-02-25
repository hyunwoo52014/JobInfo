package xml.Interpreter;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLInterpreter {
	private InputSource is = null;
	private Document document = null;
	private XPath xpath = null;
	
	public XMLInterpreter() {
		
	}
	
	public void init(String xmlData) {
		this.is = new InputSource(new StringReader(xmlData));
		try {
			this.document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
		this.xpath = XPathFactory.newInstance().newXPath();
	}
	
	public String[][] getjobs() {
		NodeList jobs = null;
		try {
			jobs = (NodeList)this.xpath.evaluate("//job", this.document, XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<String[]> data = new ArrayList<String[]>();
		for(int i=0; i<jobs.getLength(); i++) {
			data.add(new String[]{
					String.valueOf(i),																	// ����
					jobs.item(i).getChildNodes().item(17).getChildNodes().item(1).getTextContent(),		// �����
					jobs.item(i).getChildNodes().item(19).getChildNodes().item(1).getTextContent(),		// ��������
					jobs.item(i).getChildNodes().item(19).getChildNodes().item(3).getTextContent(),		// ����
					jobs.item(i).getChildNodes().item(19).getChildNodes().item(5).getTextContent(),		// �ٹ�����
					jobs.item(i).getChildNodes().item(19).getChildNodes().item(13).getTextContent(),	// ���
					jobs.item(i).getChildNodes().item(19).getChildNodes().item(15).getTextContent()		// �з�
					});
		}
		
		return data.toArray(new String[][] {});
	}
	
	public int getTotal() {
		Element el = null;
		try {
			el = (Element)this.xpath.evaluate("//jobs", this.document, XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Integer.valueOf(el.getAttribute("total"));
	}
}
