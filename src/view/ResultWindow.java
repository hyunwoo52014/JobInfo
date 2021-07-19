package view;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Future;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.Spring;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import works.BackGroundTaskCollection;
import works.model.ResultAllData;
import works.model.URLParameter;
import works.task.GetDataFromAPI;
import works.task.sub.GetParameterForNextPage;
import works.task.sub.GetParameterForPreviousPage;
import works.task.sub.command.GetNextPageCommand;
import works.task.sub.command.GetPreviousPageCommand;

public class ResultWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9222477656885905474L;
	private static final int maximumRow = 110;
	private DefaultTableModel model;
	private JTable table;
	private JLabel currentPage;
	private JLabel totalPage;
	private ResultAllData datas;
	private JPopupMenu linkPopUpMenu;
	private URLParameter urlparameter;
	
	public ResultWindow() {
		SpringLayout sl = new SpringLayout();
		setLayout(sl);
		setSize(1050, 570);
		setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				BackGroundTaskCollection.getInstance().SearchWindows.SearchButton.setEnabled(true);
				removeData();
			}

			@Override
			public void windowClosed(WindowEvent e) {
				BackGroundTaskCollection.getInstance().SearchWindows.SearchButton.setEnabled(true);
				removeData();
			}
			
		});
		
		JPanel tables = makeTables();
		JPanel controllPane = controlPanel();
		this.linkPopUpMenu = linkMenu();
		
		add(tables);
		add(controllPane);
		
		sl.putConstraint(SpringLayout.NORTH, tables, 0, SpringLayout.NORTH, getContentPane());
		sl.putConstraint(SpringLayout.WEST, tables, 0, SpringLayout.WEST, getContentPane());
		
		sl.putConstraint(SpringLayout.NORTH, controllPane, 0, SpringLayout.SOUTH, tables);
		sl.putConstraint(SpringLayout.WEST, controllPane, 0, SpringLayout.WEST, getContentPane());
	}
	
	private JPanel makeTables() {
		JPanel jp = new JPanel();
		
		jp.setPreferredSize(new Dimension(this.getWidth()-1, 500));
		jp.setSize(500, 500);
		jp.setLayout(new FlowLayout());
		String[] header = {"기업명","공고제목","지역","근무형태","학력","경력코드","게시일","마감일"};
		
		this.model = new DefaultTableModel(null, header) {

			private static final long serialVersionUID = -5410029313755964022L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		
		this.table = new JTable(this.model);
		
		this.table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				linkPopUpMenu.show(BackGroundTaskCollection.getInstance().ResultWindow, e.getXOnScreen(), e.getYOnScreen());
			}
			
		});
		
		JScrollPane jsp = new JScrollPane(this.table);

		jsp.setLocation(0, 0);
		jsp.setPreferredSize(new Dimension(this.getWidth()-1, 500));

		jp.add(jsp);
		
		return jp;
	}
	
	private JPanel controlPanel() {
		JPanel jp = new JPanel();
		SpringLayout sl = new SpringLayout();
		JButton[] buttons = {new JButton("취업 사람인"), new JButton("이전"), new JButton("다음"), new JButton("닫기")};
		this.currentPage = new JLabel(String.valueOf(Integer.MAX_VALUE));
		this.totalPage = new JLabel(String.valueOf(Integer.MAX_VALUE));
		JLabel poweredBy = new JLabel("Powered By ");
		JLabel slash = new JLabel("/");
		
		jp.setSize(this.getWidth(), 50);
		jp.setPreferredSize(new Dimension(this.getWidth(), 40));
		jp.setLayout(sl);
		
		for(int i = 0; i < buttons.length; i++) {
			jp.add(buttons[i]);
		}
		
		jp.add(poweredBy);
		jp.add(this.currentPage);
		jp.add(slash);
		jp.add(this.totalPage);
		
		buttons[0].addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("http://www.saramin.co.kr"));
				} catch (IOException | URISyntaxException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		buttons[1].addMouseListener(new MouseAdapter() {

			@SuppressWarnings("unchecked")
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int page = Integer.valueOf(urlparameter.getCount());
				Future<ResultAllData> f;
				ResultAllData data = null;
				if(page == 0) {
					return;
				}
				try {
					removeData();
					f = (Future<ResultAllData>) BackGroundTaskCollection
							.getInstance()
							.doTask(new GetDataFromAPI(new GetPreviousPageCommand(new GetParameterForPreviousPage(urlparameter))));
					while(!f.isDone()) {
						Thread.sleep(1000);
					}
					data = f.get();
					setDatas(data);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
						
		});
		
		buttons[2].addMouseListener(new MouseAdapter() {

			@SuppressWarnings("unchecked")
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Future<ResultAllData> f;
				ResultAllData data = null;
				
				try {
					removeData();
					f = (Future<ResultAllData>) BackGroundTaskCollection
							.getInstance()
							.doTask(new GetDataFromAPI(new GetNextPageCommand(new GetParameterForNextPage(urlparameter))));
					while(!f.isDone()) {
						Thread.sleep(1000);
					}
					data = f.get();
					setDatas(data);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
			
		});
		
		buttons[3].addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
			
		});
		
		sl.getConstraints(buttons[3]).setWidth(Spring.constant(60));;
		sl.getConstraints(buttons[3]).setX(Spring.constant(jp.getWidth() - sl.getConstraints(buttons[3]).getWidth().getValue() - 10));

		sl.putConstraint(SpringLayout.EAST, buttons[2], -15, SpringLayout.WEST, buttons[3]);
		
		sl.putConstraint(SpringLayout.EAST, buttons[1], -15, SpringLayout.WEST, buttons[2]);
		
		sl.putConstraint(SpringLayout.EAST, this.totalPage, -15, SpringLayout.WEST, buttons[1]);
		sl.putConstraint(SpringLayout.NORTH, this.totalPage, 5, SpringLayout.NORTH, this);
		
		sl.putConstraint(SpringLayout.EAST, slash, -15, SpringLayout.WEST, this.totalPage);
		sl.putConstraint(SpringLayout.NORTH, slash, 5, SpringLayout.NORTH, this);

		sl.putConstraint(SpringLayout.EAST, this.currentPage, -15, SpringLayout.WEST, slash);
		sl.putConstraint(SpringLayout.NORTH, this.currentPage, 5, SpringLayout.NORTH, this);
		
		sl.putConstraint(SpringLayout.NORTH, poweredBy, 5, SpringLayout.NORTH, this);
		
		sl.putConstraint(SpringLayout.WEST, buttons[0], 0, SpringLayout.EAST, poweredBy);
		
		return jp;
	}
	
	public JPopupMenu linkMenu() {
		JPopupMenu pop = new JPopupMenu();
		JMenuItem link_company_info = new JMenuItem("기업상세정보");
		JMenuItem link_recruitment_info = new JMenuItem("공고상세정보");
		
		link_company_info.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				try {
					Desktop.getDesktop().browse(new URI(datas.getResultViewData().get(row).getCompanyInfoUrl()));
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
			}

		});
		
		link_recruitment_info.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				try {
					Desktop.getDesktop().browse(new URI(datas.getResultViewData().get(row).getRecruitmentUrl()));
				} catch(IOException e2) {
					e2.printStackTrace();
				} catch(URISyntaxException e2) {
					e2.printStackTrace();
				}
			}
			
		});
		
		pop.add(link_company_info);
		pop.add(new JSeparator());
		pop.add(link_recruitment_info);
		
		return pop;
	}

	public ResultAllData getDatas() {
		return datas;
	}

	public void setDatas(ResultAllData datas) {
		
		this.datas = datas;
		this.urlparameter = datas.getURLParameter();
		
		for(int i = 0; i < datas.getResultViewData().size(); i++) {
			
			String[] tempData = new String[this.datas.getResultViewData().get(i).realLength()];
			
			Date postD = new Date(Long.valueOf(this.datas.getResultViewData().get(i).getPostingTimestamp())*1000L);
			Timestamp ts1 = new Timestamp(postD.getTime());
			Date ExperD = new Date(Long.valueOf(this.datas.getResultViewData().get(i).getExpirationTimestamp())*1000L);
			Timestamp ts2 = new Timestamp(ExperD.getTime());
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			
			tempData[0] = this.datas.getResultViewData().get(i).getCompanyName();
			tempData[1] = this.datas.getResultViewData().get(i).getRecruitmentTitle();
			tempData[2] = this.datas.getResultViewData().get(i).getLocalTag();
			tempData[3] = this.datas.getResultViewData().get(i).getJobType();
			tempData[4] = this.datas.getResultViewData().get(i).getRequiredEducationLevel();
			tempData[5] = this.datas.getResultViewData().get(i).getExperienceLevel();
			tempData[6] = formatter.format(ts1);
			tempData[7] = formatter.format(ts2);
			tempData[8] = this.datas.getResultViewData().get(i).getRecruitmentUrl();
			tempData[9] = this.datas.getResultViewData().get(i).getCompanyInfoUrl();
			
			this.model.addRow(tempData);
		}
		
		this.currentPage.setText(this.datas.getCurrentPos());
		this.totalPage.setText(String.valueOf(Integer.valueOf(this.datas.getTotalCount())/maximumRow));
		this.model.fireTableDataChanged();

	}
	
	private void removeData() {
		this.datas = null;
		this.model.getDataVector().removeAllElements();
	}
}