<%--
  Created by IntelliJ IDEA.
  User: cooki
  Date: 2022-04-13
  Time: 오후 12:56
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
    <input type="text" name="title">
    <button>CLICK</button>
</form>

<h2>파일 업로드 테스트</h2>
<form action="/upload1" method="post" enctype="multipart/form-data">
    <input type="file" name="files" multiple>
    <button>Upload</button>
</form>

<div>
    <h2>Ajax Upload</h2>
    <div class="uploadInputDiv">
        <input type="file" name="upload" multiple class="uploadFile">
    </div>
    <button class="uploadBtn">UPLOAD</button>
</div>

<style>
    .uploadResult {
        display: flex;

    }
    .uploadResult > div {
        margin: 3em;
        border: 1px solid red;
    }
</style>

<div class="uploadResult">
</div>


<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

<script>

    const uploadResult = document.querySelector(".uploadResult")

    const cloneInput = document.querySelector(".uploadFile").cloneNode()


    uploadResult.addEventListener("click", (e) => {

        if(e.target.getAttribute("class").indexOf("delBtn") < 0){
            return
        }
        const btn = e.target
        const link = btn.getAttribute("data-link")

        deleteToServer(link).then(result => {
            btn.closest("div").remove()
        })

    }, false)

    document.querySelector(".uploadBtn").addEventListener("click",(e)=> {

        const formObj = new FormData();

        const fileInput = document.querySelector(".uploadFile")

        console.log(fileInput.files)

        const files = fileInput.files

        for (let i = 0; i < files.length; i++) {
            console.log(files[i])
            formObj.append("files", files[i])
        }



        uploadToServer(formObj).then(resultArr => {

            uploadResult.innerHTML += resultArr.map(result => `<div>
                <img src='/view?fileName=\${result.thumbnail}'>
                <button data-link='\${result.link}' class="delBtn">x</button>
                \${result.original}</div>`).join(" ")

            fileInput.remove()
            document.querySelector(".uploadInputDiv").appendChild(cloneInput.cloneNode())

        })

    }, false)

    async function deleteToServer(fileName){
        const options = {headers: { "Content-Type": "application/x-www-form-urlencoded"}}

        const res = await axios.post("/delete", "fileName="+fileName, options )

        console.log(res.data)

        return res.data
    }

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
