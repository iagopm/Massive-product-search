package shops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopsApplication {
	public static void main(String[] args) {
		System.setProperty("java.awt.headless", "false");
		SpringApplication.run(ShopsApplication.class, args);
	}
}