<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %><%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<script>
    function ajaxCall()
    {

        $.ajax({
            type: "GET",
            url: '/bookAjax',
            dataType: "json",
            crossDomain: true,
            success: function (data) {
                document.getElementById("ajaxMsg").innerHTML = "Ajax success";
            },
            error: function (data) {
                document.getElementById("ajaxMsg").innerHTML = "Ajax error";
            }
        });
    }
</script>
<html>
    <head>
        <title>Shows Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body>
        <jsp:include page="include/navmenu.jsp" />
<!--        <div>
            <input type="button" onclick="ajaxCall()" value="Appel ajax">
            <div id="ajaxMsg">
                
            </div>
        </div>
-->
        <div class="container-fluid">
            <h1>Shows List</h1>
            <form:form id="filter" method="post" action="filter" modelAttribute="categorieToFilter">
                <div class="row">
                    <div class ="col-md-2">
                        <form:label path="name">Trier</form:label>
                        </div>
                        <div class="col-md-2">
                        <form:select path="name" items="${listCategories}" />
                    </div>
                    <div class="col-md-8"><input type="submit" value="Appliquer" /></div>
                </div>
            </form:form>
            <c:if test="${!empty listShows}">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Show ID</th>
                            <th>Show slug</th>
                            <th>Show Title</th>
                            <th>Price</th>
                            <th>Catégorie</th>
                            <th>Book</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listShows}" var="show">
                            <tr>
                                <td>${show.id}</td>
                                <td>${show.slug}</td>
                                <td>${show.title}</td>
                                <td>${show.price}</td>
                                <td>${show.categorieId.name}</td>
                                <td><a href="<c:url value='/book/${show.id}' />" ><c:if test="${show.bookable == true}">Bookable</c:if><c:if test="${show.bookable == false}">Pas Bookable</c:if></a></td>
                                </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>

            <h1>Ajoutez un spectacle</h1>
            <form:form id="addShowForm" method="post" action="addShow" modelAttribute="showToAdd">
                <div class ="row">
                    <div class ="col-md-2">
                        <form:label path="title">Entrez le titre du spectacle</form:label>
                        </div>
                        <div class="col-md-2">
                        <form:input id="title" name="title" path="title" />
                    </div>
                    <div class="col-md-8"></div>
                </div>
                <div class ="row">
                    <div class ="col-md-2">
                        <form:label path="slug">Entrez un mot-clé à associer</form:label>
                        </div>
                        <div class="col-md-2">
                        <form:input id="slug" name="slug" path="slug" />
                    </div>
                    <div class="col-md-8"></div>
                </div>
                <div class ="row">
                    <div class ="col-md-2">
                        <form:label path="price">Entrez le prix</form:label>
                        </div>
                        <div class="col-md-2">
                        <form:input id="price" name="price" path="price" />
                    </div>
                    <div class="col-md-8"></div>
                </div>
                <div class="row">
                    <div class ="col-md-2">
                        <form:label path="categorieId">Catégorie</form:label>
                        </div>
                        <div class="col-md-2">
                        <form:select path="categorieId.name" items="${listCategories}" />
                    </div>
                    <div class="col-md-8"></div>
                </div>
                <div class="row">
                    <div class="col-md-2">
                        <input type="submit" value="Ajouter" />
                    </div>
                    <div class="col-md-10"></div>
                </div>
            </form:form>
            <h1>Ajouter une catégorie</h1>
            <form:form id="addCategorieForm" method="post" action="addCategorie" modelAttribute="categorieToAdd">
                <div class ="row">
                    <div class ="col-md-2">
                        <form:label path="name">Entrez un nom de catégorie</form:label>
                        </div>
                        <div class="col-md-2">
                        <form:input id="name" name="name" path="name" />
                    </div>
                    <div class="col-md-8"><input type="submit" value="Ajouter" /></div>
                </div>
            </form:form>
        </div>
    </body>
</html>
