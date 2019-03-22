<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset=UTF-8"UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="layui/css/layui.css"/>
    <title>独墅湖高教区课程资源共享平台</title>
    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="css/h-school.css">
    <link rel="stylesheet" href="css/k-style.css">
    <link rel="stylesheet" href="css/swiper.min.css">
    <script src="layui/layui.js"></script>
    <style>
    .footer {
        margin-top: 80px;
    }
    </style>
    
</head>
<body>
    <script src="../../static/js/rem.js" tppabs="http://zjedu.moocollege.com/static/js/rem.js"></script>
        <div class="header">
        <div class="wCenter">
            <div class="ico">
                <i class="iconfont cl-mo">&#xe60b;</i>
            </div>
            <div class="left">
                <a href="index.htm" tppabs="http://zjedu.moocollege.com/Province/Index/index">
                    <img src="../../static/image/logoBanner.png" tppabs="http://zjedu.moocollege.com/static/image/logoBanner.png" alt="">
                </a>
            </div>
            <div class="layui-header title">
                <div class="layui-container">
                    <div class="layui-logo layui-pull-left">
                        <img src="img/frontpagelogo.png" width="360px">
                    </div>

                    <c:if test="${not empty loginUser }">
                        <div class="personalCenter layui-pull-right"><a href="toUserSystem" target="_blank" style="color:#fff"><i class="layui-icon layui-icon-tree"></i> 个人中心</a></div>
                    </c:if>
                    <c:if test="${empty loginUser }">
                        <div class="operation layui-pull-right"><i class="layui-icon layui-icon-tree"></i> 学生登录</div>
                    </c:if>
                    <div class="personalCenter layui-pull-right"><a href="toUserSystem" target="_blank" style="color:#fff"><i class="layui-icon layui-icon-tree"></i>院校</a></div>
                </div>
            </div>

        </div>
        <!-- <div class="box-shadow"></div> -->
    </div>
    

       <div class="compatible-big">
        <div class="s-detail">
            <div class="Center">
                <div class="s-intro">
                    
                    <div class="img">
                        <img src="" alt="">
                    </div>
                    <p><p>${schoolname.schDes}</p></p>
                                        <div class="s-course">开放课程</div>
                    <div class="items">
                        <div class="detail">
                            <ul>
                                <c:forEach items="${courses}" var="h">
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
                        <p class="paging">
                            <a href="schooldetail?page=${1}">&lt;&lt; 首页 </a>
                            <a href="schooldetail?page=${total-1 }">    &lt; 上一页 </a>
                            <strong>第${paging.page+1}页/共${total}页</strong>
                            <a href="schooldetail?page=${paging.page+1}">下一页 &gt;</a>
                            <a href="schooldetail?page=${total}">末页 &gt;&gt;</a>
                        </p>
                    </div>
                   
                </div> 
            </div>
        </div>
    </div>

    <div class="parterner wCenter">
        <div class="title" >
            <span><i class="school-parter" style="color: #0E7DFF" ></i></span>
        </div>
        <div class="detail">
            <div class="items">
                <div class="left">合作院校</div>
                <div class="item"><a href="/schooldetail/1"><img src="img/dnxiaohui.png" alt=""></a></div>
                <div class="item"><a href="/schooldetail/2"><img src="img/zkdxiaohui.png" alt=""></a></div>
                <div class="item"><a href="#"><img src="img/kongbai.png" alt=""></a></div>
                <div class="item"><a href="#"><img src="img/kongbai.png" alt=""></a></div>
                <div class="item"><a href="#"><img src="img/kongbai.png" alt=""></a></div>
                <div class="item"><a href="#"><img src="img/kongbai.png" alt=""></a></div>
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
        </div>
    </div>





</body>
</html>