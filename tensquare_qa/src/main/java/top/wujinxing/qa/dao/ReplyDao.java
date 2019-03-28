package top.wujinxing.qa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import top.wujinxing.qa.pojo.Reply;

/**
 * @author: wujinxing
 * @date: 2019/3/28 15:25
 * @description:
 */
public interface ReplyDao extends JpaRepository<Reply, String>, JpaSpecificationExecutor<Reply> {
}
