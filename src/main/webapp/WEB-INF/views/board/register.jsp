<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>register</h1>
<%--<form action="/board/register" method="post">--%>
<%--    <input type="text" name="title">--%>
<%--    <button>submit</button>--%>
<%--</form>--%>
<form action="/board/register" method="post">
    <div>
        <div>
            <input type="text" name="writer" placeholder="작성자를 입력하세요." value="<c:out value="${dto.writer}"/>">
        </div>
        <div>
            <input type="text" name="title" placeholder="제목을 입력하세요." value="<c:out value="${dto.title}"/>">
        </div>
        <div>
            <textarea name="content" placeholder="내용 입력하세요."><c:out value="${dto.content}"/></textarea>
        </div>
    </div>
    <button>등록</button>
</form>

<h2>파일 업로드 테스트</h2>
<form action="/upload1" method="post" enctype="multipart/form-data">
    <input type="file" name="files" multiple>
    <button>Upload</button>
</form>

<div>
    <h2>Ajax Upload</h2>
    <input type="file" name="upload" multiple class="uploadFile">
    <button class="uploadBtn">UPLOAD</button>
</div>

<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

<script>

    document.querySelector(".uploadBtn").addEventListener("click",(e)=> {

        const formObj = new FormData();

        const fileInput = document.querySelector(".uploadFile")

        console.log(fileInput.files)

        const files = fileInput.files

        for (let i = 0; i < files.length; i++) {
            console.log(files[i])
            formObj.append("files", files[i])
        }

        uploadToServer(formObj)

    }, false)


    async function uploadToServer (formObj) {

        console.log("upload to server......")
        console.log(formObj)

        const response = await axios({
            method: 'post',
            url: '/upload1',
            data: formObj,
            headers: {
                'Content-Type': 'multipart/form-data',
            },
        });

        return response.data
    }


</script>

</body>
</html>
