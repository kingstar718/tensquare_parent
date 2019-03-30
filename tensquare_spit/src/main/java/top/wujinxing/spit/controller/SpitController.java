package top.wujinxing.spit.controller;

import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import top.wujinxing.spit.pojo.Spit;
import top.wujinxing.spit.service.SpitService;

import javax.annotation.Resource;

/**
 * @author: wujinxing
 * @date: 2019/3/30 22:36
 * @description:
 */

@RestController
@CrossOrigin
@RequestMapping("/spit")
public class SpitController {

    @Resource(name = "spitService")
    private SpitService spitService;

    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping("")
    public Result findAll(){
        return new Result(true, StatusCode.OK, "查询成功", spitService.findAll());
    }

    @GetMapping("/{spitId}")
    public Result findById(@PathVariable String spitId) {
        return new Result(true, StatusCode.OK, "查询成功", spitService.findById(spitId));
    }

    @PostMapping("")
    public Result save(@RequestBody Spit spit) {
        spitService.save(spit);
        return new Result(true, StatusCode.OK, "保存成功");
    }

    @PutMapping("/{spitId}")
    public Result update(@RequestBody Spit spit, @PathVariable String spitId) {
        spit.set_id(spitId);
        spitService.update(spit);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @DeleteMapping("/{spitId}")
    public Result delete(@PathVariable String spitId) {
        spitService.deleteById(spitId);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /**
     *  删除吐槽
     * @param id
     * @return
     */
    @RequestMapping( value ="/{id}" ,method = RequestMethod.DELETE)
    public  Result deleteById(@PathVariable  String id){
        spitService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    @PutMapping("/thumbup/{spitId}")
    public Result thumbup(@PathVariable String spitId){
        //判断当前用户是否点过赞
        String userid = "1013";
        if (redisTemplate.opsForValue().get("thumbup_spit_"+userid)!=null){
            //已经点赞了
            return new Result(false, StatusCode.REPERROR, "不能重复点赞");
        }
        spitService.thumbup(spitId);
        redisTemplate.opsForValue().set("thumbup_spit_" + userid , "1");
        return new Result(true, StatusCode.OK, "点赞成功");
    }

    @GetMapping(value = "/comment/{parentid}/{page}/{size}")
    public Result findByParentid(@PathVariable String parentid, @PathVariable int page, @PathVariable int size){
        PageResult<Spit> pageResult = spitService.findByParentid(parentid, page, size);
        return new Result(true, StatusCode.OK, "查询成功", pageResult);
    }



}
