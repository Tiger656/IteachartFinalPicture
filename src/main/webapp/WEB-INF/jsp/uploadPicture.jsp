<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<body>
<h2>Task 2. Application</h2>
<form id="reg-form" enctype="multipart/form-data" action="/controller" method="POST">
    <p>Enter file name</p>
    <input type="text" name="fileName">
    <p>    </p>
    <input type="file" name="file" value="Choose your file" accept=".jpg, .jpeg, .png" >
    <p>    </p>
    <input type="hidden" name="command" value="actionUploadPicture" >
    <input type="submit" value="Upload ">
    <c:if test="${errormessage != null}">
        <p style="color: red; align: center; min-width: 150px">${errormessage}</p>
    </c:if>
</form>
<form id="form-button" action="/controller" method="POST">
    <input type="hidden" name="command" value="pageUploadedPictures" >
    <input type="submit" value="Go to uploaded pictures ">
</form>
</body>
</html>
