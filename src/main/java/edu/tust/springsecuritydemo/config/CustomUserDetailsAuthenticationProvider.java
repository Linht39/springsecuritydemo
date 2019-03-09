package edu.tust.springsecuritydemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: Linht
 * Date: 2019/3/7
 * Time: 17:20
 */
@Component
public class CustomUserDetailsAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    public CustomUserDetailsService getCustomUserDetailsService() {
        return customUserDetailsService;
    }

    public void setCustomUserDetailsService(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

    }

    /**
     * 登录验证
     *
     * @param username
     * @param usernamePasswordAuthenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

        if (customUserDetailsService == null) {
            throw new AuthenticationServiceException("未注入UserDetailsService");
        }

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
        if (userDetails == null) {
            throw new UsernameNotFoundException(username);
        }

        if (userDetails.getUsername().equals(usernamePasswordAuthenticationToken.getPrincipal().toString()) && userDetails.getPassword().equals(usernamePasswordAuthenticationToken.getCredentials().toString())) {
            return userDetails;
        }

        throw new BadCredentialsException(username + usernamePasswordAuthenticationToken.getCredentials());
    }
}
