package edu.tust.springsecuritydemo.service.impl;

import edu.tust.springsecuritydemo.dao.ISysRoleDao;
import edu.tust.springsecuritydemo.entity.SysRole;
import edu.tust.springsecuritydemo.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Linht
 * Date: 2019/3/7
 * Time: 17:59
 */
@Service
public class SysRoleServiceImpl implements ISysRoleService {

    @Autowired
    ISysRoleDao sysRoleDao;

    @Override
    public List<SysRole> getSysRoleByUsername(String username) {
        return sysRoleDao.getSysRoleByUsername(username);
    }

    @Override
    public List<SysRole> getSysRoleByUrl(String url) {
        return sysRoleDao.getSysRoleByUrl(url);
    }
}
