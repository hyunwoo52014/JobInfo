package view.bundle.panels.elements;

import java.awt.GridBagConstraints;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import org.springframework.stereotype.Component;

import data.dao.ApiRepository;
import data.dao.UIWork24DataLabelRepository;
import data.dto.api.ApiDTO;
import data.dto.event.RequestWork24DTO;
import data.dto.ui.work24.CompanyCodeDTO;
import data.dto.ui.work24.EmpWantedCareerCodeDTO;
import data.dto.ui.work24.EmpWantedEducationCodeDTO;
import data.dto.ui.work24.EmpWantedTypeCodeDTO;
import data.dto.ui.work24.SortFieldDTO;
import data.dto.ui.work24.SortOrderByDTO;
import event.JobListApiService;
import event.Work24RestApiEvent;
import lombok.extern.slf4j.Slf4j;
import view.CardLayoutNavigator;
import view.GridBagLayoutBuilder;
import view.ScreenSizeConstraints;
import view.bundle.panels.ViewPanelBundles.PanelName;

@Slf4j
@Component(value = "Work24UiPanel")
public class Work24UiPanel extends JPanel {

	private static final long serialVersionUID = 5486906577160444386L;
	private CardLayoutNavigator navigator;
	private GridBagLayoutBuilder builder;
	private UIWork24DataLabelRepository repository;
	private JobListApiService apiService;
	private RequestWork24DTO requestDTO;
	private HashMap<String, JComponent> registeredComponent;

	public Work24UiPanel(
			CardLayoutNavigator navigator,
			ScreenSizeConstraints constraints,
			UIWork24DataLabelRepository repository,
			ApiRepository apiRepository,
			JobListApiService apiService) {
		constraints.setSize(this);
		this.navigator = navigator;
		this.builder = new GridBagLayoutBuilder(this);
		this.repository = repository;
		this.apiService = apiService;
		this.requestDTO = new RequestWork24DTO();
		ApiDTO apiDto = apiRepository.getApiDTO(3);
		this.requestDTO.setAccessKey(apiDto.getAccessKey());
		this.registeredComponent = new HashMap<String, JComponent>();
		
		assemble();

	}

	private void assemble() {
		this.builder.weightx(1).weighty(0).anchor(GridBagConstraints.NORTH)
			.fill(GridBagConstraints.HORIZONTAL);
		keywordSection();
		multiCheckerSection();
		multiComboSection();
		searchAmountAndEmpCoSection();
		
		extraSection();
		footerSection();

		Set<Entry<String, JComponent>> componentSet = this.registeredComponent.entrySet();

		for (Entry<String, JComponent> entry : componentSet) {
			JComponent component = entry.getValue();
			
			if (component instanceof JLabel l) {
				l.setHorizontalAlignment(JLabel.CENTER);
			}
			
			if (component instanceof JTextField tf) {
				tf.setHorizontalAlignment(JTextField.CENTER);
			}
		}
	}
	
	private void keywordSection() {
		JLabel empWantedTitle_label = new JLabel("채용제목");
		JTextField empWantedTitle_field = new JTextField();
		JButton submitButton = new JButton("검색");
		
		empWantedTitle_field.getDocument().addDocumentListener(new DocumentListener() {
			
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
				requestDTO.setEmpWantedTitle(empWantedTitle_field.getText());
			}
		});
		
		registeredComponent.put("EmpWantedTitleLabel", empWantedTitle_label);
		registeredComponent.put("EmpWantedTitleField", empWantedTitle_field);
		registeredComponent.put("SubmitButton", submitButton);  
		
		submitButton.addActionListener((e)-> {
			navigator.setPrevName(PanelName.WORK24.getName());
			apiService.work24ApiService(new Work24RestApiEvent(this, this.requestDTO));
			navigator.show(PanelName.RESULTTABLE.getName());
		});
		
		this.builder.gridx(0).gridy(0).gridwidth(1).configure(empWantedTitle_label);
		this.builder.gridx(1).gridy(0).gridwidth(5).configure(empWantedTitle_field);
		this.builder.gridx(6).gridy(0).gridwidth(1).configure(submitButton);

	}
	
	private void multiCheckerSection() {
		JLabel coClCd_label = new JLabel("기업구분");
		JCheckBox[] coClCd_checkobox = null;
		JLabel empWantedTypeCd_label = new JLabel("고용형태");
		JCheckBox[] empWantedTypeCd_checkobox = null;
		JLabel empWantedCareerCd_label = new JLabel("경력구분");
		JCheckBox[] empWantedCareerCd_checkobox = null;
		JLabel empWantedEduCd_label = new JLabel("학력");
		JCheckBox[] empWantedEduCd_checkobox = null;
		
		List<CompanyCodeDTO> companyList = this.repository.getCompanyCodeAll();
		coClCd_checkobox = new JCheckBox[companyList.size()];
		for(int i = 0; i < coClCd_checkobox.length; i++) {
			coClCd_checkobox[i] = new JCheckBox(companyList.get(i).getLabel());
			coClCd_checkobox[i].putClientProperty("apiKey", companyList);
		}
		
		List<EmpWantedTypeCodeDTO> empTypeList = this.repository.getEmpWantedTypeCodeAll();
		empWantedTypeCd_checkobox = new JCheckBox[empTypeList.size()];
		for(int i = 0; i < empWantedTypeCd_checkobox.length; i++) {
			empWantedTypeCd_checkobox[i] = new JCheckBox(empTypeList.get(i).getLabel());
			empWantedTypeCd_checkobox[i].putClientProperty("apiKey", empTypeList);
		}
		List<EmpWantedCareerCodeDTO> empCareerList = this.repository.getEmpWantedCareerCodeAll();
		empWantedCareerCd_checkobox = new JCheckBox[empCareerList.size()];
		for(int i = 0; i < empWantedCareerCd_checkobox.length; i++) {
			empWantedCareerCd_checkobox[i] = new JCheckBox(empCareerList.get(i).getLabel());
			empWantedCareerCd_checkobox[i].putClientProperty("apiKey", empCareerList);
		}
		
		List<EmpWantedEducationCodeDTO> empEducationList = this.repository.getEmpWantedEducationCodeAll();
		empWantedEduCd_checkobox = new JCheckBox[empEducationList.size()];
		for(int i = 0; i < empWantedEduCd_checkobox.length; i++) {
			empWantedEduCd_checkobox[i] = new JCheckBox(empEducationList.get(i).getLabel());;
			empWantedEduCd_checkobox[i].putClientProperty("apiKey", empEducationList);

		}
		
		registeredComponent.put("CompanyCodeLabel", coClCd_label);
		for(int i = 0; i < coClCd_checkobox.length; i++) {
			registeredComponent.put("CompanyCodeCombobox_"+coClCd_checkobox[i].getText(), coClCd_checkobox[i]);
		}
		registeredComponent.put("EmpWantedTypeCodeLabel", empWantedTypeCd_label);
		for(int i = 0; i < empWantedTypeCd_checkobox.length; i++) {
			registeredComponent.put("EmpWantedTypeCodeCombobox_"+empWantedTypeCd_checkobox[i].getText(), empWantedTypeCd_checkobox[i]);
		}
		registeredComponent.put("EmpWantedCareerCodeLabel", empWantedCareerCd_label);
		for(int i = 0 ; i < empWantedCareerCd_checkobox.length; i++) {
			registeredComponent.put("EmpWantedCareerCodeCombobox_"+empWantedCareerCd_checkobox[i].getText(), empWantedCareerCd_checkobox[i]);
		}
		
 		registeredComponent.put("EmpWantedEducationCodeLabel", empWantedEduCd_label);
		for(int i = 0; i < empWantedEduCd_checkobox.length; i++) {
			registeredComponent.put("EmpWantedEducationCodeCombobox_"+empWantedEduCd_checkobox[i].getText(), empWantedEduCd_checkobox[i]);
		}
		
		this.requestDTO.setCoClcd(coClCd_checkobox);
		this.requestDTO.setEmpWantedTypeCd(empWantedTypeCd_checkobox);
		this.requestDTO.setEmpWantedCareerCd(empWantedCareerCd_checkobox);
		this.requestDTO.setEmpWantedEduCd(empWantedEduCd_checkobox);
		
		this.builder.gridx(0).gridy(1).configure(coClCd_label);
		for(int i = 0; i < coClCd_checkobox.length; i++) {
			this.builder.gridx(1+i).gridy(1).configure(coClCd_checkobox[i]);
		}
		this.builder.gridx(0).gridy(2).configure(empWantedTypeCd_label);
		for(int i = 0; i < empWantedTypeCd_checkobox.length; i++) {
			this.builder.gridx(1+i).gridy(2).configure(empWantedTypeCd_checkobox[i]);
		}
		this.builder.gridx(0).gridy(3).configure(empWantedCareerCd_label);
		for(int i = 0; i < empWantedCareerCd_checkobox.length; i++) {
			this.builder.gridx(1+i).gridy(3).configure(empWantedCareerCd_checkobox[i]);
		}
		this.builder.gridx(0).gridy(4).configure(empWantedEduCd_label);
		for(int i = 0; i < empWantedEduCd_checkobox.length; i++) {
			this.builder.gridx(1+i).gridy(4).configure(empWantedEduCd_checkobox[i]);
		}
	}
	
	private void multiComboSection() {

		JLabel sortField_label = new JLabel("정렬필드");
		JComboBox<SortFieldDTO> sortField_combobox = new JComboBox<SortFieldDTO>();
		JLabel sortOrderBy_label = new JLabel("정렬방식");
		JComboBox<SortOrderByDTO> sortOrderBy_combobox = new JComboBox<SortOrderByDTO>();
		
		registeredComponent.put("SortFieldLabel", sortField_label);
		registeredComponent.put("SortFieldComboBox", sortField_combobox);
		registeredComponent.put("SortOrderByLabel", sortOrderBy_label);
		registeredComponent.put("SortOrderByComboBox", sortOrderBy_combobox);
		
		for(SortFieldDTO dto : this.repository.getSortFieldAll()) {
			sortField_combobox.addItem(dto);
		}
		
		for(SortOrderByDTO dto : this.repository.getSortOrderByAll()) {
			sortOrderBy_combobox.addItem(dto);
		}

		sortField_combobox.addItemListener((e) -> {
			requestDTO.setSortField((SortFieldDTO) sortField_combobox.getSelectedItem());
		});
		
		sortOrderBy_combobox.addItemListener((e) -> {
			requestDTO.setSortOrderBy((SortOrderByDTO) sortOrderBy_combobox.getSelectedItem());
		});
		
		
		this.builder.gridx(0).gridy(5).configure(sortField_label);
		this.builder.gridx(1).gridy(5).configure(sortField_combobox);
		this.builder.gridx(2).gridy(5).configure(sortOrderBy_label);
		this.builder.gridx(3).gridy(5).configure(sortOrderBy_combobox);
		

	}
	
	private void searchAmountAndEmpCoSection() {
		JLabel startPageLabel = new JLabel("시작페이지(최대 1000)");
		JTextField startPageField = new JTextField();
		JLabel displayLabel = new JLabel("개수(최대 100)");
		JTextField displayField = new JTextField();
		JLabel empCoNoLabel = new JLabel("<html><strike>채용기업번호</strike></html>");
		JTextField empCoNoField = new JTextField();
		
		((AbstractDocument) startPageField.getDocument())
				.setDocumentFilter(new FilterInput_Number("^1000$|^\\d{0,3}$"));
		((AbstractDocument) displayField.getDocument()).setDocumentFilter(new FilterInput_Number("^100$|^\\d{0,2}$"));
		
		//((AbstractDocument) empCoNoField.getDocument()).setDocumentFilter(new FilterInput_Number("^\\d*$"));
		empCoNoField.setEnabled(false);
		empCoNoField.setToolTipText("현재 버전에선 미지원입니다.");
		
		registeredComponent.put("StartPageLabel", startPageLabel);
		registeredComponent.put("StartPageField", startPageField);
		registeredComponent.put("DisplayLabel", displayLabel);  
		registeredComponent.put("DisplayField", displayField);  
		registeredComponent.put("EmpCoNoLabel", empCoNoLabel);  
		registeredComponent.put("EmpCoNoField", empCoNoField);  
		
		startPageField.getDocument().addDocumentListener(new DocumentListener() {
			
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
				requestDTO.setStartPage(Integer.valueOf(startPageField.getText()));
			}
		});
		
		displayField.getDocument().addDocumentListener(new DocumentListener() {
			
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
				requestDTO.setDisplay(Integer.valueOf(displayField.getText()));
			}
		});
		
		this.builder.gridx(0).gridy(6).gridwidth(1).configure(startPageLabel);
		this.builder.gridx(1).gridy(6).configure(startPageField);
		this.builder.gridx(2).gridy(6).configure(displayLabel);
		this.builder.gridx(3).gridy(6).configure(displayField);
		this.builder.gridx(4).gridy(6).configure(empCoNoLabel);
		this.builder.gridx(5).gridy(6).configure(empCoNoField);
 	}
	
	private void extraSection() {
		
		JLabel jobsCd_label = new JLabel("<html><strike>직종코드</strike></html>");
		JTextField jobsCd_field = new JTextField();
		
		JLabel busino_label = new JLabel("<html><strike>사업자번호</strike></html>");
		JTextField busino_textfield = new JTextField();
		
		JButton reset_button = new JButton("초기화");
		reset_button.addActionListener((e)-> {
			Set<Entry<String, JComponent>> componentSet = this.registeredComponent.entrySet();
			for (Entry<String, JComponent> entry : componentSet) {
				JComponent component = entry.getValue();
				if (component instanceof JTextField tf) {
					tf.setText("");
				}
				
				if (component instanceof JCheckBox cb) {
					cb.setSelected(false);
				}
			}
		});
		
		registeredComponent.put("JobCodeLabel", jobsCd_label);
		registeredComponent.put("JobCodeField", jobsCd_field);
		registeredComponent.put("BusinoLabel", busino_label);
		registeredComponent.put("BusinoTextField", busino_textfield);
		
		jobsCd_field.setEnabled(false);
		jobsCd_field.setToolTipText("현재 버전에선 미지원입니다.");

		busino_textfield.setEnabled(false);
		busino_textfield.setToolTipText("현재 버전에선 미지원입니다.");

		this.builder.gridx(0).gridy(7).configure(jobsCd_label);
		this.builder.gridx(1).gridy(7).configure(jobsCd_field);
		this.builder.gridx(2).gridy(7).configure(busino_label);
		this.builder.gridx(3).gridy(7).configure(busino_textfield);
		this.builder.gridx(4).gridy(7).gridwidth(3).configure(reset_button);
		this.builder.gridwidth(1);
	}

	private void footerSection() {

		JButton button = new JButton("이전 화면");
		button.addActionListener((e) -> {
			navigator.setPrevName("");
			navigator.show(PanelName.WELCOME.getName());
		});
		
		this.builder.gridx(0).gridy(8).weighty(1).gridwidth(7).configure(Box.createHorizontalBox());
		this.builder.gridx(0).gridy(9).weighty(0).gridwidth(7).configure(button);
	}

	private class FilterInput_Number extends DocumentFilter {

		String regex;

		public FilterInput_Number(String regex) {
			this.regex = regex;
		}

		@Override
		public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
				throws BadLocationException {
			StringBuilder sb = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
			sb.insert(offset, string);
			if (isVaild(sb.toString())) {
				super.insertString(fb, offset, string, attr);
			}
		}

		@Override
		public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
				throws BadLocationException {
			StringBuilder sb = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
			sb.replace(offset, offset + length, text);
			if (isVaild(sb.toString())) {
				super.replace(fb, offset, length, text, attrs);
			}
		}

		private boolean isVaild(String input) {
			return input.matches(this.regex);
		}
	}

}
