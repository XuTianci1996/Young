<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>我的订单</title>
    <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body>
    <div class="layui-fluid" style="margin-top: 40px;">
        <fieldset class="layui-elem-field layui-field-title">
            <legend style="font-size: 26px">我的选课信息</legend>
        </fieldset>
        <table id="houseList" lay-filter="order"></table>
    </div>
<script src="layui/layui.js"></script>
<script>
    layui.use(['element','form','table','util'],function () {
        var element = layui.element,
            $ = layui.jquery,
            table = layui.table,
            util = layui.util;

        var dt = table.render({
           elem:"#houseList",
           url:"/HouseRentalSystem/myOrderInfo",
           page:true,
           limit:10,
           loading:true,
           cols:[[
               {field: 'oID', title: '序号', align: 'center'}
               ,{field: 'houseDesc', title: '课程名称', align: 'center'}
               ,{field: 'houseModel', title: '开课时间', align: 'center'}
               ,{field: 'houseArea', title: '开课地点', align: 'center'}
               ,{field: 'houseFloor', title: '教师', align: 'center'}
               ,{field: 'houseType', title: '课程详情', align: 'center'}
               ,{field: 'housePrice', title: '课程总体评价', align: 'center'}
               ,{field: 'houseAddress', title: '选课人数', align: 'center'}
               ,{field: 'houseLinkMan', title: '开课状态', align: 'center'}
               ,{field: 'communityName', title: '喵喵喵', align: 'center'}
               ,{field: 'houseOriented', title: '哈哈哈', align: 'center'}
               ,{field: 'orderTime', title: '啦啦啦', align: 'center',
            	   templet:function(d){return util.toDateString(d.orderTime)}}
               ,{field: 'orderUser', title: '嘻嘻嘻', align: 'center' }
               ,{title: '操作', align: 'center',toolbar:"#tools"}
            ]],
        });
        
        table.on('tool(order)',function(obj){
            var data = obj.data;
            var layEvent = obj.event;
            var tr = obj.tr;
            var currPage = dt.config.page.curr;
            
            if(layEvent === 'delete'){
            	console.log(data.oID)
                layer.confirm('确认删除当前数据吗？',{icon:5,shade:0.1},function(index){
                    $.post("deleteOrder",{oID:data.oID},function(success){
                    	if(success == "OK"){
                    		obj.del();
                    		dt.reload({
                    			page:{curr:1}
                    		});
                    		layer.msg("删除成功");
                    	}
                    })
                });
            }
        });
    });
</script>
<script type="text/html" id="tools">
    <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="delete">删除</a>
</script>
</body>
</html>