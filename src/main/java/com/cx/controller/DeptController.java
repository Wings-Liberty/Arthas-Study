package com.cx.controller;

import com.cx.common.R;
import com.cx.entity.DeptEntity;
import com.cx.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;



/**
 * 
 *
 * @author cx
 * @email chang_xu_@outlook.com
 * @date 2022-12-03 22:59:04
 */
@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		DeptEntity dept = deptService.getById(id);
        return R.ok().put("dept", dept);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody DeptEntity dept){
		deptService.save(dept);
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody DeptEntity dept){
		deptService.updateById(dept);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		deptService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }

}
