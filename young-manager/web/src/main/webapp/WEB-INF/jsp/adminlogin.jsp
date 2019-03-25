<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/index.css" />
    <script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <title>管理员登录</title>
</head>
<body style="background-color: #F3F3F3">

<img src="img/Login-background.jpg" class="bgImg" />

<div class="content">

    <div class="bidTitle">独墅湖高教区课程资源共享平台<br>
        管理员登录</div>

    <div class="logCon">
        <div class="line"><span>账号:</span>
            <input class="bt_input" style="width: 250px" type="text" id="adminname"  data-options="required:true" /></div>
        <div class="line"><span>密码:</span>
            <input class="bt_input" style="width: 250px" type="text" id="adminpsw" type="password"/></div>
        <button id="login" style="width: 260px; margin-left: 40px"  type="submit" class="logingBut">登录</button>
    </div>
    <%--<div class="easyui-dialog" title="管理员登录" data-options="closable:false,draggable:false" style="width:400px;height:300px;padding:10px;">--%>
    <%--<div style="margin-left: 50px;margin-top: 50px;">--%>
    <%--<div style="margin-bottom:20px;">--%>
    <%--<div>--%>
    <%--用户名: <input id="adminname"  class="easyui-textbox" data-options="required:true"  style="width:200px;height:32px" />--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--<div style="margin-bottom:20px">--%>
    <%--<div>--%>
    <%--密&nbsp;&nbsp;码: <input id="adminpsw" class="easyui-textbox" type="password" style="width:200px;height:32px"  data-options="" />--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--<div>--%>
    <%--<input id="login" type="submit"  value="登录" />--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>

    <script type="text/javascript">
        $("#login").click(function(){
            var username = $("#adminname").val();
            var password = $("#adminpsw").val();
            $.get("/check/"+username+"/"+password,function (data) {
                if(data.status == 200){
                    window.location.href="admin";
                }else if(data.status == 404){
                    window.location.href="adminlogin";
                }
            });
        });
    </script>
</body>
</html>