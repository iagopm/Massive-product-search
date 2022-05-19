package shops;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SearchTask implements InitializingBean {

	@Value("#{'${links}'.split(',')}")
	private List<String> links;
	
	@Value("${search:Search}")
	private String search;
	
	@Override
	public void afterPropertiesSet() {
		String product = JOptionPane.showInputDialog(search);
		links.forEach(l -> {
			l = l.replace("*", product);
			l = l.contains(";") ? l.replaceAll("\\s+", l.split(";")[1]) : l;
			l = l.split(";")[0];
			try {
				if (Desktop.isDesktopSupported()) {
					Desktop.getDesktop().browse(new URI(l));
				}
			} catch (URISyntaxException | IOException e) {
				e.printStackTrace();
			}
		});
	}
}