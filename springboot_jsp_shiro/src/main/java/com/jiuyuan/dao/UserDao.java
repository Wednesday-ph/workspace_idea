package com.jiuyuan.dao;

import com.jiuyuan.entity.Permission;
import com.jiuyuan.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-07-23 15:28
 */
@Mapper
@Repository
public interface UserDao {
    void save(User user);

    User findByUsername(String username);

    User findRolesByUsername(String username);

    List<Permission> findPermsByRoleid(String rid);
}
