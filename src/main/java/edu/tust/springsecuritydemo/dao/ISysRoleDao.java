package edu.tust.springsecuritydemo.dao;

import edu.tust.springsecuritydemo.entity.SysRole;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Linht
 * Date: 2019/3/7
 * Time: 14:06
 */
public interface ISysRoleDao {

    List<SysRole> getSysRoleByUserId(Long userId);

    List<SysRole> getSysRoleByUrl(String url);
}
