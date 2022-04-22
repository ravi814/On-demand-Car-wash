package com.ondemandcarwash;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableSwagger2
@EnableEurekaClient
public class WasherApplication {
	
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(WasherApplication.class, args);
	}
	
	public static final String WASHER_TAG = "washer service";
	  
	 @Bean 
	 public Docket swaggerConfiguration() 
	 { 
		 return new Docket(DocumentationType.SWAGGER_2) 
				 .select()
				 .paths(PathSelectors.ant("/washer/**"))
				 .apis(RequestHandlerSelectors.basePackage("com.ondemandcarwash")) 
				 .build()
				 .tags(new Tag(WASHER_TAG, "the washer API with description api tag"));
	 }
	 
		
}
