// 
// Decompiled by Procyon v0.6.0
// 

package view;

import java.awt.CardLayout;
import java.awt.Container;
import org.springframework.stereotype.Component;

@Component
public class CardLayoutNavigator
{
    private Container contentPane;
    private CardLayout cardLayout;
    
    public void register(final Container contentPane, final CardLayout cardLayout) {
        this.contentPane = contentPane;
        this.cardLayout = cardLayout;
    }
    
    public void show(final String cardName) {
        this.cardLayout.show(this.contentPane, cardName);
    }
}
