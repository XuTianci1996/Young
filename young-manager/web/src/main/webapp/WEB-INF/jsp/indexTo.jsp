<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css"/>
    <title>独墅湖高教区课程资源共享平台</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/h-school.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/k-style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/swiper.min.css">
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>

</head>
<body>
<div class="layui-carousel" id="bg-item">
    <div class="layui-header title">
        <div class="layui-container">
            <div class="layui-logo layui-pull-left">
                <img src="${pageContext.request.contextPath}/img/frontpagelogo.png" width="360px">
            </div>

            <c:if test="${not empty loginUser }">
                <div class="personalCenter layui-pull-right"><a class="personalCenter" href="toUserSystem" target="_blank" style="color:#fff"><i class="layui-icon layui-icon-read"></i> &nbsp;个人中心</a></div>
            </c:if>
            <c:if test="${empty loginUser }">

                <div class="operation layui-pull-right"><i class="layui-icon layui-icon-read"></i> 学生登录</div>
            </c:if>

            <div class="personalCenter layui-pull-right">
                <a class="1" href="school"><i class="layui-icon layui-icon-read"></i>院校</a></div>
        </div>

        <%--<ul class="layui-nav">--%>
        <%--<li class="layui-nav-item">--%>
        <%--<a href="">院校<span class="layui-badge">9</span></a>--%>
        <%--</li>--%>
        <%--<li class="layui-nav-item">--%>
        <%--<a href="">个人中心<span class="layui-badge-dot"></span></a>--%>
        <%--</li>--%>
        <%--<li class="layui-nav-item">--%>
        <%--<a href=""><img src="//t.cn/RCzsdCq" class="layui-nav-img">我</a>--%>
        <%--<dl class="layui-nav-child">--%>
        <%--<dd><a href="javascript:;">修改信息</a></dd>--%>
        <%--<dd><a href="javascript:;">安全管理</a></dd>--%>
        <%--<dd><a href="javascript:;">退出登录</a></dd>--%>
        <%--</dl>--%>
        <%--</li>--%>
        <%--</ul>--%>
    </div>
    <!--搜索框-->
    <div class="layui-container">
        <div class="seach-input">
            <form class="seach-form layui-form" method="post" action="${pageContext.request.contextPath}/findCourseByLike">
                <div class="layui-pull-left input">

                    <input type="text" placeholder="课程名称." name="keywords" class="seach layui-input"  value="${key}" lay-verify="required">
                </div>
                <div class="layui-pull-left button">
                    <button class="btn seach-btn" lay-submit><i class="layui-icon layui-icon-search" style="font-size: 24px;"></i></button>
                </div>
            </form>
        </div>
    </div>
    <div carousel-item>
        <div style="background: url('img/dongnan4.jpg')no-repeat center/cover"></div>
        <div style="background: url('img/dongnan1.jpg')no-repeat center/cover"></div>
        <div style="background: url('img/dongnan5.jpg')no-repeat center/cover"></div>
        <div style="background: url('img/nanda1.jpg')no-repeat center/cover"></div>
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
                                <input type="text" name="username" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <br>
                        <div class="layui-form-item">
                            <label class="layui-form-label">密码</label>
                            <div class="layui-input-block">
                                <input type="password" name="password" required  lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <br>
                        <div class="layui-form-item">
                            <button class="layui-btn layui-btn-fluid layui-btn-normal layui-btn-radius" lay-submit lay-filter="login">立即登录</button>
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
                                <input type="text" name="uname"   lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">密码</label>
                            <div class="layui-input-block">
                                <input type="password" name="password"  id="registPassword" lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">确认密码</label>
                            <div class="layui-input-block">
                                <input type="password" name="password" required  id="confirmPassword" lay-verify="required" placeholder="请再次输入密码" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">手机号</label>
                            <div class="layui-input-block">
                                <input type="text" name="telephone" required  lay-verify="required" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <%--                        <div class="layui-form-item">
                                                    <label class="layui-form-label">昵称</label>
                                                    <div class="layui-input-block">
                                                        <input type="text" name="uNickName" required  lay-verify="required" placeholder="注册后不能修改" autocomplete="off" class="layui-input">
                                                    </div>
                                                </div>--%>
                    </form>
                    <div class="layui-form-item">
                        <input type="submit" id="registSubmit" class="layui-btn layui-btn-fluid layui-btn-radius layui-btn-normal regist-btn" value="立即注册" />
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="course wCenter">

    <div class="img"  style="width: 100%;text-align: center;">

    </div>
    <div class="img"  style="width: 100%;text-align: center;">
        <c:if test="${empty key}">

            <div class="img"  style="width: 100%;text-align: center;"  > <img src="${pageContext.request.contextPath}/img/hot-course.png" alt="" name="hotcourse"></div>

        </c:if>
        <c:if test="${ empty Course}">
        <script>alert("没有该相关课程");</script>
        </c:if>

        <%--<c:if test="${ empty Course}">--%>
        <%--<script>alert("没有该相关课程");</script>--%>
        <%--</c:if>--%>
        <c:if test="${ not empty Course}">

            <fieldset class="layui-elem-field layui-field-title" id="referedCourse">
                <legend>   相关课程</legend>
            </fieldset>
        </c:if>
        <div class="detail">
            <ul>
                <c:forEach items="${HotCourse}" var="h">
                    <li><a href="coursedetails?cid=${h.cid}"}>
                        <div class="img">
                            <img src="${h.courseImage}" alt="">

                        </div>
                        <div class="status">
                            <p><span>${h.courseName}</span><span class="icon"></span></p>
                            <p><span class="planing">正在开课</span><span><img src="" alt="">${h.courseSelectnum}</span></p>
                        </div>
                        <div class="person">
                            <span><img src=""alt=""></span>
                            <span>${h.schName}</span>
                        </div>
                    </a>
                    </li>
                </c:forEach>


            </ul>

        </div>

    </div>
    <div class="course wCenter">
        <div class="detail">
            <ul>
                <c:forEach items="${Course}" var="c">
                    <li><a href="${pageContext.request.contextPath}/coursedetails?cid=${c.cid}">
                        <div class="img">
                            <img src="${c.courseImage}" alt="">

                        </div>
                        <div class="status">
                            <p><span>${c.courseName}</span><span class="icon"></span></p>
                            <p><span class="planing">正在开课</span><span><img src="" alt="">${c.courseSelectnum}</span></p>
                        </div>
                        <div class="person">
                            <span><img src=""alt=""></span>
                            <span>${c.schName}</span>
                        </div>
                    </a>
                    </li>
                </c:forEach>

            </ul>

        </div>
    </div>
    <div class="course wCenter">

        <fieldset class="layui-elem-field layui-bg-gray">
            <legend>

                <p  style="font-size: 25px;">推荐课程</p>
            </legend>
            <div class="layui-field-box">

                <div class="detail">
                    <ul>
                        <c:forEach items="${RecommendCourse}" var="c">
                            <li>
                                <a href="${pageContext.request.contextPath}/coursedetails?cid=${c.cid}">
                                    <div class="img">
                                        <img src="${c.courseImage}" alt="">
                                    </div>
                                    <div class="status">
                                        <p><span>${c.courseName}</span></p>
                                        <p><span class="planing">正在开课</span><span>${c.courseSelectnum}</span></p>
                                    </div>
                                    <div class="person">
                                        <span><img src="" alt=""></span>
                                        <span>${c.schName}</span>
                                    </div>
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </fieldset>


    </div>



    <div class="parterner wCenter">

        <fieldset class="layui-elem-field layui-field-title site-demo-button" style="margin-top: 50px;">
            <legend>合作院校</legend>
        </fieldset>

        <div class="detail">
            <div class="items">
                <%--<div class="left">合作院校</div>--%>
                <div class="item"><a href="${pageContext.request.contextPath}/schooldetail1?page=1&limit=20"><img src="img/dnxiaohui.png" alt=""></a></div>
                <div class="item"><a href="${pageContext.request.contextPath}/schooldetail2?page=1&limit=40"><img src="img/zkdxiaohui.png" alt=""></a></div>
                <div class="item"><a href=""><img src="img/kongbai.png" alt=""></a></div>
                <div class="item"><a href=""><img src="img/kongbai.png" alt=""></a></div>
                <div class="item"><a href=""><img src="img/kongbai.png" alt=""></a></div>
                <div class="item"><a href=""><img src="img/kongbai.png" alt=""></a></div>
            </div>


            <div class="footer">
                <div class="wCenter">
                    <div class="left">
                        <h5 class="black_color"><img src="../static/image/logo_small2@2x.png" alt="">独墅湖高教区课程资源共享平台</h5>
                        <p>课程内容版权均归课程内容提供者(机构)所有</p>
                    </div>
                    <div class="center">
                        <dl>
                            <dt><a class="black_color" href="Index/notice.htm">-平台介绍</a></dt>
                            <dt><a class="black_color" href="Index/help.htm">-帮助中心</a></dt>
                            <dt><a class="black_color" href="Index/concat.htm">-联系我们</a></dt>
                            <!-- <dt><a class="black_color" href="http://">-关注我们</a></dt> -->
                        </dl>
                    </div>
                    <div class="right">
                        <p class="black_color">主管单位：东南苏州研究院</p>
                        <p class="black_color">主办单位：独墅湖高教区课程资源共享平台管理中心</p>
                        <p class="black_color">承办单位：Young项目组</p>
                    </div>
                </div>
            </div>

            <script>
                layui.use(['element', 'carousel','layer','form'], function () {
                    var element = layui.element,
                        carousel = layui.carousel,
                        $ = layui.jquery,
                        layer = layui.layer,
                        form = layui.form;

                    var layer_index;
                    carousel.render({
                        elem:"#bg-item",
                        width:"100%",
                        height:"600px",
                        anim:"fade"
                    });
                    $('.operation').click(function () {
                        layer_index = layer.open({
                            type:1,
                            content:$('#sign'),
                            area:['360px','460px'],
                            title:"登录注册",
                            closeBtn:2
                        });
                    });
                    $('.list-item li').click(function () {
                        $('.list-item li').removeClass('click-this');
                        $(this).addClass('click-this');
                    });

                    $('#registSubmit').click(function () {
                        if($("input[name='uname']").val()!=""&&$("input[id='registPassword']").val()!=""&&$("input[name='telephone']").val()!=""&&$("input[id='confirmPassword']").val()!=""){
                            if(!(/^1[34578]\d{9}$/.test($("input[name='telephone']").val()))){
                                layer.msg("请输入正确的手机号！");
                            }
                            else if($("input[id='registPassword']").val()!=$("input[id='confirmPassword']").val()){
                                layer.msg("两次输入的密码不一致！");
                                $("input[id='registPassword']").val()=="";
                                $("input[id='confirmPassword']").val()=="";

                            }else{
                                $.post("regist",$('.form').serialize(),function (res) {
                                    console.log(res);
                                    if(res=='OK'){
                                        layer.close(layer_index);
                                        layer.alert("注册成功",{icon:1,time:2000});
                                        $('.form')[0].reset();
                                    }else{
                                        layer.msg("注册失败,用户名已存在");
                                    }
                                })
                            }
                        }else{
                            layer.msg("请填写所有表单");
                        }
                    });

                    form.on("submit(login)",function(){
                        $.post("login",$('#login').serialize(),function (res) {
                            if(res=="OK"){
                                window.location.href="toIndexPage";
                            }else{
                                layer.msg("用户名或者密码错误");
                            }
                        });
                        return false;
                    });
                });
            </script>
</body>
</html>
