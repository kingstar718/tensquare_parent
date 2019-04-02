package top.wujinxing.user.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author: wujinxing
 * @date: 2019/4/2 09:15
 * @description:
 */
@Data
@Entity
@Table(name = "tb_admin")
public class Admin implements Serializable {

    @Id
    private String id;

    private String loginname; //登陆名称
    private String password;
    private String state; //状态
}
