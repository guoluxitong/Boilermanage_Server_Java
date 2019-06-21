package com.itdreamworks.boilermanage.entity;

import java.io.Serializable;

public class RepairInfo implements Serializable {

    private Integer Id;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getRepairUserId() {
        return repairUserId;
    }

    public void setRepairUserId(Integer repairUserId) {
        this.repairUserId = repairUserId;
    }

    public String getRepairUserName() {
        return repairUserName;
    }

    public void setRepairUserName(String repairUserName) {
        this.repairUserName = repairUserName;
    }

    public String getRepairContent() {
        return repairContent;
    }

    public void setRepairContent(String repairContent) {
        this.repairContent = repairContent;
    }

    public String getRepairDatetime() {
        return repairDatetime;
    }

    public void setRepairDatetime(String repairDatetime) {
        this.repairDatetime = repairDatetime;
    }

    public String getBoilerNo() {
        return boilerNo;
    }

    public void setBoilerNo(String boilerNo) {
        this.boilerNo = boilerNo;
    }

    public String getInputDatetime() {
        return inputDatetime;
    }

    public void setInputDatetime(String inputDatetime) {
        this.inputDatetime = inputDatetime;
    }

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public String getControllerNo() {
        return controllerNo;
    }

    public void setControllerNo(String controllerNo) {
        this.controllerNo = controllerNo;
    }

    private Integer productId;
    private Integer repairUserId;
    private String repairUserName,repairContent,repairDatetime,boilerNo,inputDatetime,inputName,controllerNo;

}
