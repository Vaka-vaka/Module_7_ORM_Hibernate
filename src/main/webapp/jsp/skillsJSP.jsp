<%--
 Module 6. Servlets

 @autor Valentin Mozul
 @version of 24.12.2021
 --%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Skills page</title>
   <jsp:include page = "headers.jsp"/></head>
<body>

<jsp:include page = "navigators.jsp"/>

<div class="container">
    <div class="row">
        <div style="margin: 10px">
            <h2>Skills page</h2>
        </div>
        <div class="row">
            <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                <div class="btn-group me-2" role="group" aria-label="Second group">
                    <a href="/skillsJSP/new" type="button" class="btn btn-primary">New</a>
                </div>
            </div>
        </div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Language</th>
                <th scope="col">Level_Skills</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
           <%
             Object[] skillsJSP = (Object[]) request.getAttribute("skillsJSP");
             for(Object objSkills : skillsJSP) {
             ua.goit.model.Skills  skills = (ua.goit.model.Skills) objSkills;
           %>
             <tr>
                 <td><%= skills.getId() %></td>
                 <td><%= skills.getLanguage() %></td>
                 <td><%= skills.getLevel_skills() %></td>
             <td>
               <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                   <div class="btn-group me-2" role="group" aria-label="Second group">
                       <a href = "/skillsJSP/<%= skills.getId() %>" type="button" class="btn btn-warning">Edit</a>
                       <a href = "/skillsJSP?deleteId=<%= skills.getId() %>" type="button" class="btn btn-danger">Remove</a>
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