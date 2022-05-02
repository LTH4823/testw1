<%--
  Created by IntelliJ IDEA.
  User: cooki
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


  //---------------------------------------------------------

  let initState = {
    bno: ${dto.bno},
    replyArr:[],
    replyCount:0,
    size:10,
    pageNum:1
  }

  const replyUL = document.querySelector(".replyUL")
  const pageUL = document.querySelector(".pageUL")

  pageUL.addEventListener("click",(e) => {
    if(e.target.tagName != 'LI'){
      return
    }
    const dataNum = parseInt(e.target.getAttribute("data-num"))
    replySerivce.setState({pageNum:dataNum})

  }, false)


  function render(obj){

    console.log("render................")
    console.dir(obj)

    function printList(){
      const arr = obj.replyArr

      replyUL.innerHTML = arr.map(reply => `<li>\${reply.rno}</li>`).join(" ")
    }

    function printPage(){

      const currentPage = obj.pageNum
      const size = obj.size

      let endPage = Math.ceil(currentPage/10) * 10
      const startPage = endPage - 9
      const prev = startPage != 1

      endPage = obj.replyCount < endPage * obj.size? Math.ceil(obj.replyCount/obj.size) : endPage

      const next = obj.replyCount > endPage * obj.size

      console.log("startPage", startPage, "endPage", endPage, "currentPage", currentPage)

      let str = ''

      if(prev){
        str += `<li data-num=\${startPage-1}>이전</li>`
      }

      for(let i = startPage; i <= endPage; i++){
        str += `<li  data-num=\${i}>\${i}</li>`
      }

      if(next){
        str += `<li data-num=\${endPage+1}>다음</li>`
      }
      pageUL.innerHTML = str
    }

    printList()
    printPage()

  }

  //---------------------------------------------------------

  const replySerivce = (function(initState, callbackFn){

    let state = initState
    const callback = callbackFn

    const setState = (newState)=> {
      state = {...state, ...newState}
      console.log(state)

      //newState안에 replyCount속성이 있다면 혹은 pageNum이 있다면
      if(newState.replyCount || newState.pageNum){
        getServerList(newState)

      }

      callback(state)
    }

    async function getServerList(newState){

      let pageNum = Math.ceil(state.replyCount/state.size)

      if (newState.pageNum){
        pageNum = newState.pageNum
      }else {
        pageNum =  Math.ceil(state.replyCount/state.size)
      }

      const paramObj = {page:pageNum, size:state.size}

      const res = await axios.get(`/replies/list/\${state.bno}`,{params: paramObj } )

      console.log(res.data)

      state.pageNum = pageNum
      setState({replyArr: res.data})

    }


    return {setState}
  })(initState, render)

  replySerivce.setState({replyCount:${dto.replyCount}})






</script>

</body>
</html>
