package com.epam.freelancer.model;

/**
 * Created by Максим on 16.01.2016.
 */
public class Technology implements BaseEntity<Integer> {
    private Integer id;
    private String name;
    private Boolean isDeleted;


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
