package com.libertymutual.goforcode.wimp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	//bean = an answer to an expectation; if spring is looking for something that wants a docket, it will call this method
	//will look for all the beans that are class type docket or returns type docket
	//only annotate methods as beans (?)
	@Bean 	 
	
	//fluent APIs break the "two dot rule" so it creates a natural sentence that is easy for people to read
	public Docket apiConfig() { 
		
		//.apis will document all rest controllers (using @RestController annotation)
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.libertymutual.goforcode.wimp"))
				.build();
	}
}
