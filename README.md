
# spring-cloud-alibaba
### 一、模块介绍

#### 1、模块划分

```
├─spring-cloud-alibaba-------------------------------父项目
│  │
│  ├─paascloud-deperdercies--------------------------依赖管理
│  │
│  ├─paascloud-gateway-------------------------------微服务网关
│  │
│  │
│  │
│  ├─paascloud-provider
│  │  │
│  │  ├─paascloud-provider-basics-------------------基础模块
│  │  │
│  │  └─paascloud-provider-api----------------------公用API
│  │
│  │
│  ├─paascloud-generator
│  │  │
│  │  ├─paascloud-generator-message-----------------消息中心
│  │  │
│  │  └─paascloud-generator-task--------------------定时任务，统一调度
│  │ 
│  │ 
│  ├─paascloud-business
│  │  │
│  │  ├─paascloud-business-user----------------------授权以及用户管理
│  │  │
│  │  ├─paascloud-business-goods---------------------商品模块
│  │  │
│  │  ├─paascloud-business-social--------------------社交模块
│  │  │
│  │  ├─paascloud-business-events--------------------活动中心
│  │  │
│  │  └─paascloud-business-thirdparty----------------第三方模块
│  │  
│  │  
```





| 模块                | 模块名           | 说明                       | rest端口 | dubbo端口 |
| :------------------ | ---------------- | -------------------------- | -------- | --------- |
| deperdercies        | 依赖管理         | 统一管理maven依赖版        |          |           |
| gateway             | 微服务网关       | 统一入口                   | 9010     |           |
| business-user       | 授权以及用户管理 | 用户认证                   | 10010    | 15010     |
| business-goods      | 商品模块         |                            | 10020    | 15020     |
| business-social     | 社交模块         |                            | 10030    | 15030     |
| business-events     | 活动中心         |                            | 10040    | 15040     |
| business-thirdparty | 第三方模块       | 与第三方服务对接模块       | 10050    | 15050     |
| provider-basics     | 基础模块         | 通用工具类以及配置类       |          |           |
| provider-api        | 公用API          |                            |          |           |
| generator-message   | 消息中心         | RocketMQ                   | 10060    | 15060     |
| generator-task      | 定时任务         | 动态管理定时任务，统一调度 | 10070    | 15070     |
| generator-activity  | 工作流           |                            | 10080    | 15080     |
| generator-es        | 搜索引擎         |                            | 10090    | 15090     |



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

- 使用openfeign做restful风格的通信
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

