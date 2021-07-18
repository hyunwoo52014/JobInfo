package view.subContainer;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import works.BackGroundTaskCollection;
import works.model.ResultAllData;
import works.task.GetDataFromAPI;
import works.task.sub.GetFromComponent;
import works.task.sub.command.GetInitCommand;

public class SearchWindows extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9172075615117488971L;
	private final String initText = "클릭하여 활성화";
	private JLabel jl;
	public JTextField SearchTextField;
	public JButton SearchButton;
	
	public SearchWindows() {
		this.jl = new JLabel("키워드");
		this.SearchTextField = new JTextField(initText, 45);
		this.SearchButton = new JButton("검색");
		
		this.SearchTextField.setEnabled(false);
		this.SearchTextField.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				SearchTextField.setEnabled(true);
				SearchTextField.setText("");
			}
			
		});
		
		this.SearchButton.addMouseListener(new MouseAdapter() {

			@SuppressWarnings("unchecked")
			@Override
			public void mouseClicked(MouseEvent e) {
				if(SearchButton.isEnabled()) {
					Future<ResultAllData> f = null;
					ResultAllData data = null;
					try {
						f = (Future<ResultAllData>) BackGroundTaskCollection.getInstance().doTask(new GetDataFromAPI(new GetInitCommand(new GetFromComponent())));
						while(!f.isDone()) {
							Thread.sleep(1000);
						}
						data = f.get();
						
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					} catch (ExecutionException e1) {
						e1.printStackTrace();
					}
					
					BackGroundTaskCollection.getInstance().ResultWindow.setVisible(true);
					BackGroundTaskCollection.getInstance().ResultWindow.setDatas(data);
					SearchButton.setEnabled(false);
				}
			}
			
		});
		
		add(this.jl);
		add(this.SearchTextField);
		add(this.SearchButton);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
	}
	
	public String getSearchWord() {
		String returnText = this.SearchTextField.getText();
		
		if(returnText.trim().equalsIgnoreCase(initText)) {
			return null;
		}
		
		return this.SearchTextField.getText();
	}
	
}
