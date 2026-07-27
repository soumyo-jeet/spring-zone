package in.soumyo.springBootCoreDemo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "order-property")
public class OrderProperties {
    String market;
    String delayTime; // cannonical form automatically converts to camelcase form

    // configuration props internally uses these setters to set the values
    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(String delayTime) {
        this.delayTime = delayTime;
    }


}