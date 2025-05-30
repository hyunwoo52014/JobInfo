package view;

import java.awt.GridBagConstraints;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.springframework.stereotype.Component;

import data.dao.UIDataLabelRepository;
import data.dto.EducationDTO;
import data.dto.LocationCodeTotalDTO;
import data.dto.WorkTypeDTO;

@Component(value = "MenuPanel")
public class MenuBarComponents extends JPanel{
	
	GridBagLayoutBuilder builder;
	UIDataLabelRepository repository;
	
	public MenuBarComponents(ScreenSizeConstraints sizeConstraints, UIDataLabelRepository repository) {
		sizeConstraints.setSize(this);
		this.builder = new GridBagLayoutBuilder(this);
		this.repository = repository;
		assemble();
	}
	
	private void assemble() {
		keyWordSection();
		bbsGbSection();
		stockSection();
		srSection();
		jobTypeSection();
		eduLvSection();
		locationCdSection();
		JLabel fields_label = new JLabel("�ΰ� �׸�(������)");
		JLabel sort_label = new JLabel("����");
		JLabel start_label = new JLabel("������");
		JLabel count_label = new JLabel("����");
	}

	
	private void keyWordSection() {
		JLabel keyWord_label = new JLabel("Ű����");
		JTextField keyWord_textField = new JTextField();
		this.builder.gridx(0).gridy(0).gridwidth(1).configure(keyWord_label);
		this.builder.gridx(1).gridy(0).gridwidth(3).configure(keyWord_textField);
	}
	
	private void bbsGbSection() {
		JLabel bbs_gb_label = new JLabel("��ä����");
		JRadioButton all_bbs_gb = new JRadioButton("��� ä�����");
		JRadioButton saramin_bbs_gb = new JRadioButton("����� ��ä�Ӻ��� ����");
		
		ButtonGroup group = new ButtonGroup();
		group.add(all_bbs_gb);
		group.add(saramin_bbs_gb);
		all_bbs_gb.setSelected(true);
		
		this.builder.gridx(0).gridy(1).gridwidth(1).configure(bbs_gb_label);
		this.builder.gridx(1).gridy(1).configure(all_bbs_gb);
		this.builder.gridx(2).gridy(1).configure(saramin_bbs_gb);
	}
	
	private void stockSection() {
		JLabel stock_label = new JLabel("���忩��");
		JCheckBox kospi_box = new JCheckBox("��������");
		JCheckBox kosdaq_box = new JCheckBox("�ڽ���");
		JCheckBox konex_box = new JCheckBox("�ڳؽ�");
		
		this.builder.gridx(0).gridy(2).gridwidth(1).configure(stock_label);
		this.builder.gridx(1).gridy(2).configure(kospi_box);
		this.builder.gridx(2).gridy(2).configure(kosdaq_box);
		this.builder.gridx(3).gridy(2).configure(konex_box);
	}
	
	private void srSection() {
		JLabel sr_label = new JLabel("����/���� ����");
		JCheckBox sr_box = new JCheckBox("�������/�İ߾�ü ���� ����");
		
		this.builder.gridx(0).gridy(3).gridwidth(1).configure(sr_label);
		this.builder.gridx(1).gridy(3).configure(sr_box);
	}
	
	private void jobTypeSection() {
		JLabel jobType_label = new JLabel("�ٹ� ����");
		List<WorkTypeDTO> dtoList= this.repository.getWorkTypeAll();
		
		JComboBox<WorkTypeDTO> workTypeCombobox = new JComboBox<WorkTypeDTO>();
		for(WorkTypeDTO labels : dtoList) {
			workTypeCombobox.addItem(labels);
		}
		
		this.builder.gridx(0).gridy(4).gridwidth(1).configure(jobType_label);
		this.builder.gridx(1).gridy(4).configure(workTypeCombobox);
	}
	
	private void eduLvSection() {
		JLabel edu_lv_label = new JLabel("�з�");
		List<EducationDTO> dtoList = this.repository.getEducationAll();
		JComboBox<EducationDTO> educationCombobox = new JComboBox<EducationDTO>();
		for(EducationDTO labels : dtoList) {
			educationCombobox.addItem(labels);
		}
		
		this.builder.gridx(0).gridy(5).gridwidth(1).configure(edu_lv_label);
		this.builder.gridx(1).gridy(5).configure(educationCombobox);
	}
	
	private void locationCdSection() {
		JLabel label = new JLabel("�ٹ��� �ڵ� : ");
		
		JRadioButton loc_mcd_button = new JRadioButton("1�� �����ڵ�");
		JRadioButton loc_bcd_button = new JRadioButton("2�� �����ڵ�");
		JRadioButton loc_cd_button = new JRadioButton("��ü �����ڵ�");
		
		ButtonGroup group = new ButtonGroup();
		
		group.add(loc_mcd_button);
		group.add(loc_bcd_button);
		group.add(loc_cd_button);
		
		loc_mcd_button.addItemListener((e)->{
			
		});
		
	}
	
	private void industryCdSection() {
		JLabel ind_cd_label = new JLabel("����");
		
	}
	
	
	public JPanel getMenuPanel() {
		return this;
	}
}
