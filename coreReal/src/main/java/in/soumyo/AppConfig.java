package in.soumyo;


import in.soumyo.notifications.EmailNotification;
import in.soumyo.notifications.NotificationInterface;
import in.soumyo.notifications.SMSNotification;
import in.soumyo.notifications.WhatsappNotification;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


// Scan the package along with its subpackages to find out the classes having
// Component annotation
@Configuration
@ComponentScan("in.soumyo")
public class AppConfig {
    @Bean
    @Primary
    // When there is a confution of selecting a dependency class during auto-injection, it will be selected
    public NotificationInterface createEmailNotification () {
        return new EmailNotification();
    }

    @Bean
    @Qualifier("sms")
    public NotificationInterface createSMSNotification () {
        return new SMSNotification();
    }

    @Bean
    @Qualifier("wp")
    public NotificationInterface createWpNotification () {
        return new WhatsappNotification();
    }


    @Bean
    // Confution -> Primary
    // Defined -> Qualifier
    public OrderPlace createOrder (@Qualifier("wp") NotificationInterface notificationService) {
        return new OrderPlace(notificationService, 850);
    }
}
