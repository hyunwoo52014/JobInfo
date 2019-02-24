package openapi.generator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class OpenApiUrlReaderTest {
	
	@Test
	void testGenerate() {
	}

	@Test
	void testGetXmlData() {
		OpenApiUrlReader uw = new OpenApiUrlReader();
		uw.setUrl("http://api.saramin.co.kr/job-search?loc_cd=101000&count=1");
		uw.generate();
		System.out.println(uw.getXmlData());
	}

}