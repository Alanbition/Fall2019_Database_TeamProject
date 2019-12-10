<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<form id="welcome" action="welcome" method="get">
    <label>Welcome ${lastName} ${firstName} AS Student!</label> 
</form>
<label><b>Groups Joined</b></label>
<br/> 
<c:forEach items="${groups}" var="group" varStatus="status">
    <tr>
        <td><b>Group Name: </b></td>    
        <td>${group.name}</td>
        <td><b>Employee Name: </b></td>
        <td>${employees[status.index].firstName}</td>
        <td>${employees[status.index].lastName}</td>
		<br/> 
    </tr>
</c:forEach>
<form id="addGroup" action="addGroup" method="post"> 
    <button><b>Add Group</button>
</form>

<label><b>Resumes Created</b></label>
<br/> 
<c:forEach items="${resumes}" var="resume">
    <tr> 
		<td>${resume.skill}</td>
		<br/>      
    </tr>
</c:forEach>
<br/> 
<label><b>Jobs Applied</b></label>
<br/> 
<c:forEach items="${applications}" var="application">
    <tr>  
		<td>${application.description}</td> 
		<td>${application.process}</td> 
		<br/>    
    </tr>
</c:forEach>
<form id="logout" action="logout" method="post"> 
    <button>logout</button>
</form>