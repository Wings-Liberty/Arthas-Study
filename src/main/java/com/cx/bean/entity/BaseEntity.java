package com.cx.bean.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseEntity {

    private Long id;

    private Integer isDeleted;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
