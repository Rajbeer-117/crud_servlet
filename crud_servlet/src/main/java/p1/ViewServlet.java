package p1;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet{

	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
  {  
      response.setContentType("text/html");  
      PrintWriter out=response.getWriter();  
      out.println("<a href='index2.html'>Add New Employee</a>");  
      out.println("<h1>Employees List</h1>");  
        
      
      out.print("<body background='https://images.pexels.com/photos/255379/pexels-photo-255379.jpeg?auto=compress&cs=tinysrgb&h=627&fit=crop&w=1200'>");
      
      
      List<Emp> list=EmpCon.getAllEmployees();  
        
      out.print("<table border='1' width='100%'");  
      out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Country</th><th>Email</th><th>Edit</th><th>Delete</th></tr>");  
      for(Emp e:list){  
       out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getPassword()+"</td><td>"+e.getEmail()+"</td><td>"+e.getCountry()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td>  <td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");  
      }  
      out.print("</table>");  
        
      out.close();  
  }  
}
