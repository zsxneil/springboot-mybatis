package com.my.dao;

/**
 * Created by Administrator on 2017/10/3.
 */

import com.my.domain.City;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * 城市接口Dao类
 */
@Mapper //标识为mybatis的Mapper
public interface CityDao {
    /*
     *根据城市名称查询城市信息
     */
    @Select("select * from city")
    // 返回 Map 结果集
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "province_id",property = "provinceId"),
            @Result(column = "city_name",property = "cityName"),
            @Result(column = "description",property = "description")
    })
    City findByName(@Param("cityName") String cityName);
}
