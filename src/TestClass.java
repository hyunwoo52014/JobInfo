import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class TestClass {

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		SpringLayout sl = new SpringLayout();
		JPanel[] jps = {new JPanel(), new JPanel(), new JPanel()};
		jf.setLayout(sl);
		jf.setSize(500, 900);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jps[0].setSize(500, 300);
		jps[0].setBackground(Color.red);
		jps[0].add(new JLabel("jps[0]"));
		jps[0].add(new JButton("¹öÆ°"));
		
		jps[1].setSize(500, 300);
		jps[1].setBackground(Color.black);
		jps[1].add(new JLabel("jps[1]"));
		
		jps[2].setSize(500, 300);
		jps[2].setBackground(Color.blue);
		jps[2].add(new JLabel("jps[2]"));
		
		
		for(int i = 0 ; i < jps.length; i++) {
			jf.add(jps[i]);
		}
		
		sl.putConstraint(SpringLayout.WEST, jps[0], 0, SpringLayout.WEST, jf.getContentPane());
		sl.putConstraint(SpringLayout.NORTH, jps[0], 0, SpringLayout.NORTH, jf.getContentPane());
		sl.putConstraint(SpringLayout.NORTH, jps[1], 0, SpringLayout.NORTH, jf.getContentPane());
		sl.putConstraint(SpringLayout.NORTH, jps[1], 0, SpringLayout.SOUTH, jps[0]);
		sl.putConstraint(SpringLayout.NORTH, jps[2], 0, SpringLayout.NORTH, jf.getContentPane());
		sl.putConstraint(SpringLayout.NORTH, jps[2], 0, SpringLayout.SOUTH, jps[1]);
		
		jf.setVisible(true);
	}

}
