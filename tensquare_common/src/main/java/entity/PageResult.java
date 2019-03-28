package entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author: wujinxing
 * @date: 2019/3/27 21:31
 * @description: 分页结果类
 */
@Data
public class PageResult<T> {

    @JsonProperty("tatal") //总页数
    private Long total;

    @JsonProperty("rows")  //查询的数据
    private List<T> rows;
    public PageResult(Long total, List<T> rows) {
        super();
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
