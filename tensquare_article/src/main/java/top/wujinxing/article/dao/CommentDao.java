package top.wujinxing.article.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import top.wujinxing.article.pojo.Comment;

import java.util.List;

/**
 * @author: wujinxing
 * @date: 2019/3/30 23:33
 * @description:
 */
public interface CommentDao extends MongoRepository<Comment, String> {

    public List<Comment> findByArticleid(String articleid);
}
