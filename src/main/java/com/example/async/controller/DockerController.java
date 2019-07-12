package com.example.async.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 彬
 * @Date 2019/7/9
 */
@RestController
public class DockerController {

    @RequestMapping("/docker")
    public String testDockerDeploy(){
        return "hello,this is my first docker deploy in idea!";
    }
}
