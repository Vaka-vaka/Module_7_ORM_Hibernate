<%--
 Module 6. Servlets

 @autor Valentin Mozul
 @version of 24.12.2021
 --%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>viewCompaniesJSP page</title>
    <meta charset="UTF-8">
    <jsp:include page = "headers.jsp"/></head>
</head>
<body>

<jsp:include page = "navigators.jsp"/>

<% ua.goit.model.Companies  companies = (ua.goit.model.Companies) request.getAttribute("companies"); %>

<div class="container">
    <div class="row">
        <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group me-2" role="group" aria-label="Second group">
                <a href = "/companiesJSP" type="button" class="btn btn-success">Back to companies</a>
            </div>
        </div>
    </div>
        <div class="row">
            <div class="mb-3">
                <label for="id" class="form-label">ID</label>
                <input type="text" class="form-control"
                value = "<%= companies.getId() == 0 ? "" : companies.getId() %>"
                       id="id" placeholder="id">
            </div>
            <div class="mb-3">
                <label for="name_" class="form-label">Name_</label>
                <input type="text" class="form-control"
                value = "<%= companies.getName_() == null ? "" : companies.getName_() %>"
                       id="name_" placeholder="name_">
            </div>
            <div class="mb-3">
                <label for="city" class="form-label">Age</label>
                <input type="text" class="form-control"
                value = "<%= companies.getCity() == null ? "" : companies.getCity() %>"
                       id="city" placeholder="city">
            </div>
    </div>
    <div class="row">
        <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group me-2" role="group" aria-label="Second group">
                <button onclick="save()" type="button" class="btn btn-primary">Save</button>
            </div>
        </div>
    </div>
</div>
<script>
    let id = document.getElementById('id');
    let name_ = document.getElementById('name_');
    let city = document.getElementById('city');

    function save() {
    let body = {
    <% if(companies.getId() != null) {%>
             id: id.value,
          <% } %>

        name_: name_.value,

             city: city.value,

   }
<% if(companies.getId() == 0) {%>
         let url = '/companiesJSP';
         let method = 'POST';
      <% } else { %>
         let url ='/companiesJSP/<%= companies.getId() %>';
         let method = 'PUT';
      <% } %>
    fetch( url, {
    method: method,
    body: JSON.stringify(body)
    })
    . then( _ => {
        window.location.href = '/companiesJSP';
    }
    );
  };
</script>
</body>
</html>
