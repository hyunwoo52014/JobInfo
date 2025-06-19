package starter;

import javax.swing.JFrame;
import javax.swing.ToolTipManager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
	"data.dao","data.bundle", "view", "event"
})
@MapperScan("data.dao")
public class Starter {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder()
		.sources(Starter.class)
		.headless(false).run(args);
		
		globalConfig();
		JFrame frame = (JFrame) context.getBean("FrameWindow");
		frame.setVisible(true);
	}
	
	private static void globalConfig() {
		ToolTipManager.sharedInstance().setInitialDelay(200);
		ToolTipManager.sharedInstance().setDismissDelay(Integer.MAX_VALUE);
		ToolTipManager.sharedInstance().setReshowDelay(200);
	}
}