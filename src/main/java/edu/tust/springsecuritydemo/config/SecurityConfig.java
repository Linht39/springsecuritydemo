package edu.tust.springsecuritydemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * Created by IntelliJ IDEA.
 * User: Linht
 * Date: 2019/3/7
 * Time: 14:14
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAccessDecisionManager customAccessDecisionManager;
    @Autowired
    private CustomSecurityMetadataSource customSecurityMetadataSource;
    @Autowired
    private CustomUserDetailsAuthenticationProvider customUserDetailsAuthenticationProvider;

    /**
     * 装配一个自定义Filter
     *
     * @return
     */
    @Bean
    public FilterSecurityInterceptor customFilterSecurityInterceptor() {
        FilterSecurityInterceptor filterSecurityInterceptor = new FilterSecurityInterceptor();
        filterSecurityInterceptor.setAccessDecisionManager(this.customAccessDecisionManager);
        filterSecurityInterceptor.setSecurityMetadataSource(this.customSecurityMetadataSource);
        return filterSecurityInterceptor;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(this.customUserDetailsAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(this.customFilterSecurityInterceptor(), FilterSecurityInterceptor.class);
        http.formLogin();
        http.logout().logoutUrl("/logout").permitAll();
        http.csrf().disable();
    }
}
