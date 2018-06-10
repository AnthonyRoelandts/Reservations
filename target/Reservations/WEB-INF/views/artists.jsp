<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
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
            <h1>Artists List</h1>
            <c:if test="${!empty listArtists}">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Artist ID</th>
                            <th>Artist Firstname</th>
                            <th>Artist Lastname</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listArtists}" var="artist">
                            <tr>
                                <td>${artist.id}</td>
                                <td>${artist.firstname}</td>
                                <td>${artist.lastname}</td>
                                <td><a href="<c:url value='/remove/${artist.id}' />" >Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
            
        </div>
    </body>
</html>
