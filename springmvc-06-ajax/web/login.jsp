<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.6.3.js"></script>

    <script>
        function a1() {
            $.post({
                url: "${pageContext.request.contextPath}/a3",
                data: {"name": $("#name").val()},
                success: function (data) {
                    console.log(data)
                    if (data.toString() === "ok") {
                        $("#userInfo").css("color", "green");
                    } else {
                        $("#userInfo").css("color", "red");
                    }
                    $("#userInfo").html(data)
                }
            })
        }

        function a2() {
            $.post({
                url: "${pageContext.request.contextPath}/a3",
                data: {"password": $("#password").val()},
                success: function (data) {
                    console.log(data)
                    if (data.toString() === "ok") {
                        $("#passwordInfo").css("color", "green");
                    } else {
                        $("#passwordInfo").css("color", "red");
                    }
                    $("#passwordInfo").html(data)
                }
            })
        }
    </script>

</head>
<body>

<p>
    用户名：<input type="text" id="name" onblur="a1()">
    <span id="userInfo"></span>
</p>

<p>
    密码：<input type="password" id="password" onblur="a2()">
    <span id="passwordInfo"></span>
</p>

</body>
</html>
