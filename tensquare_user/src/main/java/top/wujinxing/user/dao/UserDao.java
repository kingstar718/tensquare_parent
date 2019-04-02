package top.wujinxing.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import top.wujinxing.user.pojo.User;

/**
 * @author: wujinxing
 * @date: 2019/4/1 23:01
 * @description:
 */
public interface UserDao extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {

    User findByMobile(String mobile);

    @Modifying
    @Query(value = "UPDATE tb_user SET followcount = followcount + ? WHERE id = ?", nativeQuery = true)
    void updateFansNum(int num, String friendId);

    @Modifying
    @Query(value = "UPDATE tb_user SET followcount = followcount + ? WHERE id = ?", nativeQuery = true)
    void updateFollowNum(int num, String userId);
}
