package com.pie.ssm.controller;

import com.pie.ssm.respone.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LIN
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/index")
public class IndexController {
    @GetMapping("/sort")
    public ResponseEntity<Object> sort(){
        return null;
    }
}
