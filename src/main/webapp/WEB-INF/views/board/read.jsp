<%--
  Created by IntelliJ IDEA.
  User: peter
  Date: 2022-04-25
  Time: 오전 1:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<textarea><c:out value="${dto.content}"/></textarea>

<div>
    <button class="listBtn">리스트</button>
    <button class="modBtn">수정/삭제</button>
</div>


<div>
    <div>
        <input type="text" name="replyText" value="샘플 댓글">
    </div>
    <div>
        <input type="text" name="replyer" value="testUser">
    </div>
    <div>
        <button class="addReplyBtn">댓글 추가</button>
    </div>
</div>

<div>
    <ul class="replyUL">

    </ul>
</div>

<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

<script>
    const bno = ${dto.bno}
        document.querySelector(".addReplyBtn").addEventListener("click", (e) => {
            const replyTextInput = document.querySelector("input[name='replyText']")
            const replyerInput = document.querySelector("input[name='replyer']")

            const replyText = replyTextInput.value
            const replyer = replyerInput.value

            const reply = {bno,replyText,replyer}

            console.log(reply)

            sendPost(reply)


        }, false)

    async function sendPost(reply){

        const res = await axios.post(`/replies/`, reply)

        console.log(res)

    }


    async function getReplyList(bno) {

        try {
            const res = await axios.get(`/replies/list/${bno}`)

            const data = res.data

            return data
        } catch (err) {
            return err
        }

    }


    getReplyList(bno)
        .then(arr => {

            const liStr = arr.map(replyDTO => `<li>\${replyDTO.rno}-- \${replyDTO.replyText}</li>`).join(" ")

            document.querySelector(".replyUL").innerHTML = liStr
        })
        .catch(err => console.log(err))


    document.querySelector(".listBtn").addEventListener("click", (e) => {

        self.location = `/board/list${listDTO.link}`

    }, false)

    document.querySelector(".modBtn").addEventListener("click", (e) => {

        self.location = `/board/modify/${bno}${listDTO.link}`
    }, false)

</script>

</body>
</html>
