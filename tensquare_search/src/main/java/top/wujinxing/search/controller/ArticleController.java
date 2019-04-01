package top.wujinxing.search.controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import top.wujinxing.search.pojo.Article;
import top.wujinxing.search.service.ArticleService;

/**
 * @author: wujinxing
 * @date: 2019/4/1 16:19
 * @description:
 */
@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping()
    public Result save(@RequestBody Article article){
        articleService.save(article);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    @GetMapping("/{keyWord}/{currentPage}/{pageSize}")
    public Result findbyKeyWord(@PathVariable String keyWord,
                                @PathVariable int currentPage,
                                @PathVariable int pageSize){
        Page<Article> pageData = articleService.findByKeyWord(keyWord, currentPage, pageSize);
        return new Result(true, StatusCode.OK, "查询成功", pageData.getContent());
    }
}
