package com.cx.bean.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Website extends BaseEntity{

    private String url;

    private Long belongUser;

}
