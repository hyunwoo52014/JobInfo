/**
 * 
 */
package ui;

import java.net.URI;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 * @author MIT-007
 *
 */
public class MainClass extends JFrame{

	private SettingPanel sp = null;
	private ViewPanel vp = null;
	private URI url = null;
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
		mc.vp = new ViewPanel();
		mc.sp = new SettingPanel();
		
		JTabbedPane jp = new JTabbedPane();
		jp.addTab("메인화면", mc.vp);
		jp.addTab("설정", mc.sp);
		
		mc.add(jp);
		
		mc.setSize(500,600);
		mc.setLocationRelativeTo(null);
		mc.setVisible(true);
		mc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}