package view.subContainer;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import works.TaskCollection;

public class SearchWindows extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9172075615117488971L;
	private JLabel jl;
	private JTextField jtf;
	private JButton jb;
	
	public SearchWindows() {
		this.jl = new JLabel("키워드");
		this.jtf = new JTextField("클릭하여 활성화", 40);
		this.jb = new JButton("검색");
		
		this.jtf.setEnabled(false);
		
		this.jtf.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				jtf.setEnabled(true);
				jtf.setText("");
			}
			
		});
		
		this.jb.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				//TaskCollection.getInstance().doTask();
			}
			
		});
		
		add(this.jl);
		add(this.jtf);
		add(this.jb);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
	}
	
	
	
}
