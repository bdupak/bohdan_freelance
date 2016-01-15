package com.epam.freelancer.model;

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
}
