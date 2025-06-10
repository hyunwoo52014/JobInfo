package view;

import data.dto.event.RequestSaraminDTO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import java.net.URI;
import java.awt.Desktop;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.Instant;
import java.util.List;
import data.dto.event.SaraminResponseXml;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import data.dto.event.ResponseDTO;
import javax.swing.JComponent;
import java.util.HashMap;
import event.JobListApiService;
import event.SaraminRestApiEvent;
import lombok.Generated;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import javax.swing.JPanel;

@Slf4j
@Component("ResultTablePanel")
public class ResultTableComponents extends JPanel
{
    @Generated
    private static final long serialVersionUID = -8434273600324797836L;
    ScreenSizeConstraints sizeConstraints;
    private GridBagLayoutBuilder builder;
    private CardLayoutNavigator navigator;
    JobListApiService apiService;
    private HashMap<String, JComponent> registeredComponent;
    private ResponseDTO xmlData;
    
    public ResultTableComponents(
    		ScreenSizeConstraints sizeConstraints,
    		CardLayoutNavigator navigator,
    		JobListApiService apiService
    		) {
        this.builder = new GridBagLayoutBuilder(this);
        this.registeredComponent = new HashMap<String, JComponent>();
        this.sizeConstraints = sizeConstraints;
        this.navigator = navigator;
        this.apiService = apiService;
        this.assemble();
    }
    
    private void assemble() {
        this.builder.gridwidth(1).gridheight(1).weightx(1.0).weighty(1.0).fill(2);
        this.controllButtonSection();
        this.jobListTable();
    }
    
    private void controllButtonSection() {
        final JLabel page_Label = new JLabel("페이지");
        final JLabel page_number = new JLabel("1");
        JButton change_button = new JButton("이전화면");
        change_button.addActionListener((e)->{
        	navigator.show("MenuPanel");
        });
        
        JButton prev_button = new JButton("이전");
        prev_button.addActionListener((e)->{
        	RequestSaraminDTO request = (RequestSaraminDTO) xmlData.getRequest();
        	int start = request.getStart();
        	if(start <= 0) {
        		JOptionPane.showMessageDialog(null, "맨 첫번째 장입니다.");
        		return;
        	}
        	page_number.setText(String.valueOf(Integer.parseInt(page_number.getText())-1));
        	request.setStart(--start);
        	apiService.saraminApiService(new SaraminRestApiEvent(this, request));
        });
        
        JButton next_button = new JButton("다음");
        next_button.addActionListener((e)->{
        	RequestSaraminDTO request = (RequestSaraminDTO) xmlData.getRequest();
        	int start = request.getStart();
        	
        	page_number.setText(String.valueOf(Integer.parseInt(page_number.getText())+1));
        	request.setStart(++start);
        	apiService.saraminApiService(new SaraminRestApiEvent(this, request));
        });
        
        this.registeredComponent.put("Label_page", page_Label);
        this.registeredComponent.put("Label_number", page_number);
        this.registeredComponent.put("Previous_button", prev_button);
        this.registeredComponent.put("Next_button", next_button);
        this.registeredComponent.put("Change_button", change_button);
        this.builder.gridx(0).gridy(0).weighty(0.0).configure(change_button);
        this.builder.gridx(1).gridy(0).configure(page_Label);
        this.builder.gridx(2).gridy(0).configure(page_number);
        this.builder.gridx(3).gridy(0).configure(prev_button);
        this.builder.gridx(4).gridy(0).configure(next_button);
    }
    
    private void jobListTable() {
        JPanel panelforPack = new JPanel();
        JScrollPane scrollPane = new JScrollPane();
        JTable table = new JTable();
        int[] selectedRow = new int[1];

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
        
        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);
        
        String[] columnLabels = {
        		"상태", "기한", "날짜", "공고 제목", "회사이름", "학력", "경력", "고용형태", 
        		"URI_Job", "URI_Company" };
        for (int i = 0; i < columnLabels.length; ++i) {
            model.addColumn(columnLabels[i]);
        }
        
        TableColumnModel columnModel = table.getColumnModel();
        TableColumn removeColumn = columnModel.getColumn(columnLabels.length - 2);
        columnModel.removeColumn(removeColumn);
        removeColumn = columnModel.getColumn(columnLabels.length - 1 - 1);
        columnModel.removeColumn(removeColumn);
        table.setModel(model);
        scrollPane.getViewport().add(table);
        panelforPack.add(scrollPane);
        
        this.registeredComponent.put("ScrollPanel", scrollPane);
        this.registeredComponent.put("ScrollPanel_viewPort", scrollPane.getViewport());
        this.registeredComponent.put("ViewTable", table);
        this.builder.gridx(0).gridy(1).gridwidth(5).gridheight(1).weightx(1.0).weighty(1.0).fill(1).configure(panelforPack);
        this.builder.relpaceSource(panelforPack);
        this.builder.gridx(0).gridy(0).gridwidth(1).gridheight(1).fill(1).weightx(1.0).weighty(1.0).configure(scrollPane);
        this.builder.relpaceSource(this);
    }
    
    private void addDataToTable() {
        JTable table = (JTable) this.registeredComponent.get("ViewTable");
        table.setSelectionMode(0);
        table.setRowSelectionAllowed(true);
        final DefaultTableModel model = (DefaultTableModel)table.getModel();
        for (int i = 0; i < model.getRowCount(); ++i) {
            model.removeRow(0);
        }
        final List<SaraminResponseXml.Job> jobList = ((SaraminResponseXml)this.xmlData).getJobs().getJobList();
        for (final SaraminResponseXml.Job job : jobList) {
            Object[] row = { 
            		(job.getActive() == ActiveTag.Done.getNumber()) ? ActiveTag.Done.getTag() : ActiveTag.Continue.getTag(), 
            		job.getCloseType().getValue(), 
            		this.convertTimestamp(job.getExpirationTimestamp()),
            		job.getPosition().getTitle().getValue(),
            		job.getCompany().getName().getValue(),
            		job.getPosition().getRequiredEducationLevel().getValue(),
            		job.getPosition().getExperienceLevel().getValue(),
            		job.getPosition().getJobtype().getValue(),
            		job.getUrl(),
            		job.getCompany().getName().getHref()
            		};
            model.addRow(row);
        }
    }
    
    private String convertTimestamp(final long timeStamp) {
        final Instant instant = Instant.ofEpochSecond(timeStamp);
        final ZoneId koreaZoneInd = ZoneId.of("Asia/Seoul");
        final LocalDateTime koreaDateTime = LocalDateTime.ofInstant(instant, koreaZoneInd);
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        final String formattedDate = koreaDateTime.format(formatter);
        return formattedDate;
    }
    
    private void openWebBroswer(String url) {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(url));
            }
        }
        catch (final Exception e) {
            JOptionPane.showMessageDialog(null, "url 오류");
        }
    }
    
    public void setXmlString(final ResponseDTO dto) {
        this.xmlData = dto;
        this.addDataToTable();
    }
    
    private enum ActiveTag
    {
        Done(0, "마감"),
        Continue(1, "진행중");
    	
        int number;
        String tag;

        
        private ActiveTag(final int number, final String tag) {
            this.number = number;
            this.tag = tag;
        }
        
        public int getNumber() {
            return this.number;
        }
        
        public String getTag() {
            return this.tag;
        }

    }
}
