<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="userList" title="用户列表"
       data-options="singleSelect:true,collapsible:true,pagination:true,url:'/user/list',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
    <tr>
        <th data-options="field:'ck',checkbox:true"></th>
        <th data-options="field:'uid',width:60">用户ID</th>
        <th data-options="field:'uname',width:100">用户名</th>
        <th data-options="field:'school',width:100">认证学校</th>
        <th data-options="field:'stunumber',width:100">学号</th>
        <th data-options="field:'telephone',width:100">手机号</th>
        <th data-options="field:'email',width:120,">邮箱</th>
        <th data-options="field:'sex',width:70">性别</th>
        <th data-options="field:'uimage',width:500">头像</th>
    </tr>
    </thead>
</table>

<script>

    function getSelectionsIds(){
        var userList = $("#userList");
        var sels = userList.datagrid("getSelections");
        var ids = [];
        for(var i in sels){
            ids.push(sels[i].uid);
        }
        ids = ids.join(",");
        return ids;
    }

    var toolbar = [{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
            var ids = getSelectionsIds();
            if(ids.length == 0){
                $.messager.alert('提示','未选中用户!');
                return ;
            }
            $.messager.confirm('确认','确定删除ID为 '+ids+' 的用户吗？',function(r){
                if (r){
                    var params = {"ids":ids};
                    $.post("/rest/user/delete",params, function(data){
                        if(data.status == 200){
                            $.messager.alert('提示','删除用户成功!',undefined,function(){
                                $("#userList").datagrid("reload");
                            });
                        }
                    });
                }
            });
        }
    }];
</script>