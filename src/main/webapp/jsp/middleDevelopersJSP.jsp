<%--
 Module 6. Servlets

 @autor Valentin Mozul
 @version of 24.12.2021
 --%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>A list of all Middle developers</title>
   <jsp:include page = "headers.jsp"/></head>
<body>

<jsp:include page = "navigators.jsp"/>

<div class="container">
    <div class="row">
        <div style="margin: 10px">
            <h2>A list of all Middle developers</h2>
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
            <th scope="col">Middle Developers</th>
            </tr>
            </thead>
 <tbody>
           <%
             Object[] middleDevelopersJSP = (Object[]) request.getAttribute("middleDevelopersJSP");
             for(Object objMiddleDevelopers : middleDevelopersJSP) {
             ua.goit.model.MiddleDevelopers  middleDevelopers = (ua.goit.model.MiddleDevelopers) objMiddleDevelopers;
           %>
             <tr>
                 <td><%= middleDevelopers.getDevelopersName() %></td>
              <tr>
              <% } %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>