package y.y.yadmin.config;

import config.properties.DruidProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultProperties {
    @Bean
    @ConfigurationProperties("spring.datasource.db1")
    public DruidProperties druidProperties(){
        return new DruidProperties();
    }
}
