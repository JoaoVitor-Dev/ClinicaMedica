package com.ifto.clinicamedica;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfiguracaoSpringMvc implements WebMvcConfigurer {
    /**
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/home").setViewName("home");

        //registry.addRedirectViewController("/", "/consulta/list");
        //registry.addRedirectViewController("/home", "/consulta/list");
    }
}
