<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/25
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="layui/css/layui.css"/>
    <title>独墅湖高教区课程资源共享平台</title>
    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="css/h-school.css">
    <link rel="stylesheet" href="css/k-style.css">
    <link rel="stylesheet" href="css/swiper.min.css">
    <script src="layui/layui.js"></script>
</head>
<body>
 <div class="layui-fluid" style="margin-top: 40px;">
    <fieldset class="layui-elem-field layui-field-title">
        <legend style="font-size: 26px;text-align: center"> <i class="layui-icon layui-icon-face-surprised" style="font-size: 40px; color: #1E9FFF;"></i> &nbsp 亲，您还可能对以下课程感兴趣哦！</legend>
    </fieldset>
    <table id="houseList" lay-filter="order"></table>
</div>
<div class="course wCenter" style="padding: 10px">

    <fieldset class="layui-elem-field layui-bg-gray">
<div class="layui-field-box">
<div class="detail"  >
    <ul>

        <li > <a href="coursedetails?cid=${personnal.cid}" target="_blank" >
            <div class="img">
                <img src="${personnal.courseImage}" alt="">

            </div>
            <div class="status">
                <p><span>${personnal.courseName}</span><span class="icon"></span></p>
                <p><span class="planing">正在开课</span></p>
            </div>
            <div class="person">
                <span></span>
                <span>${personnal.schName}</span>
            </div>
        </a>
        </li >
        <li ><a href="coursedetails?cid=${personna2.cid}" target="_blank" >
            <div class="img">
                <img src="${personna2.courseImage}" alt="">

            </div>
            <div class="status">
                <p><span>${personna2.courseName}</span><span class="icon"></span></p>
                <p><span class="planing">正在开课</span></p>
            </div>
            <div class="person">
                <span></span>
                <span>${personna2.schName}</span>
            </div>
        </a>
        </li>
        <li ><a href="coursedetails?cid=${personna3.cid}" target="_blank">
            <div class="img">
                <img src="${personna3.courseImage}" alt="">

            </div>
            <div class="status">
                <p><span>${personna3.courseName}</span><span class="icon"></span></p>
                <p><span class="planing">正在开课</span></p>
            </div>
            <div class="person">
                <span></span>
                <span>${personna3.schName}</span>
            </div>
        </a>
        </li>
        <li ><a href="coursedetails?cid=${personna4.cid}" target="_blank">
            <div class="img">
                <img src="${personna4.courseImage}" alt="">

            </div>
            <div class="status">
                <p><span>${personna4.courseName}</span><span class="icon"></span></p>
                <p><span class="planing">正在开课</span></p>
            </div>
            <div class="person">
                <span></span>
                <span>${personna4.schName}</span>
            </div>
        </a>
        </li>


    </ul>

</div>
</div>


</body>
</html>

