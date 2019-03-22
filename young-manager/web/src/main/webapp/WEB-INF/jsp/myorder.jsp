<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>我的课程</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
</head>
<body>
<div class="layui-fluid" style="margin-top: 40px;">
    <fieldset class="layui-elem-field layui-field-title">
        <legend style="font-size: 26px">我的选课信息</legend>
    </fieldset>
    <table id="courseList" lay-filter="order"></table>
</div>

<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script>
    layui.use(['element','form','table','util'],function () {
        var element = layui.element,
            $ = layui.jquery,
            table = layui.table,
            util = layui.util;

        var dt = table.render({
            elem:"#courseList",
            url:"/myCourseInfo",
            page:true,
            limit:10,
            loading:true,
            cols:[[
                {field: 'cid', title: 'CID', align: 'center', width:80, sort: true}
                ,{field: 'courseCode', title: '课程编号', align: 'center', width:120 }
                ,{field: 'courseName', title: '课程名称', align: 'center', width:200}
                ,{field: 'schName', title: '开课院校', align: 'center', sort: true, minWidth: 120}
                ,{field: 'courseInfo', title: '课程信息', align: 'center', width:400}
                ,{field: 'courseSelectnum', title: '选课人数', align: 'center', sort: true, width:120 }
                ,{field: 'courseTotalnum', title: '限选人数', align: 'center', sort: true, width:120 }
                ,{field: 'courseRemark', title: '课程备注', align: 'center' }
                ,{title: '相关操作', align: 'center',toolbar:"#tools", minWidth: 180}
            ]],

            initSort: {
                field: 'cid' //排序字段，对应 cols 设定的各字段名
                ,type: 'asc' //排序方式  asc: 升序、desc: 降序、null: 默认排序
            }
        });

        table.on('tool(order)',function(obj){
            var data = obj.data;
            var layEvent = obj.event;
            var tr = obj.tr;
            var currPage = dt.config.page.curr;

            if(layEvent === 'delete'){
                console.log(data.cid)
                console.log("${loginUser.uid}")
                layer.confirm('确认退出当前课程吗？',
                    {icon:5,shade:0.1},
                    function(index){
                        $.post("quitCourse",{cid:data.cid, uid:"${loginUser.uid}"},function(success){
                            if(success == "OK"){
                                obj.del();
                                dt.reload({
                                    page:{curr:1}
                                });
                                layer.msg("成功退出！");
                            }
                        })
                    });
            }

            if(layEvent === 'check'){
                window.open("${pageContext.request.contextPath}/coursedetails?cid="+data.cid);
            }


        });
    });
</script>
<script type="text/html" id="tools">
    <a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="check">查看详情</a>
    <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="delete">退出课程</a>
</script>
</body>
</html>