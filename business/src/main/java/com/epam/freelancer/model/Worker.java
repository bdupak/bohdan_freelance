package com.epam.freelancer.model;

/**
 * Created by Максим on 16.01.2016.
 */
public class Worker implements BaseEntity<Integer> {
    private Integer id;
    private Integer orderId;
    private Integer devId;
    private Double newHourly;
    private Double sumHours;
    private Boolean isDeleted;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getDevId() {
        return devId;
    }

    public void setDevId(Integer devId) {
        this.devId = devId;
    }

    public Double getNewHourly() {
        return newHourly;
    }

    public void setNewHourly(Double newHourly) {
        this.newHourly = newHourly;
    }

    public Double getSumHours() {
        return sumHours;
    }

    public void setSumHours(Double sumHours) {
        this.sumHours = sumHours;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Boolean getDeleted() {
        return isDeleted;
    }

    @Override
    public void setDeleted(Boolean deleted) {
        this.isDeleted = deleted;
    }
}
