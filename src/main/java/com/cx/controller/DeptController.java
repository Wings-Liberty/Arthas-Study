package com.cx.controller;

import java.util.Arrays;
import java.util.Map;

import com.cx.common.PageUtils;
import com.cx.common.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cx.entity.DeptEntity;
import com.cx.service.DeptService;



/**
 * 
 *
 * @author cx
 * @email chang_xu_@outlook.com
 * @date 2022-12-03 22:59:04
 */
@RestController
@RequestMapping("cx/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		DeptEntity dept = deptService.getById(id);
        return R.ok().put("dept", dept);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DeptEntity dept){
		deptService.save(dept);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DeptEntity dept){
		deptService.updateById(dept);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		deptService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }

}
