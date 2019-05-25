package com.alibaba.xinan.sirs.mapper;

import com.alibaba.xinan.sirs.entity.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Moore
 * @since 2019-05-25
 */
@Mapper
public interface AccountMapper {

    /**
     * list all
     *
     * @return all account
     */
    @Select("SELECT * FROM account")
    List<Account> listAll();

    /**
     * freeze by id
     *
     * @param id account id
     */
    @Update("UPDATE account SET status = '冻结' WHERE id = #{id}")
    void freezeAccountById(Integer id);

    /**
     * update or insert
     *
     * @param account the account
     */
    @Insert("REPLACE INTO account(id, name, sex, age, salary, location, status) " +
            "VALUES(#{id}, #{name}, #{sex}, #{age}, #{salary}, #{location}, #{status})")
    void insertOrUpdateAccount(Account account);
}
