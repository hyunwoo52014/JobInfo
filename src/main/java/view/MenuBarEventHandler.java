package view;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class MenuBarEventHandler {
	
	private final ApplicationEventPublisher publisher;
	
	public MenuBarEventHandler(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}
	
	
}
