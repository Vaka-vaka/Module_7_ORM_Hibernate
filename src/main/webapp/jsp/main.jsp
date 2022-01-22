<%--
 Module 6. Servlets

 @autor Valentin Mozul
 @version of 24.12.2021
 --%>

<!DOCTYPE html>
<html lang="en">
      <head>
          <title>Main page</title>
          <jsp:include page = "headers.jsp"/>
     </head>
      <body>

      <jsp:include page = "navigators.jsp"/>

 <div style="margin: 20px">
         <h1>Today's date: <%= (new java.util.Date()). toLocaleString() %></h2>
        </div>
 <div style="margin: 40px">
          <h2>Today's date: <%= (new java.util.Date()). toLocaleString() %></h2>
         </div>
 <div style="margin: 60px">
          <h3>Today's date: <%= (new java.util.Date()). toLocaleString() %></h2>
         </div>
<div style="margin: 80px">
         <h4>Today's date: <%= (new java.util.Date()). toLocaleString() %></h2>
        </div>
<div style="margin: 100px">
         <h5>Today's date: <%= (new java.util.Date()). toLocaleString() %></h2>
        </div>
<div style="margin: 120px">
         <h6>Today's date: <%= (new java.util.Date()). toLocaleString() %></h2>
        </div>
      </body>
</html>
