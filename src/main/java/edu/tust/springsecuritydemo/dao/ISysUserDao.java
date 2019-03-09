package edu.tust.springsecuritydemo.dao;

import edu.tust.springsecuritydemo.entity.SysUser;

/**
 * Created by IntelliJ IDEA.
 * User: Linht
 * Date: 2019/3/7
 * Time: 14:04
 */
public interface ISysUserDao {

    SysUser getSysUserByUsername(String username);
}
