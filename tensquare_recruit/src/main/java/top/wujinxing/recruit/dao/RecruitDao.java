package top.wujinxing.recruit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import top.wujinxing.recruit.pojo.Recruit;

import java.util.List;

/**
 * @author: wujinxing
 * @date: 2019/3/28 11:42
 * @description:
 */
public interface RecruitDao extends JpaRepository<Recruit, String>, JpaSpecificationExecutor<Recruit> {

    /**
     *查询最新职位列表(按创建日期降序排序)
     * @param state
     * @return
     */
    List<Recruit> findTop6ByStateOrderByCreatetimeDesc(String state);

    /**
     * 根据状态查询
     * @param state
     * @return
     */
    List<Recruit> findTop6ByStateNotOrderByCreatetimeDesc(String state);
}
