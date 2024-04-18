package com.sky.controller.admin;



//通用接口 阿里云oss上传图片接口


import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
@RequestMapping("/admin/common")

@Api(tags="通用接口")
public class CommonController {

//文件上传

    @PostMapping("/upload")
    @ApiOperation("文件上传")

    public Result<String> upload(MultipartFile file){


        log.info("文件上传,{}",file);
        return null;

    }

}
