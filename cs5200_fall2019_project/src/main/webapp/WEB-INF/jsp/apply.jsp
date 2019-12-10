<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form id="apply" action="apply" method="post">
<h2>Application </h2>
<br/>
<label>Student Email: </label>
    <input type="text" name="email">
    <br/>
    <label>Password: </label>
    <input type="text" name="password">
    <br/>
    <label>Job Title: </label>
    <input type="text" name="jobTitle">
    <br/>
    <button>Submit</button>
    <br/>
</form>