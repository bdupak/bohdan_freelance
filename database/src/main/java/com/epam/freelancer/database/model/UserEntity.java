package com.epam.freelancer.database.model;

import java.util.Locale;

public interface UserEntity extends BaseEntity<Integer> {
    String getEmail();

    void setEmail(String email);

    String getPassword();

    void setPassword(String password);

    String getUuid();

    void setUuid(String uuid);

    Locale getLocale();

    void setLocale(Locale locale);

    String getFname();

    void setFname(String fname);

    String getLname();

    void setLname(String lname);

    String getLang();

    void setLang(String lang);
    
    String getSalt();
    
    void setSalt(String salt);
}
