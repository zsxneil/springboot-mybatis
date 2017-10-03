package com.my.service.impl;

import com.my.dao.CityDao;
import com.my.domain.City;
import com.my.service.CityService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/10/3.
 */
@Service
public class CityServiceImpl implements CityService {

    private static final Logger logger = Logger.getLogger(CityServiceImpl.class);

    @Autowired
    private CityDao cityDao;



    /**
     * 获取城市逻辑
     * 如果缓存存在，从缓存中获取城市信息
     * 如果缓存中不存在，则从db中获取
     * @param id
     * @return
     */
    @Override
    @Cacheable(value = "cityCache",keyGenerator = "wiselyKeyGenerator")
    public City findCityById(Long id) {

        // 从 DB 中获取城市信息
        City city = cityDao.findById(id);
        logger.info("未发现缓存，从db中查找到 >> " + (city == null ? null : city.toString()));
        return city;
    }

    @Override
    public Long saveCity(City city) {
        Long ret = cityDao.saveCity(city);
        return ret;
    }

    /**
     * 更新城市逻辑：
     * 如果缓存存在，删除
     * 如果缓存不存在，不操作缓存，只更新数据库
     */
    @CacheEvict(value = "cityCache",key = "'com.my.service.impl.CityServiceImplfindCityById' + #city.id")
    @Override
    public City updateCity(City city) {
        Long ret = cityDao.updateCity(city);
        return findCityById(city.getId());
    }

    /**
     * 删除城市逻辑：
     * 如果缓存存在，删除
     * 如果缓存不存在，不操作缓存，只更新数据库
     */

    @CacheEvict(value = "cityCache",key = "'com.my.service.impl.CityServiceImplfindCityById' + #id")
    @Override
    public Long deleteCity(Long id) {
        Long ret = cityDao.deleteCity(id);
        return ret;
    }
}
