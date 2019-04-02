package top.wujinxing.article.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import top.wujinxing.article.pojo.Channel;

/**
 * @author: wujinxing
 * @date: 2019/3/28 16:14
 * @description:
 */
public interface ChannelDao extends JpaRepository<Channel, String>, JpaSpecificationExecutor<Channel> {
}
