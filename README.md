
# spring-cloud-alibaba
### 一、模块介绍



| 模块                | 模块名     | 说明                           | rest端口 | dubbo端口 |
| :------------------ | ---------- | ------------------------------ | -------- | --------- |
| basics-deperdencies | 依赖管理   | 统一管理maven依赖版本号        |          |           |
| bus-module          | 公共模块   | maven依赖、工具类以及配置类    |          |           |
| bus-api             | 公共接口   | 共用接口声明，方便所有服务调用 |          |           |
| server-gateway      | 网关       | 统一入口                       |          | 9510      |
| bus-task            | 定时任务   | 定时任务处理，统一调度         | 9020     | 9520      |
| bus-message         | 消息处理   | 服务与RocketMQ直接的处理       | 9030     | 9530      |
|                     |            |                                |          |           |
| auth-user           | 用户模块   | 用户管理与认证                 | 9040     | 9540      |
| bus-thirdparty      | 第三方模块 | 业务中与第三方对接接口         | 9050     | 9550      |
| business-goods      | 商品模块   | 商品管理                       |          |           |
|                     |            |                                |          |           |
|                     |            |                                |          |           |



- 网：
- 定时任务：bus-task   10
- 公共接口：bus-api
- 消息处理：bus-rocketmq
- 公共模块：bus-module
- 统一管理依赖：bus-deperdencies        
- 用户模块：auth-user   
- 第三方： bus-thirdparty
- 业务business
   - 商品：business-goods 
     - rest：10200，dubbo：15200
   - 社交：business-social 
     - rest：10200，dubbo：15200
   - 积分、等级、钱包 ：business-miscellaneous
     -  rest：10200，dubbo：15200
   - 活动、秒杀、优惠卷：business-passion
     - est：10200，dubbo：15200



### 二、项目技术介绍

基于springboot + springcloud + spring-cloud-alibaba的微服务架构

#### 1、网关

- 使用gateway做网关
- 集成sentinel做网关限流、熔断

- 使用Sentinel-dashboard做控制台，动态修改资源的保护规则
- 整合swagger聚合各服务系统API文档

#### 2、注册与发现

- 使用nacos做服务注册和配置中心

#### 3、服务

- 使用feign做restful风格的通信，以及使用ribbon做负载均衡，sentinel做熔断
- 使用dubbo做服务直接的调用以及sentinel做熔断

#### 4、数据

- 使用MySQL做数据存储

- 使用MyBatis操作数据库，hikari做数据库的连接池
- 使用Redis做缓存
- 使用ES做搜索引擎使用

#### 5、认证和权限

- 使用oAuth2做授权
- 使用security做安全认证

#### 6、其他

- 使用quartz做定时任务处理
- 使用RocketMQ做消息驱动
- 使用activiti做工作流

#### 7、治理

- 各组件均使用docker的方式部署管理
- 使用ELK和Redis做日志收集分析

