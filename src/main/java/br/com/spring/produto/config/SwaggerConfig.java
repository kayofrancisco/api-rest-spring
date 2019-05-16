package br.com.spring.produto.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.bytebuddy.asm.Advice.Return;
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
	public Docket produtoAPI() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("br.com.spring.produto")).paths(regex("/produto")).build()
				.apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo("Produto API REST", 
				"API REST para gerenciamento de produtos", 
				"1.0", 
				"Termos do serviço", 
				new Contact("Kayo Francisco", 
						"https://www.kayofrancisco.com.br", 
						"kayofrancisco@hotmail.com"), 
					"Apache version lisence", 
						"http://apache.lisence.com", new ArrayList<VendorExtension>());
		return apiInfo;
	}
	
}
