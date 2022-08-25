package com.sunyinuo.windcraftbackend.mapper;

import com.sunyinuo.windcraftbackend.model.Ban;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Ban表mapper层
 * @author sunyinuo
 */
@Mapper
public interface BanMapper {

    /**
     * 获取所有用户
     * @return 实体类列表
     */
    @Select("select * from ban")
    List<Ban> getUserList();

    /**
     * 根据id查询所有
     * @param id id
     * @return 实体类
     */
    @Select("select * from ban where id = #{id}")
    Ban getUserById(String id);

    /**
     * 根据source查询所有
     * @param source 来源
     * @return 实体类列表
     */
    @Select("select * from ban where source = #{source}")
    List<Ban> getUserBySource(String source);

    /**
     * 根据reason查询所有
     * @param reason 原因
     * @return 实体类列表
     */
    @Select("select * from ban where reason = #{reason}")
    List<Ban> getUserByReason(String reason);

    /**
     * 根据banTime查询所有
     * @param banTime 封禁时间
     * @return 实体类列表
     */
    @Select("select * from ban where banTime = #{banTime}")
    List<Ban> getUserByBanTime(String banTime);

    /**
     * 根据unBanTime查询所有
     * @param unBanTime 解禁时间
     * @return 实体类列表
     */
    @Select("select * from ban where unBanTime = #{unBanTime}")
    List<Ban> getUserByUnBanTime(String unBanTime);

    /**
     * 根据banType查询所有
     * @param banType 封禁类型
     * @return 实体类列表
     */
    @Select("select * from ban where banType = #{banType}")
    List<Ban> getUserByBanType(String banType);

    /**
     * 根据name查询所有
     * @param name 游戏名
     * @return 实体类列表
     */
    @Select("select * from ban where name = #{name}")
    List<Ban> getUserByName(String name);

    /**
     * 新增
     * @param ban 实体类
     * @return 是否成功
     */
    @Insert("insert into ban(id, source, reason, banTime, unBanTime, banType, name) value (#{id}, #{source}, #{reason}, #{banTime}, #{unBanTime}, #{banType}, #{name})")
    int addUser(Ban ban);

    /**
     * 根据name删除记录
     * @param name 游戏名
     * @return 是否成功
     */
    @Delete("delete from ban where name = #{name}")
    int deleteUserByName(String name);
}
