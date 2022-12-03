package com.cx.service;

import com.cx.bean.entity.User;

public interface IService {

    void hello();

    void throwException();

    Integer getHashCode(User user);

    void logHashCode(Integer hashCode);
}
