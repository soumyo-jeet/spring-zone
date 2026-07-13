package in.soumyo;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


// Scan the package along with its subpackages to find out the classes having
// Component annotation
@Configuration
@ComponentScan("in.soumyo")
public class AppConfig {
}
