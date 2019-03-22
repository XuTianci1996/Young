<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table  onload="getLocalTime()" class="easyui-datagrid" id="coursesList" title="用户选课列表"
       data-options="singleSelect:true,collapsible:true,pagination:true,url:'/courseselected/list',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
    <tr>
        <th data-options="field:'ck',checkbox:true"></th>
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
        alert(sels[0].uid);
        var ids = [];
        for(var i in sels){
            ids.push(sels[i].uid);
        }
        ids = ids.join(",");
        return ids;
    }

    var toolbar = [{
        text:'删除不良评论',
        iconCls:'icon-cancel',
        handler:function(){
            var userList = $("#coursesList");
            var sels = userList.datagrid("getSelections");
            var uid = sels[0].uid;
            var cid = sels[0].cid;
            if(uid == null){
                $.messager.alert('提示','未选中评价!');
                return ;
            }
            $.messager.confirm('确认','确定删除该评价吗？',function(r){
                if (r){

                    $.post("/clearEvaluation/" + uid +"/"+cid, function(data){
                        if(data.status == 200){
                            $.messager.alert('提示','删除评价成功!',function(){
                                $("#coursesList").datagrid("reload");
                            });
                        }
                    });
                }
            });
        }
    }];
</script>