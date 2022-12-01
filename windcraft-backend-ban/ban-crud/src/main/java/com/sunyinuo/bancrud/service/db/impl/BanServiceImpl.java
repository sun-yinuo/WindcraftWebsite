package com.sunyinuo.bancrud.service.db.impl;

import com.sunyinuo.bancrud.mapper.BanMapper;
import com.sunyinuo.bancrud.model.Ban;
import com.sunyinuo.bancrud.service.db.BanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Ban
 * @author sunyinuo
 */
@Service
public class BanServiceImpl implements BanService {

    @Resource
    private BanMapper banMapper;

    /**
     * 获取所有
     * @return 实体类列表
     */
    @Override
    public List<Ban> getBanList() {
        return banMapper.getBanList();
    }

    /**
     * 根据id查询所有
     *
     * @param id id
     * @return 实体类
     */
    @Override
    public Ban getBanById(int id) {
        return banMapper.getBanById(id);
    }

    /**
     * 根据source查询所有
     *
     * @param source 来源
     * @return 实体类列表
     */
    @Override
    public List<Ban> getBanBySource(String source) {
        return banMapper.getBanBySource(source);
    }

    /**
     * 根据reason查询所有
     *
     * @param reason 原因
     * @return 实体类列表
     */
    @Override
    public List<Ban> getBanByReason(String reason) {
        return banMapper.getBanByReason(reason);
    }

    /**
     * 根据banTime查询所有
     *
     * @param banTime 封禁时间
     * @return 实体类列表
     */
    @Override
    public List<Ban> getBanByBanTime(String banTime) {
        return banMapper.getBanByBanTime(banTime);
    }

    /**
     * 根据unBanTime查询所有
     *
     * @param unBanTime 解禁时间
     * @return 实体类列表
     */
    @Override
    public List<Ban> getBanByUnBanTime(String unBanTime) {
        return banMapper.getBanByUnBanTime(unBanTime);
    }

    /**
     * 根据banType查询所有
     *
     * @param banType 封禁类型
     * @return 实体类列表
     */
    @Override
    public List<Ban> getBanByBanType(String banType) {
        return banMapper.getBanByBanType(banType);
    }

    /**
     * 根据name查询所有
     *
     * @param name 游戏名
     * @return 实体类列表
     */
    @Override
    public List<Ban> getBanByName(String name) {
        return banMapper.getBanByName(name);
    }

    /**
     * 新增
     *
     * @param ban 实体类
     * @return 是否成功
     */
    @Override
    public int addBan(Ban ban) {
       return banMapper.addBan(ban);
    }

    /**
     * 根据name删除记录
     *
     * @param name 游戏名
     * @return 是否成功
     */
    @Override
    public int deleteBanByName(String name) {
        return banMapper.deleteBanByName(name);
    }
}
