<p align="center">
 <img src="https://img.shields.io/badge/Spring%20Boot-2.7.18-blue.svg" alt="Downloads">
 <img src="https://img.shields.io/badge/Vue-3.2-blue.svg" alt="Downloads">
 <img src="https://img.shields.io/github/license/YunaiV/ruoyi-vue-pro"/>
</p>

# Hospital Research Project Management System (`hosp-res-proj`)

**严肃声明：现在、未来都不会有商业版本，所有代码全部开源!！**

**「我喜欢写代码，乐此不疲」**  
**「我喜欢做开源，以此为乐」**

我 🐶 在上海艰苦奋斗，早中晚在 top3 大厂认真搬砖，夜里为开源做贡献。

如果这个项目让你有所收获，记得 Star 关注哦，这对我是非常不错的鼓励与支持。

## 🐶 新手必读

* 演示地址【Vue3 + element-plus】：<http://dashboard-vue3.yudao.iocoder.cn> (此为原项目演示，本系统界面类似)
* 启动文档：<https://doc.iocoder.cn/quick-start/> (原项目启动文档，可参考)
* 视频教程：<https://doc.iocoder.cn/video/> (原项目视频教程)

## 🐯 平台简介

**`hosp-res-proj`** 是一个基于 [芋道 RuoYi-Vue-Pro](https://gitee.com/zhijiantianya/ruoyi-vue-pro) 构建的医院科研项目管理平台。
旨在为医院科研管理部门提供一套高效、便捷的工具，用于管理科研项目的申报、经费、成果等核心环节，并结合AI辅助、电子流程表单、数据可视化等现代化技术，提升科研管理效率与水平。
本项目所有代码开源，个人与企业可 100% 免费使用。

> 有任何问题，或者想要的功能，可以在 _Issues_ 中提给艿艿。
>
> 😜 给项目点点 Star 吧，这对我们真的很重要！

![架构图](/.image/common/ruoyi-vue-pro-architecture.png) <!-- TODO: Consider updating this diagram if architecture significantly diverges -->

* Java 后端：`master` 分支为 JDK 8 + Spring Boot 2.7
* 管理后台的电脑端：Vue3 提供 `element-plus` (本项目主要采用)
* 后端采用 Spring Boot 多模块架构、MySQL + MyBatis Plus、Redis + Redisson
* 数据库可使用 MySQL
* 消息队列可使用 Event、Redis、RabbitMQ、Kafka、RocketMQ 等 (按需启用)
* 权限认证使用 Spring Security & Token & Redis，支持多终端认证
* 支持加载动态权限菜单，按钮级别权限控制
* 支持 SaaS 多租户
* 工作流使用 Flowable，支持动态表单、在线设计流程
* 高效率开发，使用代码生成器可以一键生成部分前后端代码
* 集成微信小程序、微信公众号、企业微信、钉钉等三方登陆 (按需启用)
* 集成支付宝、微信等支付与退款 (按需启用)
* 集成阿里云、腾讯云等短信渠道，集成 MinIO、阿里云、腾讯云、七牛云等云存储服务 (按需启用)
* 集成报表设计器、大屏设计器 (按需启用)

## 🐳 项目关系

本项目是基于 [RuoYi-Vue-Pro](https://gitee.com/zhijiantianya/ruoyi-vue-pro) 进行的定制化开发，专注于医院科研项目管理领域。
RuoYi-Vue-Pro 提供了强大的基础框架和丰富的功能模块，本项目在此基础上进行业务功能的深化和拓展。

### 后端项目

| 项目                                                              | Star                                                                                                                                                                                                                                                                                             | 简介                          |
|-----------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------|
| [ruoyi-vue-pro](https://gitee.com/zhijiantianya/ruoyi-vue-pro)  | [![Gitee star](https://gitee.com/zhijiantianya/ruoyi-vue-pro/badge/star.svg?theme=white)](https://gitee.com/zhijiantianya/ruoyi-vue-pro) [![GitHub stars](https://img.shields.io/github/stars/YunaiV/ruoyi-vue-pro.svg?style=social&label=Stars)](https://github.com/YunaiV/ruoyi-vue-pro)       | 基于 Spring Boot 多模块架构        |

### 前端项目 (参考原项目)

| 项目                                                                         | Star                                                                                                                                                                                                                                                                                                                     | 简介                                     |
|----------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------|
| [yudao-ui-admin-vue3](https://gitee.com/yudaocode/yudao-ui-admin-vue3)     | [![Gitee star](https://gitee.com/yudaocode/yudao-ui-admin-vue3/badge/star.svg?theme=white)](https://gitee.com/yudaocode/yudao-ui-admin-vue3) [![GitHub stars](https://img.shields.io/github/stars/yudaocode/yudao-ui-admin-vue3.svg?style=social&label=Stars)](https://github.com/yudaocode/yudao-ui-admin-vue3)         | 基于 Vue3 + element-plus 实现的管理后台         |


## 😎 开源协议

本项目遵循 [MIT License](https://gitee.com/zhijiantianya/ruoyi-vue-pro/blob/master/LICENSE) 开源协议，个人与企业可 100% 免费使用，不用保留类作者、Copyright 信息。

## 🐼 系统核心功能

本系统在RuoYi-Vue-Pro的基础上，重点构建了以下医院科研项目管理相关的核心功能：

*   **科研项目申报管理**:
    *   项目立项、信息录入与维护。
    *   支持项目模板，简化申报流程。
    *   AI辅助：可能集成AI进行项目申请书的智能填表、文本润色、合规性检查等。
*   **经费管理模块**:
    *   项目预算编制与申请。
    *   经费到账与支出记录，凭证管理。
    *   经费使用情况统计与预警。
*   **成果管理与绩效分配**:
    *   科研成果（论文、专利、软著、奖励等）的登记与管理。
    *   成果与科研项目的关联。
    *   绩效点数与激励机制的计算与分配（待规划）。
*   **电子流程表单**:
    *   基于Flowable工作流引擎，实现在线表单设计与流程定制。
    *   项目申报、经费审批、成果审核等关键流程的电子化。
    *   AI辅助：可能集成AI对审批节点进行智能预审、风险提示等。
*   **跨系统接口集成**:
    *   预留与医院HIS、LIS、CIS等核心业务系统的数据接口能力。
    *   实现项目与临床数据、患者信息等的关联（需符合隐私与伦理规范）。
*   **数据可视化与统计分析**:
    *   对项目、经费、成果等多维度数据进行统计与可视化展示。
    *   生成科研报表，辅助决策。
*   **安全与权限管理**:
    *   基于Spring Security的精细化权限控制，保障数据安全。
    *   针对医院科研管理角色（如科研人员、科室主任、科研处管理员、财务人员等）定制权限。
*   **基础系统功能 (继承自RuoYi-Vue-Pro)**:
    *   用户管理、角色管理、部门管理、岗位管理。
    *   字典管理、操作日志、登录日志。
    *   通知公告、文件服务、应用管理。
    *   多租户支持（可用于不同院区或大型科研团队的隔离）。

## 🐨 技术栈

### 模块

| 项目                    | 说明                 |
|-----------------------|--------------------|
| `yudao-dependencies`  | Maven 依赖版本管理       |
| `yudao-framework`     | Java 框架拓展          |
| `yudao-server`        | 服务端主项目 |
| `yudao-module-system` | 系统功能的 Module 模块    |
| `yudao-module-infra`  | 基础设施的 Module 模块    |
| `yudao-module-hospital`| 医院科研项目管理的 Module 模块 |
| `yudao-module-bpm`    | 工作流程的 Module 模块    |
<!-- 可按需启用其他模块 -->
<!-- <module>yudao-module-member</module> -->
<!-- <module>yudao-module-report</module> -->
<!-- <module>yudao-module-mp</module> -->
<!-- <module>yudao-module-pay</module> -->
<!-- <module>yudao-module-mall</module> -->
<!-- <module>yudao-module-crm</module> -->
<!-- <module>yudao-module-erp</module> -->
<!-- <module>yudao-module-iot</module> -->
<!-- <module>yudao-module-ai</module> -->


### 框架

| 框架                                                                                          | 说明               | 版本             | 学习指南                                                           |
|---------------------------------------------------------------------------------------------|------------------|----------------|----------------------------------------------------------------|
| [Spring Boot](https://spring.io/projects/spring-boot)                                       | 应用开发框架           | 2.7.18         | [文档](https://github.com/YunaiV/SpringBoot-Labs)                |
| [MySQL](https://www.mysql.com/cn/)                                                          | 数据库服务器           | 8.0+     |                                                                |
| [Druid](https://github.com/alibaba/druid)                                                   | JDBC 连接池、监控组件    | 1.2.23         | [文档](http://www.iocoder.cn/Spring-Boot/datasource-pool/?yudao) |
| [MyBatis Plus](https://mp.baomidou.com/)                                                    | MyBatis 增强工具包    | 3.5.7          | [文档](http://www.iocoder.cn/Spring-Boot/MyBatis/?yudao)         |
| [Dynamic Datasource](https://dynamic-datasource.com/)                                       | 动态数据源            | 3.6.1          | [文档](http://www.iocoder.cn/Spring-Boot/datasource-pool/?yudao) |
| [Redis](https://redis.io/)                                                                  | key-value 数据库    | 6.0+ |                                                                |
| [Redisson](https://github.com/redisson/redisson)                                            | Redis 客户端        | 3.32.0         | [文档](http://www.iocoder.cn/Spring-Boot/Redis/?yudao)           |
| [Spring MVC](https://github.com/spring-projects/spring-framework/tree/master/spring-webmvc) | MVC 框架           | 5.3.24         | [文档](http://www.iocoder.cn/SpringMVC/MVC/?yudao)               |
| [Spring Security](https://github.com/spring-projects/spring-security)                       | Spring 安全框架      | 5.7.11         | [文档](http://www.iocoder.cn/Spring-Boot/Spring-Security/?yudao) |
| [Hibernate Validator](https://github.com/hibernate/hibernate-validator)                     | 参数校验组件           | 6.2.5          | [文档](http://www.iocoder.cn/Spring-Boot/Validation/?yudao)      |
| [Flowable](https://github.com/flowable/flowable-engine)                                     | 工作流引擎            | 6.8.0          | [文档](https://doc.iocoder.cn/bpm/)                              |
| [Quartz](https://github.com/quartz-scheduler)                                               | 任务调度组件           | 2.3.2          | [文档](http://www.iocoder.cn/Spring-Boot/Job/?yudao)             |
| [Springdoc](https://springdoc.org/)                                                         | Swagger 文档       | 1.7.0          | [文档](http://www.iocoder.cn/Spring-Boot/Swagger/?yudao)         |
| [SkyWalking](https://skywalking.apache.org/)                                                | 分布式应用追踪系统        | 8.12.0         | [文档](http://www.iocoder.cn/Spring-Boot/SkyWalking/?yudao)      |
| [Spring Boot Admin](https://github.com/codecentric/spring-boot-admin)                       | Spring Boot 监控平台 | 2.7.10         | [文档](http://www.iocoder.cn/Spring-Boot/Admin/?yudao)           |
| [Jackson](https://github.com/FasterXML/jackson)                                             | JSON 工具库         | 2.13.5         |                                                                |
| [MapStruct](https://mapstruct.org/)                                                         | Java Bean 转换     | 1.6.3          | [文档](http://www.iocoder.cn/Spring-Boot/MapStruct/?yudao)       |
| [Lombok](https://projectlombok.org/)                                                        | 消除冗长的 Java 代码    | 1.18.34        | [文档](http://www.iocoder.cn/Spring-Boot/Lombok/?yudao)          |
| [JUnit](https://junit.org/junit5/)                                                          | Java 单元测试框架      | 5.8.2          | -                                                              |
| [Mockito](https://github.com/mockito/mockito)                                               | Java Mock 框架     | 4.8.0          | -                                                              |

## 🚀 部署 (using Docker)

1.  **编译打包**：
    在项目根目录执行以下命令打包获取 `yudao-server/target/hosp-res-proj.jar` 文件：
    ```bash
    mvn clean package -DskipTests
    ```

2.  **构建 Docker 镜像**:
    进入 `yudao-server` 目录，执行 Dockerfile 构建镜像。
    ```bash
    cd yudao-server
    docker build -t yudao/hosp-res-proj .
    ```
    (确保 `yudao-server/Dockerfile` 中的 `COPY` 指令已更新为 `COPY ./target/hosp-res-proj.jar app.jar`)

3.  **运行 Docker Compose**:
    进入 `script/docker` 目录，执行 `docker-compose.yml` 启动项目及所需中间件。
    ```bash
    cd script/docker
    docker-compose up -d
    ```
    项目启动后，主应用服务名为 `hosp-res-proj-app`。
    如果端口映射保持默认，可以通过 `http://localhost:48080` (后端) 和 `http://localhost:8080` (前端，需单独构建和运行前端项目) 访问。

## 🐷 演示图 (参考原项目)

### 系统功能

| 模块       | biu                         | biu                       | biu                      |
|----------|-----------------------------|---------------------------|--------------------------|
| 登录 & 首页  | ![登录](/.image/登录.jpg)       | ![首页](/.image/首页.jpg)     | ![个人中心](/.image/个人中心.jpg) |
| 用户 & 应用  | ![用户管理](/.image/用户管理.jpg)   | ![令牌管理](/.image/令牌管理.jpg) | ![应用管理](/.image/应用管理.jpg) |
| 租户 & 套餐  | ![租户管理](/.image/租户管理.jpg)   | ![租户套餐](/.image/租户套餐.png) | -                        |
| 部门 & 岗位  | ![部门管理](/.image/部门管理.jpg)   | ![岗位管理](/.image/岗位管理.jpg) | -                        |
| 菜单 & 角色  | ![菜单管理](/.image/菜单管理.jpg)   | ![角色管理](/.image/角色管理.jpg) | -                        |
| 审计日志     | ![操作日志](/.image/操作日志.jpg)   | ![登录日志](/.image/登录日志.jpg) | -                        |
| 短信       | ![短信渠道](/.image/短信渠道.jpg)   | ![短信模板](/.image/短信模板.jpg) | ![短信日志](/.image/短信日志.jpg) |
| 字典 & 敏感词 | ![字典类型](/.image/字典类型.jpg)   | ![字典数据](/.image/字典数据.jpg) | ![敏感词](/.image/敏感词.jpg)  |
| 错误码 & 通知 | ![错误码管理](/.image/错误码管理.jpg) | ![通知公告](/.image/通知公告.jpg) | -                        |

### 工作流程

| 模块      | biu                             | biu                             | biu                             |
|---------|---------------------------------|---------------------------------|---------------------------------|
| 流程模型    | ![流程模型-列表](/.image/流程模型-列表.jpg) | ![流程模型-设计](/.image/流程模型-设计.jpg) | ![流程模型-定义](/.image/流程模型-定义.jpg) |
| 表单 & 分组 | ![流程表单](/.image/流程表单.jpg)       | ![用户分组](/.image/用户分组.jpg)       | -                               |
| 我的流程    | ![我的流程-列表](/.image/我的流程-列表.jpg) | ![我的流程-发起](/.image/我的流程-发起.jpg) | ![我的流程-详情](/.image/我的流程-详情.jpg) |
| 待办 & 已办 | ![任务列表-审批](/.image/任务列表-审批.jpg) | ![任务列表-待办](/.image/任务列表-待办.jpg) | ![任务列表-已办](/.image/任务列表-已办.jpg) |

### 基础设施

| 模块            | biu                           | biu                         | biu                       |
|---------------|-------------------------------|-----------------------------|---------------------------|
| 代码生成          | ![代码生成](/.image/代码生成.jpg)     | ![生成效果](/.image/生成效果.jpg)   | -                         |
| 文档            | ![系统接口](/.image/系统接口.jpg)     | ![数据库文档](/.image/数据库文档.jpg) | -                         |
| 文件 & 配置       | ![文件配置](/.image/文件配置.jpg)     | ![文件管理](/.image/文件管理2.jpg)  | ![配置管理](/.image/配置管理.jpg) |
| 定时任务          | ![定时任务](/.image/定时任务.jpg)     | ![任务日志](/.image/任务日志.jpg)   | -                         |
| API 日志        | ![访问日志](/.image/访问日志.jpg)     | ![错误日志](/.image/错误日志.jpg)   | -                         |
| MySQL & Redis | ![MySQL](/.image/MySQL.jpg)   | ![Redis](/.image/Redis.jpg) | -                         |
| 监控平台          | ![Java监控](/.image/Java监控.jpg) | ![链路追踪](/.image/链路追踪.jpg)   | ![日志中心](/.image/日志中心.jpg) |

<!-- Removed sections for 商城系统, ERP 系统, CRM 系统, AI 大模型 as they are not the primary focus of this customized system for now -->
<!-- Screenshots for "微信公众号" and "数据报表" can be kept if those infra features are still relevant -->

### 移动端（管理后台 - 参考原项目）

| biu                              | biu                              | biu                              |
|----------------------------------|----------------------------------|----------------------------------|
| ![](/.image/admin-uniapp/01.png) | ![](/.image/admin-uniapp/02.png) | ![](/.image/admin-uniapp/03.png) |
| ![](/.image/admin-uniapp/04.png) | ![](/.image/admin-uniapp/05.png) | ![](/.image/admin-uniapp/06.png) |
| ![](/.image/admin-uniapp/07.png) | ![](/.image/admin-uniapp/08.png) | ![](/.image/admin-uniapp/09.png) |

目前已经实现登录、我的、工作台、编辑资料、头像修改、密码修改、常见问题、关于我们等基础功能。
