package com.my.domain;

/**
 * Created by Administrator on 2017/10/3.
 */
public class City {
    /**城市编号**/
    private Long id;
    /**省份编号**/
    private Long provinceId;
    /**城市名称**/
    private String cityName;
    /**城市介绍**/
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
