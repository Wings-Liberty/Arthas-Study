package com.cx.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestUtil {

    public static String name = "TestUtil";

    public static String test(){
        log.info(name);
        return name;
    }

}
