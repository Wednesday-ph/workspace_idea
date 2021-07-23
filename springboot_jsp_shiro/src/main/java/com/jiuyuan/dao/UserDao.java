package com.jiuyuan.dao;

import com.jiuyuan.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author shkstart
 * @create 2021-07-23 15:28
 */
@Mapper
@Repository
public interface UserDao {
    void save(User user);
}
