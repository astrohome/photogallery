package com.galaxysoft.photogallery.web.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@ComponentScan({"com.galaxysoft.photogallery.impl",
        "com.galaxysoft.photogallery.utils",
        "com.galaxysoft.photogallery.web.controllers"})
@PropertySources({
        @PropertySource("classpath:application.yml")
})
@Configuration
@EnableWebMvc
@Import(RepositoryConfig.class)
public class SpringWebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("application.yml"));
        propertySourcesPlaceholderConfigurer.setProperties(yaml.getObject());
        return propertySourcesPlaceholderConfigurer;
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver
                = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

//    @Autowired
//    private FormatConverter formatConverter;
//
//    @Autowired
//    private PaperTypeConverter paperTypeConverter;
//
//    @Autowired
//    private IntConverter intConverter;
//
//    @Autowired
//    private FloatConverter floatConverter;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/favicon.ico").addResourceLocations("/resources/favicon.ico");
    }

    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        cookieLocaleResolver.setDefaultLocale(StringUtils.parseLocaleString("ru"));
        return cookieLocaleResolver;
    }

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {

        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:messages", "classpath:labels", "classpath:emails");
        // if true, the key of the message will be displayed if the key is not
        // found, instead of throwing a NoSuchMessageException
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setDefaultEncoding("UTF-8");
        // # -1 : never reload, 0 always reload
        messageSource.setCacheSeconds(0);
        return messageSource;
    }

//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(String.class, FormatImpl.class, formatConverter);
//        registry.addConverter(String.class, PaperType.class, paperTypeConverter);
//        registry.addConverter(String.class, Integer.class, intConverter);
//        registry.addConverter(floatConverter);
//    }

}
