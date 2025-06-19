package view.bundle.panels.elements;

import java.awt.GridBagConstraints;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.springframework.stereotype.Component;

import view.CardLayoutNavigator;
import view.GridBagLayoutBuilder;
import view.ScreenSizeConstraints;
import view.bundle.panels.ViewPanelBundles.PanelName;

@Component(value = "WelcomePanel")
public class WelcomePanel extends JPanel {


	private static final long serialVersionUID = 6781130872024980977L;
	
    private CardLayoutNavigator navigator;
    private GridBagLayoutBuilder builder;
	public WelcomePanel(
			ScreenSizeConstraints constraints,
			CardLayoutNavigator navigator
			) {
		this.navigator = navigator;
		constraints.setSize(this);
		builder = new GridBagLayoutBuilder(this);
		assemble();
	}
	
	private void assemble() {
		
		
		JButton saramin = new JButton("사람인");
		saramin.addActionListener((e) -> {
			this.navigator.show(PanelName.SARAMIN.getName());
		});
		
		JButton work24 = new JButton("고용24");
		work24.addActionListener((e) -> {
			this.navigator.show(PanelName.WORK24.getName());
		});
		
		this.builder.weightx(1).weighty(1).fill(GridBagConstraints.BOTH);
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 5; j++) {
				this.builder.gridx(j).gridy(i);
				if(j == 1 && i == 1) {
					this.builder.configure(saramin);
				} else if(j == 3 && i == 1) {
					this.builder.configure(work24);
				} else {
					this.builder.configure(Box.createHorizontalBox());
				}
			}
		}
	}
	
}
