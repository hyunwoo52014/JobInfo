package view;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.event.ItemEvent;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.MaskFormatter;

import org.springframework.stereotype.Component;

import data.bundle.SaraminComponentBundle;
import data.dao.ApiRepository;
import data.dao.UIDataLabelRepository;
import data.dto.api.ApiDTO;
import data.dto.event.RequestSaraminDTO;
import data.dto.ui.EducationDTO;
import data.dto.ui.IndustryCodeDTO;
import data.dto.ui.IndustryRootCodeDTO;
import data.dto.ui.JobCodeDTO;
import data.dto.ui.LocationCodeDTO;
import data.dto.ui.LocationCodeFirstDTO;
import data.dto.ui.LocationCodeSecondsDTO;
import data.dto.ui.LocationCodeTotalDTO;
import data.dto.ui.OccupationCodeDTO;
import data.dto.ui.SortLabelDTO;
import data.dto.ui.WorkTypeDTO;
import event.JobListApiService;
import event.SaraminRestApiEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component(value = "MenuPanel")
public class MenuBarComponents extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HashMap<String, JComponent> registeredComponent;
	private RequestSaraminDTO requestDTO;
	GridBagLayoutBuilder builder;
	UIDataLabelRepository uiRepository;
	ApiRepository apiRepository;
	JobListApiService apiService;
	CardLayoutNavigator navigator;

	public MenuBarComponents(
			ScreenSizeConstraints sizeConstraints,
			SaraminComponentBundle bundle,
			JobListApiService apiService,
			CardLayoutNavigator navigator
			) {
		sizeConstraints.setSize(this);
		this.apiService = apiService;
		this.uiRepository = bundle.uiRepository;
		this.apiRepository = bundle.apiRepository;
		this.navigator = navigator;
		this.registeredComponent = new HashMap<String, JComponent>();
		this.builder = new GridBagLayoutBuilder(this);
		this.requestDTO = new RequestSaraminDTO();
		ApiDTO apiDto = this.apiRepository.getApiDTO(1);
		this.requestDTO.setAccessKey(apiDto.getAccessKey());
		this.requestDTO.setHeaderValue(apiDto.getHeaderValue());
		
		assemble();
	}

	private void assemble() {
		this.builder.weightx(1).weighty(0).anchor(GridBagConstraints.NORTH).fill(GridBagConstraints.HORIZONTAL);
		keyWordSection();
		bbsGbSection();
		stockSection();
		srSection();
		jobTypeSection();
		eduLvSection();
		locationCdSection();
		industryCdSection();
		optionalSection();
		extraSection();
		
		Set<Entry<String, JComponent>> componentSet = this.registeredComponent.entrySet();
		
		for(Entry<String, JComponent> entry : componentSet) {
			JComponent component = entry.getValue();
			
			if(component instanceof JLabel l) {
				l.setHorizontalAlignment(JLabel.RIGHT);
			}
		}
	}

	private void keyWordSection() {
		
		JLabel keyWord_label = new JLabel("키워드");
		
		JTextField keyWord_textField = new JTextField();
		
		keyWord_textField.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				updateText();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				updateText();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				updateText();
			}
			
			private void updateText() {
				requestDTO.setKeywords(keyWord_textField.getText());
			}
		});;
		
		JButton button = new JButton("검색");
		button.addActionListener((e) -> {
			this.apiService.saraminApiService(new SaraminRestApiEvent(this, this.requestDTO));
			this.navigator.show("ResultTablePanel");
		});
		
		this.registeredComponent.put("KeyWordLabel", keyWord_label);
		this.registeredComponent.put("KeyWordTextField", keyWord_textField);
		this.registeredComponent.put("SubmitButton", button);

		this.builder.gridx(0).gridy(0).gridwidth(1).configure(keyWord_label);
		this.builder.gridx(1).gridy(0).gridwidth(5).configure(keyWord_textField);
		this.builder.gridx(6).gridy(0).gridwidth(1).configure(button);
	}

	private void bbsGbSection() {
		JLabel bbs_gb_label = new JLabel("공채구분");

		JRadioButton all_bbs_gb = new JRadioButton("모든 채용공고");
		JRadioButton saramin_bbs_gb = new JRadioButton("사람인 공채속보만 포함");

		ButtonGroup group = new ButtonGroup();
		group.add(all_bbs_gb);
		group.add(saramin_bbs_gb);
		//all_bbs_gb.setSelected(true);
		
		all_bbs_gb.addItemListener((e) -> {
			this.requestDTO.setBbs_gb(false);
		});
		
		saramin_bbs_gb.addItemListener((e) -> {
			this.requestDTO.setBbs_gb(true);
		});
		
		this.registeredComponent.put("BbsGbLabel", bbs_gb_label);
		this.registeredComponent.put("AllBbsGbRadioButton", all_bbs_gb);
		this.registeredComponent.put("SaraminBbsGbRadioButton", saramin_bbs_gb);
		
		this.builder.gridx(0).gridy(1).configure(bbs_gb_label);
		this.builder.gridx(1).gridy(1).configure(all_bbs_gb);
		this.builder.gridx(2).gridy(1).configure(saramin_bbs_gb);
	}

	private void stockSection() {
		JLabel stock_label = new JLabel("상장여부");
		JCheckBox kospi_box = new JCheckBox("유가증권");
		JCheckBox kosdaq_box = new JCheckBox("코스닥");
		JCheckBox konex_box = new JCheckBox("코넥스");
		kospi_box.putClientProperty("apiValue", "kospi");
		kosdaq_box.putClientProperty("apiValue", "kosdaq");
		konex_box.putClientProperty("apiValue", "konex");
		
		this.requestDTO.setStocks(new JCheckBox[] {kospi_box, kosdaq_box, konex_box});
		
		this.registeredComponent.put("StockLabel", stock_label);
		this.registeredComponent.put("KospiCheckBox", kospi_box);
		this.registeredComponent.put("KosdaqCheckBox", kosdaq_box);
		this.registeredComponent.put("KonexCheckBox", konex_box);
		
		this.builder.gridx(0).gridy(2).configure(stock_label);
		this.builder.gridx(1).gridy(2).configure(kospi_box);
		this.builder.gridx(2).gridy(2).configure(kosdaq_box);
		this.builder.gridx(3).gridy(2).configure(konex_box);
	}

	private void srSection() {
		JLabel sr_label = new JLabel("제외/포함 설정");
		JCheckBox sr_box = new JCheckBox("헤드헌팅/파견업체 공고 제외");
		
		this.requestDTO.setSr(sr_box);

		this.registeredComponent.put("SrLabel", sr_label);
		this.registeredComponent.put("SrBox", sr_box);
		
		this.builder.gridx(0).gridy(3).configure(sr_label);
		this.builder.gridx(1).gridy(3).configure(sr_box);
	}

	private void jobTypeSection() {
		JLabel jobType_label = new JLabel("근무 형태");

		List<WorkTypeDTO> dtoList = this.uiRepository.getWorkTypeAll();

		JComboBox<WorkTypeDTO> workTypeCombobox = new JComboBox<WorkTypeDTO>();
		for (WorkTypeDTO labels : dtoList) {
			workTypeCombobox.addItem(labels);
		}
		
		workTypeCombobox.addItemListener((e)->{
			this.requestDTO.setJob_type((WorkTypeDTO) workTypeCombobox.getSelectedItem());
		});
		
		this.registeredComponent.put("JobTypeLabel", jobType_label);
		this.registeredComponent.put("WorkTypeCombobox", workTypeCombobox);

		this.builder.gridx(0).gridy(4).configure(jobType_label);
		this.builder.gridx(1).gridy(4).configure(workTypeCombobox);
	}

	private void eduLvSection() {
		JLabel edu_lv_label = new JLabel("학력");

		List<EducationDTO> dtoList = this.uiRepository.getEducationAll();
		JComboBox<EducationDTO> educationCombobox = new JComboBox<EducationDTO>();
		for (EducationDTO labels : dtoList) {
			educationCombobox.addItem(labels);
		}
		
		educationCombobox.addItemListener((e) -> {
			this.requestDTO.setEdu_lv((EducationDTO) educationCombobox.getSelectedItem());
		});
		
		this.registeredComponent.put("EducationLvLabel", edu_lv_label);
		this.registeredComponent.put("EducationCombobox", educationCombobox);
		
		this.builder.gridx(0).gridy(5).configure(edu_lv_label);
		this.builder.gridx(1).gridy(5).configure(educationCombobox);
	}

	private void locationCdSection() {
		JLabel label = new JLabel("근무지 코드 선택 ");

		JRadioButton loc_mcd_button = new JRadioButton("1차 지역코드");
		JRadioButton loc_bcd_button = new JRadioButton("2차 지역코드");
		JRadioButton loc_cd_button = new JRadioButton("전체 지역코드");
		ButtonGroup group = new ButtonGroup();
		group.add(loc_mcd_button);
		group.add(loc_bcd_button);
		group.add(loc_cd_button);

		JComboBox<LocationCodeDTO> locationComboBox = new JComboBox<LocationCodeDTO>();

		loc_mcd_button.addItemListener((e) -> {
			locationComboBox.removeAllItems();
			List<LocationCodeFirstDTO> dtoList = this.uiRepository.getLocationFirstAll();
			for (LocationCodeFirstDTO dto : dtoList) {
				locationComboBox.addItem(dto);
			}
		});

		loc_bcd_button.addItemListener((e) -> {
			locationComboBox.removeAllItems();
			List<LocationCodeSecondsDTO> dtoList = this.uiRepository.getLocationSecondsAll();
			for (LocationCodeSecondsDTO dto : dtoList) {
				locationComboBox.addItem(dto);
			}
		});
		;

		loc_cd_button.addItemListener((e) -> {
			locationComboBox.removeAllItems();
			List<LocationCodeTotalDTO> dtoList = this.uiRepository.getLocationTotalAll();
			for (LocationCodeTotalDTO dto : dtoList) {
				locationComboBox.addItem(dto);
			}
		});
		
		locationComboBox.addItemListener((e)->{
			this.requestDTO.setLoc_cd((LocationCodeDTO) locationComboBox.getSelectedItem());
		});
		
		this.registeredComponent.put("LocationLabel", label);
		this.registeredComponent.put("LocationMCDRadioButton", loc_mcd_button);
		this.registeredComponent.put("LocationBCDRadioButton", loc_bcd_button);
		this.registeredComponent.put("LocationCDRadioButton", loc_cd_button);
		this.registeredComponent.put("LocationComboBox", locationComboBox);

		this.builder.gridx(0).gridy(6).configure(label);
		this.builder.gridx(1).gridy(6).configure(loc_mcd_button);
		this.builder.gridx(2).gridy(6).configure(loc_bcd_button);
		this.builder.gridx(3).gridy(6).configure(loc_cd_button);
		this.builder.gridx(4).gridy(6).configure(locationComboBox);
	}

	private void industryCdSection() {
		JLabel ind_cd_label = new JLabel("업종 목록");
		JCheckBox ind_cd_checker = new JCheckBox("분야");
		JComboBox<IndustryCodeDTO> int_cd_box = new JComboBox<IndustryCodeDTO>();
		
		JLabel occupation_label = new JLabel("직무 목록");
		JCheckBox job_mid_cd_checker = new JCheckBox("분류");
		JComboBox<OccupationCodeDTO> job_mid_cd_box = new JComboBox<OccupationCodeDTO>();
		JCheckBox job_cd_checker = new JCheckBox("사업");
		JComboBox<JobCodeDTO> job_cd_box = new JComboBox<JobCodeDTO>();
		
		int_cd_box.setEnabled(false);
		job_mid_cd_box.setEnabled(false);
		job_cd_box.setEnabled(false);
		
		ind_cd_checker.addItemListener((e) -> {
			int_cd_box.removeAllItems();
			if (e.getStateChange() == ItemEvent.SELECTED) {
				List<IndustryCodeDTO> dtoList = this.uiRepository.getIndustryCodeAll();
				for (IndustryCodeDTO dto : dtoList) {
					int_cd_box.addItem(dto);
				}
				int_cd_box.setEnabled(true);
			} else {
				int_cd_box.setEnabled(false);
			}

		});
		
		job_mid_cd_checker.addItemListener((e) -> {
			job_mid_cd_box.removeAllItems();
			if(e.getStateChange() == ItemEvent.SELECTED) {
				List<OccupationCodeDTO> dtoList = this.uiRepository.getOccupationCodeAll();
				for(OccupationCodeDTO dto : dtoList) {
					job_mid_cd_box.addItem(dto);
				}
				job_mid_cd_box.setEnabled(true);
			} else {
				job_mid_cd_box.setEnabled(false);
				job_cd_checker.setSelected(false);
			}
		});

		job_cd_checker.addItemListener((e) -> {

			job_cd_box.removeAllItems();
			if(e.getStateChange() == ItemEvent.SELECTED) {
				List<JobCodeDTO> dtoList = this.uiRepository.getJobCodeAll();
				OccupationCodeDTO root_dto = (OccupationCodeDTO) job_mid_cd_box.getSelectedItem();
				int root_code = root_dto.getCode();
				for(JobCodeDTO dto : dtoList) {
					if(dto.getRoot_code() == root_code) {
						job_cd_box.addItem(dto);
					}
				}
				job_cd_box.setEnabled(true);
			} else {
				job_cd_box.setEnabled(false);
			}
		});
		
		int_cd_box.addItemListener((e)->{
			this.requestDTO.setInd_cd((IndustryCodeDTO) int_cd_box.getSelectedItem());
		});
		
		job_mid_cd_box.addItemListener((e)->{
			this.requestDTO.setJob_mid_cd((OccupationCodeDTO) job_mid_cd_box.getSelectedItem());
		});
		
		job_cd_box.addItemListener((e)->{
			this.requestDTO.setJob_cd((JobCodeDTO) job_cd_box.getSelectedItem());
		});
		
		this.registeredComponent.put("IndustryLabel", ind_cd_label);
		this.registeredComponent.put("Int_cd_checker", ind_cd_checker);
		this.registeredComponent.put("Ind_cd_box", int_cd_box);
		this.registeredComponent.put("OccupationLabel", occupation_label);
		this.registeredComponent.put("Occ_JobMidCdChecker", job_mid_cd_checker);
		this.registeredComponent.put("Occ_JobMidCdBox", job_mid_cd_box);
		this.registeredComponent.put("Occ_JobCdChecker", job_cd_checker);
		this.registeredComponent.put("Occ_JobCdBox", job_cd_box);

		this.builder.gridx(0).gridy(7).configure(ind_cd_label);
		this.builder.gridx(1).gridy(7).configure(ind_cd_checker);
		this.builder.gridx(2).gridy(7).configure(int_cd_box);
		this.builder.gridx(0).gridy(8).configure(occupation_label);
		this.builder.gridx(1).gridy(8).configure(job_mid_cd_checker);
		this.builder.gridx(2).gridy(8).configure(job_mid_cd_box);
		this.builder.gridx(3).gridy(8).configure(job_cd_checker);
		this.builder.gridx(4).gridy(8).configure(job_cd_box);

	}

	private void optionalSection() {
		JLabel fields_label = new JLabel("부가 항목(선택적)");
		JCheckBox box1 = new JCheckBox("날짜/시간 형식의 게시일");
		JCheckBox box2 = new JCheckBox("날짜/시간 형식의 마감일시");
		JCheckBox box3 = new JCheckBox("업직종 키워드(상세분류) 코드");
		JCheckBox box4 = new JCheckBox("조회수/지원자수");
		
		box1.putClientProperty("apiValue", "posting-date");
		box2.putClientProperty("apiValue", "expiration-date");
		box3.putClientProperty("apiValue", "keyword-code");
		box4.putClientProperty("apiValue", "count");
		
		this.requestDTO.setFields(new JCheckBox[] {box1, box2, box3, box4});

		this.registeredComponent.put("OptionFieldLabel", fields_label);
		this.registeredComponent.put("Opt_PostDateCheckbox", box1);
		this.registeredComponent.put("Opt_DeadLineCheckbox", box2);
		this.registeredComponent.put("Opt_OccupationCheckbox", box3);
		this.registeredComponent.put("Opt_CountCheckbox", box4);
		
		this.builder.gridx(0).gridy(9).configure(fields_label);
		this.builder.gridx(1).gridy(9).configure(box1);
		this.builder.gridx(2).gridy(9).configure(box2);
		this.builder.gridx(3).gridy(9).configure(box3);
		this.builder.gridx(4).gridy(9).configure(box4);
	}

	private void extraSection() {
		JLabel sort_label = new JLabel("정렬");
		JLabel start_label = new JLabel("페이지");
		JLabel count_label = new JLabel("개수");
		
		MaskFormatter start_format = null;
		MaskFormatter count_format = null;
		
		try {
			start_format = new MaskFormatter("####");
			count_format = new MaskFormatter("###");
		} catch (ParseException e){
			
		}
		
		JFormattedTextField pageField = new JFormattedTextField(start_format);
		pageField.setFocusLostBehavior(JFormattedTextField.PERSIST);
		JFormattedTextField countField = new JFormattedTextField(count_format);
		countField.setFocusLostBehavior(JFormattedTextField.PERSIST);
		
		JComboBox<SortLabelDTO> sortComboBox = new JComboBox<SortLabelDTO>();
		List<SortLabelDTO> dtoList = this.uiRepository.getSortLabelAll();
		for (SortLabelDTO dto : dtoList) {
			sortComboBox.addItem(dto);
		}
		
		sortComboBox.addItemListener((e)->{
			this.requestDTO.setSort((SortLabelDTO) sortComboBox.getSelectedItem());
		});

		
		
		pageField.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				updateText();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				updateText();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				updateText();
			}
			
			private void updateText() {
				if(countField.getText() == "") {
					return;
				}
				requestDTO.setStart(Integer.parseInt(pageField.getText()));
			}
		});
		
		countField.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				updateText();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				updateText();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				updateText();
			}
			
			private void updateText() {
				if(countField.getText() == "") {
					return;
				}
				requestDTO.setCount(Integer.parseInt(countField.getText()));
			}
		});
		
		this.registeredComponent.put("ExtaraSortLabel", sort_label);
		this.registeredComponent.put("ExtaraSortComboBox", sortComboBox);
		this.registeredComponent.put("ExtaraStartLabel", start_label);
		this.registeredComponent.put("ExtaraPageField", pageField);
		this.registeredComponent.put("ExtaraCountLabel", count_label);
		this.registeredComponent.put("ExtaraCountField", countField);

		this.builder.gridx(0).gridy(10).configure(sort_label);
		this.builder.gridx(1).gridy(10).configure(sortComboBox);
		this.builder.gridx(2).gridy(10).configure(start_label);
		this.builder.gridx(3).gridy(10).configure(pageField);
		this.builder.gridx(4).gridy(10).configure(count_label);
		this.builder.gridx(5).gridy(10).gridwidth(2).configure(countField);

		/* girdbaglayout 한계로 인한 더미 컴포넌트 추가 : 해당 컴포넌트가 맨 아래에서
		 * 빈공간으로 존재하며 기존 컴포넌트를 위쪽으로 올려줌
		*/
		this.builder.gridx(0).gridy(11).weighty(1).gridwidth(6).configure((Container) Box.createVerticalGlue());
	}

}
