<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/3/9
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>麒麟金服</title>
  <link id="bs-css" href="<%=request.getContextPath()%>/bootstrap/bootstrap-cerulean.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/bootstrap/charisma-app.css" rel="stylesheet">
  <!-- jQuery -->
  <script src="<%=request.getContextPath()%>/jquery/jquery.min.js"></script>
  <!-- The fav icon -->
  <link rel="shortcut icon" href="<%=request.getContextPath()%>/img/favicon.ico">
</head>
<body>
    <div class="ch-container">
      <div class="row">

        <div class="row">
          <div class="col-md-12 center login-header">
            <h2>欢迎来到麒麟金服</h2>
          </div>
          <!--/span-->
        </div>
        <!--/row-->

        <div class="row">
          <div class="well col-md-5 center login-box">
            <div class="alert alert-info">
              请使用用户名和密码登录
            </div>
            <form class="form-horizontal" name="Form1">
              <fieldset>
                <div class="input-group input-group-lg">
                  <span class="input-group-addon"><i class="glyphicon glyphicon-user red"></i></span>
                  <input type="text" class="form-control" id="username" placeholder="用户名">
                </div>
                <div class="clearfix"></div>
                <br>

                <div class="input-group input-group-lg">
                  <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
                  <input type="password" class="form-control" id="passwd" placeholder="密码">
                </div>
                <div class="clearfix"></div>

                <!--<div class="input-prepend">
                    <label class="remember" for="remember"><input type="checkbox" id="remember"> 记住账号和密码</label>
                </div>
                <div class="clearfix"></div>-->

                <p class="center col-md-5">
                  <button type="button" name="btnsubmit" id="excute" class="btn btn-primary">登录</button>
                </p>
              </fieldset>
            </form>
          </div>
          <!--/span-->
        </div>
        <!--/row-->
      </div>
      <!--/fluid-row-->

    </div>
    <!--/.fluid-container-->

    <!-- external javascript -->

    <script src="<%=request.getContextPath()%>/bootstrap/bootstrap.min.js"></script>
    <!-- application script for Charisma demo -->
    <script src="<%=request.getContextPath()%>/bootstrap/charisma.js"></script>
</body>
</html>
