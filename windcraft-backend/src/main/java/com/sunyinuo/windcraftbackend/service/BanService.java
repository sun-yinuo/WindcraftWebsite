package com.sunyinuo.windcraftbackend.service;

import com.sunyinuo.windcraftbackend.model.Ban;

import java.util.List;

/**
 * @author sunyinuo
 */
public interface BanService {

    /**
     * 获取所有用户
     * @return 实体类列表
     */
    List<Ban> getUserList();

    /**
     * 根据id查询所有
     * @param id id
     * @return 实体类
     */
    Ban getUserById(String id);

    /**
     * 根据source查询所有
     * @param source 来源
     * @return 实体类列表
     */
    List<Ban> getUserBySource(String source);

    /**
     * 根据reason查询所有
     * @param reason 原因
     * @return 实体类列表
     */
    List<Ban> getUserByReason(String reason);

    /**
     * 根据banTime查询所有
     * @param banTime 封禁时间
     * @return 实体类列表
     */
    List<Ban> getUserByBanTime(String banTime);

    /**
     * 根据unBanTime查询所有
     * @param unBanTime 解禁时间
     * @return 实体类列表
     */
    List<Ban> getUserByUnBanTime(String unBanTime);

    /**
     * 根据banType查询所有
     * @param banType 封禁类型
     * @return 实体类列表
     */
    List<Ban> getUserByBanType(String banType);

    /**
     * 根据name查询所有
     * @param name 游戏名
     * @return 实体类列表
     */
    List<Ban> getUserByName(String name);

    /**
     * 新增
     * @param ban 实体类
     * @return 是否成功
     */
    int addUser(Ban ban);

    /**
     * 根据name删除记录
     * @param name 游戏名
     * @return 是否成功
     */
    int deleteUserByName(String name);
}
