package view.bundle.panels;

import org.springframework.stereotype.Component;

import view.bundle.panels.elements.ResultTablePanel;
import view.bundle.panels.elements.SaraminUiPanel;
import view.bundle.panels.elements.WelcomePanel;
import view.bundle.panels.elements.Work24UiPanel;

@Component
public class ViewPanelBundles {

	public ResultTablePanel resultTableComponents;
	public SaraminUiPanel sraminUiPanel;
	public WelcomePanel welcomePanel;
	public Work24UiPanel work24UiPanel;
	
	public ViewPanelBundles(
			ResultTablePanel resultTableComponents,
			SaraminUiPanel sraminUiPanel,
			WelcomePanel welcomePanel,
			Work24UiPanel work24UiPanel
			) {
		this.resultTableComponents = resultTableComponents;
		this.sraminUiPanel = sraminUiPanel;
		this.welcomePanel = welcomePanel;
		this.work24UiPanel = work24UiPanel;
	}

	public static enum PanelName{
		WELCOME("WelcomePanel"),
		SARAMIN("SaraminUiPanel"),
		WORK24("Work24UiPanel"),
		RESULTTABLE("ResultTablePanel");
		
		private String name;
		private PanelName(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
	}
}
