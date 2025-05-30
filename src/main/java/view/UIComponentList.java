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
import lombok.extern.log4j.Log4j2;

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
	
	@Bean()
	JPanel selectPanel(UIDataLabelRepository labelRepo) {
		JPanel panel = new JPanel();

		
		return panel;
	}
}