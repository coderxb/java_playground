项目结构

claudecode2spring/
├── pom.xml                          # Maven 依赖配置
├── sql/init.sql                     # 建库建表 SQL
└── src/main/
├── java/com/example/user/
│   ├── UserApplication.java     # 启动类
│   ├── common/
│   │   ├── Result.java          # 统一返回结果
│   │   ├── BusinessException.java # 业务异常
│   │   └── GlobalExceptionHandler.java # 全局异常处理
│   ├── config/
│   │   ├── CorsConfig.java      # 跨域配置
│   │   └── MybatisPlusConfig.java # 分页插件配置
│   ├── dto/
│   │   ├── UserCreateDTO.java   # 新增用户请求体
│   │   └── UserUpdateDTO.java   # 修改用户请求体
│   ├── entity/User.java         # 用户实体
│   ├── mapper/UserMapper.java   # MyBatis-Plus Mapper
│   ├── service/
│   │   ├── UserService.java     # 服务接口
│   │   └── impl/UserServiceImpl.java # 服务实现
│   └── controller/UserController.java # REST 控制器
└── resources/application.yml    # 应用配置

运行步骤
1. 执行建表 SQL — 在 MySQL 中运行 sql/init.sql
2. 修改数据库配置 — 编辑 application.yml 中的 username 和 password
3. 启动项目：
   mvn spring-boot:run

接口测试

Knife4j 文档地址：http://localhost:8080/doc.html

┌────────┬─────────────────┬────────────┐
│  方法  │      路径       │    说明    │
├────────┼─────────────────┼────────────┤
│ POST   │ /api/users      │ 新增用户   │
├────────┼─────────────────┼────────────┤
│ GET    │ /api/users/{id} │ 根据ID查询 │
├────────┼─────────────────┼────────────┤
│ GET    │ /api/users      │ 用户列表   │
├────────┼─────────────────┼────────────┤
│ PUT    │ /api/users      │ 修改用户   │
├────────┼─────────────────┼────────────┤
│ DELETE │ /api/users/{id} │ 删除用户   │
└────────┴─────────────────┴────────────┘

新增用户示例请求体：
{
"username": "zhangsan",
"password": "123456",
"nickname": "张三",
"email": "zhangsan@example.com",
"phone": "13800138000"
}

功能特性：密码使用 BCrypt 加密存储，查询接口自动隐藏密码字段，用户名唯一性校验，参数校验 + 全局异常处理。