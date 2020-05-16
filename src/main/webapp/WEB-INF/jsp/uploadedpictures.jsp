<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<body>
<h2>Uploaded Pictures</h2>
<c:forEach items="${images}" var="picture">
    <br/>
    <h2>${picture}</h2>
    <br/>
    <img src="${picture}" />
</c:forEach>

<form id="form-button" action="/controller" method="POST">
    <input type="hidden" name="command" value="pageUploadPicture" >
    <input type="submit" value="Go to uploading">
</form>
</body>
</html>
