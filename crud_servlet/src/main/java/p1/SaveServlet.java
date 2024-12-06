package p1;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException
    {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.print("<body background='https://images.pexels.com/photos/255379/pexels-photo-255379.jpeg?auto=compress&cs=tinysrgb&h=627&fit=crop&w=1200'>");
        int id=Integer.parseInt(request.getParameter("id")); //9
        String name=request.getParameter("name");  //rahul
        String password=request.getParameter("password");   //
        String email=request.getParameter("email");  //
        String country=request.getParameter("country");  
          
        Emp e=new Emp(); //e=> 9,rahul......
        e.setId(id);//
        e.setName(name);  
        e.setPassword(password);  
        e.setEmail(email);  
        e.setCountry(country);  
         
        if(name==null || password==null || email==null)
        {
        	out.print("enter all data");
        	request.getRequestDispatcher("index2.html").include(request, response); 
        }
        
        int status=EmpCon.save(e);  
        if(status>0)
        {  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("index2.html").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
        
        
          
        out.close();  
    }  
}