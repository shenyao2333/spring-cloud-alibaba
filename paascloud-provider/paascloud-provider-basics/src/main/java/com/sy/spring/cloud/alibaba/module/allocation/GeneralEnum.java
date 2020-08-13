package com.sy.spring.cloud.alibaba.module.allocation;

/**
 * @author my
 */
/**
 * @author sy
 * @dateTime 2020.3.15 20:08
 * @description 一些系统设置类
 */
public enum GeneralEnum {

    /**
     * type 类型，
     * value 值
     * valueLong long类型的值
     */

    TOKEN_VALID("token有效时间",7200L),

    CODE_VALID("验证码有效期",180L),

    YUN_CODE_TEMPLATEID("云-短信验证码模版","538226"),



    ;




   public String type;

   public String value;

   public Long valueLong;

    GeneralEnum(String type, String value) {
        this.type = type;
        this.value = value;
    }

    GeneralEnum(String type, Long value) {
        this.type = type;
        this.valueLong = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
