
<%--
  Created by IntelliJ IDEA.
  User: LTH
  Date: 2022-04-13
  Time: 오후 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--    <h1>${pageMaker}</h1>--%>

<h1>${listDTO}</h1>


<hr/>

<h3>${listDTO.link}</h3>


<ul>
    <c:forEach items="${dtoList}" var="board">
        <li>
            <span> ${board.bno} </span>
            <span><a href='/board/read${listDTO.link}&bno=${board.bno}'> ${board.title}</a></span>
        </li>
    </c:forEach>
</ul>


<%--    <h1>${dtoList}</h1>--%>


    <script>
        const result = '${result}' // == null? '': result
        console.log(result)

        if(result !== ''){
            alert("처리되었습니다.")
        }

    </script>
</body>
</html>
