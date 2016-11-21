<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="contextPath" content="${pageContext.request.contextPath}"/>
    <script src="${pageContext.request.contextPath}/jquery/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/bootstrap.min.css"/>
    <script src="${pageContext.request.contextPath}/bootstrap/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/react-15.4/react.min.js"></script>
    <script src="${pageContext.request.contextPath}/react-15.4/react-dom.min.js"></script>
    <script src="${pageContext.request.contextPath}/react-15.4/react-dom-fiber.min.js"></script>
    <script src="${pageContext.request.contextPath}/react-15.4/react-dom-server.min.js"></script>
    <script src="${pageContext.request.contextPath}/react-15.4/react-with-addons.min.js"></script>
    <script src="${pageContext.request.contextPath}/react-15.4/browser.min.5.6.16.js"></script>
    <script src="${pageContext.request.contextPath}/react-15.4/redux.min.3.6.0.js"></script>
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
                        <form action="${pageContext.request.contextPath}/tradeBrokerageNo/list.do" method="get"
                                   class="form-inline" role="form">
                            <button type="submit" class="btn btn-success">搜索</button>
                        </form>
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
                                    </tbody>
                                </table>
                            </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="ceshi"></div>
</body>
</html>
<script type="text/jsx">
    React.render(
            <h1>Hello World</h1>,
            document.getElementById("ceshi")
    );
</script>

