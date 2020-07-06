<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    

    <h1 style="color:green;text-align:center">Registration contact details</h1>

     <font color="green">${Saved}</font>
    
     <form:form method="POST"
			   modelAttribute="contact">
     

      <table>
         <tr>
             <td>NAME:</td>
             <td><form:input path="contactName"/></td>
         </tr>
         
         <tr>
             <td>EMAIL:</td>
             <td><form:input path="contactEmail"/></td>
         </tr>
         
         <tr>
             <td>CONTACT_NO:</td>
             <td><form:input path="contactNum"/></td>
          </tr>
 
          <tr>
		      <td><input type="reset" value="Reset" /></td>
		      <td><input type="submit" value="Submit" /></td>
          </tr>
     </table>
     </form:form>


<a href="showAllContact">show All Contact</a>

