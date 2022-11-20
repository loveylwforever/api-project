package com.company.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.company.project.common.result.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("index")
public class IndexController {

    @RequestMapping("test")
    public Result test(){
        return Result.success(JSONObject.toJSON("hello"));
    }
}
