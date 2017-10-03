package com.my.dao;

/**
 * Created by Administrator on 2017/10/3.
 */

import com.my.domain.City;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * 城市接口Dao类
 */
@Repository
public interface CityDao {
    /*
     *根据城市名称查询城市信息
     */
    City findByName(@Param("cityName") String cityName);
}
