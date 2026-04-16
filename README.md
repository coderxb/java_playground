# java_playground

Java学习与实践项目集，包含多个独立子项目。

## 项目结构

```
java_playground/
├── ant_test/              # Ant构建示例
├── claudecode2spring/     # Spring Boot用户管理系统
├── EasyBlog/              # Spring MVC博客系统
├── HelloAlgorithm/        # 算法学习
├── HelloJava/             # Java基础示例
├── HelloMongoDB/          # MongoDB示例
└── RunRemoteLinux/        # 远程Linux执行工具
```

## 子项目说明

### 1. HelloJava
Java基础示例项目，展示各种核心库的使用。
- **包**: `com.china.gavin`
- **依赖**: MySQL, JUnit, Log4j, SLF4J, Jedis, Guice, Gson, cglib, commons-email
- **特点**: Java 1.7，包含XML解析(JDOM, dom4j)、Excel处理(jxl)、邮件发送等示例

### 2. HelloAlgorithm
算法学习项目，包含基础算法实现和LeetCode题目。
- **包**: `com.xuebing.algorithm`
- **模块**:
  - `basis` - 基础算法
    - `search/binary` - 二分搜索系列
    - `sorting` - 排序算法(冒泡、插入、快排、希尔等)
    - `tree` - 二叉树、LRU
  - `extension` - 扩展内容
    - `rpn` - 逆波兰表达式
    - `shorturl` - 短链接算法
  - `interview` - 面试题
  - `leetcode` - LeetCode题目

### 3. EasyBlog
Spring MVC博客系统，使用传统SSM架构。
- **包**: `indi.coderxb.easyblog`
- **技术栈**: Spring 3.2 + MyBatis + Redis + Ehcache + c3p0
- **特点**: 包含完整Controller-Service-Mapper分层，单元测试，多环境配置(dev/prod)

### 4. claudecode2spring
Spring Boot用户管理系统，采用现代微服务架构。
- **包**: `com.example.user`
- **技术栈**: Spring Boot 2.7 + MyBatis-Plus + MySQL + Knife4j(Swagger)
- **模块**: Controller层(Auth, User)、Service层、Mapper层、DTO层
- **特点**: RESTful API设计，包含全局异常处理、分页查询

### 5. HelloMongoDB
MongoDB数据库示例项目。
- **包**: `com.gavin`
- **技术栈**: MongoDB Driver + Morphia ORM + Spring 3.0.5
- **特点**: 展示MongoDB与Java的集成使用

### 6. RunRemoteLinux
远程执行Linux命令的工具。
- **包**: `indi.xuebing.rrl`
- **依赖**: ganymed-ssh2, jsch
- **特点**: 通过SSH远程连接并执行Linux命令

### 7. ant_test
Ant构建工具的入门示例。
- **包**: `com.gavin.helloworld`
- **特点**: 展示Ant构建脚本的基本用法(target依赖、jar打包等)

## 构建与运行

各子项目独立构建，使用Maven或Ant。

```bash
# Maven项目
cd <子项目目录>
mvn clean install

# 运行Spring Boot项目
cd claudecode2spring
mvn spring-boot:run

# Ant项目
cd ant_test
ant run
```
