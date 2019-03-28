<%@ page import="cn.young.manager.pojo.Evaluation" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>课程详情</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/comment.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/details.css">

    <style type="text/css">

    </style>
</head>
<body>
<%--引入header.jsp--%>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>

<section class="layui-container wrapper">
    <p class="breadcrumb">
				<span class="layui-breadcrumb" lay-separator=">">
					<a href="/toIndexPage">首页</a>
					<a href="javascript:;">课程详情</a>
				</span>
    </p>
    <div class="carousel-image layui-pull-left layui-col-md7">
        <div class="layui-carousel" id="details-image ">
            <c:if test="${Course.courseImage == null}">
                <img src="${pageContext.request.contextPath}/img/nocover.jpg" style="width: 660px;"/>
            </c:if>

            <c:if test="${Course.courseImage != null}">
                <img src="${Course.courseImage}" style="width: 660px;"/>
            </c:if>
        </div>
    </div>
    <div class="details-info layui-pull-right layui-col-md5 ">
        <div class="show-price">
            <span class="sale-price">${Course.courseName}</span>
        </div>
        <hr>
        <div class="show-house-name">
            <p><span class="field">课程编号：</span><span class="name" id="course-code">${Course.courseCode}</span></p>
            <p><span class="field">主办学校：</span><span class="name">${Course.schName}</span></p>
            <p><span class="field">已选人数：</span><span class="name">${Course.courseSelectnum}</span></p>
            <p><span class="field">限选人数：</span><span class="name">${Course.courseTotalnum}</span></p>
        </div>
        <hr>
        <div class="house-model">
            <ul>
                <li>
                    <p>课程信息：</p>
                    <c:if test="${empty loginUser}">
                        <div class="operation2"><a style="font-size: 20px; font-weight: bold; color: #3D9EEA; cursor:pointer;">&nbsp;&nbsp;[请登录后查看信息]</a></div>
                    </c:if>
                    <c:if test="${not empty loginUser}">
                        <span>${Course.courseInfo}</span>
                    </c:if>
                </li>
            </ul>
        </div>
        <hr>
        <div class="order-btn-container">
            <input type="hidden" id="course-id" value="${Course.cid}">
            <input type="hidden" id="user-id" value="${loginUser.uid}">
            <button id="select-btn" class="order-btn layui-btn layui-btn-warm">选择课程</button>
        </div>
    </div>

    <div class="layui-row">
        <%--课程简介--%>
        <div class="layui-col-md7">
            <div class="anchor-title" style="color: #ee9f1a; ">
                <i class="layui-icon layui-icon-template " style="
                    float: left; color: #ee9f1a; font-size: 30px;"></i>
                <h3>&nbsp;课程简介</h3>
            </div>
            <div class="course-info" style="color:#525252; width: 660px; font-size: 15px; padding: 10px 10px;">
                <c:if test="${Course.courseDes == '' || Course.courseDes == ' '}">
                    <p style="line-height: 150%">
                        这是一门涉及${Course.courseName}的科目，请同学们提前做好预习工作(*╹▽╹*)
                    </p>
                </c:if>
                <c:if test="${Course.courseDes != ''}">
                    <p style="line-height: 150%">
                            ${Course.courseDes}
                    </p>
                </c:if>
            </div>
        </div>

        <!-- 课程评分 -->
        <div class="layui-col-md4 layui-col-md-offset1">
            <div class="anchor-title" style="color: #ee9f1a;">
                <i class="layui-icon layui-icon-form " style="
                    float: left; color: #ee9f1a; font-size: 30px;"></i>
                <h3>&nbsp;课程评分</h3>
            </div>
            <div class="layui-row">
                <div class="layui-col-md4 " style="font-size: 40px; padding: 20px 20px; font-weight:bold;">
                    <a>${Evaluation.average_mark}</a>
                </div>

                <div class="layui-col-md8" style="">
                    <div class="layui-row">
                        <div class="starrate"></div>
                        <br/>
                    </div>
                    <div class="layui-row">
                        <a>${Evaluation.total}</a>人&nbsp;评分
                    </div>
                </div>
            </div>

            <% Evaluation eva = (Evaluation) pageContext.findAttribute("Evaluation");
                //计算每种星级的比例
                double rate5_num = eva.getRate_five() * 100.0 / eva.getTotal();
                String rate5 = String.format("%.1f", rate5_num);
                double rate4_num = eva.getRate_four() * 100.0 / eva.getTotal();
                String rate4 = String.format("%.1f", rate4_num);
                double rate3_num = eva.getRate_three() * 100.0 / eva.getTotal();
                String rate3 = String.format("%.1f", rate3_num);
                double rate2_num = eva.getRate_two() * 100.0 / eva.getTotal();
                String rate2 = String.format("%.1f", rate2_num);
                double rate1_num = eva.getRate_one() * 100.0 / eva.getTotal();
                String rate1 = String.format("%.1f", rate1_num);

                if (eva.getTotal() == 0.0) {
                    rate5 = "0.0";
                    rate4 = "0.0";
                    rate3 = "0.0";
                    rate2 = "0.0";
                    rate1 = "0.0";
                }
            %>
            <div class="layui-row" style="padding: 5px 20px;">
                <div class="layui-col-md1" style="">
                    <a>5星</a>
                </div>
                <div class="layui-col-md7" style="padding: 5px">
                    <div class="layui-progress">
                        <div class="layui-progress-bar layui-bg-red" lay-percent="<%=rate5 %>%"></div>
                    </div>
                </div>
                <div class="layui-col-md4" style="padding-left: 5px;">
                    <a><%= rate5 %>%</a>
                </div>
            </div>

            <div class="layui-row" style="padding: 0px 20px;">
                <div class="layui-col-md1" style="">
                    <a>4星</a>
                </div>
                <div class="layui-col-md7" style="padding: 5px">
                    <div class="layui-progress">
                        <div class="layui-progress-bar layui-bg-orange" lay-percent="<%=rate4 %>%"></div>
                    </div>
                </div>
                <div class="layui-col-md4" style="padding-left: 5px;">
                    <a><%= rate4 %>%</a>
                </div>
            </div>

            <div class="layui-row" style="padding: 5px 20px;">
                <div class="layui-col-md1" style="">
                    <a>3星</a>
                </div>
                <div class="layui-col-md7" style="padding: 5px">
                    <div class="layui-progress">
                        <div class="layui-progress-bar layui-bg-blue" lay-percent="<%=rate3 %>%"></div>
                    </div>
                </div>
                <div class="layui-col-md4" style="padding-left: 5px;">
                    <a><%= rate3 %>%</a>
                </div>
            </div>

            <div class="layui-row" style="padding: 0px 20px;">
                <div class="layui-col-md1" style="">
                    <a>2星</a>
                </div>
                <div class="layui-col-md7" style="padding: 5px">
                    <div class="layui-progress">
                        <div class="layui-progress-bar layui-bg-green" lay-percent="<%=rate2 %>%"></div>
                    </div>
                </div>
                <div class="layui-col-md4" style="padding-left: 5px;">
                    <a><%= rate2 %>%</a>
                </div>
            </div>

            <div class="layui-row" style="padding: 5px 20px;">
                <div class="layui-col-md1" style="">
                    <a>1星</a>
                </div>
                <div class="layui-col-md7" style="padding: 5px">
                    <div class="layui-progress">
                        <div class="layui-progress-bar layui-bg-cyan" lay-percent="<%=rate1 %>%"></div>
                    </div>
                </div>
                <div class="layui-col-md4" style="padding-left: 5px;">
                    <a><%= rate1 %>%</a>
                </div>
            </div>

        </div>
    </div>

    <div class="anchor-title" style="color: #ee9f1a;">
        <i class="layui-icon layui-icon-survey " style="
             float: left; color: #ee9f1a; font-size: 30px;"></i>
        <h3>&nbsp;课程评价</h3>
    </div>
    <div class="comment_list">

        <%--AJAX获取课程评价分页内容--%>
        <%--<div id="paging-comment"></div>--%>
        <c:if test="${fn:length(UserRemarkList) == 0}">
            <div class="layui-row" style="padding: 5px 20px;">
                <div class="layui-col-md6">
                    <i class="layui-icon layui-icon-dialogue" style="color: #CCCCCC; font-size: 80px; float: right"></i>
                </div>
                <div class="layui-col-md6">
                    <div class="layui-col-md12" style="padding-top: 30px; font-size: 20px">
                        &nbsp&nbsp<a style="color:#CCCCCC; ">赶紧选择课程，参与评价吧！</a>
                    </div>
                </div>

            </div>
        </c:if>

        <c:if test="${fn:length(UserRemarkList) > 0}">
            <c:forEach items="${UserRemarkList}" var="Remark" varStatus="status">
                <div class="comment">
                    <div class="imgdiv"><img class="imgcss" src="${Remark.uimage}"/></div>
                    <div style="padding-left: 80px">
                        <span class="comment_name ">${Remark.uname} </span>
                        <span id="userrate${status.index}"></span>
                        <span><fmt:formatDate value="${Remark.content_date}" pattern="yyyy年MM月dd日"/></span>
                        <div class="comment_content">&nbsp;&nbsp;${Remark.content}</div>
                    </div>
                </div>
                <hr>
            </c:forEach>
        </c:if>

        <div id="paging" style="text-align: center;"></div>

    </div>

</section>

<%--页脚--%>
<div class="layui-container layui-bg-gray" style="margin-top: 50px;">
    <div class="layui-row layui-col-space20">
        <div class="layui-col-md5">
            <img src="${pageContext.request.contextPath}/img/young.png" width="60px"
                 height="60px" style="float: left; margin-right: 20px;">
            <h5 class="black_color" style="padding-top: 10px;">独墅湖高教区课程资源共享平台</h5>
            <p>课程内容版权均归课程内容提供者(机构)所有</p>
        </div>

        <div class="layui-col-md2">
            <dl>
                <dt><a href="javascript:;">-平台介绍</a></dt>
                <dt><a href="javascript:;">-帮助中心</a></dt>
                <dt><a href="javascript:;">-联系我们</a></dt>
            </dl>
        </div>

        <div class="layui-col-md5">
            <p>主管单位：东南苏州研究院</p>
            <p>主办单位：独墅湖高教区课程资源共享平台管理中心</p>
            <p>承办单位：Young项目组</p>
        </div>

    </div>
</div>


<!--登录注册的弹窗，移到header中了-->


<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script>
    layui.use(['element', 'carousel', 'layer', 'form', 'rate', 'laypage'], function () {
        var element = layui.element,
            carousel = layui.carousel,
            $ = layui.jquery,
            layer = layui.layer,
            form = layui.form,
            layedit = layui.layedit,
            laypage = layui.laypage,
            rate = layui.rate;

        //课程平均评分
        rate.render({
            elem: '.starrate',
            readonly: true,
            value: ${Evaluation.average_mark}, //平均评分
            half: true,
        });

        //评论区每个用户的评分
        <c:forEach items="${UserRemarkList}" var="Remark" varStatus="status">
        rate.render({
            elem: '#userrate${status.index}', //绑定元素
            readonly: true,
            value: ${Remark.mark}, //列表第n个用户的评分
            half: true,
        });
        </c:forEach>

        //轮播图效果（课程封面图片）
        carousel.render({
            elem: "#details-image",
            width: "100%",
            height: "400px",
            anim: "default"
        });

        //弹窗
        var layer_index;
        $('.operation, .operation2').click(function () {
            layer_index = layer.open({
                type: 1,
                content: $('#sign'),
                area: ['360px', '460px'],
                title: "学生登录",
                closeBtn: 2
            });
        });

        $('.list-item li').click(function () {
            $('.list-item li').removeClass('click-this');
            $(this).addClass('click-this');
        });

        //注册
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

        //登录
        form.on("submit(login)", function () {
            $.post("login", $('#login').serialize(), function (res) {
                if (res == "OK") {
                    layer.close(layer_index);
                    layer.msg("登录成功");

                    setTimeout(function () {  //使用  setTimeout（）方法设定定时2000毫秒
                        window.location.reload();//页面刷新
                    }, 2000);
                } else {
                    layer.msg("用户名或者密码错误");
                }
            });
            return false;
        });

        //注销
        $("#logout").click(function () {
            $.post("logout", function (data) {
                layer.msg("注销成功, 刷新中...");
                setTimeout(function () {  //使用  setTimeout（）方法设定定时2000毫秒
                    window.location.reload();//页面刷新
                }, 2000);
            });
        });

        //用户登录的情况下，查看选课状态
        var ischoose = 0; //假设用户没选
        <c:if test="${loginUser != null}">
        $(function () {
            $.post("hasChoosed", {
                cid: $("#course-id").val(),
                uid: $("#user-id").val()
            }, function (res) {
                if (res == '1') {
                    // 用户选了这门课
                    // 按钮样式改为灰色
                    $("#select-btn").css("background-color", "#666");
                    $("#select-btn").html("退出课程");
                    ischoose = 1;
                } else if (res == '0') {
                    // 用户没选这门课
                    // 按钮样式不用动！！
                }
            });
        });
        </c:if>

        //选课与退课

        $("#select-btn").click(function () {
            if ($("#user-id").val() == "") {
                layer.alert("您还没登录，请先登录再操作", {
                    icon: 5
                });
                return;
            }
            //选课
            if (ischoose == 0) {
                $.post("chooseCourse", {
                    cid: $("#course-id").val(),
                    uid: $("#user-id").val(),
                    course_code: "${Course.courseCode}" //修复BUG: 课程编号无法传送！
                }, function (data) {
                    if (data == "OK") {
                        layer.alert("恭喜你，选课成功！", {
                            icon: 1
                        });
                        //按钮样式改为灰色
                        $("#select-btn").css("background-color", "#666");
                        $("#select-btn").html("退出课程");
                        element.init();
                        ischoose = 1;
                    } else if (data == "FULL") {
                        layer.alert("对不起，该课已满！", {
                            icon: 2
                        });
                    }
                });
            } else {
                //退课
                //先询问意见：真的要退出吗？
                layer.confirm('您确定要退出这门课程吗？', {
                    btn: ['我再想想', '去意已决'] //按钮
                }, function () {
                    layer.msg('期待您做出正确的决定！', {icon: 6});
                }, function () {
                    $.post("quitCourse", {
                        cid: $("#course-id").val(),
                        uid: $("#user-id").val()
                    }, function (data) {
                        if (data == "OK") {
                            layer.alert("您已成功退出该课程！", {
                                icon: 1
                            });
                            //按钮样式改为原来的颜色
                            $("#select-btn").css("background-color", "#ffc601");
                            $("#select-btn").html("选择课程");
                            element.init();
                            ischoose = 0;
                        }
                    });
                });
            }


        });


    });
</script>
</body>
</html>
