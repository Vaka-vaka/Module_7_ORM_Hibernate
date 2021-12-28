<%--
 Module 6. Servlets

 @autor Valentin Mozul
 @version of 24.12.2021
 --%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Salary (sum) of all developers of a single project</title>
   <jsp:include page = "headers.jsp"/></head>
<body>

<jsp:include page = "navigators.jsp"/>

<div class="container">
    <div class="row">
        <div style="margin: 10px">
            <h2>Salary (sum) of all developers of a single project</h2>
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
            <th scope="col">Sum salary developers</th>
            </tr>
            </thead>
 <tbody>
           <%
             Object[] salaryJSP = (Object[]) request.getAttribute("salaryJSP");
             for(Object objSalary : salaryJSP) {
             ua.goit.model.Salary  salary = (ua.goit.model.Salary) objSalary;
           %>
             <tr>
                 <td><%= salary.getName_() %></td>
                 <td><%= salary.getSumSalary() %></td>
              <tr>
              <% } %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>