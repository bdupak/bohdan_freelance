package com.epam.freelancer.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Locale;

/**
 * Created by Максим on 15.01.2016.
 */
public class Developer implements UserEntity {

    private Integer id;
    private String email;
    private String password;
    private String fname;
    private String lname;
    private Boolean isDeleted;
    private Integer version;
    private Double hourly;
    private Timestamp zone;
    private Locale locale;
    private String lang;
    private String uuid;
    private String regUrl;
    private Date regDate;


    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Double getHourly() {
        return hourly;
    }

    public void setHourly(Double hourly) {
        this.hourly = hourly;
    }

    public Timestamp getZone() {
        return zone;
    }

    public void setZone(Timestamp zone) {
        this.zone = zone;
    }

    public String getRegUrl() {
        return regUrl;
    }

    public void setRegUrl(String regUrl) {
        this.regUrl = regUrl;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getLang() {
        return lang != null ? locale.toLanguageTag() : null;
    }

    public void setLang(String lang) {
        if (lang == null) {
            this.lang = null;
            return;
        }
        String[] langCode = lang.split("-");
        if (langCode.length == 2)
            this.locale = new Locale(langCode[0], langCode[1]);
        else
            this.locale = new Locale(langCode[0]);
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUuid() {
        return uuid;
    }

    @Override
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String getFname() {
        return fname;
    }

    @Override
    public void setFname(String fname) {
        this.fname = fname;
    }

    @Override
    public String getLname() {
        return lname;
    }

    @Override
    public void setLname(String lname) {
        this.lname = lname;
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
