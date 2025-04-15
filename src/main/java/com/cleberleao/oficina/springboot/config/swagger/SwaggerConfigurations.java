package com.cleberleao.oficina.springboot.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.List;

@Configuration
public class SwaggerConfigurations {

	@Bean
	public Docket oficinaApi() {
		List<RequestParameter> globalParameters = Collections.singletonList(
				new RequestParameterBuilder()
						.name("Authorization")
						.description("Header para token JWT")
						.in("header")
						.required(false)
						.query(q -> q.model(m -> m.scalarModel(ScalarType.STRING)))
						.build()
		);

		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.cleberleao.oficina.springboot"))
				.paths(PathSelectors.any())
				.build()
				.globalRequestParameters(globalParameters);
	}
}