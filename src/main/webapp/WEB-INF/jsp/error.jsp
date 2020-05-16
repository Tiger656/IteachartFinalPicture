
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>ERROR!!!</title>
    <link rel="stylesheet" href="./styles.css">
</head>
<body>
    <div class="content">
        <b>ERROR</b>
            <div id="main-text">
                <p><b>   Cause: <c:out value="${cause}"/></b></p>
            </div>
    </div>
</body>
</html>
