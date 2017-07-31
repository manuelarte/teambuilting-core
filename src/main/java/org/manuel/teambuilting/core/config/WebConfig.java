package org.manuel.teambuilting.core.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addCorsMappings(final CorsRegistry registry) {
		registry.addMapping("/**");
	}

	@Bean
    @Primary
	public ObjectMapper objectMapper() {
		final ObjectMapper jsonObjectMapper = new ObjectMapper().findAndRegisterModules();
		jsonObjectMapper.configure(DeserializationFeature.ACCEPT_FLOAT_AS_INT, false);
		return jsonObjectMapper;
	}
}
