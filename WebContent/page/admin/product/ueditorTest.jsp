<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/resources/common/include/include.inc" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" style="height:100%">
<head>
    <title>个人基本信息——对啊，学习是免费的！</title>
    <link href="<%=contextPath%>/resources/css/style.css" rel="stylesheet" type="text/css"/>
    <!-- 放在path 初始化后引入js -->
    <script type="text/javascript">
        var editor;
        $(function () {
            editor = new UE.ui.Editor({maximumWords: 1500,
            	 toolbars:[[ 'source', '|', 'undo', 'redo',  '|', 'bold', 'italic', 'underline', 'strikethrough', '|','forecolor', 'backcolor']]
            });
            editor.render("editor");
            editor.ready(function () {//需要ready后执行，否则可能报错
                editor.setContent('abc34<h1>kfc</h1>');
            })

        });
    </script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/resources/js/ueditor/editor_config.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/resources/js/ueditor/editor_all.js"></script>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath }/resources/js/ueditor/themes/default/ueditor.css"></link>
   
   
    </script>
    <style type="text/css">
        .changeBtn {
            background: url("<%=contextPath%>/resources/images/bth_zhuce.jpg") no-repeat scroll 0 0 transparent;
            border: 0 none;
            color: #FFFFFF;
            font-family: "微软雅黑";
            font-size: 14px;
            height: 32px;
            width: 72px;
        }

        .userInfo_uploadFile {
            opacity: 0;
            filter: alpha(opacity=0);
            width: 82px;
            font-size: 40px;
            height: 32px;
        }

        .geshicss {
            display: none;
            margin-top: 10px;
            left: 497px;
            height: 20px;
            top: -5px;
            position: absolute;
            line-height: 20px;
            background: #d45e69;
            border-radius: 2px;;
            padding: 3px 5px;
            color: #fff;
            font-weight: bold;
        }

        @media screen and (-webkit-min-device-pixel-ratio:0) {
            .geshicss {
                display: none;
                margin-top: 10px;
                left: 497px;
                height: 20px;
                top: -6px;
                position: absolute;
                line-height: 20px;
                background: #d45e69;
                border-radius: 2px;;
                padding: 3px 5px;
                color: #fff;
                font-weight: bold;
            }
        }
    </style>

    <style>
        .main_right1 .tab-label-container {
            border-top: 1px solid #e5e5e5;
            border-bottom: 1px solid #C3C3C3;
            padding-top: 20px;
            position: relative;
            top: 1px;
            background: -webkit-linear-gradient(#ffffff, #f2f2f2);
            height: 40px;
        }

        .main_right1 .tab-label-container .classic-tabs {
            display: block;
            padding-left: 19px;
            text-align: center;
            margin-bottom: 0;
            position: relative;
            top: 1px;
        }

        .main_right1 .tab-label-container .classic-tabs li {
            float: left;
        }

        .main_right1 .tab-label-container .classic-tabs .tab2 {
            display: block;
            background: -webkit-linear-gradient(#f8f9f9, #d6d6d6);
            border: 1px solid #C3C3C3;
            border-radius: 3px 3px 0 0;
            color: #7A7A7A;
            font-weight: bold;
            padding: 10px;
            text-shadow: 0 1px #fff;
            margin-bottom: 0;
        }

        .main_right1 .tab-label-container .classic-tabs .tab1 {
            display: block;
            background: #F6F7F8;
            border-bottom-color: #F6F7F8;
            box-shadow: none;
            top: 1px;
            color: #526075;
            border-top: 1px solid #C3C3C3;
            border-left: 1px solid #C3C3C3;
            border-right: 1px solid #C3C3C3;
            border-bottom: 1px solid #f6f7f8;
            border-radius: 3px 3px 0 0;
            font-weight: bold;
            padding: 10px;
            margin-bottom: 0;
        }

        .main_right1 .wrapper table {
            border: 1px solid #d7d7d7;
        }

        .main_right1 .wrapper table td {
            border-bottom: 1px solid #d7d7d7;
            padding-top: 12px;
            padding-bottom: 12px;
        }

        .main_right1 .wrapper table .top {
            background: url(<%=contextPath%>/resources/images/bg_tab_top.png) repeat-x;
            font-size: 16px;
            color: #666666;
            font-family: "微软雅黑";
        }

        .main_right1 .wrapper table .ma {
            background: #FFF;
            color: #666;
            font-size: 12px;
        }

        .main_right1 .wrapper table .ma a {
            color: #0088cc;
        }

        .main_right1 .wrapper table .w2 td {
            border: 0;
            background: #FFF;
            color: #666;
            font-size: 12px;
        }

        .main_right1 .wrapper table .w2 a {
            color: #0088cc;
        }
    </style>
</head>
<body style="height:100%">
	       
       
        <div class="wrapper_biaot" style="margin-top: 10px;" id="editor"></div>
</body>
</html>
