package view;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.util.Iterator;
import java.util.List;

import javax.swing.WindowConstants;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import data.dao.UIDataLabelRepository;
import data.dto.EducationDTO;
import data.dto.LocationCodeFirstDTO;
import data.dto.LocationCodeSecondsDTO;
import data.dto.LocationCodeTotalDTO;
import data.dto.SalaryDTO;
import data.dto.WorkTypeDTO;

@Configuration
public class UIComponentList {

	@Bean(name = "ResultWindow")
	JFrame resultWindow(ScreenSizeConstraints constraints, JPanel panel) {
		JFrame frame = new JFrame();
		frame.add(panel, BorderLayout.NORTH);
		frame.setTitle("JobInfo");
		constraints.setSize(frame);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
 		return frame;
	}
	
	@Bean(name = "SettingWindow")
	JFrame settingWindow(ScreenSizeConstraints constraints) {
		JFrame frame = new JFrame();
		constraints.setSize(frame);
		frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
 		return frame;
	}
	
	@Bean(name = "MenuBar")
	JPanel selectPanel(UIDataLabelRepository labelRepo) {
		JPanel panel = new JPanel();
		
		GridBagLayoutBuilder builder = new GridBagLayoutBuilder(panel);
		
		JLabel workTypeLabel = new JLabel("근무형태",JLabel.CENTER);
		JLabel educationLabel = new JLabel("학력",JLabel.CENTER);
		JLabel salaryLabel = new JLabel("연봉",JLabel.CENTER);
		JLabel locationLabel = new JLabel("지역",JLabel.CENTER);
		JLabel industryLabel = new JLabel("산업",JLabel.CENTER);
		
		List<WorkTypeDTO> workTypeList = labelRepo.getWorkTypeAll();
		JComboBox<WorkTypeDTO> workTypeCombobox = new JComboBox<WorkTypeDTO>();
		for(WorkTypeDTO labels : workTypeList) {
			workTypeCombobox.addItem(labels);
		}		
		
		List<EducationDTO> educationList = labelRepo.getEducationAll();
		JComboBox<EducationDTO> educationCombobox = new JComboBox<EducationDTO>();
		for(EducationDTO labels : educationList) {
			educationCombobox.addItem(labels);
		}
		
		List<SalaryDTO> salaryList = labelRepo.getSalaryAll();
		JComboBox<SalaryDTO> salaryCombobox = new JComboBox<SalaryDTO>();
		for(SalaryDTO labels : salaryList) {
			salaryCombobox.addItem(labels);
		}
		
		JComboBox<LocationCodeFirstDTO> locationFirstComboBox = new JComboBox<LocationCodeFirstDTO>();
		JComboBox<LocationCodeSecondsDTO> locationSecondsComboBox = new JComboBox<LocationCodeSecondsDTO>();
		locationSecondsComboBox.setEnabled(false);
		JComboBox<LocationCodeTotalDTO> locationTotalCombobox = new JComboBox<LocationCodeTotalDTO>();
		locationTotalCombobox.setEnabled(false);
		
		List<LocationCodeFirstDTO> locationFirstList = labelRepo.getLocationFirstAll();
		for(LocationCodeFirstDTO locationFirst : locationFirstList) {
			locationFirstComboBox.addItem(locationFirst);
		}
		
		locationFirstComboBox.addActionListener((e)-> {
			LocationCodeFirstDTO selected = (LocationCodeFirstDTO) locationFirstComboBox.getSelectedItem();			
			List<LocationCodeSecondsDTO> locationSecondsList = labelRepo.getLocationSecondsAll();
			locationSecondsComboBox.removeAllItems();
			locationTotalCombobox.setEnabled(false);
			
			for(LocationCodeSecondsDTO locationSeconds : locationSecondsList) {
				if(locationSeconds.getCode() == selected.getCode()) {
					locationSecondsComboBox.addItem(locationSeconds);
				}
			}
			
			locationSecondsComboBox.setEnabled(true);
		});
		
		locationSecondsComboBox.addActionListener((e)->{
			LocationCodeFirstDTO selected_first = (LocationCodeFirstDTO) locationFirstComboBox.getSelectedItem();
			LocationCodeSecondsDTO selected_seconds = (LocationCodeSecondsDTO) locationSecondsComboBox.getSelectedItem();
			List<LocationCodeTotalDTO> locationTotalList = labelRepo.getLocationTotalAll();
			locationTotalCombobox.removeAllItems();
			
			for(LocationCodeTotalDTO locationTotal : locationTotalList) {
				if(selected_first.getCode() == locationTotal.getFirst_code()) {
					locationTotalCombobox.addItem(locationTotal);
				}
			}
			
			locationTotalCombobox.setEnabled(true);
		});
		
		builder.gridx(0).gridy(0).weightx(1).fill(GridBagConstraints.HORIZONTAL).configure(workTypeLabel);
		builder.gridx(1).configure(workTypeCombobox);
		builder.gridx(2).configure(educationLabel);
		builder.gridx(3).configure(educationCombobox);
		builder.gridx(4).configure(salaryLabel);
		builder.gridx(5).configure(salaryCombobox);
		
		builder.gridx(0).gridy(1).configure(locationLabel);
		builder.gridx(1).configure(locationFirstComboBox);
		builder.gridx(2).gridwidth(2).configure(locationSecondsComboBox);
		builder.gridx(4).gridwidth(2).configure(locationTotalCombobox);
		
		builder.gridx(0).gridy(2).gridwidth(1).weightx(1).configure(industryLabel);
		
		return panel;
	}
	
}