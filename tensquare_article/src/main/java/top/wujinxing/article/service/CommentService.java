package top.wujinxing.article.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wujinxing.article.dao.CommentDao;
import top.wujinxing.article.pojo.Comment;
import util.IdWorker;

import java.util.List;

/**
 * @author: wujinxing
 * @date: 2019/3/30 23:34
 * @description:
 */
@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private IdWorker idWorker;

    public void add(Comment comment){
        comment.set_id(idWorker.nextId()+"");
        commentDao.save(comment);
    }

    public List<Comment> findByArticleid(String articleid){
        return commentDao.findByArticleid(articleid);
    }

    public void delete(String articleid){
        commentDao.deleteById(articleid);
    }
}
