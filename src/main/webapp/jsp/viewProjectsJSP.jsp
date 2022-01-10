<%--
  Module_7_ORM_Hibernate

  @autor Valentin Mozul
  @version of 30.12.2021
 --%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>viewProjectsJSP page</title>
    <meta charset="UTF-8">
    <jsp:include page = "headers.jsp"/></head>
</head>
<body>

<jsp:include page = "navigators.jsp"/>

<% ua.goit.model.Projects  projects = (ua.goit.model.Projects) request.getAttribute("projects"); %>

<div class="container">
    <div class="row">
        <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group me-2" role="group" aria-label="Second group">
                <a href = "/projectsJSP" type="button" class="btn btn-success">Back to projects</a>
            </div>
        </div>
    </div>
        <div class="row">
            <div class="mb-3">
                <label for="id" class="form-label">ID</label>
                <input type="text" class="form-control"
                value = "<%= projects.getId() == null ? "" : projects.getId() %>"
                       id="id" placeholder="id">
            </div>
            <div class="mb-3">
                <label for="name_" class="form-label">Name_</label>
                <input type="text" class="form-control"
                value = "<%= projects.getName_() == null ? "" : projects.getName_() %>"
                       id="name_" placeholder="name_">
            </div>
            <div class="mb-3">
                <label for="language" class="form-label">Language</label>
                <input type="text" class="form-control"
                value = "<%= projects.getLanguage() == null ? "" : projects.getLanguage() %>"
                       id="language" placeholder="language">
            </div>
            <div class="mb-3">
                    <label for="cost" class="form-label">Cost</label>
                    <input type="text" class="form-control"
                    value = "<%= projects.getCost() == 0 ? "" : projects.getCost() %>"
                           id="cost" placeholder="cost">
            </div>
            <div class="mb-3">
                    <label for="creation_date" class="form-label">Creation_date</label>
                    <input type="text" class="form-control"
                    value = "<%= projects.getCreation_date() == null ? "" : projects.getCreation_date() %>"
                           id="creation_date" placeholder="year-month-day">
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
    let language = document.getElementById('language');
    let cost = document.getElementById('cost');
    let creation_date = document.getElementById('creation_date');

    function save() {
    let body = {
    <% if(projects.getId() != null) {%>
         id: id.value,
    <% } %>

        name_: name_.value,

        language: language.value,

        cost: cost.value,

        creation_date: creation_date.value,
   }

<% if(projects.getId() == null) {%>
         let url = '/projectsJSP';
         let method = 'POST';
      <% } else { %>
         let url ='/projectsJSP/<%= projects.getId() %>';
         let method = 'PUT';
      <% } %>
    fetch( url, {
    method: method,
    body: JSON.stringify(body)
    })
    . then( _ => {
        window.location.href = '/projectsJSP';
    }
    );
  };
</script>
</body>
</html>
