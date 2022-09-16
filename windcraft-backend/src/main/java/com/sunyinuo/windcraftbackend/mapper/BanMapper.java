package com.sunyinuo.windcraftbackend.mapper;

import com.sunyinuo.windcraftbackend.model.Ban;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Ban表mapper
 * @author sunyinuo
 */
@Mapper
public interface BanMapper {

    /**
     * 获取所有用户
     * @return 实体类列表
     */
    List<Ban> getBanList();
    /**
     * 根据id查询所有
     * @param id id
     * @return 实体类
     */
    Ban getBanById(int id);

    /**
     * 根据source查询所有
     * @param source 来源
     * @return 实体类列表
     */
    List<Ban> getBanBySource(String source);

    /**
     * 根据reason查询所有
     * @param reason 原因
     * @return 实体类列表
     */
    List<Ban> getBanByReason(String reason);

    /**
     * 根据banTime查询所有
     * @param banTime 封禁时间
     * @return 实体类列表
     */
    List<Ban> getBanByBanTime(String banTime);

    /**
     * 根据unBanTime查询所有
     * @param unBanTime 解禁时间
     * @return 实体类列表
     */
    List<Ban> getBanByUnBanTime(String unBanTime);

    /**
     * 根据banType查询所有
     * @param banType 封禁类型
     * @return 实体类列表
     */
    List<Ban> getBanByBanType(String banType);

    /**
     * 根据name查询所有
     * @param name 游戏名
     * @return 实体类列表
     */
    List<Ban> getBanByName(String name);

    /**
     * 新增
     * @param ban 实体类
     * @return 是否成功
     */
    int addBan(Ban ban);

    /**
     * 根据name删除记录
     * @param name 游戏名
     * @return 是否成功
     */
    int deleteBanByName(String name);
}
