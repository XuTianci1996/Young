<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>课程评价</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">

    <style type="text/css">
        .rate {
            padding-bottom: 5px;
        }

        .remark-item {
            padding-left: 30px;
            font-weight: 700;
        }

        .hr-line {
            height: 20px;
            border-top: 1px solid gainsboro;
            margin-top: 20px;
            margin-left: 30px;
            width: 300px;
            position: relative;
        }

        .buttons {
            float: right;
            margin: 40px 70px 70px 0px;
        }

        .mytitle {
            font-weight: 200;
        }
    </style>

</head>
<body>
<div class="layui-layer-title mytitle" style="font-size: 20px;">${courseName}</div>
<fieldset class="layui-elem-field" style="margin-top: 30px;">
    <legend>课程评分</legend>
    <div class="layui-field-box">
        <a class="remark-item">课程内容：</a>
        <div class="rate" id="starrate1"></div>
        <br/>
        <a class="remark-item">教学质量：</a>
        <div class="rate" id="starrate2"></div>
        <br/>
        <a class="remark-item">上课环境：</a>
        <div class="rate" id="starrate3"></div>
        <br/>
        <div id="hr" class="hr-line"></div>

        <a class="remark-item">总评分：&nbsp;&nbsp;&nbsp;</a>
        <div class="rate" id="starrate-all"></div>
        <br/>
    </div>
</fieldset>


<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>文字评价</legend>
</fieldset>

<div style="padding-left:20px; width: 80%;">
    <textarea id="text-comment" style="display: none;">${remark.content}</textarea>
</div>

<div class="buttons">
    <button class="layui-btn layui-btn-lg layui-btn-primary layedit-btn" data-type="redo">重新编辑</button>
    <button class="layui-btn layui-btn-lg layedit-btn" data-type="submit">确认提交</button>
</div>

</body>
<script src="${pageContext.request.contextPath }/layui/layui.js"></script>
<script type="text/javascript">

    layui.use(['form', 'table', 'rate', 'layedit'], function () {
        var form = layui.form;
        var table = layui.table;
        var $ = layui.jquery;
        var rate = layui.rate;
        var layedit = layui.layedit;

        // 渲染 - 课程内容
        var ins1 = rate.render({
            elem: '#starrate1', //绑定元素
            text: true,
            setText: function (value) { //自定义文本的回调
                var arrs = {
                    '1': '极差',
                    '2': '差',
                    '3': '中等',
                    '4': '好',
                    '5': '极好'
                };
                this.span.text(arrs[value] || "（课程内容是否充实，有价值）");
            },
            choose: function (value) {
                var ins4 = rate.render({
                    elem: '#starrate-all', //绑定元素
                    readonly: true,
                    value: (ins1.config.value + ins2.config.value + ins3.config.value) / 3,
                    theme: '#009688',
                    text: true
                });

            }
        });
        // 渲染 - 教学质量
        var ins2 = rate.render({
            elem: '#starrate2', //绑定元素
            text: true,
            setText: function (value) { //自定义文本的回调
                var arrs = {
                    '1': '极差',
                    '2': '差',
                    '3': '中等',
                    '4': '好',
                    '5': '极好'
                };
                this.span.text(arrs[value] || "（教师是否积极参与教学，对学生负责）");
            },
            choose: function (value) {
                var ins4 = rate.render({
                    elem: '#starrate-all', //绑定元素
                    readonly: true,
                    value: (ins1.config.value + ins2.config.value + ins3.config.value) / 3,
                    theme: '#009688',
                    text: true
                });

            }
        });
        // 渲染 - 上课环境
        var ins3 = rate.render({
            elem: '#starrate3', //绑定元素
            text: true,
            setText: function (value) { //自定义文本的回调
                var arrs = {
                    '1': '极差',
                    '2': '差',
                    '3': '中等',
                    '4': '好',
                    '5': '极好'
                };
                this.span.text(arrs[value] || "（教室周围的环境如何，是否影响听课）");
            },
            choose: function (value) {
                var ins4 = rate.render({
                    elem: '#starrate-all', //绑定元素
                    readonly: true,
                    value: (ins1.config.value + ins2.config.value + ins3.config.value) / 3,
                    theme: '#009688',
                    text: true
                });

            }
        });
        // 总评分
        var ins4 = rate.render({
            elem: '#starrate-all', //绑定元素
            readonly: true,
            value: '${remark.mark}',
            // value: (ins1.config.value + ins2.config.value + ins3.config.value) / 3,
            theme: '#009688',
            text: true
        });

        //富文本编辑器
        var index = layedit.build('text-comment', {
            tool: ['strong', 'italic', 'underline', 'del', '|',
                'left', 'center', 'right', '|', 'face'
            ],
            height: 200,
        });


        var active = {
            //确认提交按钮(评分+评价)
            submit: function () {
                var average = Math.round((ins1.config.value + ins2.config.value + ins3.config.value) / 3) || '${remark.mark}' || 0;
                var regex = /^\s*$/g; //判断文本输入非空
                if (average == 0) {
                    layer.alert("评分不能为空！", {
                        icon: 2
                    });
                } else if (regex.test(layedit.getText(index))) {
                    layer.alert("文字评价不能为空！", {
                        icon: 2
                    });
                } else {
                    // ajax提交数据
                    // ${flag} 是不是首次评价
                    // alert(average);
                    // alert(layedit.getText(index)); //获取编辑器内容
                    $.post("updateRemark", {
                            "mark": average,
                            "content": layedit.getText(index),
                            "cid": "${remark.cid}",
                            "courseCode": "${remark.courseCode}"
                        },
                        function (res) {
                            if (res == "success") {
                                layer.alert("感谢您的评价！", {
                                    icon: 1
                                });
                            }
                        });
                }

            },
            //重新编辑按钮
            redo: function () {
                layedit.setContent(index, '');
            }
        };

        //方便定义按钮点击事件
        $('.layedit-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });

</script>
</html>
