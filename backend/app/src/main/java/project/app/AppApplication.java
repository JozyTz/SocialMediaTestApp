package project.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
	
	
	 @Bean
	 public Docket myDocket() {
	 	return new Docket(DocumentationType.SWAGGER_2)
	 			.apiInfo(apiInfo())
	 			.select()
	 			.apis(RequestHandlerSelectors.any())
	 			.paths(PathSelectors.any())
	 			.build();
	 }
	
	 private ApiInfo apiInfo() {
	 	return new ApiInfoBuilder()
	 			.title("2Do5_server")
	 			.description("Hi, welcome to the backend of the Coms309 2Do5 project, here is the API document!")
	 			.termsOfServiceUrl("https://coms-402-sd-8.cs.iastate.edu:8080/terms")
	 			.contact(new Contact("YizhenXu","https://github.com/519045752/ComS402C_SD3","yizhenx@iastate.edu"))
	 			.version("0.0.2")
	 				.build();
	 	}
}
