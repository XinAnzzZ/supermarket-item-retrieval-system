package com.alibaba.xinan.sirs.mapper;

import com.alibaba.xinan.sirs.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author XinAnzzZ
 * @date 2018/11/22 15:51
 */
@Mapper
public interface UserMapper {

    /**
     * insert user
     *
     * @param user the user
     */
    void insert(User user);

    /**
     * find by id
     *
     * @param id the user id
     * @return the user
     */
    @Select("SELECT id, username, password, phone_number, email, create_time, is_del " +
            "FROM user WHERE id = #{id}")
    User getById(String id);

    /**
     * get by username
     *
     * @param username the username
     * @return the user
     */
    @Select("SELECT id, username, password, phone_number, email, create_time, is_del " +
            "FROM user WHERE username = #{username}")
    User getByUsername(String username);

    /**
     * find all
     *
     * @param user the user
     * @return the user list
     */
    List<User> findAll(User user);
}
