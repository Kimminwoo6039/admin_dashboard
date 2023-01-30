package com.level.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    // 로깅 설정 (logging)
    private static Logger logger = LoggerFactory.getLogger(MvcConfiguration.class);

    // 의존성 주입(application.properties)
    @Autowired
    Environment environment;

    // application-dev.properties (resources.uri-path 값)
    @Value("${resources.uri-path}")
    private String resourcesUriPath;

    // application-dev.properties (resources.location 값)
    @Value("${resources.location}")
    private String resourcesLocation;

    // JSP 환경설정
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/",".jsp");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (environment.acceptsProfiles(Profiles.of("dev"))) {
            if (!Boolean.parseBoolean(environment.getProperty("file.synchronize.prod"))) {
                resourcesLocation = "file:" + System.getProperty("user.dir") + resourcesLocation;
                logger.debug("resourcesLocation : {}", resourcesLocation);
            }
        }
        registry.addResourceHandler(resourcesUriPath + "/**")
                .addResourceLocations(resourcesLocation);

    }

    // 인터셉터 주입
//    @Bean
//    public AuthInterceptor authInterceptor() {
//        return new AuthInterceptor();
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/ip-check", "/eng/ip-check", "/upload/**", "/css/**", "/images/**", "/font/**",
//                        "/js/**", "/svg/**", "/vendor/**", "/favicon.ico", "/admin/assets/**", "/error");
//    }


}