package entity;

/**
 * @description: 结果类，用户控制层返回结果封装
 * @author: caipeng
 * @create: 2019-04-01 16:08
 */
public class Result {

    /**
     * id：是否成功
     */
    private boolean flag;
    /**
     * code: 返回码
     */
    private Integer code;
    /**
     * message: 返回信息
     */
    private String message;
    /**
     * data: 返回数据（可能有，可能没有）
     */
    private Object data;

    public Result() {
    }

    /**
     * 增删改方法用构造器
     *
     * @param flag
     * @param code
     * @param message
     */
    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    /**
     * 查询使用构造器
     *
     * @param flag
     * @param code
     * @param data
     */
    public Result(boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Result success(Object o) {
        return new Result(true, StatusCode.OK, "操作成功", o);
    }

    public static Result success() {
        return new Result(true, StatusCode.OK, "操作成功");
    }

    public static Result failure() {
        return new Result(true, StatusCode.ERROR, "操作失败");
    }
}
