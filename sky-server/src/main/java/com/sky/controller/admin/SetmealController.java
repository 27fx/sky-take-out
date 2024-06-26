package com.sky.controller.admin;


import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.SetmealService;
import com.sky.vo.SetmealVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@Api(tags = "套餐管理相关接口")
@RequestMapping("/admin/setmeal")

public class SetmealController {


    @Autowired
    private SetmealService setmealService;






    @PostMapping
    @ApiOperation("保存套餐信息")
    @CacheEvict(cacheNames = "setmealCache",key="#setmealDTO.categoryId")
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



    @DeleteMapping
    @ApiOperation("删除套餐")
    @CacheEvict(cacheNames = "setmealCache",allEntries = true)
    public Result delete(@RequestParam List<Long> ids){

        setmealService.deleteBatch(ids);
        return Result.success();
    }



    @GetMapping("/{id}")
    @ApiOperation("根据id查询套餐")
    public Result<SetmealVO> getById(@PathVariable Long id){
        log.info("根据id查询套餐,{}",id);
        SetmealVO setmealVO=setmealService.getByIdWithDish(id);
        return Result.success(setmealVO);

    }





    @PutMapping
    @ApiOperation("修改套餐内容")
    @CacheEvict(cacheNames = "setmealCache",allEntries = true)
    public Result update(@RequestBody SetmealDTO setmealDTO){


        setmealService.update(setmealDTO);

        return Result.success();

    }


    @PostMapping("/status/{status}")
    @ApiOperation("更改套餐起售状态")
    @CacheEvict(cacheNames = "setmealCache",allEntries = true)

    public Result startOrStop(@PathVariable Integer status,Long id){
        setmealService.startOrStop(status,id);
        return Result.success();
    }






}
