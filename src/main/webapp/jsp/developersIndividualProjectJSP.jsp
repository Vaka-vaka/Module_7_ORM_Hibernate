<%--
 Module 6. Servlets

 @autor Valentin Mozul
 @version of 24.12.2021
 --%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>List of developers of an individual project</title>
   <jsp:include page = "headers.jsp"/></head>
<body>

<jsp:include page = "navigators.jsp"/>

<div class="container">
    <div class="row">
        <div style="margin: 10px">
            <h2>List of developers of an individual project</h2>
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
            <th scope="col">Projects names</th>
            <th scope="col">Developers</th>
            </tr>
            </thead>
 <tbody>
           <%
             Object[] developersIndividualProjectJSP = (Object[]) request.getAttribute("developersIndividualProjectJSP");
             for(Object objDevelopersIndividualProject : developersIndividualProjectJSP) {
             ua.goit.model.DevelopersIndividualProject  developersIndividualProject = (ua.goit.model.DevelopersIndividualProject) objDevelopersIndividualProject;
           %>
             <tr>
                 <td><%= developersIndividualProject.getName_() %></td>
                 <td><%= developersIndividualProject.getDevelopers() %></td>
              <tr>
              <% } %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>