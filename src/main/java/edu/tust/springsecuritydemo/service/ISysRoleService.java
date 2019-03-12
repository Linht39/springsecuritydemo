package edu.tust.springsecuritydemo.service;

import edu.tust.springsecuritydemo.entity.SysRole;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Linht
 * Date: 2019/3/7
 * Time: 17:41
 */
public interface ISysRoleService {

    List<SysRole> getSysRoleByUserId(Long userId);

    List<SysRole> getSysRoleByUrl(String url);
}
