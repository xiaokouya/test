package com.zhao.controller;

import com.zhao.util.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Result> hello(@RequestParam(value = "bad", required = false, defaultValue = "false") Boolean bad) {
        Result rs = new Result(200, "ok");
        if (bad) {
            rs.setStatus(400);
            rs.setMessage("bad message");
//            HttpStatus.BAD_REQUEST 值得是400，枚举类型
            return new ResponseEntity<Result>(rs, HttpStatus.BAD_REQUEST);
        }
        rs.putData("words", "Hello world!");
//        如果执行正常，返回的是Result的对象toString方法
        return ResponseEntity.ok(rs);
    }
}
