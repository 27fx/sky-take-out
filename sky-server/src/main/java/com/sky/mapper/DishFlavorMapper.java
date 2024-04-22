package com.sky.mapper;


import com.sky.annotation.AutoFill;
import com.sky.entity.DishFlavor;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DishFlavorMapper {


    void insertBatch(List<DishFlavor> flavors);



    //根据DISH ID 删除口味表中的信息

    @Delete("delete from dish_flavor where id=#{dishId}")
    void deleteByDishId(Long dishId);
}
