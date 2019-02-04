package com.ml.helloworld.config;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

/**
 * @author Michael Liu
 */
//@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class OAuthResourceServerConfiguration extends ResourceServerConfigurerAdapter
{

  private static final String RESOURCE_ID = "my_rest_api";

  @Override
  public void configure(ResourceServerSecurityConfigurer resources) {
    resources.resourceId(RESOURCE_ID).stateless(false);
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.
        anonymous().disable()
        .requestMatchers().antMatchers("/oauth2/**")
        .and().authorizeRequests()
        .antMatchers("/oauth2/**").access("hasRole('ADMIN')")
        .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
  }

}
