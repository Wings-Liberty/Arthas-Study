package com.cx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.dao.EmpDao;
import com.cx.entity.EmpEntity;
import com.cx.service.EmpService;
import org.springframework.stereotype.Service;


@Service("empService")
public class EmpServiceImpl extends ServiceImpl<EmpDao, EmpEntity> implements EmpService {


}