package xml.Interpreter;

import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XMLInterpreter {
	
	public String[][] getjobs(String xmldata) {
		try {
			InputSource is = new InputSource(new StringReader(xmldata));
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
			XPath xpath = XPathFactory.newInstance().newXPath();
			NodeList jobs = (NodeList)xpath.evaluate("//job", document, XPathConstants.NODESET);
			ArrayList<String[]> data = new ArrayList<String[]>();
			for(int i=0; i<jobs.getLength(); i++) {
				data.add(new String[]{
						String.valueOf(i),																	// 순서
						jobs.item(i).getChildNodes().item(17).getChildNodes().item(1).getTextContent(),		// 기업명
						jobs.item(i).getChildNodes().item(19).getChildNodes().item(1).getTextContent(),		// 공고제목
						jobs.item(i).getChildNodes().item(19).getChildNodes().item(3).getTextContent(),		// 지역
						jobs.item(i).getChildNodes().item(19).getChildNodes().item(5).getTextContent(),		// 근무형태
						jobs.item(i).getChildNodes().item(19).getChildNodes().item(13).getTextContent(),	// 경력
						jobs.item(i).getChildNodes().item(19).getChildNodes().item(15).getTextContent(),	// 학력
						jobs.item(i).getChildNodes().item(23).getTextContent()								// 연봉
						});
			}
			return data.toArray(new String[][] {});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
