package com.jiuyuan.service;

import com.jiuyuan.entity.Permission;
import com.jiuyuan.entity.User;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-07-23 15:34
 */
public interface UserService {
    void register(User user);

    User findByUsername(String username);

    User findRolesByUsername(String username);

    List<Permission> findPermsByRoleid(String rid);
}
