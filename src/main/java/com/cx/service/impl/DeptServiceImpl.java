package com.cx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.common.PageUtils;
import com.cx.common.Query;
import com.cx.dao.DeptDao;
import com.cx.entity.DeptEntity;
import com.cx.service.DeptService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("deptService")
public class DeptServiceImpl extends ServiceImpl<DeptDao, DeptEntity> implements DeptService {


}