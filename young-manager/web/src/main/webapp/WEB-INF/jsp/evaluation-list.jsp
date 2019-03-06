<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="evaluationList" title="用户列表"
       data-options="singleSelect:true,collapsible:true,pagination:true,url:'/evaluation/list',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
    <tr>
        <th data-options="field:'ck',checkbox:true"></th>
        <th data-options="field:'eid',width:60">评价ID</th>
        <th data-options="field:'courseCode',width:100">课程编号</th>
        <th data-options="field:'averageMark',width:100">评价得分</th>
        <th data-options="field:'total',width:100">评价人数</th>
    </tr>
    </thead>
</table>

<script>

    function getSelectionsIds(){
        var userList = $("#evaluationList");
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