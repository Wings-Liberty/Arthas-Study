package com.cx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.dao.DeptDao;
import com.cx.entity.DeptEntity;
import com.cx.service.DeptService;
import org.springframework.stereotype.Service;


@Service("deptService")
public class DeptServiceImpl extends ServiceImpl<DeptDao, DeptEntity> implements DeptService {


}