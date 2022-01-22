<%--
 Module 6. Servlets

 @autor Valentin Mozul
 @version of 24.12.2021
 --%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Customers page</title>
   <jsp:include page = "headers.jsp"/></head>
<body>

<jsp:include page = "navigators.jsp"/>

<div class="container">
    <div class="row">
        <div style="margin: 10px">
            <h2>Customers page</h2>
        </div>
        <div class="row">
            <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                <div class="btn-group me-2" role="group" aria-label="Second group">
                    <a href="/customersJSP/new" type="button" class="btn btn-primary">New</a>
                </div>
            </div>
        </div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Name_</th>
                <th scope="col">City</th>
            </tr>
            </thead>
            <tbody>
            <%
               Object[] customersJSP = (Object[]) request.getAttribute("customersJSP");
                for(Object objCustomers : customersJSP) {
                ua.goit.model.Customers  customers = (ua.goit.model.Customers) objCustomers;
                 %>
                <tr>
                      <td><%= customers.getId() %></td>
                      <td><%= customers.getName_() %></td>
                      <td><%= customers.getCity() %></td>
                      <td>
                              <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                                  <div class="btn-group me-2" role="group" aria-label="Second group">
                                    <a href = "/customersJSP/<%= customers.getId() %>" type="button" class="btn btn-warning">Edit</a>
                                    <a href = "/customersJSP?deleteId=<%= customers.getId() %>" type="button" class="btn btn-danger">Remove</a>
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