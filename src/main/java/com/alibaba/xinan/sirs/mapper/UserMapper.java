package com.alibaba.xinan.sirs.mapper;

import com.alibaba.xinan.sirs.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
    @Select("SELECT id, username, password, phone_number, email, create_time, is_del FROM user WHERE id = #{id};")
    User findById(String id);
}
