/*
 * Decompiled with CFR 0.152.
 */
package event;

import data.dto.api.ApiDTO;
import data.dto.event.SaraminResponseXml;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import view.ResultTableComponents;

@Slf4j
@Component
public class RESTApiListener {
	
    ResultTableComponents panel;

    public RESTApiListener(ResultTableComponents panel) {
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
            context = JAXBContext.newInstance((Class[])new Class[]{SaraminResponseXml.class});
            unmarshaller = context.createUnmarshaller();
            jobSearch = (SaraminResponseXml)unmarshaller.unmarshal((Reader)new StringReader(result));
        }
        catch (Exception exception) {
        	for(StackTraceElement e : exception.getStackTrace()) {
        		log.error(e.toString());
        	}
        }
        log.debug("url : " + event.apiUrl());
        jobSearch.setRequest((ApiDTO)event.getDto());
        this.panel.setXmlString(jobSearch);
    }
}

