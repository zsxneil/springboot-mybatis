package com.my.service;

import com.my.domain.City;

/**
 * 城市业务逻辑接口类
 * Created by Administrator on 2017/10/3.
 */
public interface CityService {
    /**
     * 根据城市名称，查询城市信息
     * @param cityName
     * @return
     */
    City findCityByName(String cityName);
}
