package view;

import java.awt.CardLayout;
import java.awt.Container;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
public class CardLayoutNavigator
{
    private Container contentPane;
    private CardLayout cardLayout;
    private String previousName;
    
    public void register(final Container contentPane, final CardLayout cardLayout) {
        this.contentPane = contentPane;
        this.cardLayout = cardLayout;
        this.previousName = "";
    }
    
    public void show(final String cardName) {
        this.cardLayout.show(this.contentPane, cardName);
    }
    
    public void setPrevName(String name) {
    	this.previousName = name;
    }
    
    public String getPrevname() {
    	return this.previousName;
    }

}
