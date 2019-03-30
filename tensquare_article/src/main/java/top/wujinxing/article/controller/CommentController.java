package top.wujinxing.article.controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.wujinxing.article.pojo.Comment;
import top.wujinxing.article.service.CommentService;

/**
 * @author: wujinxing
 * @date: 2019/3/30 23:36
 * @description:
 */
@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public Result save(@RequestBody Comment comment){
        commentService.add(comment);
        return new Result(true, StatusCode.OK, "提交成功");
    }

    @GetMapping(value = "/article/{articleid}")
    public Result findByArticleid(@PathVariable String articleid){
        return new Result(true, StatusCode.OK, "查询成功",
                commentService.findByArticleid(articleid));
    }

    @DeleteMapping(value = "/article/{articleid}")
    public Result deleteByArticleid(@PathVariable String articleid){
        commentService.delete(articleid);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
