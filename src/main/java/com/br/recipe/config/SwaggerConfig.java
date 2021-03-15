package com.br.recipe.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2

public class SwaggerConfig {
	
	@Bean
  public Docket productApi() {
      return new Docket(DocumentationType.SWAGGER_2)
              .select()
              .apis(RequestHandlerSelectors.basePackage("com.br.recipe"))
              .build()
              .apiInfo(metaInfo());
  }
	

	 private ApiInfo metaInfo() {

	        ApiInfo apiInfo = new ApiInfo(
	        		 "FastRecipe API REST",
		                "API REST FastRecipe Management.",
		                "1.0",
		                "Terms of Service",
		                new Contact("Gabrielle Duarte", "https://github.com/GabrielleDuarte",
		                        "gabrielleduartee3@gmail.com"),
	                "",
	                "", new ArrayList<VendorExtension>()
	        );

	        return apiInfo;
	    }


}