package com.epam.freelancer.model;

/**
 * Created by Максим on 16.01.2016.
 */
public class Test implements BaseEntity<Integer> {
    private Integer id;
    private Integer techId;
    private String name;
    private Integer adminId;
    private Integer passScore;
    private Integer secPerQuest;
    private Boolean isDeleted;

    public Integer getTechId() {
        return techId;
    }

    public void setTechId(Integer techId) {
        this.techId = techId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getPassScore() {
        return passScore;
    }

    public void setPassScore(Integer passScore) {
        this.passScore = passScore;
    }

    public Integer getSecPerQuest() {
        return secPerQuest;
    }

    public void setSecPerQuest(Integer secPerQuest) {
        this.secPerQuest = secPerQuest;
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
