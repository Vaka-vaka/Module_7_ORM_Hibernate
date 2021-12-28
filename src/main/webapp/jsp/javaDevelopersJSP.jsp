<%--
 Module 6. Servlets

 @autor Valentin Mozul
 @version of 24.12.2021
 --%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>A list of all Java developers</title>
   <jsp:include page = "headers.jsp"/></head>
<body>

<jsp:include page = "navigators.jsp"/>

<div class="container">
    <div class="row">
        <div style="margin: 10px">
            <h2>A list of all Java developers</h2>
        </div>
        <div class="row">
                    <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                        <div class="btn-group me-2" role="group" aria-label="Second group">
                        </div>
                    </div>
        </div>
        <table class="table">
            <thead>
            <tr>
            <th scope="col">Java Developers</th>
            </tr>
            </thead>
 <tbody>
           <%
             Object[] javaDevelopersJSP = (Object[]) request.getAttribute("javaDevelopersJSP");
             for(Object objJavaDevelopers : javaDevelopersJSP) {
             ua.goit.model.JavaDevelopers  javaDevelopers = (ua.goit.model.JavaDevelopers) objJavaDevelopers;
           %>
             <tr>
                 <td><%= javaDevelopers.getDevelopersName() %></td>
              <tr>
              <% } %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>