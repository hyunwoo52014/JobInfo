/*
 * Decompiled with CFR 0.152.
 */
package event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class JobListApiService {
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void saraminApiService(SaraminRestApiEvent event) {
        this.eventPublisher.publishEvent(event);
    }
    
    public void work24ApiService(Work24RestApiEvent event) {
    	this.eventPublisher.publishEvent(event);
    }
    
    public void pageMove(PageMoveEvent event) {
    	this.eventPublisher.publishEvent(event);
    }
}

