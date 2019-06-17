package com.itdreamworks.boilermanage.entity;

public class UserProduct {
    private Integer id;
    private String boilerNo;            //锅炉编号
    private Integer boilerModelNumber;  //锅炉型号
    private String boilerName;           //锅炉型号名称

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    private String controllerNo;        //控制器编号
    private Integer userId;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBoilerNo() {
        return boilerNo;
    }

    public void setBoilerNo(String boilerNo) {
        this.boilerNo = boilerNo;
    }

    public Integer getBoilerModelNumber() {
        return boilerModelNumber;
    }

    public void setBoilerModelNumber(Integer boilerModelNumber) {
        this.boilerModelNumber = boilerModelNumber;
    }

    public String getBoilerName() {
        return boilerName;
    }

    public void setBoilerName(String boilerName) {
        this.boilerName = boilerName;
    }

    public String getControllerNo() {
        return controllerNo;
    }

    public void setControllerNo(String controllerNo) {
        this.controllerNo = controllerNo;
    }

    public Float getTonnageNum() {
        return tonnageNum;
    }

    public void setTonnageNum(Float tonnageNum) {
        this.tonnageNum = tonnageNum;
    }

    public Integer getMedium() {
        return medium;
    }

    public void setMedium(Integer medium) {
        this.medium = medium;
    }

    public Integer getFuel() {
        return fuel;
    }

    public void setFuel(Integer fuel) {
        this.fuel = fuel;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    private Float tonnageNum;            //吨位
    private Integer medium;             //介质
    private Integer fuel;               //燃料
    private String longitude;           //经度
    private String latitude;            //纬度
    private String province;            //省
    private String city;                //市
    private String district;            //区
    private String street;              //街道
}
