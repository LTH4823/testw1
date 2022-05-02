<%--
  Created by IntelliJ IDEA.
  User: LTH
  Date: 2022-05-02
  Time: 오전 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<ul class="replyUL">

</ul>

<ul class="pageUL">

</ul>

<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script>

  //---------------------------------------------------------------------


  let initState = {
    bno:${dto.bno},
    replyArr:[],
    replyCount:0,
    replySize:0,
    pageNum:1
  }

  function render(obj){

    console.log("render..................")

    const replyUL = document.querySelector(".replyUL")
    const pageUL = document.querySelector(".pageUL")

    function printList(){
      const arr =obj.replyArr

      replyUL.innerHTML = "<li>Print List</li>"
    }

    function printPage(){
      pageUL.innerHTML = "<li>Page List</li>"
    }

    printList()
    printPage()

  }

  //---------------------------------------------------------------------

  const replyService = (function (initState, callbackFn){

    let state = initState
    const callback = callbackFn

    //전개 연산자 ...
    const setState = (newState)=>{
      state = {...state,...newState}
      console.log(state)

      callback(state)
    }

    return {setState}
  })(initState, render)

  replyService.setState({replyCount:${dto.replyCount}})
  replyService.setState({pageNum:11})

</script>
</body>
</html>
