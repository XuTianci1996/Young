<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table  onload="getLocalTime()" class="easyui-datagrid" id="coursesList" title="课程列表"
       data-options="singleSelect:true,collapsible:true,pagination:true,url:'/courseselected/list',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
    <tr>
        <th data-options="field:'cid',width:60">课程ID</th>
        <th data-options="field:'uid',width:100">用户ID</th>
        <th data-options="field:'courseCode',width:100">课程编码</th>
        <th data-options="field:'mark',width:100">评价分数</th>
        <th data-options="field:'content',width:100">评价内容</th>
        <th data-options="field:'contentDate',width:300">评价时间</th>
        <th data-options="field:'status',width:70,">课程状态</th>
        <th data-options="field:'ischoose',width:70">选课状态</th>
    </tr>
    </thead>
</table>

<script>

    function getSelectionsIds(){
        var userList = $("#coursesList");
        var sels = userList.datagrid("getSelections");
        var ids = [];
        for(var i in sels){
            ids.push(sels[i].uid);
        }
        ids = ids.join(",");
        return ids;
    }
    function getLocalTime(contentDate) {
        alert("11111");
        alert(contentDate);
        contentDate=""+contentDate+"";//因为jsonDate是number型的indexOf会报错
        if (contentDate.indexOf("+") > 0) {
            contentDate = contentDate.substring(0, contentDate.indexOf("+"));
        }
        else if (contentDate.indexOf("-") > 0) {
            contentDate = contentDate.substring(0, contentDate.indexOf("-"));
        }
        var date = new Date(parseInt(contentDate, 10));
        var month = date.getMonth() + 1 < 10 ? "0" + (contentDate.getMonth() + 1) : contentDate.getMonth() + 1;
        var currentDate = date.getDate() < 10 ? "0" + contentDate.getDate() : contentDate.getDate();
        var hours = date.getHours() < 10 ? "0" + contentDate.getHours() : contentDate.getHours();
        var minutes = date.getMinutes() < 10 ? "0" + contentDate.getMinutes() : contentDate.getMinutes();
        var seconds = date.getSeconds() < 10 ? "0" + contentDate.getSeconds() : contentDate.getSeconds();
        return date.getFullYear() + "-" + month + "-" + currentDate + " " + hours + ":" + minutes + ":" + seconds;
    }
    var toolbar = [{
        text:'课程评价列表',
        iconCls:'icon'
    }];
</script>