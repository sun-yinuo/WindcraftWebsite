package com.sunyinuo.windcraftbackend.service.impl;

import com.sunyinuo.windcraftbackend.mapper.BanMapper;
import com.sunyinuo.windcraftbackend.model.Ban;
import com.sunyinuo.windcraftbackend.service.BanService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Ban
 * @author sunyinuo
 */
@Service
public class BanServiceImpl implements BanService {

    private final BanMapper banMapper;

    public BanServiceImpl(BanMapper banMapper) {
        this.banMapper = banMapper;
    }

    /**
     * 获取所有用户
     * @return 实体类列表
     */
    @Override
    public List<Ban> getUserList() {
        return banMapper.getUserList();
    }

    /**
     * 根据id查询所有
     *
     * @param id id
     * @return 实体类
     */
    @Override
    public Ban getUserById(String id) {
        return banMapper.getUserById(id);
    }

    /**
     * 根据source查询所有
     *
     * @param source 来源
     * @return 实体类列表
     */
    @Override
    public List<Ban> getUserBySource(String source) {
        return banMapper.getUserBySource(source);
    }

    /**
     * 根据reason查询所有
     *
     * @param reason 原因
     * @return 实体类列表
     */
    @Override
    public List<Ban> getUserByReason(String reason) {
        return banMapper.getUserByReason(reason);
    }

    /**
     * 根据banTime查询所有
     *
     * @param banTime 封禁时间
     * @return 实体类列表
     */
    @Override
    public List<Ban> getUserByBanTime(String banTime) {
        return banMapper.getUserByBanTime(banTime);
    }

    /**
     * 根据unBanTime查询所有
     *
     * @param unBanTime 解禁时间
     * @return 实体类列表
     */
    @Override
    public List<Ban> getUserByUnBanTime(String unBanTime) {
        return banMapper.getUserByUnBanTime(unBanTime);
    }

    /**
     * 根据banType查询所有
     *
     * @param banType 封禁类型
     * @return 实体类列表
     */
    @Override
    public List<Ban> getUserByBanType(String banType) {
        return banMapper.getUserByBanType(banType);
    }

    /**
     * 根据name查询所有
     *
     * @param name 游戏名
     * @return 实体类列表
     */
    @Override
    public List<Ban> getUserByName(String name) {
        return banMapper.getUserByName(name);
    }

    /**
     * 新增
     *
     * @param ban 实体类
     * @return 是否成功
     */
    @Override
    public int addUser(Ban ban) {
       return banMapper.addUser(ban);
    }

    /**
     * 根据name删除记录
     *
     * @param name 游戏名
     * @return 是否成功
     */
    @Override
    public int deleteUserByName(String name) {
        return banMapper.deleteUserByName(name);
    }
}
