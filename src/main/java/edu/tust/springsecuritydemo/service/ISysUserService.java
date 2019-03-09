package edu.tust.springsecuritydemo.service;

import edu.tust.springsecuritydemo.entity.SysUser;

/**
 * Created by IntelliJ IDEA.
 * User: Linht
 * Date: 2019/3/7
 * Time: 17:43
 */
public interface ISysUserService {

    SysUser getSysUserByUsername(String username);
}
