define({ "api": [
  {
    "type": "get",
    "url": "/user/:id",
    "title": "获取用户信息",
    "name": "GetUser",
    "group": "User",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Number",
            "optional": false,
            "field": "id",
            "description": "<p>Users unique ID.</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "firstname",
            "description": "<p>Firstname of the User.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "lastname",
            "description": "<p>Lastname of the User.</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\n  \"firstname\": \"John\",\n  \"lastname\": \"Doe\"\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "fields": {
        "Error 4xx": [
          {
            "group": "Error 4xx",
            "optional": false,
            "field": "UserNotFound",
            "description": "<p>The id of the User was not found.</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found\n{\n  \"error\": \"UserNotFound\"\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "springboot-apidoc/src/main/java/com/example/demo/UserController.java",
    "groupTitle": "User"
  },
  {
    "type": "get",
    "url": "/user/:id",
    "title": "Request User information",
    "name": "GetUser",
    "group": "User",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Number",
            "optional": false,
            "field": "id",
            "description": "<p>Users unique ID.</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "firstname",
            "description": "<p>Firstname of the User.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "lastname",
            "description": "<p>Lastname of the User.</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\n  \"firstname\": \"John\",\n  \"lastname\": \"Doe\"\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "fields": {
        "Error 4xx": [
          {
            "group": "Error 4xx",
            "optional": false,
            "field": "UserNotFound",
            "description": "<p>The id of the User was not found.</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found\n{\n  \"error\": \"UserNotFound\"\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "springboot-apidoc/src/main/java/com/example/demo/UserController.java",
    "groupTitle": "User"
  },
  {
    "type": "GET",
    "url": "/users/:id",
    "title": "获取用户信息",
    "group": "Users",
    "version": "0.0.1",
    "description": "<p>获取用户信息</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          },
          {
            "group": "200",
            "type": "int",
            "optional": false,
            "field": "code",
            "description": "<p>0 代表无错误 1代表有错误</p>"
          },
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>真实姓名</p>"
          },
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "mobile",
            "description": "<p>手机号</p>"
          },
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "birthday",
            "description": "<p>生日</p>"
          },
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "email",
            "description": "<p>邮箱</p>"
          },
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "summary",
            "description": "<p>简介</p>"
          },
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "recommendCode",
            "description": "<p>我的推荐码</p>"
          },
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "idCardNo",
            "description": "<p>身份证号</p>"
          },
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "memberState",
            "description": "<p>会员状态 0普通用户 1VIP 2账户冻结</p>"
          },
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "address",
            "description": "<p>家庭住址</p>"
          },
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "money",
            "description": "<p>账户现金</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\n  \"code\": 0,\n  \"msg\": \"\",\n  \"name\": \"真实姓名\",\n  \"mobile\": 15808544477,\n  \"birthday\": \"1990-03-05\",\n  \"email\": \"slocn@gamil.com\",\n  \"summary\": \"简介\",\n  \"recommendCode\": \"我的推荐码\",\n  \"idCardNo\": \"身份证号\",\n  \"memberState\": 1,\n  \"address\": \"家庭住址\",\n  \"money\": \"30.65\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "springboot-apidoc/src/main/java/com/example/demo/UserController.java",
    "groupTitle": "Users",
    "name": "GetUsersId"
  },
  {
    "type": "POST",
    "url": "/login",
    "title": "用户登录",
    "group": "Users",
    "version": "0.0.1",
    "description": "<p>用于用户登录</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "userName",
            "description": "<p>用户名</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "password",
            "description": "<p>密码</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "?userName=张三&password=11223344",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          },
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "code",
            "description": "<p>0 代表无错误 1代表有错误</p>"
          },
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "user",
            "description": "<p>用户信息</p>"
          },
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "userId",
            "description": "<p>用户id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"0\",\"msg\":\"登录成功\",\"userId\":\"fe6386d550bd434b8cd994b58c3f8075\"}",
          "type": "json"
        }
      ]
    },
    "filename": "springboot-apidoc/src/main/java/com/example/demo/UserController.java",
    "groupTitle": "Users",
    "name": "PostLogin"
  },
  {
    "type": "POST",
    "url": "/register",
    "title": "注册用户",
    "group": "Users",
    "version": "0.0.1",
    "description": "<p>用于注册用户</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "account",
            "description": "<p>用户账户名</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "password",
            "description": "<p>密码</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "mobile",
            "description": "<p>手机号</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "vip",
            "defaultValue": "0",
            "description": "<p>是否注册Vip身份 0 普通用户 1 Vip用户</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": true,
            "field": "recommend",
            "description": "<p>邀请码</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "?account=sodlinken&password=11223344&mobile=13739554137&vip=0&recommend=",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          },
          {
            "group": "200",
            "type": "int",
            "optional": false,
            "field": "code",
            "description": "<p>0 代表无错误 1代表有错误</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"0\",\"msg\":\"注册成功\"}",
          "type": "json"
        }
      ]
    },
    "filename": "springboot-apidoc/src/main/java/com/example/demo/UserController.java",
    "groupTitle": "Users",
    "name": "PostRegister"
  },
  {
    "type": "POST",
    "url": "/users/:id",
    "title": "修改(完善)用户信息",
    "group": "Users",
    "version": "0.0.1",
    "description": "<p>修改(完善)用户信息</p>",
    "parameter": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": true,
            "field": "name",
            "description": "<p>真实姓名</p>"
          },
          {
            "group": "200",
            "type": "String",
            "optional": true,
            "field": "mobile",
            "description": "<p>手机号</p>"
          },
          {
            "group": "200",
            "type": "String",
            "optional": true,
            "field": "birthday",
            "description": "<p>生日</p>"
          },
          {
            "group": "200",
            "type": "String",
            "optional": true,
            "field": "email",
            "description": "<p>邮箱</p>"
          },
          {
            "group": "200",
            "type": "String",
            "optional": true,
            "field": "summary",
            "description": "<p>简介</p>"
          },
          {
            "group": "200",
            "type": "String",
            "optional": true,
            "field": "idCardNo",
            "description": "<p>身份证号</p>"
          },
          {
            "group": "200",
            "type": "String",
            "optional": true,
            "field": "address",
            "description": "<p>家庭住址</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          },
          {
            "group": "200",
            "type": "int",
            "optional": false,
            "field": "code",
            "description": "<p>0 代表无错误 1代表有错误</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"0\",\"msg\":\"修改成功\"}",
          "type": "json"
        }
      ]
    },
    "filename": "springboot-apidoc/src/main/java/com/example/demo/UserController.java",
    "groupTitle": "Users",
    "name": "PostUsersId"
  }
] });
