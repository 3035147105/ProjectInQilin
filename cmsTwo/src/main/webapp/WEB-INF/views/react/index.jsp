<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>react</title>
    <meta name="contextPath" content="${pageContext.request.contextPath}"/>
    <script src="${pageContext.request.contextPath}/react-15.4/react.min.js"></script>
    <script src="${pageContext.request.contextPath}/react-15.4/react-dom.min.js"></script>
    <script src="${pageContext.request.contextPath}/react-15.4/react-dom-fiber.min.js"></script>
    <script src="${pageContext.request.contextPath}/react-15.4/react-dom-server.min.js"></script>
    <script src="${pageContext.request.contextPath}/react-15.4/react-with-addons.min.js"></script>
    <script src="${pageContext.request.contextPath}/react-15.4/browser.min.5.6.16.js"></script>
    <script src="${pageContext.request.contextPath}/react-15.4/redux.min.3.6.0.js"></script>
</head>
<body>
    <div id="ceshi"></div>
    <div id="example"></div>
    <div id="example1"></div>
</body>
</html>
<script type="text/babel">
    var arr = [
            "你是菜鸟吗？","你甘心当一只菜鸟吗"
    ];
    var myDIV = <div className="foo"></div>;
    ReactDOM.render(myDIV, document.getElementById("example"));

    <%--var MyComponent = React.createClass({/*...*/});--%>
    <%--var myElement = <MyComponent someProperty={true}/>;--%>
    <%--ReactDOM.render(myElement, document.getElementById("example1"));--%>

    var HelloMsg = React.createClass({
        render:function () {
            return <h1>组件，你好</h1>;
        }
    });

    ReactDOM.render(
        <div>
            <h1>Hello React!</h1>
            <h2>欢迎学习react!</h2>
            <p data-myattribute="ghq">这是我名字的简称</p>
            {/*可以在JSX中使用JS表达式*/}
            <h2>{1+1}</h2>
            {/*可以在JSX中使用三元运算符来代替if else语法*/}
            <h2>{2==1 ? "i等于1":"i不等于1"}</h2>
            {/*
                jxs允许在模板中插入数组，
                数组会自动展开
            */}
            <div>{arr}</div>
        </div>,
        document.getElementById("ceshi")
    );

    ReactDOM.render(
            <HelloMsg/>,
            document.getElementById("example1")
    );

</script>