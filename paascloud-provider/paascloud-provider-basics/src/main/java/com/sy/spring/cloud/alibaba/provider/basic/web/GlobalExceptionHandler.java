package com.sy.spring.cloud.alibaba.provider.basic.web;

import org.springframework.beans.TypeMismatchException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * @author sy
 * Date: 2020/3/27 13:51
 * @Description 处理全局异常
 */
@RestControllerAdvice
public class GlobalExceptionHandler  {


    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public <T> R serviceException(MethodArgumentNotValidException ex) {
        //获取参数校验错误集合
        List<FieldError> bindingResult = ex.getBindingResult().getFieldErrors();
        StringBuilder errorMessage = new StringBuilder();
        for (FieldError fieldError : bindingResult) {
            errorMessage.append(fieldError.getDefaultMessage()).append(";") ;
        }
        errorMessage.substring(errorMessage.length()-1);
        return new R<T>(R.CodeStatus.REQUEST_PARAM,false,errorMessage.toString(),null);
    }




    /**
     * 参数类型
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {TypeMismatchException.class})
    public R serviceException(TypeMismatchException ex) {
        String  message = String.format("参数类型不匹配，类型应该为: %s", ex.getRequiredType());
        return  R.fail(R.CodeStatus.REQUEST_PARAM,message);
    }


    /**
     * 请求方式错误
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class})
    public R serviceException(HttpRequestMethodNotSupportedException ex, HttpServletRequest request) {
        return R.fail(R.CodeStatus.REQUEST, "接口"+ request.getMethod()+"请求类型错误!");
    }

    /**
     * 索引重复
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {DuplicateKeyException.class})
    public R serviceException(DuplicateKeyException ex) {
        return R.fail(R.CodeStatus.DATA, "索引重复");
    }

    /**
     * 数据异常
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {SQLException.class})
    public R serviceException(SQLException ex) {
        return R.fail(R.CodeStatus.DATA, "索引重复");
    }


    /**
     * 自定义异常
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {GrabException.class})
    public R serviceException(GrabException ex) {
        return R.fail(ex.getCode(), ex.getMsg());
    }




    /**
     * 其他异常
     * @return
     */
    @ExceptionHandler(value = {Exception.class})
    public R serviceException(Exception e) {
        e.printStackTrace();
        return R.fail(-1,e.getMessage());
    }





}
