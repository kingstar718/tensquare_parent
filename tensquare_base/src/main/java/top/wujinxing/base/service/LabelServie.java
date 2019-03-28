package top.wujinxing.base.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.wujinxing.base.dao.LabelDao;
import top.wujinxing.base.pojo.Label;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author: wujinxing
 * @date: 2019/3/27 21:57
 * @description: 标签业务逻辑类
 */
@Service
@Transactional
public class LabelServie {
    @Autowired(required = false)
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 查询全部标签
     * @return
     */
    public List<Label> findAll(){
        return labelDao.findAll();
    }

    /**
     * 根据ID查询标签
     * @param id
     * @return
     */
    public Label findById(String id){
        return labelDao.findById(id).get();
    }

    /**
     * 增加标签
     * @param label
     */
    public void add(Label label){
        label.setId(idWorker.nextId()+""); //设置id
        labelDao.save(label);
    }

    /**
     * 修改标签
     * @param label
     */
    public void update(Label label){
        labelDao.save(label);
    }

    /**
     * 删除标签
     * @param id
     */
    public void deleteById(String id){
        labelDao.deleteById(id);
    }

    /**
     * 构建条件查询
     * @param searchMap
     * @return
     */
    private Specification<Label> createSpecification(Map searchMap){
        return new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

                List<Predicate> predicateList = new ArrayList<>();
                if (searchMap.get("labelname")!=null && !"".equals(searchMap.get("labelname"))){
                    predicateList.add(cb.like(root.get("labelname").as(String.class), "%"+(String)searchMap.get("labelname")+"%"));
                }
                if(searchMap.get("state")!=null && !"".equals(searchMap.get("state"))){
                    predicateList.add(cb.equal(root.get("state").as(String.class), (String)searchMap.get("state")));
                }
                if(searchMap.get("recommend")!=null && !"".equals(searchMap.get("recommend"))){
                    predicateList.add(cb.equal(root.get("recommend").as(String.class), (String)searchMap.get("recommend")));
                }
                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
    }

    /**
     * 封装查询对象
     * @param label
     * @return
     */
    private Specification<Label> searchMap(Label label) {
        return (Specification<Label>) (root, query, cb) -> {
            List<Predicate> list = new LinkedList<>();
            if (!StringUtils.isEmpty(label.getLabelname())) {
                Predicate labelname = cb.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");
                list.add(labelname);
            }
            if (!StringUtils.isEmpty(label.getState())) {
                Predicate state = cb.like(root.get("state").as(String.class), label.getState());
                list.add(state);
            }
            Predicate[] array = new Predicate[list.size()];
            array = list.toArray(array);
            return cb.and(array);
        };
    }

    /**
     * 条件查询
     * @param label
     * @return
     */
    /*public List<Label> findSearch(Map searchMap){
        Specification specification = createSpecification(searchMap);
        return labelDao.findAll(specification);
    }*/
    public List<Label> findSearch(final Label label){
        return labelDao.findAll(searchMap(label));
    }

    /**
     * 分页查询
     * @param label
     * @param currentPage
     * @param pageSize
     * @return
     */
    public Page<Label> pageQuery(Label label, int currentPage, int pageSize){
        return labelDao.findAll(searchMap(label), PageRequest.of(currentPage-1, pageSize));
    }
}
