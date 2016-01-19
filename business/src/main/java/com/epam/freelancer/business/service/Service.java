package com.epam.freelancer.business.service;

import com.epam.freelancer.business.util.ValidationParametersBuilder.Parameters;
import com.epam.freelancer.database.model.BaseEntity;
import com.epam.freelancer.database.model.UserEntity;

import java.util.List;
import java.util.Map;

public interface Service<T extends BaseEntity<ID>, ID> {
	T create(Map<String, String[]> data);

    T modify(T entity);

    void remove(T entity);

    T findById(ID id);

    List<T> findAll();

    void encodePassword(UserEntity userEntity);

/*	public default String encodePassword(String password)
            throws NoSuchAlgorithmException
	{
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(password.getBytes());

		byte byteData[] = md.digest();
		StringBuilder encodedPassword = new StringBuilder();
		for (int i = 0; i < byteData.length; i++) {
			encodedPassword.append(Integer.toString(
					(byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		return encodedPassword.toString();
	}*/

    boolean isDataValid(Map<Parameters, String> data);
}
