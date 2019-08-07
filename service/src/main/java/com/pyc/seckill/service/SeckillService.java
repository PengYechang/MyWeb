package com.pyc.seckill.service;

import com.pyc.seckill.dto.Exposer;
import com.pyc.seckill.dto.SeckillExecution;
import com.pyc.seckill.exception.RepeatKillException;
import com.pyc.seckill.exception.SeckillCloseException;
import com.pyc.seckill.exception.SeckillException;
import com.pyc.seckill.entity.Page;
import com.pyc.seckill.entity.Seckill;

import java.util.List;

public interface SeckillService {

    /**
     * 分页查询其数据
     * @param name 秒杀名称
     * @param page 页面
     * @return
     */
    public List<Seckill> getSeckillListByFenye(String name, Page page);

    /**
     * 查询单个秒杀记录
     *
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);

    /**
     * 秒杀开启时输出秒杀接口地址
     *
     * @param seckillId
     * @return
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     *
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws RepeatKillException, SeckillCloseException, SeckillException;

    /**
     * 执行秒杀操作by procedure
     *
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5);

    /**
     * 删除一行数据
     * @param seckillId
     */
    void deleteById(long seckillId);

    /**
     * 添加一条数据
     * @param seckill
     */
    void addOneSeckill(Seckill seckill);

}
