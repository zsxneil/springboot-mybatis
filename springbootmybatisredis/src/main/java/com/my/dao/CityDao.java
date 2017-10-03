package com.my.dao;

import com.my.domain.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 城市dao接口类
 * Created by Administrator on 2017/10/3.
 */
public interface CityDao {
    /**
     *
     * 获取城市信息列表
     *
     * @return
     */
    List<City> findAllCity();

    /**
     * 根据id查询城市信息
     * @param id
     * @return
     */
    City findById(@Param("id") Long id);
    Long saveCity(City city);
    Long updateCity(City city);
    Long deleteCity(Long id);
}
