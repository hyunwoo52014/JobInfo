package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.WindowConstants;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UIComponentList {

	@Bean(name = "FrameWindow")
	JFrame FrameWindow(
			ScreenSizeConstraints constraints,
			@Qualifier("MenuPanel") JPanel MenuBar,
			@Qualifier("ResultTablePanel") JPanel ResultTable,
			CardLayoutNavigator navigator
		) {
		JFrame frame = new JFrame();
		Container contentPane = frame.getContentPane();
		CardLayout layout = new CardLayout();
		contentPane.setLayout(layout);
		navigator.register(contentPane, layout);
		contentPane.add(MenuBar, "MenuPanel");
		contentPane.add(ResultTable, "ResultTablePanel");
		navigator.show("MenuPanel");
		
		
		frame.setTitle("JobInfo");
		constraints.setSize(frame);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
 		return frame;
	}

	
}