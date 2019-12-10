<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<form id="welcome" action="welcome" method="get">
    <label>Welcome! ${lastName} ${firstName} AS Employee</label> 
</form>
<label><b>Group Created:</b> ${group.name}}</label>
<br/>
<label><b>Students Joined:</b></label>
<c:forEach items="${students}" var="student">
    <tr>
        <td>${student.firstName}</td>
        <td>${student.lastName}</td>
        <td>${student.email}</td>
		<br/> 
    </tr>
</c:forEach>
<br/> 
<form id="logout" action="logout" method="post"> 
    <button>logout</button>
</form>
<form id="createGroup" action="createGroup" method="post"> 
    <button>Create Group</button>
</form>