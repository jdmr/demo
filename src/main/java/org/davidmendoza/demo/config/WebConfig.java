/*
 * Copyright 2010-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.davidmendoza.demo.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;
import java.util.Locale;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * Messages to support internationalization/localization.
     */
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    // additional webmvc-related beans
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setCache(false);
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    /**
     * Supports FileUploads.
     */
    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(500000);
        return multipartResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("locale");
        return localeChangeInterceptor;
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("en_US"));
        return localeResolver;
    }

    // implementing WebMvcConfigurer
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/img/**").addResourceLocations("/img/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/crossdomain.xml").addResourceLocations("/crossdomain.xml");
        registry.addResourceHandler("/favicon.ico").addResourceLocations("/favicon.ico");
        registry.addResourceHandler("/robots.txt").addResourceLocations("/robots.txt");
        registry.addResourceHandler("/humans.txt").addResourceLocations("/humans.txt");
        registry.addResourceHandler("/404.html").addResourceLocations("/404.html");
        registry.addResourceHandler("/405.html").addResourceLocations("/405.html");
        registry.addResourceHandler("/apple-touch-icon-114x114-precomposed.png").addResourceLocations("/apple-touch-icon-114x114-precomposed.png");
        registry.addResourceHandler("/apple-touch-icon-144x144-precomposed.png").addResourceLocations("/apple-touch-icon-144x144-precomposed.png");
        registry.addResourceHandler("/apple-touch-icon-57x57-precomposed.png").addResourceLocations("/apple-touch-icon-57x57-precomposed.png");
        registry.addResourceHandler("/apple-touch-icon-72x72-precomposed.png").addResourceLocations("/apple-touch-icon-72x72-precomposed.png");
        registry.addResourceHandler("/apple-touch-icon-precomposed.png").addResourceLocations("/apple-touch-icon-precomposed.png");
        registry.addResourceHandler("/apple-touch-icon.png").addResourceLocations("/apple-touch-icon.png");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJacksonHttpMessageConverter());
    }

    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        factory.setValidationMessageSource(messageSource);
        return factory;
    }

}