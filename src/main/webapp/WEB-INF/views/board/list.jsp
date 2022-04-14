<%--
  Created by IntelliJ IDEA.
  User: LTH
  Date: 2022-04-13
  Time: 오후 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <script>
        const result = '${result}' // == null? '': result
        console.log(result)

        if(result !== ''){
            alert("처리되었습니다.")
        }

    </script>
</body>
</html>
