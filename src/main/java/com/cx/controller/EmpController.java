package com.cx.controller;

import java.util.Arrays;
import java.util.Map;

import com.cx.common.PageUtils;
import com.cx.common.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cx.entity.EmpEntity;
import com.cx.service.EmpService;
import com.common.utils.PageUtils;
import com.common.utils.R;



/**
 * 
 *
 * @author cx
 * @email chang_xu_@outlook.com
 * @date 2022-12-03 22:59:04
 */
@RestController
@RequestMapping("cx/emp")
public class EmpController {
    @Autowired
    private EmpService empService;


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		EmpEntity emp = empService.getById(id);
        return R.ok().put("emp", emp);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody EmpEntity emp){
		empService.save(emp);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody EmpEntity emp){
		empService.updateById(emp);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		empService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }

}
