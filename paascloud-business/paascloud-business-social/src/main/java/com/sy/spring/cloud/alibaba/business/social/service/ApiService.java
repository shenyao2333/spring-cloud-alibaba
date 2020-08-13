package com.sy.spring.cloud.alibaba.business.social.service;

import java.io.File;

/**
 * @author sy
 * @date Created in 2020.4.27 21:52
 * @description 公开接口的处理
 */
public interface ApiService {

    /**
     * 上传图片
     * @param file
     * @return
     */
    String uploadFile(File file);
}
