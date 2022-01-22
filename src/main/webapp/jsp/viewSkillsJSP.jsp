<%--
 Module 6. Servlets

 @autor Valentin Mozul
 @version of 24.12.2021
 --%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>viewSkillsJSP page</title>
    <meta charset="UTF-8">
    <jsp:include page = "headers.jsp"/></head>
</head>
<body>

<jsp:include page = "navigators.jsp"/>

<% ua.goit.model.Skills  skills = (ua.goit.model.Skills) request.getAttribute("skills"); %>

<div class="container">
    <div class="row">
        <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group me-2" role="group" aria-label="Second group">
                <a href = "/skillsJSP" type="button" class="btn btn-success">Back to skills</a>
            </div>
        </div>
    </div>
        <div class="row">
            <div class="mb-3">
                <label for="id" class="form-label">ID</label>
                <input type="text" class="form-control"
                value = "<%= skills.getId() == null ? "" : skills.getId() %>"
                       id="id" placeholder="id">
            </div>
            <div class="mb-3">
                <label for="language" class="form-label">Language</label>
                <input type="text" class="form-control"
                value = "<%= skills.getLanguage() == null ? "" : skills.getLanguage() %>"
                       id="language" placeholder="language">
            </div>
            <div class="mb-3">
                            <label for="level_skills" class="form-label">Level_skills</label>
                            <input type="text" class="form-control"
                            value = "<%= skills.getLevel_skills() == null ? "" : skills.getLevel_skills() %>"
                                   id="level_skills" placeholder="level_skills">
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
    let language = document.getElementById('language');
    let level_skills = document.getElementById('level_skills');

    function save() {
    let body = {
    <% if(skills.getId() != null) {%>
         id: id.value,
    <% } %>

        language: language.value,

        level_skills: level_skills.value,
   }

<% if(skills.getId() == null) {%>
         let url = '/skillsJSP';
         let method = 'POST';
      <% } else { %>
         let url ='/skillsJSP/<%= skills.getId() %>';
         let method = 'PUT';
      <% } %>
    fetch( url, {
    method: method,
    body: JSON.stringify(body)
    })
    . then( _ => {
        window.location.href = '/skillsJSP';
    }
    );
  };
</script>
</body>
</html>
