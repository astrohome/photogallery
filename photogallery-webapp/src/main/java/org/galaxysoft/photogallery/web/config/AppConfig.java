package org.galaxysoft.photogallery.web.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;

/**
 * @author SivaLabs
 */
@Configuration
@ComponentScan(basePackages = {"com.galaxysoft.photogallery.web","com.galaxysoft.photogallery.web.utils"})
@Import(value = { WebMvcConfiguration.class })
public class AppConfig {
    //<context:property-placeholder location="classpath:application.properties"></context:property-placeholder>
    @Bean
    public static PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocation(new ClassPathResource("application.properties"));
        ppc.setIgnoreUnresolvablePlaceholders(true);
        ppc.setFileEncoding("UTF-8");
        return ppc;
    }
}
