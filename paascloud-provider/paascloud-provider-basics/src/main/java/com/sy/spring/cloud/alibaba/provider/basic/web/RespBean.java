package com.sy.spring.cloud.alibaba.provider.basic.web;

import lombok.Data;

import java.io.Serializable;

/**
 * @author sy
 * Date: 2020/3/27 11:26
 * @Description 返回对象
 */
@Data
public class RespBean<T> implements Serializable {

    private static final long serialVersionUID = -1949931234174289546L;


    /**
     * 状态码
     */
    private Integer code;

    /**
     * 消息
     */
    private String message;


    private boolean status;

    /**
     * 返回对象
     */
    private T data;



    public RespBean() {
        super();
    }

    public RespBean(Integer code) {
        super();
        this.code = code;
    }

    public RespBean(Integer code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public RespBean(Integer code, Throwable throwable) {
        super();
        this.code = code;
        this.message = throwable.getMessage();
    }

    public RespBean(Integer code, T data) {
        super();
        this.code = code;
        this.data = data;
    }

    public RespBean(Integer code, String message, T data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public RespBean(Integer code, String message, T data, boolean status) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
        this.status=status;
    }



    public RespBean(Integer code, boolean status, String message, T data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
        this.status=status;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        RespBean<?> other = (RespBean<?>) obj;
        if (data == null) {
            if (other.data != null) {
                return false;
            }
        } else if (!data.equals(other.data)) {
            return false;
        }
        if (message == null) {
            if (other.message != null) {
                return false;
            }
        } else if (!message.equals(other.message)) {
            return false;
        }
        if (code == null) {
            if (other.code != null) {
                return false;
            }
        } else if (!code.equals(other.code)) {
            return false;
        }
        return true;
    }



    public  static <T> RespBean fail(Integer code, String msg){
        return new RespBean<T>(code,false,msg ,null);
    }


    public  static <T> RespBean fail(ErrorEnum errorEnum){
        return new RespBean<T>(errorEnum.getCode(),false,errorEnum.getMsg(),null);
    }


    public  static <T> RespBean fail(){
        return new RespBean<T>(ErrorEnum.SYS.getCode(),false,ErrorEnum.SYS.getMsg(),null);
    }


    public static <T> RespBean<T> fail(String msg){
        return new RespBean<T>(CodeStatus.SYS,false,msg,null);
    }

    public static RespBean succeed(){
        return new RespBean(ErrorEnum.SUCCEED.getCode(),true,null,null);
    }

    public static <T> RespBean<T> succeed   (T data){
        return new RespBean<T>(ErrorEnum.SUCCEED.getCode(),true,ErrorEnum.SUCCEED.getMsg(),data);
    }

    public static <T> RespBean<T> succeed(String msg,T data){
        return new RespBean<T>(ErrorEnum.SUCCEED.getCode(),true,msg,data);
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * 通用状态码
     * <p>
     * Description:
     * </p>
     *
     * @author Lusifer
     * @version v1.0.0
     * @date 2019-07-30 05:02:49
     */
    public static class CodeStatus {


        /**
         * 请求成功
         */
        public static final int OK = 0;

        /**
         * 请求失败
         */
        public static final int SYS = -1;

        /**
         * 请求错误
         */
        public static final int REQUEST = 2000;
        //参数校验失败
        public static final int REQUEST_PARAM=2001;


        /**
         * 权限不足
         */
        public static final int POWER = 3000;
        public static final int LOG_ERR=3001;



        /**
         * 数据异常
         */
        public static final int DATA = 4000;

        /**
         * 未知异常
         */
        public static final int ANOMALY = 5000;

        /**
         * 网络异常
         */
        public static final int NET = 6000;


        /**
         * 令牌过期
         */
        public static final int EXPIRED = 7000;

        /**
         * 第三方错误
         */
        public static final int EXTERN = 8000;


        public static final int FEIGNFALL=9001;
    }



}
