package br.com.pw.apigatewayzull.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	private JwtTokenStore jwtTokenStore;
	
	private static final String[] PATHS_PUBLIC = {"/autorization/oauth"};
	
	private static final String[] PATHS_OPERATOR = {"/workerr/**"};
	
	private static final String[] PATHS_ADMIN = {"/payment/**", "/user/**", "/actuator/**", "/workerr/actuator/**", "/autorization/actuator/**" };
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(jwtTokenStore);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(PATHS_PUBLIC).permitAll()
		.antMatchers(HttpMethod.GET, PATHS_OPERATOR).hasAnyRole("OPERATOR", "ADMIN")
		.antMatchers(PATHS_ADMIN).hasRole("ADMIN");
	}

	
}
