package com.algorythmia.springbootalgorythmia.config;


import com.algorythmia.springbootalgorythmia.entity.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private String theAllowedOrigins = "http://localhost:3000";
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        cors.addMapping(config.getBasePath() + "/**")
                .allowedOrigins(theAllowedOrigins)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("Content-Type", "Accept", "X-Requested-With", "remember-me","Access-Control-Allow-Origin")
                .allowCredentials(true)
        .maxAge(3600);
        config.exposeIdsFor(Product.class);
        config.exposeIdsFor(Order.class);
        config.exposeIdsFor(ProductCategory.class);
        config.exposeIdsFor(Customer.class);
        config.exposeIdsFor(BillingAddress.class);
        config.exposeIdsFor(ShippingAddress.class);

    }
}


