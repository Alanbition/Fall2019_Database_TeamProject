<form id="register" action="register" method="post">
    <label>Registration </label>
    <br/>
    <label>UserRole: </label>
    <input type="text" name="userRole">
    <br/>
    <label>First Name: </label>
    <input type="text" name="firstName">
    <br/>
    <label>Last Name: </label>
    <input type="text" name="lastName">
    <br/>
    <label>Email: </label>
    <input type="text" name="email">
    <br/>
    <label>Password: </label>
    <input type="text" name="password">
    <br/>
    <button>Submit</button>
    <br/>
    <label>Login </label>  
    <br/>  
      <form:form method = "GET" action = "redirect">
         <table>
            <tr>
               <td>
                  <input type = "submit" value = "Login"/>
               </td>
            </tr>
         </table>  
      </form:form>  
</form>