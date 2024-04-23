package com.sky.controller.admin;


import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.SetmealService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@Api(tags = "套餐管理相关接口")
@RequestMapping("/admin/setmeal")

public class SetmealController {


    @Autowired
    private SetmealService setmealService;






    @PostMapping
    @ApiOperation("保存套餐信息")
    public Result save(@RequestBody SetmealDTO setmealDTO){

        log.info("保存套餐信息,{}",setmealDTO);


        setmealService.saveWithDish(setmealDTO);
        return Result.success();
    }



    @GetMapping("/page")

    @ApiOperation("套餐分页查询")

    public Result<PageResult> page(SetmealPageQueryDTO setmealPageQueryDTO){

        log.info("套餐分页查询,{}",setmealPageQueryDTO);
        PageResult pageResult=setmealService.pageQuery(setmealPageQueryDTO);
        return Result.success(pageResult);

    }
}
