<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<%--提取页面顶栏--%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/comment.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/details.css">


<div class="layui-header title">
    <div class="layui-container">
        <div class="layui-pull-left">
            <a href="toIndexPage" target="_blank">
                <img src="${pageContext.request.contextPath}/img/logo.png" height="40px">
            </a>
        </div>
        <c:if test="${not empty loginUser }">
            <div class="personalCenter layui-pull-right"><a id="logout" href="javascript:;" target="_blank"
                                                            style="color:#fff"><i
                    class="layui-icon layui-icon-face-cry"></i> &nbsp;注销</a></div>
            <div class="personalCenter layui-pull-right"><a href="/toUserSystem" target="_blank" style="color:#fff"><i
                    class="layui-icon layui-icon-face-smile"></i> &nbsp;个人中心</a></div>
        </c:if>
        <c:if test="${empty loginUser }">
            <div class="operation layui-pull-right"><i class="layui-icon layui-icon-face-smile"></i>&nbsp;注册</div>
            <div class="operation layui-pull-right"><i class="layui-icon layui-icon-tree"></i>&nbsp;学生登录</div>
        </c:if>
    </div>
</div>

<div class="layui-container">
    <div class="layui-tab layui-tab-brief" id="sign" lay-filter="" style="display: none;">
        <ul class="layui-tab-title">
            <li class="layui-this">登录</li>
            <li>注册</li>
        </ul>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <div class="" style="margin: 40px 20px;">
                    <form class="layui-form layui-form-pane" id="login">
                        <div class="layui-form-item">
                            <label class="layui-form-label">用户名</label>
                            <div class="layui-input-block">
                                <input type="text" name="username" required lay-verify="required" placeholder="请输入用户名"
                                       autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <br>
                        <div class="layui-form-item">
                            <label class="layui-form-label">密码</label>
                            <div class="layui-input-block">
                                <input type="password" name="password" required lay-verify="required"
                                       placeholder="请输入密码" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <br>
                        <div class="layui-form-item">
                            <button class="layui-btn layui-btn-fluid layui-btn-normal layui-btn-radius" lay-submit
                                    lay-filter="login">立即登录
                            </button>
                        </div>
                    </form>
                </div>
            </div>
            <div class="layui-tab-item">
                <div class="" style="margin: 30px 20px;">
                    <form class="layui-form layui-form-pane form">
                        <div class="layui-form-item">
                            <label class="layui-form-label">用户名</label>
                            <div class="layui-input-block">
                                <input type="text" name="uname" required lay-verify="required" placeholder="请输入用户名"
                                       autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">密码</label>
                            <div class="layui-input-block">
                                <input type="password" name="password" required id="registPassword"
                                       lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">确认密码</label>
                            <div class="layui-input-block">
                                <input type="password" name="password" required id="confirmPassword"
                                       lay-verify="required" placeholder="请再次输入密码" autocomplete="off"
                                       class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">手机号</label>
                            <div class="layui-input-block">
                                <input type="text" name="telephone" placeholder="请输入手机号" required lay-verify="required" autocomplete="off"
                                       class="layui-input">
                            </div>
                        </div>
                    </form>
                    <div class="layui-form-item">
                        <input type="submit" id="registSubmit"
                               class="layui-btn layui-btn-fluid layui-btn-radius layui-btn-normal regist-btn"
                               value="立即注册"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script>
    layui.use(['element', 'carousel', 'layer', 'form'], function () {
        var element = layui.element,
            carousel = layui.carousel,
            $ = layui.jquery,
            layer = layui.layer,
            form = layui.form,
            layedit = layui.layedit;

        //真没办法，js代码还是没法分离出来，放回原网页了o(╥﹏╥)o
    });
</script>