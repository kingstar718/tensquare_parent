package top.wujinxing.user.controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.wujinxing.user.pojo.User;
import top.wujinxing.user.service.UserService;

/**
 * @author: wujinxing
 * @date: 2019/4/1 22:57
 * @description:
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public Result findAll(){
        return new Result(true, StatusCode.OK, "查询成功",userService.findAll());
    }

    @PostMapping(value = "/sendsms/{mobile}")
    public Result sendsms(@PathVariable String mobile) {
        userService.sendSms(mobile);
        return new Result(true, StatusCode.OK, "发送成功");
    }

    @PostMapping(value="/register/{code}")
    public Result register(@PathVariable User user, @PathVariable String code){
        userService.add(user, code);
        return new Result(true, StatusCode.OK, "注册成功");
    }
}
