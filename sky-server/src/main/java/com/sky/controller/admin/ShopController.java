package com.sky.controller.admin;


import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController("adminShopController")
@Slf4j
@RequestMapping("/admin/shop")
@Api(tags = "店铺相关接口")

public class ShopController {



    public static final String Key="SHOP_STATUS";

    @Autowired
    private RedisTemplate redisTemplate;

    @ApiOperation("设置店铺营业状态")
    @PutMapping("/{status}")
    public Result setStatus(@PathVariable Integer status){


        log.info("设置店铺的营业状态,{}",status==1?"营业中":"暂停营业中");
        redisTemplate.opsForValue().set(Key,status);
        return Result.success();
    }





    @GetMapping("/status")
    @ApiOperation("查询店铺营业状态")


    public Result<Integer> getStatus(){


        Integer status = (Integer) redisTemplate.opsForValue().get(Key);

        log.info("获取到店铺的营业状态为,{}",status==1?"营业中":"暂停营业中");
        return Result.success(status);
    }

}