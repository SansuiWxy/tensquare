package entity;

import java.util.List;

/**
 * @param <T>
 * @description: 分页结果类
 * @author: caipeng
 * @create: 2019-04-01 16:18
 */
public class PageResult<T> {

    /**
     * 总记录数
     */
    private Long total;

    /**
     * 分页的结果集
     */
    private List<T> rows;

    public PageResult(Long total, List<T> rows) {
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
