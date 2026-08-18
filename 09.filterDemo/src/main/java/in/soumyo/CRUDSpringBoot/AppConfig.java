package in.soumyo.CRUDSpringBoot;


import in.soumyo.CRUDSpringBoot.filters.ResponseBodyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public FilterRegistrationBean<ResponseBodyFilter> getResponseBodyFilterBean () {
        FilterRegistrationBean<ResponseBodyFilter> regBean =
                new FilterRegistrationBean<>();

        regBean.setFilter(new ResponseBodyFilter());
        regBean.setOrder(3);
        regBean.addUrlPatterns("/api/*");

        return regBean;
    }
}
