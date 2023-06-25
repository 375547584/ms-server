package com.shenhai.tech.market.common.response;


import java.io.Serializable;
import lombok.Data;

// 行情数据专用，非分页数据
@Data
public class ResponseVO<T> implements Serializable {
    private static final int SUCCESS = 1;
    public static final String MSG_SUCCESS = "请求成功";
    public static final int FAIL = 0;
    //
    public static final String MSG_FAIL = "请求失败";

    // 状态码
    private int code;
    // 状态描述
    private String message;
    private T data;
    // 总数
    private Integer total;
    // 页数
    private Integer index;
    // 请求ID
    private String subId;

    /**
     * 表格数据对象
     */
    public ResponseVO() {
        this.code = SUCCESS;
        this.message = MSG_SUCCESS;
    }

    /**
     * 分页
     *
     * @param data  列表数据
     * @param total 总记录数
     */
    public ResponseVO(T data, int total) {
        this.code = SUCCESS;
        this.message = MSG_SUCCESS;
        this.data = data;
        this.total = total;

    }

    public ResponseVO(T data, Integer total, Integer index) {
        this.code = SUCCESS;
        this.message = MSG_SUCCESS;

        this.data = data;
        this.index = index;
        this.total = total;
    }


    public ResponseVO(T data, Integer total, Integer index, String subId) {
        this.code = SUCCESS;
        this.message = MSG_SUCCESS;
        this.subId = subId;
        this.data = data;
        this.index = index;
        this.total = total;
    }

    public ResponseVO(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
    }

    public ResponseVO(T data) {
        this.code = SUCCESS;
        this.message = MSG_SUCCESS;
        this.data = data;
    }

    public ResponseVO(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public static <T> ResponseVO<T> success() {
        return new ResponseVO<>();
    }

    public static <T> ResponseVO<T>  success(T data) {
        return new ResponseVO<>(data);
    }

    public static <T> ResponseVO<T>  success(T data, Integer total, Integer index) {
        return new ResponseVO<>(data, total, index);
    }

    public static <T> ResponseVO<T>  success(T data, Integer total, Integer index, String subId) {
        return new ResponseVO<>(data, total, index, subId);
    }

    public static <T> ResponseVO<T>  err(ResponseCode statusConstant) {
        return new ResponseVO<>(statusConstant.getCode(), statusConstant.getMessage());
    }

    public static <T> ResponseVO<T>  err(Integer code, String msg) {
        return new ResponseVO<>(code, msg);
    }

    public static <T> ResponseVO<T>  err(String msg) {
        return new ResponseVO<>(FAIL, msg);
    }
}
