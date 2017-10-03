package com.my.service.impl;

import com.my.dao.CityDao;
import com.my.domain.City;
import com.my.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 城市业务逻辑实现类
 * Created by Administrator on 2017/10/3.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Override
    public City findCityByName(String cityName) {
        City city = cityDao.findByName(cityName);
        return city;
    }
}
