package top.wujinxing.recruit.dao;

/**
 * @author: wujinxing
 * @date: 2019/3/28 11:40
 * @description:
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import top.wujinxing.recruit.pojo.Enterprise;

import java.util.List;

/**
 * 数据访问接口
 */
public interface EnterpriseDao extends JpaRepository<Enterprise, String>, JpaSpecificationExecutor<Enterprise> {

    List<Enterprise> findByIshot(String ishot);
}
