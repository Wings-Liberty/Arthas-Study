package com.test;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class IPTest {

    @Test
    public void getLocalHostIP() throws UnknownHostException {
        System.out.println(InetAddress.getLocalHost().getHostAddress());
    }

    @Test
    public void test() throws UnknownHostException {
        List<String> firstList = null;
        for (String s : firstList) {
            System.out.println(s);
        }

    }

}
