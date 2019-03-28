package top.wujinxing.base.controller;

import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import top.wujinxing.base.pojo.Label;
import top.wujinxing.base.service.LabelServie;

import java.util.List;

/**
 * @author: wujinxing
 * @date: 2019/3/27 21:49
 * @description:
 */

@RestController
@CrossOrigin
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelServie labelServie;

    /**
     * 查询全部列表
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK, "查询成功",
                labelServie.findAll());
    }

    /**
     * 根据ID查询标签
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable("id") String id){
        return new Result(true, StatusCode.OK, "根据ID查询成功",
                labelServie.findById(id));
    }

    /**
     * 增加标签
     * @param label
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Label label){
        labelServie.add(label);
        return new Result(true, StatusCode.OK, "增加成功");
    }

    /**
     * 修改标签
     * @param id
     * @param label
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Result update(@PathVariable String id, @RequestBody Label label){
        label.setId(id);
        labelServie.update(label);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除标签
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id){
        labelServie.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    @PostMapping("/search")
    public Result findSearch(@RequestBody Label label){
        List<Label> list = labelServie.findSearch(label);
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    @PostMapping("/search/{page}/{size}")
    public Result pageQuery(@RequestBody Label label, @PathVariable("page") int currentPage, @PathVariable("size") int pageSize){
        Page<Label> pageData = labelServie.pageQuery(label, currentPage, pageSize);
        return new Result(true, StatusCode.OK, "查询成功",
                new PageResult<>(pageData.getTotalElements(),pageData.getContent() ));
    }
}
