package top.wujinxing.qa.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import top.wujinxing.qa.pojo.Problem;

/**
 * @author: wujinxing
 * @date: 2019/3/28 15:26
 * @description:
 */
public interface ProblemDao extends JpaRepository<Problem, String>, JpaSpecificationExecutor<Problem> {

    // nativeQuery = true: 执行SQL
    @Query(value = "SELECT * FROM tb_problem, tb_pl WHERE id = problemid AND labelid = ? ORDER BY replytime DESC", nativeQuery = true)
    Page<Problem> newList(String labelId, Pageable pageable);

    @Query(value = "SELECT * FROM tb_problem, tb_pl WHERE id = problemid AND labelid = ? ORDER BY reply DESC", nativeQuery = true)
    Page<Problem> hotList(String labelId, Pageable pageable);

    @Query(value = "SELECT * FROM tb_problem, tb_pl WHERE id = problemid AND labelid = ? AND reply = 0 ORDER BY createtime DESC", nativeQuery = true)
    Page<Problem> waitList(String labelId, Pageable pageable);
}
