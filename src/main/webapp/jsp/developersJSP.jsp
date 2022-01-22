<%--
 Module 6. Servlets

 @autor Valentin Mozul
 @version of 24.12.2021
 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Developers page</title>
   <%@ include file="headers.jsp" %>
</head>
<body>

<%@ include file="navigators.jsp" %>

<div class="container">
    <div class="row">
        <div style="margin: 10px">
            <h2>Developers page</h2>
        </div>
        <div class="row">
            <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                <div class="btn-group me-2" role="group" aria-label="Second group">
                    <a href="/developersJSP/new" type="button" class="btn btn-primary">New</a>
                </div>
            </div>
        </div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Name_</th>
                <th scope="col">Age</th>
                <th scope="col">Gender</th>
                <th scope="col">Salary</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
           <c:forEach var="developer" items="${developersJSP}">
                           <tr>
                               <td><b><c:out value = "${developer.id}"/></b></td>
                               <td><c:out value = "${developer.name_}"/></td>
                               <td><c:out value = "${developer.age}"/></td>
                               <td><c:out value = "${developer.gender}"/></td>
                               <td><c:out value = "${developer.salary}"/></td>
                               <td>
                              <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                                  <div class="btn-group me-2" role="group" aria-label="Second group">
                                    <a href="/developersJSP/<c:out value = '${developer.id}'/>" alt="Редактировать" type="button" class="btn edit_btn">
                                    <a href="/developersJSP?deleteId=<c:out value = '${developer.id}'/>" alt="Удалить" type="button" class="btn del_btn">
                                 </div>
                              </div>
                      </td>
                <tr>
              </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>