<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<form id="welcome" action="welcome" method="get">
    <label>Welcome ${lastName} ${firstName} AS Student!</label> 
</form>
<label>Groups Joined</label>
<br/> 
<c:forEach items="${groups}" var="group">
    <tr>    
        <td>${group.name}</td>
		<br/> 
    </tr>
</c:forEach>
<form id="addGroup" action="addGroup" method="post"> 
    <button>Add Group</button>
</form>

<label>Resumes Created</label>
<br/> 
<c:forEach items="${resumes}" var="resume">
    <tr> 
		<td>${resume.skill}</td>
		<br/>      
    </tr>
</c:forEach>
<br/> 
<label>Jobs Applied</label>
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