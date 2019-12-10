<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form id="apply" action="apply" method="post">
<h2>Application </h2>
<br/>
<label>UserId: </label>
    <input type="number" name="id">
    <br/>
    <label>Job Title: </label>
    <input type="text" name="jobTitle">
    <br/>
    <button>Submit</button>
    <br/>
</form>