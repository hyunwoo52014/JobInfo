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
	private String[][] tableData = null;
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
		
		System.out.println("0 "+jobs.item(0).getNodeName());	// 기업명
		System.out.println("1 "+jobs.item(0).getChildNodes().item(0));
		System.out.println("2 "+jobs.item(0).getChildNodes().item(1));
		System.out.println("3 "+jobs.item(0).getChildNodes().item(2));
		System.out.println("4 "+jobs.item(0).getChildNodes().item(3));
		System.out.println("5 "+jobs.item(0).getChildNodes().item(4));
		System.out.println("6 "+jobs.item(0).getChildNodes().item(5));
		System.out.println("7 "+jobs.item(0).getChildNodes().item(6));
		System.out.println("8 "+jobs.item(0).getChildNodes().item(7));
		System.out.println("9 "+jobs.item(0).getChildNodes().item(8));
		System.out.println("10 "+jobs.item(0).getChildNodes().item(9));
		System.out.println("11 "+jobs.item(0).getChildNodes().item(10));
		System.out.println("12 "+jobs.item(0).getChildNodes().item(11));
		System.out.println("13 "+jobs.item(0).getChildNodes().item(12));
		System.out.println("14 "+jobs.item(0).getChildNodes().item(13));
		System.out.println("15 "+jobs.item(0).getChildNodes().item(14));
		System.out.println("16 "+jobs.item(0).getChildNodes().item(15).getNodeName());
		System.out.println("17 "+jobs.item(0).getChildNodes().item(16));
		System.out.println("18 "+jobs.item(0).getChildNodes().item(17));
		System.out.println("19 "+jobs.item(0).getChildNodes().item(18));
		System.out.println("20 "+jobs.item(0).getChildNodes().item(19));
		System.out.println("21 "+jobs.item(0).getChildNodes().item(20));
		System.out.println("22 "+jobs.item(0).getChildNodes().item(21));
		System.out.println("23 "+jobs.item(0).getChildNodes().item(22));
		System.out.println("24 "+jobs.item(0).getChildNodes().item(23));
		System.out.println("25 "+jobs.item(0).getChildNodes().item(24));
		System.out.println("26 "+jobs.item(0).getChildNodes().item(25));
		System.out.println("27 "+jobs.item(0).getChildNodes().item(26));
		System.out.println("28 "+jobs.item(0).getChildNodes().item(27));
		System.out.println("29 "+jobs.item(0).getChildNodes().item(28));
		ArrayList<String[]> data = new ArrayList<String[]>();
		/*
		for(int i=0; i<jobs.getLength(); i++) {
			data.add(new String[]{String.valueOf(i),												// 순서
					jobs.item(i).getChildNodes().item(9).getNodeValue(),							// 기업명
					jobs.item(i).getChildNodes().item(10).getChildNodes().item(0).getNodeValue(),	// 공고제목
					jobs.item(i).getChildNodes().item(10).getChildNodes().item(1).getNodeValue(),   // 지역
					jobs.item(i).getChildNodes().item(10).getChildNodes().item(2).getNodeValue(),	// 근무형태
					jobs.item(i).getChildNodes().item(10).getChildNodes().item(3).getNodeValue(),	// 모집인원
					jobs.item(i).getChildNodes().item(10).getChildNodes().item(4).getNodeValue(),	// 경력
					jobs.item(i).getChildNodes().item(10).getChildNodes().item(5).getNodeValue()	// 학력
					});
			
		}
		*/
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
