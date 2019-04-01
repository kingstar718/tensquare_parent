package top.wujinxing.search.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import top.wujinxing.search.pojo.Article;

/**
 * @author: wujinxing
 * @date: 2019/4/1 16:15
 * @description:
 */
public interface ArticleDao extends ElasticsearchRepository<Article, String> {

    Page<Article> findByTitleOrContentLike(String title, String content, Pageable pageable);
}
