<%--
  Created by IntelliJ IDEA.
  User: LTH
  Date: 2022-04-13
  Time: 오후 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Register Page</h1>
    <form action="/board/register" method="post">
        <input type="text" name="title"></input>
        <button>submit</button>
    </form>
    <script>
        window.history.forward();
        function noBack(){
            window.history.forward();
        }
    </script>
</body>
</html>
