<%--
 Module 6. Servlets

 @autor Valentin Mozul
 @version of 24.12.2021
 --%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Projects page</title>
   <jsp:include page = "headers.jsp"/></head>
<body>

<jsp:include page = "navigators.jsp"/>

<div class="container">
    <div class="row">
        <div style="margin: 10px">
            <h2>Projects page</h2>
        </div>
        <div class="row">
            <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                <div class="btn-group me-2" role="group" aria-label="Second group">
                    <a href="/projectsJSP/new" type="button" class="btn btn-primary">New</a>
                </div>
            </div>
        </div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Name_</th>
                <th scope="col">Language</th>
                <th scope="col">Cost</th>
                <th scope="col">Creation_date</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
  <%
             Object[] projectsJSP = (Object[]) request.getAttribute("projectsJSP");
             for(Object objProjects : projectsJSP) {
             ua.goit.model.Projects  projects = (ua.goit.model.Projects) objProjects;
           %>
             <tr>
                 <td><%= projects.getId() %></td>
                 <td><%= projects.getName_() %></td>
                 <td><%= projects.getLanguage() %></td>
                 <td><%= projects.getCost() %></td>
                 <td><%= projects.getCreation_date() %></td>
             <td>
               <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                   <div class="btn-group me-2" role="group" aria-label="Second group">
                       <a href = "/projectsJSP/<%= projects.getId() %>" type="button" class="btn btn-warning">Edit</a>
                       <a href = "/projectsJSP?deleteId=<%= projects.getId() %>" type="button" class="btn btn-danger">Remove</a>
                   </div>
               </div>
              </td>
              <tr>
              <% } %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>