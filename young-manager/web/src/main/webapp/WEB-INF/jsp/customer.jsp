<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户个人中心</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <link rel="stylesheet" href="css/admin.css">
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <a href="welcome.html" target="iframe">
            <div class="layui-logo">
                <h2>用户个人中心</h2>
            </div>
        </a>
        <ul class="layui-nav layui-layout-right" lay-filter="layadmin-layout-right">
            <li class="layui-nav-item" lay-unselect="" style="">
                <a href="javascript:;">
                    <img class="layui-nav-img" src="${loginUser.uimage}" />
                    <cite>${loginUser.uname}，欢迎回来</cite>
                    <span class="layui-nav-more"></span></a>
                <dl class="layui-nav-child layui-anim layui-anim-upbit">
                    <dd style="text-align: center;"><a href="updatepwd.html" target="iframe">修改密码</a></dd>
                    <hr>
                    <dd layadmin-event="logout" style="text-align: center;"><a href="signout">退出登录</a></dd>
                </dl>
            </li>
        </ul>
    </div>
    <div class="layui-side">
        <ul class="layui-nav layui-nav-tree" lay-filter="test">
            <li class="layui-nav-item">
                <a href="javascript:;">用户信息管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="updatepwd" target="iframe">修改我的密码</a></dd>
                    <dd><a href="addInfo" target="iframe">个人信息认证</a></dd>
                    <dd><a href="recommend" target="iframe">我的专属推荐</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-nav-tree" lay-filter="test">
            <li class="layui-nav-item">
                <a href="javascript:;">课程信息管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="myorder" target="iframe">我的课程信息</a></dd>
                    <dd><a href="myremark" target="iframe">我的课程评价</a></dd>
                </dl>
            </li>
        </ul>
    </div>
    <div class="layui-body">
        <iframe src="welcome" width="100%" height="100%" frameborder="0" name="iframe" scrolling="auto" seamless></iframe>
    </div>
    <div class="layui-footer" style="text-align: center;font-size: 16px">
        <p><span><a href="index">返回首页</a></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>Young项目组</span> </p>
    </div>
</div>
<script src="layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['element'], function () {
        var element = layui.element,
            $ = layui.jquery;
    });
</script>
</body>
</html>
