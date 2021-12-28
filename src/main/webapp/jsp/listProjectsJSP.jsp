<%--
 Module 6. Servlets

 @autor Valentin Mozul
 @version of 24.12.2021
 --%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>A list of projects in the following format: date of creation - project name - number of developers on this project</title>
   <jsp:include page = "headers.jsp"/></head>
<body>

<jsp:include page = "navigators.jsp"/>

<div class="container">
    <div class="row">
        <div style="margin: 10px">
            <h2>A list of projects in the following format: date of creation - project name - number of developers on this project</h2>
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
            <th scope="col">List Projects</th>
            </tr>
            </thead>
 <tbody>
           <%
             Object[] listProjectsJSP = (Object[]) request.getAttribute("listProjectsJSP");
             for(Object objListProjects : listProjectsJSP) {
             ua.goit.model.ListProjects  listProjects = (ua.goit.model.ListProjects) objListProjects;
           %>
             <tr>
                 <td><%= listProjects.getListProjects()%></td>
              <tr>
              <% } %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>