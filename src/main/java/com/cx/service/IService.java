package com.cx.service;

import com.cx.bean.entity.User;

public interface IService {

    void throwException();

    Integer getHashCode(User user);

    void logHashCode(Integer hashCode);
}
