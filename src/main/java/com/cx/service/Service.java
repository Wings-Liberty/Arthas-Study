package com.cx.service;

import cn.hutool.core.util.ObjectUtil;
import com.cx.bean.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Service implements IService {

    private static final String SERVICE_NAME = "arthas-test-service";

    /**
     * 如果是 private，arthas 就不能直接用 . 访问属性
     */
    @Value("${hello}")
    public String hello;

    @Override
    public void throwException() {
        throw new RuntimeException("抛异常了");
    }

    @Override
    public Integer getHashCode(User user) {
        if (ObjectUtil.isAllNotEmpty(user, user.getUsername(), user.getPassword())){
            return user.hashCode();
        }
        return null;
    }

    /**
     * 模拟收到空值报空指针异常
     * @param hashCode
     */
    @Override
    public void logHashCode(Integer hashCode) {
        if (ObjectUtil.isEmpty(hashCode)) {
            throw new NullPointerException("空指针了，也不知道是哪空指针了");
        }
        log.info("user's hashCode is {}", hashCode);
    }
}
