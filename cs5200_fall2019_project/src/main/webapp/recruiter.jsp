<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <div class = "panel panel-primary">
  <div class="panel-heading">
     <h3 class="panel-title">Employee</h3>
  </div>
  <div class="panel-body">
     <span th:text="${singlePerson.name}"></span>
  </div>
</div>
 <title>Recruiter List</title>
 <link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
 <script src="../webjars/jquery/3.0.0/js/jquery.min.js" ></script>
</head>
<body>
 <div class= "container">
  <h2>Employee List</h2>
  <table class="table table-striped">
   <thead>
    <tr>
     <th scope="row">Id	</th>
     <th scope="row">FirstName	</th>
     <th scope="row">LastName	</th>
     <th scope="row">Email	</th>
     <th scope="row">Password	</th>
     <th scope="row">Phone	</th>
     <th scope="row">JobTitle	</th>
     <th scope="row">BankAccount	</th>
     <th scope="row">Company	</th>
     <th scope="row">Edit	</th>
     <th scope="row">Delete	</th>
    </tr>
   </thead>
   <tbody>
    <c:forEach items="${employee_list }" var="employee" >
     <tr>
      <td> </td>
      <td> </td>
      <td> </td>
      <td> </td>
      <td> </td>
      <td> </td>
      <td>
       <spring:url value="/employee/update/${employee.employeeId }" var="updateURL" />
       <a class="btn btn-primary" href="${updateURL }" role="button">Update</a>
      </td>
      <td>
       <spring:url value="/employee/delete/${employee.employeeId }" var="deleteURL" />
       <a class="btn btn-primary" href="${deleteURL }" role="button">Delete</a>
      </td>
     </tr>
    </c:forEach>
   </tbody>
  </table>
  <spring:url value="/employee/add" var="addURL" />
  <a class="btn btn-primary" href="${addURL }" role="button">Add New Employee</a>
 </div>


</body>
</html>