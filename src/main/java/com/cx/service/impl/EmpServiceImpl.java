package com.cx.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.utils.PageUtils;
import com.common.utils.Query;

import com.cx.dao.EmpDao;
import com.cx.entity.EmpEntity;
import com.cx.service.EmpService;


@Service("empService")
public class EmpServiceImpl extends ServiceImpl<EmpDao, EmpEntity> implements EmpService {


}