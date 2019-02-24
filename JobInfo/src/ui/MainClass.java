/**
 * 
 */
package ui;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 * @author MIT-007
 *
 */
public class MainClass extends JFrame{

	private SettingPanel sp = null;
	private ViewPanel vp = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 5683869211808981759L;

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainClass mc = new MainClass();
		mc.setTitle("검색프로그램");
		mc.sp = new SettingPanel();
		mc.vp = new ViewPanel(mc.sp);
		
		JTabbedPane jp = new JTabbedPane();
		jp.addTab("메인화면", mc.vp);
		jp.addTab("검색설정", mc.sp);
		
		mc.add(jp);
		
		mc.setSize(1300,700);
		mc.setLocationRelativeTo(null);
		mc.setVisible(true);
		mc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}