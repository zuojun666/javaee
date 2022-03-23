<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/index.css">
    <script src="js/index.js"></script>
    <title>首页</title>
</head>
<body>
<div id="div_container">
    <div id="div_fruit_list">
        <p class="center f30">欢迎使用水果库存后台管理系统</p>
        <div style="border:0 solid red;width:60%;margin-left:20%;text-align:right;">
            <a href="${pageContext.request.contextPath}/add.jsp"
               style="border:0 solid blue;margin-bottom:4px;">添加新库存记录</a>
        </div>
        <form action="${pageContext.request.contextPath}/select.do">
            <table id="tbl_fruit">
                <tr>
                    <td colspan="4"><input name="select_value" style="width: 250px;height: 30px" type="text">
                        <input type="submit" style="width: 100px;height: 30px" value="关键字查询">
                    </td>
                </tr>
                <tr>
                    <th class="w20">名称</th>
                    <th class="w20">单价</th>
                    <th class="w20">库存</th>
                    <th>操作</th>
                </tr>
                <c:if test="${sessionScope.fruitList==null}">
                    <tr>
                        <td colspan="4">对不起，库存为空！</td>
                    </tr>
                </c:if>
                <c:if test="${sessionScope.fruitList!=null}">
                    <c:forEach items="${sessionScope.fruitList}" var="fruit">
                        <tr>
                            <td><a href="${pageContext.request.contextPath}/edit.do?fid=${fruit.fid}">${fruit.fname}</a>
                            </td>
                            <td>${fruit.price}</td>
                            <td>${fruit.fcount}</td>
                            <td><img src="imgs/del.jpg" class="delImg" onclick="delFruit(${fruit.fid})" alt=""/></td>
                        </tr>
                    </c:forEach>
                </c:if>
                <tr>
                    <td colspan="2"><a
                            href="${pageContext.request.contextPath}/list.do?pageNum=${sessionScope.pageNum-1}"
                            style="width: 100px;height: 50px;">上一页</a></td>
                    <td colspan="2"><a
                            href="${pageContext.request.contextPath}/list.do?pageNum=${sessionScope.pageNum+1}"
                            style="width: 100px;height: 50px;">下一页</a></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
