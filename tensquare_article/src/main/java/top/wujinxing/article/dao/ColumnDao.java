package top.wujinxing.article.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import top.wujinxing.article.pojo.Column;

/**
 * @author: wujinxing
 * @date: 2019/3/28 16:13
 * @description:
 */
public interface ColumnDao extends JpaRepository<Column, String>, JpaSpecificationExecutor<Column> {
}
