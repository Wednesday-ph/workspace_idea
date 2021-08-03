package com.jiuyuan.service;

import com.jiuyuan.dao.UserDao;
import com.jiuyuan.entity.Permission;
import com.jiuyuan.entity.User;
import com.jiuyuan.utils.SaltUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-07-23 15:35
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void register(User user) {
        String salt = SaltUtils.getSalt(8);
        user.setSalt(salt);
        Md5Hash md5Hash = new Md5Hash(user.getPassword(), salt, 1024);
        user.setPassword(md5Hash.toHex());

        userDao.save(user);

    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User findRolesByUsername(String username) {
        return userDao.findRolesByUsername(username);
    }

    @Override
    public List<Permission> findPermsByRoleid(String rid) {
        return userDao.findPermsByRoleid(rid);
    }
}
