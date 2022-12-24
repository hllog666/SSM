<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-l2 column">
            <div class="page-header">
                <h1>
                    <small>书籍列表-显示所有书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/books/toAddPaper">新增书籍</a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/books/allBook">显示全部书籍</a>
        </div>
        <div class="col-md-8 column">
            <form class="form-inline" action="${pageContext.request.contextPath}/books/queryBook" method="post">
                <span style="color: red;font-weight: bold">${error}</span>
                <input type="text" placeholder="请输入要查询的书籍名称" class="form-control" name="queryBookName">
                <input type="submit" value="查询" class="btn btn-primary">
            </form>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>书籍编号</th>
                    <th>书籍名称</th>
                    <th>书籍数量</th>
                    <th>书籍详情</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="book" items="${list}">
                    <tr>
                        <td>${book.bookId}</td>
                        <td>${book.bookName}</td>
                        <td>${book.bookCounts}</td>
                        <td>${book.detail}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/books/toUpdatePaper?id=${book.bookId}">修改</a>
                            &nbsp;|&nbsp;
                            <a href="${pageContext.request.contextPath}/books/deleteBook/${book.bookId}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
