<%@page contentType="text/html; utf-8" pageEncoding="utf-8"  isELIgnored="false" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/user/logout">退出登录</a>
<ul>
    <shiro:hasRole name="user">
        <shiro:hasPermission name="user:create.01">
            <li><a href="">user管理系统</a></li>
        </shiro:hasPermission>
        <shiro:hasPermission name="user:create.02">
            <li><a href="">用户系统</a></li>
        </shiro:hasPermission>
    </shiro:hasRole>

    <shiro:hasRole name="user">
        <shiro:hasPermission name="user.create.01">
            <li><a href="">user管理系统</a></li>
        </shiro:hasPermission>
    </shiro:hasRole>

    <shiro:hasRole name="admin">
        <shiro:hasPermission name="user:create.01">
            <li><a href="">admin文件系统</a></li>
        </shiro:hasPermission>
        <shiro:hasPermission name="user:create.02">
            <li><a href="">硬件系统</a></li>
        </shiro:hasPermission>
    </shiro:hasRole>

    <shiro:hasRole name="admin">
        <shiro:hasPermission name="admin:*.*">
            <li><a href="">admin管理系统</a></li>
        </shiro:hasPermission>
    </shiro:hasRole>
</ul>
</body>
</html>