<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/edit.css">
    <title>编辑</title>
</head>
<body>
<div id="div_container">
    <div id="div_fruit_list">
        <p class="center f30">编辑库存信息3</p>
        <form action="${pageContext.request.contextPath}/update.do" method="post">
            <input type="hidden" name="fid" value="${sessionScope.fruit.fid}"/>
            <table id="tbl_fruit">
                <tr>
                    <th class="w20">名称：</th>
                    <td><input type="text" name="fname" value="${sessionScope.fruit.fname}"/></td>
                </tr>
                <tr>
                    <th class="w20">单价：</th>
                    <td><input type="text" name="price" value="${sessionScope.fruit.price}"/></td>
                </tr>
                <tr>
                    <th class="w20">库存：</th>
                    <td><input type="text" name="fcount" value="${sessionScope.fruit.fcount}"/></td>
                </tr>
                <tr>
                    <th class="w20">备注：</th>
                    <td><input type="text" name="remark" value="${sessionScope.fruit.remark}"/></td>
                </tr>
                <tr>
                    <th colspan="2">
                        <input type="submit" value="修改"/>
                    </th>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
