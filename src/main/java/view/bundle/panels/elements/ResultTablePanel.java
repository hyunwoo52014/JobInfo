package view.bundle.panels.elements;

import data.dto.event.SaraminResponseXml;
import data.dto.event.Work24ResponseXml;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import data.dto.event.ResponseDTO;
import javax.swing.JComponent;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.ScrollPane;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import event.JobListApiService;
import event.PageMoveEvent;
import lombok.extern.slf4j.Slf4j;
import view.CardLayoutNavigator;
import view.GridBagLayoutBuilder;
import view.ScreenSizeConstraints;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import javax.swing.JPanel;

@Slf4j
@Component("ResultTablePanel")
public class ResultTablePanel extends JPanel {

	private static final long serialVersionUID = -8434273600324797836L;
	ScreenSizeConstraints sizeConstraints;
	GridBagLayoutBuilder builder;
	CardLayoutNavigator navigator;
	JobListApiService apiService;
	HashMap<String, JComponent> registeredComponent;
	ResponseDTO xmlData;
	JScrollPane saraminScrollableTable, work24ScrollableTable;

	public ResultTablePanel(ScreenSizeConstraints sizeConstraints, CardLayoutNavigator navigator,
			JobListApiService apiService, @Qualifier("SaraminScrollableTable") JScrollPane saraminScrollableTable,
			@Qualifier("Work24ScrollableTable") JScrollPane work24ScrollableTable) {
		this.builder = new GridBagLayoutBuilder(this);
		this.registeredComponent = new HashMap<String, JComponent>();
		this.sizeConstraints = sizeConstraints;
		this.navigator = navigator;
		this.apiService = apiService;
		this.saraminScrollableTable = saraminScrollableTable;
		this.work24ScrollableTable = work24ScrollableTable;

		this.assemble();
	}

	private void assemble() {
		this.builder.gridwidth(1).gridheight(1).weightx(1.0).weighty(1.0).fill(2);
		this.controllButtonSection();
		this.jobListTable();
	}

	private void controllButtonSection() {
		JLabel page_Label = new JLabel("페이지");
		JLabel page_number = new JLabel("-1");

		JButton change_button = new JButton("이전화면");
		change_button.addActionListener((e) -> {
			navigator.show(navigator.getPrevname());
		});

		JButton prev_button = new JButton("이전");
		prev_button.addActionListener((e) -> {
			apiService.pageMove(new PageMoveEvent(this, xmlData, false));
		});

		JButton next_button = new JButton("다음");
		next_button.addActionListener((e) -> {
			apiService.pageMove(new PageMoveEvent(this, xmlData, true));
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
		JPanel wapperPanel = new JPanel();
		wapperPanel.add(saraminScrollableTable);
		wapperPanel.add(work24ScrollableTable);
		saraminScrollableTable.setVisible(false);
		work24ScrollableTable.setVisible(false);

		this.registeredComponent.put("WapperPanel", wapperPanel);
		this.builder.gridx(0).gridy(1).gridwidth(5).weightx(1.0).weighty(1.0).fill(GridBagConstraints.BOTH)
				.configure(wapperPanel);
		this.builder.relpaceSource(wapperPanel);
		this.builder.gridx(0).gridy(0).configure(saraminScrollableTable);
		this.builder.gridx(0).gridy(0).configure(work24ScrollableTable);
	}

	public void setXmlString(ResponseDTO dto) {
		this.xmlData = dto;
		JLabel label = (JLabel) this.registeredComponent.get("Label_number");

		if (dto instanceof SaraminResponseXml) {
			if(!saraminScrollableTable.isVisible()) {
				saraminScrollableTable.setVisible(true);
				work24ScrollableTable.setVisible(false);
			}
			int start = ((SaraminResponseXml) dto).getJobs().getStart();
			label.setText(String.valueOf(start + 1));
			setSaraminData(dto);
			return;
		}

		if (dto instanceof Work24ResponseXml) {
			if(!work24ScrollableTable.isVisible()) {
				saraminScrollableTable.setVisible(false);
				work24ScrollableTable.setVisible(true);
			}
			int startPage = ((Work24ResponseXml) dto).getStartPage();
			label.setText(String.valueOf(startPage));
			setWork24Data(dto);
			return;
		}
	}

	public void setSaraminData(ResponseDTO xmlData) {

		DefaultTableModel model = (DefaultTableModel) ((JTable) this.saraminScrollableTable.getClientProperty("TABLE"))
				.getModel();

		model.getDataVector().removeAll(model.getDataVector());

		List<SaraminResponseXml.Job> jobList = ((SaraminResponseXml) xmlData).getJobs().getJobList();
		for (SaraminResponseXml.Job job : jobList) {
			Object[] row = {
					(job.getActive() == SaraminActiveTag.Done.getNumber()) ? SaraminActiveTag.Done.getTag()
							: SaraminActiveTag.Continue.getTag(),
					job.getCloseType().getValue(), convertTimestamp(job.getExpirationTimestamp()),
					job.getPosition().getTitle().getValue(), job.getCompany().getName().getValue(),
					job.getPosition().getRequiredEducationLevel().getValue(),
					job.getPosition().getExperienceLevel().getValue(), job.getPosition().getJobtype().getValue(),
					job.getUrl(), job.getCompany().getName().getHref() };
			model.addRow(row);
		}

		model.fireTableDataChanged();
	}

	public void setWork24Data(ResponseDTO xmlData) {

		DefaultTableModel model = (DefaultTableModel) ((JTable) this.work24ScrollableTable.getClientProperty("TABLE"))
				.getModel();

		model.getDataVector().removeAll(model.getDataVector());

		List<Work24ResponseXml.DhsOpenEmpInfo> infoList = ((Work24ResponseXml) xmlData).getDhsOpenEmpInfos();
		for (Work24ResponseXml.DhsOpenEmpInfo info : infoList) {
			Object[] row = { info.getEmpSeqno(), info.getEmpWantedTitle(), info.getEmpBusiNm(),
					info.getCoClcdNm().length() > 0 ? info.getCoClcdNm() : "미기재(未記載)", info.getEmpWantedStdt(),
					info.getEmpWantedEndt(), info.getEmpWantedTypeNm(), info.getEmpWantedHomepgDetail() };
			model.addRow(row);
		}

		model.fireTableDataChanged();
	}

	private String convertTimestamp(final long timeStamp) {
		final Instant instant = Instant.ofEpochSecond(timeStamp);
		final ZoneId koreaZoneInd = ZoneId.of("Asia/Seoul");
		final LocalDateTime koreaDateTime = LocalDateTime.ofInstant(instant, koreaZoneInd);
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		final String formattedDate = koreaDateTime.format(formatter);
		return formattedDate;
	}

	private enum SaraminActiveTag {
		Done(0, "마감"), Continue(1, "진행중");

		int number;
		String tag;

		private SaraminActiveTag(final int number, final String tag) {
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
