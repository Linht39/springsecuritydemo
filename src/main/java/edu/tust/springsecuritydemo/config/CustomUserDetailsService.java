package edu.tust.springsecuritydemo.config;

import edu.tust.springsecuritydemo.entity.SysRole;
import edu.tust.springsecuritydemo.entity.SysUser;
import edu.tust.springsecuritydemo.service.ISysRoleService;
import edu.tust.springsecuritydemo.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Linht
 * Date: 2019/3/7
 * Time: 14:03
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    ISysUserService sysUserService;

    @Autowired
    ISysRoleService sysRoleService;

    /**
     * 根据username返回用户权限信息
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser sysUser = sysUserService.getSysUserByUsername(username);
        List<SysRole> sysRoles = sysRoleService.getSysRoleByUsername(username);
        sysUser.setSysRoles(sysRoles);
        return sysUser;
    }
}
