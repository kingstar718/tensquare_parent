package top.wujinxing.gathering.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import top.wujinxing.gathering.pojo.Gathering;

/**
 * @author: wujinxing
 * @date: 2019/3/28 17:42
 * @description:
 */
public interface GatheringDao extends JpaRepository<Gathering, String>, JpaSpecificationExecutor<Gathering> {
}
