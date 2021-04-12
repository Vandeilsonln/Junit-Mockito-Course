package com.testing.tests.order.dto;

public class OrderDTO {
    public int id;
    public String status;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }
}

