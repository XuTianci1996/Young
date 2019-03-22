<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>我发布的课程评价</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css">
</head>
<body>
<div class="layui-fluid" style="margin-top: 40px;">
    <fieldset class="layui-elem-field layui-field-title">
        <legend style="font-size: 26px">我的课程评价</legend>
    </fieldset>
    <table id="remarkList" lay-filter="remark"></table>
</div>
<script src="${pageContext.request.contextPath }/layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['element','table','util'], function () {
        var element = layui.element,
            $ = layui.jquery,
            table = layui.table,
            util = layui.util;

        var dt = table.render({
            elem:"#remarkList",
            url:"/myRemarkInfo",
            page:true,
            cols:[[
                {field: 'cid', title: 'CID', align: 'center'},
                {field: 'courseCode', title: '课程编号', align: 'center'},
                {field: 'courseName', title: '课程名称', align: 'center'},
                {field: 'schName', title: '开课院校', align: 'center'},
                {field: 'mark', title: '我的评分', align: 'center', width:100},
                {field: 'content', title: '我的文字评价', align: 'center', minWidth: 400},
                {field: 'content_date', title: '评价时间', align: 'center'},
                {title: '操作', align: 'center',toolbar:"#tools",width:190}
            ]],
        });
        
        table.on('tool(remark)',function(obj){
            var data = obj.data;
            var layEvent = obj.event;
            var tr = obj.tr;
            var currPage = dt.config.page.curr;

            if(layEvent ==="edit"){
                window.location.href="jumpToRemarkPage?cid="+data.cid+"&courseName="+data.courseName;
            }
            if(layEvent === "view"){
                window.open("coursedetails?cid="+data.cid);
            }

        });
    });
</script>
<script type="text/html" id="tools">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑评价</a>
    <a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="view">课程详情</a>
</script>

</body>
</html>