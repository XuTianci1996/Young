<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="courseList" title="课程列表"
       data-options="singleSelect:true,collapsible:true,pagination:true,url:'/course/list',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
    <tr>
        <th data-options="field:'cid',width:60">课程ID</th>
        <th data-options="field:'schName',width:100">学校名称</th>
        <th data-options="field:'courseCode',width:100">课程编码</th>
        <th data-options="field:'courseName',width:100">课程名</th>
        <th data-options="field:'courseInfo',width:300">课程信息</th>
        <th data-options="field:'courseSelectnum',width:70,">已选人数</th>
        <th data-options="field:'courseTotalnum',width:70">限选人数</th>
        <th data-options="field:'courseRemark',width:100">备注</th>
        <th data-options="field:'courseDes',width:100">课程描述</th>
        <th data-options="field:'courseImage',width:100">课程图片</th>
    </tr>
    </thead>
</table>

<script>

    function getSelectionsIds(){
        var userList = $("#courseList");
        var sels = userList.datagrid("getSelections");
        var ids = [];
        for(var i in sels){
            ids.push(sels[i].uid);
        }
        ids = ids.join(",");
        return ids;
    }

    var toolbar = [{
        text:'课程列表',
        iconCls:'icon'
    }];
</script>