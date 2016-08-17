<%--
  Created by IntelliJ IDEA.
  User: gaohaiqing
  Date: 16-7-27
  Time: 下午6:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="contextPath" content="${pageContext.request.contextPath}"/>
    <script src="${pageContext.request.contextPath}/jquery/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/bootstrap.min.css"/>
    <script src="${pageContext.request.contextPath}/bootstrap/bootstrap.min.js"></script>
    <title>feedback主页</title>
</head>
<body>
<div class="row">
    <div class="col-lg-12">
        <div class="row">
            <div class="col-lg-12">
                <h1>管理</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="main-box">
                    <header class="main-box-header clearfix">
                        <h2>列表</h2>
                    </header>
                    <div class="main-box-body clearfix">
                        <form:form action="${pageContext.request.contextPath}/tradeBrokerageNo/list.do" method="get"
                                   class="form-inline" role="form">
                            <button type="submit" class="btn btn-success">搜索</button>
                        </form:form>
                        <br>
                            <div class="table-responsive">
                                <table id="table-example-fixed" class="table table-hover">
                                    <thead>
                                    <tr>
                                        <th>内容</th>
                                        <th>手机</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="row" items="${page}" varStatus="rowStatus">
                                        <tr data-id="${row.id}">
                                            <td>${row.content}</td>
                                            <td>${row.phone}</td>
                                            <td colspan="1">
                                                <a class="btn btn-xs btn-danger" onclick="deleteBrokerage(${row.id})" data-toggle="modal">删除</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
