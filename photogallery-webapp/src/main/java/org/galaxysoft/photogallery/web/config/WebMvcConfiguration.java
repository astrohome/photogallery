package org.galaxysoft.photogallery.web.config;

import org.galaxysoft.photogallery.web.utils.ResourceBundleBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.faces.mvc.JsfView;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;


@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public UrlBasedViewResolver faceletsViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setViewClass(JsfView.class);
        resolver.setPrefix("/");
        resolver.setSuffix(".xhtml");
        return resolver;
    }

    @Bean
    public SimpleControllerHandlerAdapter simpleControllerHandlerAdapter() {
        return new SimpleControllerHandlerAdapter();
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
        registry.addResourceHandler("/resources*").addResourceLocations("/resources/");
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

    @Bean
    public ResourceBundleBean msg() {
        return new ResourceBundleBean();
    }

//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(String.class, IFormat.class, formatConverter);
//        registry.addConverter(String.class, IPaperType.class, paperTypeConverter);
//        registry.addConverter(String.class, Integer.class, intConverter);
//        registry.addConverter(floatConverter);
//    }

}
