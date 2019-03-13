package edu.tust.springsecuritydemo.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: Linht
 * Date: 2019/3/7
 * Time: 13:41
 */
public class SysUser implements UserDetails, Serializable {

    private static final Long serialVersionUID = 1L;

    private Long id;
    private String username;
    private String password;
    private List<SysRole> sysRoles;

    public SysUser(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public SysUser(String username, String password, List<SysRole> sysRoles) {
        this.username = username;
        this.password = password;
        this.sysRoles = sysRoles;
    }

    public SysUser(Long id, String username, String password, List<SysRole> sysRoles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sysRoles = sysRoles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new Vector<>();
        List<SysRole> sysRoles = this.getSysRoles();
        for (SysRole sysRole : sysRoles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(sysRole.getRoleName()));
        }
        return grantedAuthorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SysRole> getSysRoles() {
        return sysRoles;
    }

    public void setSysRoles(List<SysRole> sysRoles) {
        this.sysRoles = sysRoles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sysRoles=" + sysRoles +
                '}';
    }
}
