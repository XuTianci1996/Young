<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>验证信息</title>
    <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body>
<div class="wrapper" style="width: 900px;margin-top: 40px">
    <fieldset class="layui-elem-field layui-field-title">
        <legend style="font-size: 26px">认证信息</legend>
    </fieldset>
    <form id="addHouseForm" class="layui-form">
        <div class="layui-form-item">
            <label class="layui-form-label">学校</label>
            <div class="layui-input-block">
                <input type="hidden" name="id" value="${loginUser.uid }">
                <!-- <textarea name="houseDesc" placeholder="请输入内容" class="layui-textarea" required lay-verify="required" ></textarea>-->
                <input type="text" name="school" required lay-verify="required" value="${loginUser.school }" placeholder="" autocomplete="off"
                class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block">
                <input type="text" value="${loginUser.stuName}" name="stu_name" required lay-verify="required" placeholder=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">学号</label>
            <div class="layui-input-block">
                <input type="text" name="stu_number" value="${loginUser.stuNumber}" required lay-verify="required" placeholder=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <!--<div class="layui-form-item">
            <label class="layui-form-label">哈哈哈哈</label>
            <div class="layui-input-block">
                <input type="text" name="houseFloor" required lay-verify="required" placeholder="   "
                       autocomplete="off" class="layui-input">
            </div>
        </div>-->
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <select name="sex"  lay-verify="required">
                    <option value="${loginUser.sex}"></option>
                    <option  value="0" selected>保密</option>
                    <option value="1">女</option>
                    <option value="2">男</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-block">
                <input type="text" name="email" value="${loginUser.email}" required lay-verify="required" placeholder=""
                autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">联系电话</label>
            <div class="layui-input-block">
                <input type="text" name="telephone" value="${loginUser.telephone}" required lay-verify="required|phone" placeholder=""
                autocomplete="off" class="layui-input">
            </div>
        </div>

        <hr>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="addHouseRecord" id="addHouseRecord-btn">现在发布</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<script src="layui/layui.js"></script>
<script>
    layui.use(['element','form','layer','upload'],function () {
        var element = layui.element,
            form = layui.form ,
            layer = layui.layer,
            upload = layui.upload,
            $ = layui.jquery;

        upload.render({
            elem:"#SingleUpload",
            url:"/HouseRentalSystem/singleUpload",
            done: function(res, index, upload){
                //假设code=0代表上传成功
                if(res.code == 0){
                    layer.msg("文件异步加载成功！",{icon:1});
                    $("#simpleImg").attr("src",res.image);
                    $("#SingleUpload").addClass("layui-btn-disabled");
                    $("#SingleUpload").off("click");
                }
            }
        });

        var demoListView = $('#detailsList')
            ,uploadListIns = upload.render({
            elem: '#MultipleUpload'
            ,url: '/HouseRentalSystem/MultipleUpload'
            ,accept: 'file'
            ,multiple: true
            ,auto: false
            ,bindAction: '#testListAction'
            ,choose: function(obj){
                var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
                //读取本地文件
                obj.preview(function(index, file, result){
                    var tr = $(['<tr id="upload-'+ index +'">'
                        ,'<td>'+ file.name +'</td>'
                        ,'<td>'+ (file.size/1014).toFixed(1) +'kb</td>'
                        ,'<td>等待上传</td>'
                        ,'<td>'
                        ,'<button class="layui-btn layui-btn-xs demo-reload layui-hide">重传</button>'
                        ,'<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete">删除</button>'
                        ,'</td>'
                        ,'</tr>'].join(''));

                    //单个重传
                    tr.find('.demo-reload').on('click', function(){
                        obj.upload(index, file);
                    });

                    //删除
                    tr.find('.demo-delete').on('click', function(){
                        delete files[index]; //删除对应的文件
                        tr.remove();
                        uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
                    });

                    demoListView.append(tr);
                });
            }
            ,done: function(res, index, upload){
                if(res.code == 0){ //上传成功
                    var tr = demoListView.find('tr#upload-'+ index)
                        ,tds = tr.children();
                    tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
                    tds.eq(3).html(''); //清空操作
                    return delete this.files[index]; //删除文件队列已经上传成功的文件
                }
                this.error(index, upload);
            }
            ,error: function(index, upload){
                var tr = demoListView.find('tr#upload-'+ index)
                    ,tds = tr.children();
                tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
                tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
            }
        });

        form.on("submit(addHouseRecord)",function(data){
            $.post("addHouseRecord",$("#addHouseForm").serialize(),function(res){
                if(res=="OK"){
                    layer.msg("验证个人信息信息成功！",{icon:1,end:function(){window.location.href="addHouse";}});
                    $("#addHouseForm")[0].reset();
                }
            })
            return false;
        });
    });
</script>
</body>
</html>