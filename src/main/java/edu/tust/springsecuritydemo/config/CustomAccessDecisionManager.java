package edu.tust.springsecuritydemo.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: Linht
 * Date: 2019/3/7
 * Time: 16:34
 */
@Component
public class CustomAccessDecisionManager implements AccessDecisionManager {

    /**
     * 权限验证
     *
     * @param authentication   当前登录用户权限信息
     * @param obj              请求Url
     * @param configAttributes 请求Url需要的权限
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object obj, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {

        if (configAttributes == null || configAttributes.size() <= 0) {
            return;
        }

        Iterator<ConfigAttribute> configAttributeIterator = configAttributes.iterator();
        String needRole;
        while (configAttributeIterator.hasNext()) {
            ConfigAttribute configAttribute = configAttributeIterator.next();
            if (configAttribute == null || (needRole = configAttribute.getAttribute()) == null) {
                continue;
            }

            for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
                if (needRole.equals(grantedAuthority.getAuthority())) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("无权限");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
