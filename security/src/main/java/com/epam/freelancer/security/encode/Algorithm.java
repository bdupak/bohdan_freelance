package com.epam.freelancer.security.encode;

public interface Algorithm {

    String crypt(String base, String salt);
}
