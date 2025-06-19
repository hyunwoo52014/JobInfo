package event;

import javax.swing.JOptionPane;

import org.springframework.context.ApplicationEvent;

import data.dto.api.ApiDTO;
import data.dto.event.RequestSaraminDTO;
import data.dto.event.RequestWork24DTO;
import data.dto.event.ResponseDTO;

public class PageMoveEvent extends ApplicationEvent {

	private static final long serialVersionUID = -7261557889133397655L;
	private ResponseDTO dto;
	private boolean direction;
	
	public PageMoveEvent(Object source, ResponseDTO dto, boolean direction) {
		super(source);
		this.dto = dto;
		this.direction = direction;
	}
	
	public ResponseDTO previousPageMove() {
		ApiDTO request = dto.getRequest();
		if(request instanceof RequestSaraminDTO) {
			int start = ((RequestSaraminDTO)request).getStart();
        	if(start <= 0) {
        		JOptionPane.showMessageDialog(null, "맨 첫번째 장입니다.");
        		return null;
        	}
        	((RequestSaraminDTO)request).setStart(--start);
		} else if(request instanceof RequestWork24DTO) {
			int startPage = ((RequestWork24DTO)request).getStartPage();
			if(startPage <= 1) {
	    		JOptionPane.showMessageDialog(null, "맨 첫번째 장입니다.");
	    		return null;
	    	}
	    	((RequestWork24DTO)request).setStartPage(--startPage);
		}
		dto.setRequest(request);
		return dto;
	}
	
	public ResponseDTO nextPageMove() {
		ApiDTO request = dto.getRequest();
		if(request instanceof RequestSaraminDTO) {
			int start = ((RequestSaraminDTO)request).getStart();
        	((RequestSaraminDTO)request).setStart(++start);
		} else if(request instanceof RequestWork24DTO) {
			int startPage = ((RequestWork24DTO)request).getStartPage();
	    	((RequestWork24DTO)request).setStartPage(++startPage);
		}
		
		dto.setRequest(request);
		return dto;
	}
	
	public boolean getDirection() {
		return this.direction;
	}

}