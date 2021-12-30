<%--
 Module 6. Servlets

 @autor Valentin Mozul
 @version of 24.12.2021
 --%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>viewDevelopersJSP page</title>
    <meta charset="UTF-8">
    <jsp:include page = "headers.jsp"/></head>
</head>
<body>

<jsp:include page = "navigators.jsp"/>

<% ua.goit.model.Developers  developers = (ua.goit.model.Developers) request.getAttribute("developers"); %>

<div class="container">
    <div class="row">
        <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group me-2" role="group" aria-label="Second group">
                <a href = "/developersJSP" type="button" class="btn btn-success">Back to developers</a>
            </div>
        </div>
    </div>
        <div class="row">
            <div class="mb-3">
                <label for="id" class="form-label">ID</label>
                <input type="text" class="form-control"
                value = "<%= developers.getId() == null ? "" : developers.getId() %>"
                       id="id" placeholder="id">
            </div>
            <div class="mb-3">
                <label for="name_" class="form-label">Name_</label>
                <input type="text" class="form-control"
                value = "<%= developers.getName_() == null ? "" : developers.getName_() %>"
                       id="name_" placeholder="name_">
            </div>
            <div class="mb-3">
                <label for="age" class="form-label">Age</label>
                <input type="text" class="form-control"
                value = "<%= developers.getAge() == 0 ? "" : developers.getAge() %>"
                       id="age" placeholder="age">
            </div>
            <div class="mb-3">
                <label for="gender" class="form-label">Gender</label>
                <input type="text" class="form-control"
                value = "<%= developers.getGender() == null ? "" : developers.getGender() %>"
                       id="gender" placeholder="gender">
            </div>
            <div class="mb-3">
                <label for="salary" class="form-label">Salary</label>
                <input type="text" class="form-control"
                value = "<%= developers.getSalary() == 0 ? "" : developers.getSalary() %>"
                       id="salary" placeholder="salary">
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
    let age = document.getElementById('age');
    let gender = document.getElementById('gender');
    let salary = document.getElementById('salary');

    function save() {
    let body = {
    <% if(developers.getId() != null) {%>
             id: id.value,
          <% } %>

        name_: name_.value,

             age: age.value,

        gender: gender.value,

             salary: salary.value,

   }
<% if(developers.getId() == null) {%>
         let url = '/developersJSP';
         let method = 'POST';
      <% } else { %>
         let url ='/developersJSP/<%= developers.getId() %>';
         let method = 'PUT';
      <% } %>
    fetch( url, {
    method: method,
    body: JSON.stringify(body)
    })
    . then( _ => {
        window.location.href = '/developersJSP';
    }
    );
  };
</script>
</body>
</html>
