<%--
 Module 6. Servlets

 @autor Valentin Mozul
 @version of 24.12.2021
 --%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Main page</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/developersJSP">Developers</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/skillsJSP">Skills</a>
                </li>
                <li class="nav-item">
                     <a class="nav-link" href="/projectsJSP">Projects</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/companiesJSP">Companies</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/customersJSP">Customers</a>
                </li>

                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                   Home Work Module 4
                  </a>
                  <ul class="dropdown-menu" aria-labelledby="navbarDarkDropdownMenuLink">

                    <li><a class="dropdown-item" href="/salaryJSP">Report 1 "Salary (sum) of all developers of a single project"</a></li>
                    <li><a class="dropdown-item" href="/developersIndividualProjectJSP">Report 2 "List of developers of an individual project"</a></li>
                     <li><a class="dropdown-item" href="/javaDevelopersJSP">Report 3 "A list of all Java developers"</a></li>
                     <li><a class="dropdown-item" href="/middleDevelopersJSP">Report 4 "A list of all Middle developers"</a></li>
                     <li><a class="dropdown-item" href="/listProjectsJSP">Report 5
                     "A list of projects in the following format: date of creation - project name - number of developers on this project"</a></li>
                  </ul>
                </li>

            </ul>
        </div>
    </div>
</nav>
