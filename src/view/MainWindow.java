package view;

import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import view.subContainer.JobTypeNEducation;
import view.subContainer.LocalIndustryJobCategoryCodelist;
import view.subContainer.OptionalItem;
import view.subContainer.SaraminRecruitmentOption;
import view.subContainer.SearchWindows;
import works.BackGroundTaskCollection;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SpringLayout sl = new SpringLayout();
	
	public MainWindow() {
		setLayout(sl);
		setTitle("Saramin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(660, 700);
		
		SearchWindows sw = BackGroundTaskCollection.getInstance().SearchWindows;
		SaraminRecruitmentOption sro = BackGroundTaskCollection.getInstance().SaraminRecruitmentOption;
		JobTypeNEducation jtne = BackGroundTaskCollection.getInstance().JobTypeNEducation;
		LocalIndustryJobCategoryCodelist lijccl = BackGroundTaskCollection.getInstance().LocalIndustryJobCategoryCodelist;
		OptionalItem oi = BackGroundTaskCollection.getInstance().OptionalItem;
		JLabel poweredby = new JLabel("Powered By");
		JButton button = new JButton("»ç¶÷ÀÎ");
		
		add(sw);
		add(sro);
		add(jtne);
		add(lijccl);
		add(oi);
		add(poweredby);
		add(button);
		
		button.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("http://www.saramin.co.kr"));
				} catch (IOException | URISyntaxException e1) {
					e1.printStackTrace();
				}

			}
			
		});
		
		this.sl.putConstraint(SpringLayout.WEST, sro, 5, SpringLayout.WEST, this);
		this.sl.putConstraint(SpringLayout.NORTH, sro, 0, SpringLayout.SOUTH, sw);
		
		this.sl.putConstraint(SpringLayout.WEST, jtne, 5, SpringLayout.WEST, this);
		this.sl.putConstraint(SpringLayout.NORTH, jtne, 0, SpringLayout.SOUTH, sro);
		
		this.sl.putConstraint(SpringLayout.WEST, lijccl, 5, SpringLayout.WEST, this);
		this.sl.putConstraint(SpringLayout.NORTH, lijccl, 0, SpringLayout.SOUTH, jtne);
		
		this.sl.putConstraint(SpringLayout.WEST, oi, 5, SpringLayout.WEST, this);
		this.sl.putConstraint(SpringLayout.NORTH, oi, 0, SpringLayout.SOUTH, lijccl);

		this.sl.putConstraint(SpringLayout.WEST, poweredby, 5, SpringLayout.WEST, this);
		this.sl.putConstraint(SpringLayout.NORTH, poweredby, 10, SpringLayout.SOUTH, oi);
		
		this.sl.putConstraint(SpringLayout.WEST, button, 5, SpringLayout.EAST, poweredby);
		this.sl.putConstraint(SpringLayout.NORTH, button, 5, SpringLayout.SOUTH, oi);
		
	}
	
	public void setThisWindowVisible(boolean b) {
		if(b == true) {
			setVisible(true);
		} else {
			setVisible(false);
		}
	}
	
	
}
