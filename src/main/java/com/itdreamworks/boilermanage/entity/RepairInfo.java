package com.itdreamworks.boilermanage.entity;

import java.io.Serializable;

public class RepairInfo implements Serializable {

    private Integer repairId,productId,userId;

    public Integer getUserId() {
        return userId;
    }
    public String getBoilerNo() {
        return boilerNo;
    }

    public void setBoilerNo(String boilerNo) {
        this.boilerNo = boilerNo;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    private String repairName,repairContent,repairDate,boilerNo,inputDate,inputName;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getRepairId() {
        return repairId;

    }

    public String getRepairName() {
        return repairName;
    }

    public void setRepairId(Integer repairId) {
        this.repairId = repairId;
    }

    public void setRepairName(String repairName) {
        this.repairName = repairName;
    }

    public void setRepairContent(String repairContent) {
        this.repairContent = repairContent;
    }

    public void setRepairDate(String repairDate) {
        this.repairDate = repairDate;
    }

    public String getRepairContent() {
        return repairContent;
    }

    public String getRepairDate() {
        return repairDate;
    }
}
