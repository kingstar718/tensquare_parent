package top.wujinxing.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import top.wujinxing.user.pojo.Admin;

/**
 * @author: wujinxing
 * @date: 2019/4/2 09:18
 * @description:
 */
public interface AdminDao extends JpaRepository<Admin, String>, JpaSpecificationExecutor<Admin> {

    Admin findByLoginname(String loginname);
}
