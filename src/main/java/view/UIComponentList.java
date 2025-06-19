package view;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;
import view.bundle.panels.ViewPanelBundles;
import view.bundle.panels.ViewPanelBundles.PanelName;

@Slf4j
@Configuration
public class UIComponentList {

	@Bean(name = "FrameWindow")
	JFrame FrameWindow(ScreenSizeConstraints constraints, ViewPanelBundles bundles, CardLayoutNavigator navigator) {
		JFrame frame = new JFrame();
		Container contentPane = frame.getContentPane();
		CardLayout layout = new CardLayout();
		contentPane.setLayout(layout);
		navigator.register(contentPane, layout);

		contentPane.add(bundles.welcomePanel, PanelName.WELCOME.getName());
		contentPane.add(bundles.sraminUiPanel, PanelName.SARAMIN.getName());
		contentPane.add(bundles.work24UiPanel, PanelName.WORK24.getName());
		contentPane.add(bundles.resultTableComponents, PanelName.RESULTTABLE.getName());
		navigator.show(PanelName.WELCOME.getName());

		frame.setTitle("JobInfo");
		constraints.setSize(frame);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
		return frame;
	}

	@Bean(value = "SaraminScrollableTable")
	JScrollPane SaraminScrollableTable() {
		JScrollPane scrollPane = new JScrollPane();
		JTable table = new JTable();
		table.setSelectionMode(0);
		table.setRowSelectionAllowed(true);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		DefaultTableColumnModel columnModel = (DefaultTableColumnModel) table.getColumnModel();
		int[] selectedRow = new int[1];

		String[] columnLabels = { "상태", "기한", "날짜", "공고 제목", "회사이름", "학력", "경력", "고용형태", "URI_Job", "URI_Company" };
		for (int i = 0; i < columnLabels.length; ++i) {
			model.addColumn(columnLabels[i]);
		}

		TableColumn removeColumn = columnModel.getColumn(columnLabels.length - 2);
		columnModel.removeColumn(removeColumn);
		removeColumn = columnModel.getColumn(columnLabels.length - 1 - 1);
		columnModel.removeColumn(removeColumn);

		addPopupToSaraminTable(selectedRow, table);
		scrollPane.getViewport().add(table);
		scrollPane.putClientProperty("TABLE", table);
		
		return scrollPane;
	}

	@Bean(value = "Work24ScrollableTable")
	JScrollPane Work24ScrollableTable() {
		JScrollPane scrollPane = new JScrollPane();
		JTable table = new JTable();
		table.setSelectionMode(0);
		table.setRowSelectionAllowed(true);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		DefaultTableColumnModel columnModel = (DefaultTableColumnModel) table.getColumnModel();
		int[] selectedRow = new int[1];

		String[] columnLabels = { "공개채용공고순번", "채용제목", "채용업체명", "기업구분명", "채용시작일자", "채용종료일자", "고용형태", "채용사이트URL" };

		for (int i = 0; i < columnLabels.length; ++i) {
			model.addColumn(columnLabels[i]);
		}
		
		TableColumn removeColumn = columnModel.getColumn(columnLabels.length - 1);
		columnModel.removeColumn(removeColumn);
		
		addPopupToWork24Table(selectedRow, table);
	    scrollPane.getViewport().add(table);
		scrollPane.putClientProperty("TABLE", table);

		return scrollPane;

	}
	
	private void addPopupToSaraminTable(int[] selectedRow, JTable table) {
		JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem webBrowser_job = new JMenuItem("웹 브라우저에서 공고 열기");
        webBrowser_job.addActionListener((e)->{
        	if(selectedRow[0] < 0 || selectedRow[0] > table.getRowCount()-1) {
        		selectedRow[0] = 0;
        	}
        	DefaultTableModel model = (DefaultTableModel) table.getModel();
        	String url = (String) model.getValueAt(selectedRow[0], model.getColumnCount()-2);
        	openWebBroswer(url);
        });
        
        JMenuItem webBrowser_company = new JMenuItem("웹 브라우저에서 회사 정보 열기");
        webBrowser_company.addActionListener((e)->{
        	if(selectedRow[0] < 0 || selectedRow[0] > table.getRowCount()-1) {
        		selectedRow[0] = 0;
        	}
        	DefaultTableModel model = (DefaultTableModel) table.getModel();
        	String url = (String) model.getValueAt(selectedRow[0], model.getColumnCount()-1);
        	openWebBroswer(url);
        });
        
        popupMenu.add(webBrowser_job);
        popupMenu.add(webBrowser_company);
        
        table.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				showPopup(e);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				showPopup(e);
			}
        	
			private void showPopup(MouseEvent e) {
				if(e.isPopupTrigger()) {
					int row = table.rowAtPoint(e.getPoint());
					selectedRow[0] = row;
					popupMenu.show(e.getComponent(),e.getX(),e.getY());
				}
			}
		});
	}
	
	private void addPopupToWork24Table(int[] selectedRow, JTable table) {
		JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem webBrowser_job = new JMenuItem("웹 브라우저에서 공고 열기");
        webBrowser_job.addActionListener((e)->{
        	if(selectedRow[0] < 0 || selectedRow[0] > table.getRowCount()-1) {
        		selectedRow[0] = 0;
        	}
        	DefaultTableModel model = (DefaultTableModel) table.getModel();
        	String url = (String) model.getValueAt(selectedRow[0], model.getColumnCount()-1);
        	openWebBroswer(url);
        });
        /*
        JMenuItem webBrowser_company = new JMenuItem("웹 브라우저에서 회사 정보 열기");
        webBrowser_company.addActionListener((e)->{
        	if(selectedRow[0] < 0 || selectedRow[0] > table.getRowCount()-1) {
        		selectedRow[0] = 0;
        	}
        	DefaultTableModel model = (DefaultTableModel) table.getModel();
        	String url = (String) model.getValueAt(selectedRow[0], model.getColumnCount()-1);
        	openWebBroswer(url);
        });
        */
        popupMenu.add(webBrowser_job);
        //popupMenu.add(webBrowser_company);
        
        table.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				showPopup(e);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				showPopup(e);
			}
        	
			private void showPopup(MouseEvent e) {
				if(e.isPopupTrigger()) {
					int row = table.rowAtPoint(e.getPoint());
					selectedRow[0] = row;
					popupMenu.show(e.getComponent(),e.getX(),e.getY());
				}
			}
		});
	}
	
	private void openWebBroswer(String url) {
		log.info(url);
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(url));
            }
        }
        catch (final Exception e) {
            JOptionPane.showMessageDialog(null, "url 오류");
        }
    }
}