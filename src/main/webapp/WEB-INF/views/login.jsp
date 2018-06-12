<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="true" %>
<html>
    <head>
        <title>Artists Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body>
        <jsp:include page="include/navmenu.jsp" />
        <div class="container-fluid">
            <form:form id="loginForm" method="post" action="login" modelAttribute="userToLogin">
                <div class ="row">
                    <div class ="col-md-2">
                        <form:label path="login">Entrez votre nom de compte</form:label>
                        </div>
                        <div class="col-md-2">
                        <form:input id="login" name="login" path="login" />
                    </div>
                    <div class="col-md-8"></div>
                </div>
                <div class="row">
                    <div class="col-md-2">
                        <form:label path="password">Entrez votre mot de passe</form:label>
                        </div>
                        <div class="col-md-2">
                        <form:password id="password" name="password" path="password" />
                    </div>
                    <div class="col-md-8"></div>
                </div>
                <div class="row">
                    <div class="col-md-2">
                        <input type="submit" value="Se connecter" />
                    </div>
                    <div class="col-md-10"></div>
                </div>
            </form:form>
            <c:if test="${null != errorMessage}">
                <div style="color:red"><c:out value = "${errorMessage}" /></div>
            </c:if>
            <c:if test="${null != loggedMessage}">
                <div style="color:green;"><c:out value = "${loggedMessage}" /></div>
            </c:if>
        </div>
    </body>
</html>
