/*
 * Decompiled with CFR 0.152.
 */
package event;

import data.dto.api.ApiDTO;
import data.dto.event.RequestSaraminDTO;
import data.dto.event.RequestWork24DTO;
import data.dto.event.ResponseDTO;
import data.dto.event.SaraminResponseXml;
import data.dto.event.Work24ResponseXml;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import java.io.StringReader;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import view.bundle.panels.elements.ResultTablePanel;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RESTApiListener {
	
	ResultTablePanel panel;

    public RESTApiListener(ResultTablePanel panel) {
        this.panel = panel;
    }

    @Async
    @EventListener
    public void doRequestXmlString(SaraminRestApiEvent event) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().addHeader("Accept", event.getHeaderValue()).url(event.apiUrl()).build();
        Response response = null;
        String result = null;
        JAXBContext context = null;
        Unmarshaller unmarshaller = null;
        SaraminResponseXml jobSearch = null;
        try {
            response = client.newCall(request).execute();
            result = response.body().string();
            context = JAXBContext.newInstance(SaraminResponseXml.class);
            unmarshaller = context.createUnmarshaller();
            jobSearch = (SaraminResponseXml)unmarshaller.unmarshal(new StringReader(result));
        }
        catch (Exception exception) {
        	for(StackTraceElement e : exception.getStackTrace()) {
        		log.error(e.toString());
        	}
        }
        log.debug("url : " + event.apiUrl());
        jobSearch.setRequest((ApiDTO)event.getDTO());
        this.panel.setXmlString(jobSearch);
    }
    
    @Async
    @EventListener
    public void postRequestWork24XmlString(Work24RestApiEvent event) {
    	OkHttpClient client = new OkHttpClient();
    	Request request = new Request.Builder()
    					.url(event.apiUrl()).build();
    	Response response = null;
        String result = null;
        JAXBContext context = null;
        Unmarshaller unmarshaller = null;
        Work24ResponseXml work24xml = null;
    	try {
    		response = client.newCall(request).execute();
    		result = response.body().string();
    		context = JAXBContext.newInstance(Work24ResponseXml.class);
    		unmarshaller = context.createUnmarshaller();
    		work24xml = (Work24ResponseXml) unmarshaller.unmarshal(new StringReader(result));
    	} catch (Exception exception) {
    		for(StackTraceElement e : exception.getStackTrace()) {
        		log.error(e.toString());
        	}
    		log.error(exception.getLocalizedMessage() + " >:< " + exception.getMessage());
    	}
    	
    	log.debug("url : " + event.apiUrl());
    	work24xml.setRequest((ApiDTO)event.getDTO());
        this.panel.setXmlString(work24xml);
    }
    
    @Async
    @EventListener
    public void pageMove(PageMoveEvent pageMove) {
    	ResponseDTO dto;
    	if(pageMove.getDirection()) {
    		dto = pageMove.nextPageMove();
    		redirectionApiCall(dto);
    	} else {
    		dto = pageMove.previousPageMove();
    		redirectionApiCall(dto);
    	}
    }
    
    private void redirectionApiCall(ResponseDTO dto) {
    	if(dto instanceof SaraminResponseXml) {
    		RequestSaraminDTO request = (RequestSaraminDTO) dto.getRequest();
        	doRequestXmlString(new SaraminRestApiEvent(this, request));
    	}
    	
    	if(dto instanceof Work24ResponseXml) {
    		RequestWork24DTO request = (RequestWork24DTO) dto.getRequest();
        	postRequestWork24XmlString(new Work24RestApiEvent(this, request));
    	}
    }
}