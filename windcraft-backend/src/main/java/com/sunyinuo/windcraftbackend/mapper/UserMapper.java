package com.sunyinuo.windcraftbackend.mapper;

import com.sunyinuo.windcraftbackend.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * User表mapper层
 * @author sunyinuo
 */
@Mapper
public interface UserMapper {
    /**
     * 获取所有用户
     * @return 用户实体类List
     */
    @Select("select * from user")
    List<User> getUserList();


    /**
     * 根据id查询所有用户
     * @param id id
     * @return 用户实体类
     */
    @Select("select * from user where id = #{id}")
    List<User> getUserById(int id);

    /**
     * 根据userName查询所有用户
     * @param userName 用户名
     * @return 用户实体类
     */
    @Select("select * from user where userName = #{userName}")
    User getUserByName(String userName);

    /**
     * 根据userPassword查询所有用户
     * @param userPassword 密码
     * @return 用户实体类
     */
    @Select("select * from user where userPassword = #{userPassword}")
    List<User> getUserByPassword(String userPassword);

    /**
     * 根据time查询所有用户
     * @param time 时间
     * @return 用户实体类
     */
    @Select("select * from user where time = #{time}")
    List<User> getUserByTime(long time);

    /**
     * 根据ip查询所有用户
     * @param ip ip
     * @return 用户实体类
     */
    @Select("select * from user where ip = #{ip}")
    List<User> getUserByIp(String ip);

    /**
     * 添加用户
     * @param user 用户实体类
     * @return 是否成功
     */
    @Insert("insert into user(id, userName, userPassword, time, ip) value (#{id},#{userName},#{userPassword},#{time},#{ip})")
    int addUser(User user);

    /**
     * 根据userName删除用户
     * @param userName 用户名
     * @return 是否成功
     */
    @Delete("delete from user where userName = #{userName}")
    int deleteUserByName(String userName);
}
