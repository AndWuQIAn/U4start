package cn.kgc.house.domain;

import cn.kgc.house.utils.PageBean;

/**
 *  条件类
 */
public class Condition extends PageBean {

    private String title;

    private  Long startprice;

    private Long endprice;

    private  Integer dis_id;

    private  Integer street_id;

    private  Integer ltfloorage;

    private Integer gtfloorage;

    private Integer betfloorage;

    private  Integer type_id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getStartprice() {
        return startprice;
    }

    public void setStartprice(Long startprice) {
        this.startprice = startprice;
    }

    public Long getEndprice() {
        return endprice;
    }

    public void setEndprice(Long endprice) {
        this.endprice = endprice;
    }

    public Integer getDis_id() {
        return dis_id;
    }

    public void setDis_id(Integer dis_id) {
        this.dis_id = dis_id;
    }

    public Integer getStreet_id() {
        return street_id;
    }

    public void setStreet_id(Integer street_id) {
        this.street_id = street_id;
    }

    public Integer getLtfloorage() {
        return ltfloorage;
    }

    public void setLtfloorage(Integer ltfloorage) {
        this.ltfloorage = ltfloorage;
    }

    public Integer getGtfloorage() {
        return gtfloorage;
    }

    public void setGtfloorage(Integer gtfloorage) {
        this.gtfloorage = gtfloorage;
    }

    public Integer getBetfloorage() {
        return betfloorage;
    }

    public void setBetfloorage(Integer betfloorage) {
        this.betfloorage = betfloorage;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }
}
