package top.wujinxing.article.controller;

import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import top.wujinxing.article.pojo.Article;
import top.wujinxing.article.service.ArticleService;

import java.util.Map;

/**
 * @author: wujinxing
 * @date: 2019/3/28 16:38
 * @description:
 */
@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 查询全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        return new Result(true,StatusCode.OK,"查询成功",articleService.findAll());
    }

    /**
     * 根据ID查询
     * @param id ID
     * @return
     */
    @GetMapping(value="/{id}")
    public Result findById(@PathVariable String id){
        return new Result(true,StatusCode.OK,"查询成功",articleService.findById(id));
    }

    /**
     * 分页+多条件查询
     * @param searchMap 查询条件封装
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @PostMapping(value="/search/{page}/{size}")
    public Result findSearch(@RequestBody Map searchMap , @PathVariable int page, @PathVariable int size){
        Page<Article> pageList = articleService.findSearch(searchMap, page, size);
        return  new Result(true,StatusCode.OK,"查询成功",  new PageResult<Article>(pageList.getTotalElements(), pageList.getContent()) );
    }

    /**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @PostMapping(value="/search")
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",articleService.findSearch(searchMap));
    }

    /**
     * 增加
     * @param article
     */
    @PostMapping
    public Result add(@RequestBody Article article  ){
        articleService.add(article);
        return new Result(true,StatusCode.OK,"增加成功");
    }

    /**
     * 修改
     * @param article
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Article article, @PathVariable String id ){
        article.setId(id);
        articleService.update(article);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /**
     * 删除
     * @param id
     */
    @DeleteMapping(value="/{id}")
    public Result delete(@PathVariable String id ){
        articleService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /**
     * 审核
     * @param id
     * @return
     */
    @PutMapping(value="/examine/{id}")
    public Result examine( @PathVariable String id){
        articleService.examine(id);
        return new Result(true,StatusCode.OK,"审核成功");
    }

    /**
     * 点赞
     * @param id
     * @return
     */
    @PutMapping(value="/thumbup/{id}")
    public Result updateThumbup( @PathVariable String id){
        articleService.updateThumbup(id);
        return new Result(true,StatusCode.OK,"点赞成功");
    }

}
