package in.soumyo.dtoDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DtoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DtoDemoApplication.class, args);
		System.out.println("hello world");
	}

}
