/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sy.spring.cloud.alibaba.bus.api.feign.businessgoods.fallback;


import com.sy.spring.cloud.alibaba.bus.api.feign.businessgoods.TestFeign2;
import com.sy.spring.cloud.alibaba.module.web.RespBean;

/**
 * @author lengleng
 * @date 2019-08-01
 * <p>
 * sentinel 降级处理
 */
public class EchoServiceFallback implements TestFeign2 {

	private Throwable throwable;

	EchoServiceFallback(Throwable throwable) {
		this.throwable = throwable;
	}


    @Override
    public RespBean testFeign() {
        return RespBean.fail(RespBean.CodeStatus.FEIGNFALL,throwable.getMessage());
    }
}
