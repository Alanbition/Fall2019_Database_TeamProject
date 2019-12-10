<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<label><B>All Employees</B></label>
<c:forEach items="${employees}" var="employee">
    <tr>
        <td>${employee.id}</td>    
        <td>${employee.firstName}</td>
        <td>${employee.lastName}</td>
    </tr>
    <br/>
</c:forEach>
<form id="addActivePoints" action="addActivePoints" method="post">
    <label>Employee ID: </label>
    <input type="text" name="id">
    <br/>
    <button>Add</button>  
</form>
