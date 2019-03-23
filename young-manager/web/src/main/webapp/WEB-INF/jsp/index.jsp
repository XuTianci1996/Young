<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
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
<div class="layui-carousel" id="bg-item">
    <div class="layui-header title">
        <div class="layui-container">
            <div class="layui-logo layui-pull-left">
                <img src="img/frontpagelogo.png" width="360px">
            </div>

            <c:if test="${not empty loginUser }">
                <div class="personalCenter layui-pull-right"><a class="operation" href="toUserSystem" target="_blank" style="color:#fff"><i class="layui-icon layui-icon-read"></i> &nbsp;个人中心</a></div>
            </c:if>
            <c:if test="${empty loginUser }">

                <div class="operation layui-pull-right"><i class="layui-icon layui-icon-read"></i> &nbsp;学生登录</div>
            </c:if>

            <div class="personalCenter layui-pull-right">
                <a class="operation"><a class="operation" href="school" target="_blank" style="color:#fff"><i class="layui-icon layui-icon-read"></i>&nbsp;院校</a></div>
        </div>


    </div>
    <!--搜索框-->
    <div class="layui-container">
        <div class="seach-input">
            <form class="seach-form layui-form" method="post" action="findHouseByLike">
                <div class="layui-pull-left input">

                    <input type="text" placeholder="课程名称." name="keywords" class="seach layui-input"  lay-verify="">
                </div>
                <div class="layui-pull-left button">
                    <button class="btn seach-btn" lay-submit><i class="layui-icon layui-icon-search" style="font-size: 24px;"></i></button>
                </div>
            </form>
        </div>
    </div>
    <div carousel-item style="">
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
                                <input type="text" name="uname" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">密码</label>
                            <div class="layui-input-block">
                                <input type="password" name="password" required  id="registPassword" lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
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

    <fieldset class="layui-elem-field layui-bg-gray">

        <legend>
            <p  style="font-size: 25px;">热门课程</p>
        </legend>

        <div class="layui-field-box">

            <div class="detail">
                <ul>
                    <c:forEach items="${HotCourse}" var="h">
                        <li>
                            <a href="javascript:if(confirm('http://zjedu.moocollege.com/course/detail/30008288  \n\n���ļ��޷��� Teleport Ultra ����, ��Ϊ ����һ�����·���ⲿ������Ϊ������ʼ��ַ�ĵ�ַ��  \n\n�����ڷ������ϴ���?'))window.location='http://zjedu.moocollege.com/course/detail/30008288'">
                                <div class="img">
                                    <img src="${h.courseImage}" alt="">

                                </div>
                                <div class="status">
                                    <p><span>${h.courseName}</span><span class="icon"></span></p>
                                    <p><span class="planing">正在开课</span><span><img src="" alt="">${h.courseSelectnum}</span></p>
                                </div>
                                <div class="person">
                                    <c:if test="${h.schName.trim() eq '东南大学'}">

                                        <span><img src=""alt=""></span>
                                        <span><img src="img/dnxiaohui.png"width="25" height="15" style="vertical-align:middle">${h.schName}</span>
                                    </c:if>
                                    <c:if test="${h.schName.trim() eq '中国科技大学'}">

                                        <span><img src=""alt=""></span>
                                        <span><img src="img/zkdxiaohui.png"width="25" height="15" style="vertical-align:middle">${h.schName}</span>
                                    </c:if>
                                </div>
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </div>

        </div>
    </fieldset>

</div>
<div class="course wCenter">

    <fieldset class="layui-elem-field layui-bg-gray">
        <legend>

            <p  style="font-size: 25px;">推荐课程</p>
        </legend>
        <div class="layui-field-box">

            <div class="detail">
                <ul>
                    <li>
                        <a href="/course/detail/30008333">
                            <div class="img">
                                <img src="img/3.jpg" alt="">
                            </div>
                            <div class="status">
                                <p><span>马克思主义基本原理概论</span><span class="icon"><i class="dimc2">省级精品</i></span></p>
                                <p><span class="planing" >正在开课</span><span><img src="/static/image/people@2x.png" alt="">2732</span></p>
                            </div>
                            <div class="person">
                                <span><img src="/static/image/head.png" alt="">王来法</span>
                                <span>浙江工商大学</span>
                            </div>
                        </a>
                    </li>
                    <li><a href="/course/detail/30008288">
                        <div class="img">
                            <img src="img/9.jpg" alt="">
                        </div>
                        <div class="status">
                            <p><span>思想道德修养与法律基础</span><span class="icon"><i class="dimc3">立项课程</i></span></p>
                            <p><span class="planing">正在开课</span><span><img src="/static/image/people@2x.png" alt="">2983</span></p>
                        </div>
                        <div class="person">
                            <span><img src="http://image.moocollege.com/v2_customer/0uGjprijZ-DxLzpgB2BveyJKzvaf7Iuc3viE3XUwoNwMw5ItXcfcpE1diyBL8rik_1504748014916@!small" alt="">翁攀峰</span>
                            <span>温州医科大学</span>
                        </div>
                    </a>
                    </li>
                    <li>
                        <a href="/course/detail/30007327">
                            <div class="img">
                                <img src="img/1.png" alt="">
                            </div>
                            <div class="status">
                                <p><span>电路分析基础（2019春学期）</span><span class="icon"><i class="dimc1">国家精品</i></span></p>
                                <p><span class="planing" >正在开课</span><span><img src="/static/image/people@2x.png" alt="">2368</span></p>
                            </div>
                            <div class="person">
                                <span><img src="/static/image/head.png" alt="">卢飒</span>
                                <span>中国计量大学现代科技学院</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="/course/detail/30007776">
                            <div class="img">
                                <img src="img/4.jpg" alt="">
                            </div>
                            <div class="status">
                                <p><span>病理生理学(2018-2019学年下)</span><span class="icon"><i class="dimc3">立项课程</i></span></p>
                                <p><span class="planing" >正在开课</span><span><img src="/static/image/people@2x.png" alt="">1959</span></p>
                            </div>
                            <div class="person">
                                <span><img src="http://image.moocollege.com/v2_customer/4idB3NBDFu0jSZW1G5AppEp4IAwUbPHfAnKBy6ylGTjCa29QaeZSckLPn4NWawlV_1502179242430@!small" alt="">许益笑</span>
                                <span>温州医科大学仁济学院</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="/course/detail/30007397">
                            <div class="img">
                                <img src="img/7.jpg" alt="">
                            </div>
                            <div class="status">
                                <p><span>经济数学</span><span class="icon"><i class="dimc2">省级精品</i></span></p>
                                <p><span class="planing" >正在开课</span><span><img src="/static/image/people@2x.png" alt="">1058</span></p>
                            </div>
                            <div class="person">
                                <span><img src="/static/image/head.png" alt="">陈笑缘</span>
                                <span>浙江商业职业技术学院</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="/course/detail/30007600">
                            <div class="img">
                                <img src="img/7.jpg" alt="">
                            </div>
                            <div class="status">
                                <p><span>应用高等数学</span><span class="icon"><i class="dimc3">立项课程</i></span></p>
                                <p><span class="planing" >正在开课</span><span><img src="/static/image/people@2x.png" alt="">1435</span></p>
                            </div>
                            <div class="person">
                                <span><img src="/static/image/head.png" alt="">胡桐春</span>
                                <span>杭州科技职业技术学院</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="/course/detail/30008058">
                            <div class="img">
                                <img src="img/8.jpg" alt="">
                            </div>
                            <div class="status">
                                <p><span>江南古镇与水乡文化</span><span class="icon"><i class="dimc3">立项课程</i></span></p>
                                <p><span class="planing" >正在开课</span><span><img src="/static/image/people@2x.png" alt="">1248</span></p>
                            </div>
                            <div class="person">
                                <span><img src="http://image.moocollege.com/v2_customer/XK9HStabaw5VpkGP9zxJaNyNHPwbzYKuWyspuiCb4M0J1ZEc6EQ0qtra9b845Y2m_1502432178802@!small" alt="">陈勰</span>
                                <span>温州医科大学仁济学院</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="/course/detail/30007330">
                            <div class="img">
                                <img src="img/14.jpg" alt="">
                            </div>
                            <div class="status">
                                <p><span>大学生创业导航</span><span class="icon"><i class="dimc3">立项课程</i></span></p>
                                <p><span class="planing" >正在开课</span><span><img src="/static/image/people@2x.png" alt="">8140</span></p>
                            </div>
                            <div class="person">
                                <span><img src="/static/image/head.png" alt="">吴芳珍</span>
                                <span>金华职业技术学院</span>
                            </div>
                        </a>
                    </li>


                </ul>
            </div>
        </div>
    </fieldset>


</div>
<br><br>


<div class="parterner wCenter">


    <fieldset class="layui-elem-field layui-field-title">
        <legend>
            <p  style="font-size: 25px;">合作院校</p>
        </legend>
        <div class="layui-field-box">

        </div>
    </fieldset>

    <div class="detail">
        <div class="items">
            <%--<div class="left">合作院校</div>--%>
            <div class="item"><a href="http://localhost:8080/schooldetail1?page=1&limit=20"><img src="img/dnxiaohui.png" alt=""></a></div>
            <div class="item"><a href="http://localhost:8080/schooldetail2?page=1&limit=40"><img src="img/zkdxiaohui.png" alt=""></a></div>
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
                        if($("input[id='registPassword']").val()!=$("input[id='confirmPassword']").val()){
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
    </div>
</div>
</body>
</html>
