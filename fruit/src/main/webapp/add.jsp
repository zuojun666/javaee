<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/add.css">
    <title>添加</title>
</head>
<body>
<div id="div_container">
    <div id="div_fruit_list">
        <p class="center f30">新增库存信息2</p>
        <form action="${pageContext.request.contextPath}/add.do" method="post">
            <table id="tbl_fruit">
                <tr>
                    <th class="w20">名称：</th>
                    <td><input type="text" name="fname"/></td>
                </tr>
                <tr>
                    <th class="w20">单价：</th>
                    <td><input type="text" name="price"/></td>
                </tr>
                <tr>
                    <th class="w20">库存：</th>
                    <td><input type="text" name="fcount"/></td>
                </tr>
                <tr>
                    <th class="w20">备注：</th>
                    <td><input type="text" name="remark"/></td>
                </tr>
                <tr>
                    <th colspan="2">
                        <input type="submit" value="添加"/>
                    </th>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
