package edu.tust.springsecuritydemo.config;

import edu.tust.springsecuritydemo.entity.SysRole;
import edu.tust.springsecuritydemo.service.ISysRoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Linht
 * Date: 2019/3/7
 * Time: 15:54
 */
@Component
public class CustomSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    ISysRoleService sysRoleService;

    /**
     * 根据请求Url返回其需要的权限
     *
     * @param obj
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object obj) throws IllegalArgumentException {

        Collection<ConfigAttribute> configAttributes = new ArrayList<>();
        String requestUrl = ((FilterInvocation) obj).getRequestUrl();

        //TODO url校验：此处逻辑可优化利用AntPathMatcher匹配Url后根据匹配Id获取权限
        if (StringUtils.isNotBlank(requestUrl) && requestUrl.contains("?")) {
            requestUrl = StringUtils.substringBefore(requestUrl, "?");
        }
        List<SysRole> sysRoles = sysRoleService.getSysRoleByUrl(requestUrl);

        for (SysRole sysRole : sysRoles) {
            configAttributes.add(new SecurityConfig(sysRole.getRoleName()));
        }
        return configAttributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
