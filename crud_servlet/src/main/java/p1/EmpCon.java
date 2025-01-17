package p1;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*; 

public class EmpCon {

	 public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	        	Class.forName("com.mysql.jdbc.Driver");
	             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rajjdbc","root","rajbeer123"); //2 
	        }
	        catch(Exception e)
	        {System.out.println(e);}  
	        return con;  
	    }  
	 
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)   
	         throws ServletException, IOException
	    {  
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        out.print("<body background='https://images.pexels.com/photos/255379/pexels-photo-255379.jpeg?auto=compress&cs=tinysrgb&h=627&fit=crop&w=1200'>");
	    }
	    public static int save(Emp e){  
	        int status=0;  
	        try{  
	            Connection con=EmpCon.getConnection();  
	            PreparedStatement ps=con.prepareStatement( "insert into user(id,name,password,email,country) values (?,?,?,?,?)");  
	            ps.setInt(1,e.getId());  
	            ps.setString(2,e.getName());  
	            ps.setString(3,e.getPassword());  
	            ps.setString(4,e.getEmail());  
	            ps.setString(5,e.getCountry());  
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status; //1  
	    }  
	    public static int update(Emp e){  
	        int status=0;  
	        try{  
	           
	        	Connection con=EmpCon.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "update user set name=?,password=?,email=?,country=? where id=?");  
	            ps.setString(1,e.getName());  
	            ps.setString(2,e.getPassword());  
	            ps.setString(3,e.getEmail());  
	            ps.setString(4,e.getCountry());  
	            ps.setInt(5,e.getId());  
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static int delete(int id){ //2 
	        int status=0;  
	        try{  
	            Connection con=EmpCon.getConnection();  
	            PreparedStatement ps=con.prepareStatement("delete from user where id=?");  
	            ps.setInt(1,id);  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static Emp getEmployeeById(int id){   //2
	        Emp e=new Emp();  
	          
	        try{  
	            Connection con=EmpCon.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from user where id=?");  
	            ps.setInt(1,id);  
	            ResultSet rs=ps.executeQuery();  
	          
	            if(rs.next())
	            {  
	                e.setId(rs.getInt(1));  
	                e.setName(rs.getString(2));  
	                e.setPassword(rs.getString(3));  
	                e.setEmail(rs.getString(4));  
	                e.setCountry(rs.getString(5));  
	            }  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return e;  
	    }  
	    public static List<Emp> getAllEmployees()
	    {  
	        List<Emp> list=new ArrayList<Emp>();  
	          
	        try{  
	            Connection con=EmpCon.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from user");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next())
	            {  
	                Emp e=new Emp();  
	                e.setId(rs.getInt(1));   //2
	                e.setName(rs.getString(2));  //pooja
	                e.setPassword(rs.getString(3));  
	                e.setEmail(rs.getString(4));  
	                e.setCountry(rs.getString(5));  
	                list.add(e);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }  
}
