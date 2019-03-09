package edu.tust.springsecuritydemo.service.impl;

import edu.tust.springsecuritydemo.dao.ISysUserDao;
import edu.tust.springsecuritydemo.entity.SysUser;
import edu.tust.springsecuritydemo.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: Linht
 * Date: 2019/3/7
 * Time: 17:56
 */
@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    ISysUserDao sysUserDao;

    @Override
    public SysUser getSysUserByUsername(String username) {
        return sysUserDao.getSysUserByUsername(username);
    }
}
