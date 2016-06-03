package com.snowstore.bootAdmin.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;

import com.snowstore.log.configure.LogStashConfigure;
import com.snowstore.mercury.configuration.EnableHealth;
import com.snowstore.terra.client.TerraPropertyPlaceholderConfigurer;


@Configuration
@Import(LogStashConfigure.class)
@EnableHealth
public class WebConfig {
	
	/**配置中心
	 * @return
	 */
	@Bean
	public TerraPropertyPlaceholderConfigurer terraPropertyPlaceholderConfigurer() {
		return new TerraPropertyPlaceholderConfigurer();
	}
	
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {

		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				ErrorPage error400Page = new ErrorPage(HttpStatus.BAD_REQUEST, "/error_page/400.html");
				ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/error_page/401.html");
				ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/html/404.html");
				ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/html/500.html");
				container.addErrorPages(error400Page, error401Page, error404Page, error500Page); 
			}
		};
	}
	
}
