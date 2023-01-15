package com.webservices.bykeapi.repository;

public class BikeFull {
//    {
//        "brand": "LAPIERRE X-CONTROL 3",
//            "cassette": "11/42",
//            "id": 1,
//            "owner": {
//            "id": 1,
//                    "name": "Merlot"
//        },
//        "purchaseDate": "2013-11-10",
//            "type": "mountain",
//            "wheels": "29.00"
//    }
    private int id;
    private String brand;
    private String cassette;
    private String wheels;
    private String purchaseDate;
    private String type;
    private UserSimple owner;

    public BikeFull(
            int id,
            String brand,
            String cassette,
            String wheels,
            String purchaseDate,
            String type,
            UserSimple owner
    ) {
        this.id = id;
        this.brand = brand;
        this.cassette = cassette;
        this.wheels = wheels;
        this.purchaseDate = purchaseDate;
        this.type = type;
        this.owner = owner;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getCassette() {
        return this.cassette;
    }

    public void setCassette(String cassette) {
        this.cassette = cassette;
    }
    public String getWheels() {
        return this.wheels;
    }

    public void setWheels(String wheels) {
        this.wheels = wheels;
    }
    public String getPurchaseDate() {
        return this.purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public UserSimple getOwner() {
        return this.owner;
    }

    public void setOwner(UserSimple owner) {
        this.owner = owner;
    }
}
