package com.cx.bean.vo;

import com.cx.bean.entity.User;
import com.cx.bean.entity.Website;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO extends User {

    private List<Website> websiteList;

}
