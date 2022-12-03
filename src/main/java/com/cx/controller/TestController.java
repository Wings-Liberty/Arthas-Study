package com.cx.controller;


import cn.hutool.core.util.ObjectUtil;
import com.cx.bean.entity.User;
import com.cx.common.R;
import com.cx.service.IService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 参数传什么，接口返回什么
 */
@Slf4j
@RestController
@RequestMapping("/echo")
public class TestController {

    @Value("${hello}")
    private String hello;

    @Autowired
    private IService service;

    /**
     * 测试接口
     * @return
     */
    @GetMapping("/test")
    public String test() {
        log.info("test");
        log.debug("debug test");
        return "test";
    }

    @PostMapping("/user")
    public R echoUser(@RequestBody User user){
        log.info("user");
        log.debug("debug {}", user);
        return R.ok(user);
    }

    @GetMapping("/ok")
    public R echoOk() {
        log.info("ok");
        log.debug("debug ok");
        return R.ok("ok");
    }

    @GetMapping("/error")
    public R echoError() {
        log.info("error");
        log.debug("debug error");
        return R.error();
    }

    @GetMapping("/exception")
    public R echoException() {
        log.info("exception");
        log.debug("debug exception");
        service.throwException();
        return R.error();
    }

    /**
     * 测试用例：传 null ，不传 null
     * @param user
     * @return
     */
    @PostMapping("/user/hashCode")
    public R echoUserHashCode(@RequestBody User user){
        log.info("user");
        Integer hashCode = service.getHashCode(user);
        service.logHashCode(hashCode);
        return R.ok(hashCode);
    }

    /**
     * 测试用例 file 为 null 或不为 null
     * @param file
     * @return
     */
    @PostMapping("/fileName")
    public R echoFileName(MultipartFile file){
        if (ObjectUtil.isEmpty(file)) {
            throw new RuntimeException("controller 直接抛异常");
        }
        String filename = file.getOriginalFilename();
        log.info("file name is {}", filename);
        return R.ok(filename);
    }

}
