package com.cx.util;

import com.cx.bean.entity.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestUtil {

    public static String name = "TestUtil";

    public static String test(){
        log.info(name);
        return name;
    }

    public static User echoUser(User user){
        if (user != null) {
            log.info(user.toString());
        }else {
            log.info("user is null");
        }
        return user;
    }

}
