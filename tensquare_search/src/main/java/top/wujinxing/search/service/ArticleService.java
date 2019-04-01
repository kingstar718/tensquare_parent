package top.wujinxing.search.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import top.wujinxing.search.dao.ArticleDao;
import top.wujinxing.search.pojo.Article;

import javax.annotation.Resource;

/**
 * @author: wujinxing
 * @date: 2019/4/1 16:18
 * @description:
 */
@Service
public class ArticleService {
    @Resource(name = "articleDao")
    private ArticleDao dao;

    public void save(Article article) {
        dao.save(article);
    }

    /**
     * 根据关键字查询文章
     * @param keyWord
     * @param currentPage
     * @param pageSize
     * @return
     */
    public Page<Article> findByKeyWord(String keyWord, int currentPage, int pageSize) {
        Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        return dao.findByTitleOrContentLike(keyWord, keyWord, pageable);
    }
}
