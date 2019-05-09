package com.itdreamworks.boilermanage.entity;


public class ProductTypeAmountClass {
    private int amount;
    private String mediumType;
    private String fuelType;
    public int getAmount(){
        return amount;
    }
    public void setAmount(int amount){
        this.amount = amount;
    }
    public String getMediumType(){
        return mediumType;
    }
    public void setMediumType(String mediumType){
        this.mediumType = mediumType;
    }
    public String getFuelType(){
        return fuelType;
    }
    public void setFuelType(String fuelType){
        this.fuelType = fuelType;
    }
}