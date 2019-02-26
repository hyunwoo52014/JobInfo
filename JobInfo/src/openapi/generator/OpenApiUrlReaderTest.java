package openapi.generator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class OpenApiUrlReaderTest {
	
	private static OpenApiUrlReader uw = null;
	
	@BeforeAll
	static void init() {
		uw = new OpenApiUrlReader();
	}
	
	
	@Test
	void testGetXmlData() {
		uw.setUrl("http://api.saramin.co.kr/job-search?loc_cd=101000&count=1");
		uw.generate();
		System.out.println(uw.getXmlData());
	}

	@Test
	void testGetUrl() {
		assertEquals(" ",uw.getUrl());
	}
}