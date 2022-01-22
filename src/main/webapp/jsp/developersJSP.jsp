<%--
 Module 6. Servlets

 @autor Valentin Mozul
 @version of 24.12.2021
 --%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Developers page</title>
   <jsp:include page = "headers.jsp"/></head>
<body>

<jsp:include page = "navigators.jsp"/>

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
            <%
               Object[] developersJSP = (Object[]) request.getAttribute("developersJSP");
                for(Object objDevelopers : developersJSP) {
                ua.goit.model.Developers  developers = (ua.goit.model.Developers) objDevelopers;
                 %>
                <tr>
                      <td><%= developers.getId() %></td>
                      <td><%= developers.getName_() %></td>
                      <td><%= developers.getAge() %></td>
                      <td><%= developers.getGender() %></td>
                      <td><%= developers.getSalary() %></td>
                      <td>
                              <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                                  <div class="btn-group me-2" role="group" aria-label="Second group">
                                    <a href = "/developersJSP/<%= developers.getId() %>" type="button" class="btn btn-warning">Edit</a>
                                    <a href = "/developersJSP?deleteId=<%= developers.getId() %>" type="button" class="btn btn-danger">Remove</a>
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