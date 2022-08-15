<%@ page import="java.sql.*"%>

<%

	String s=request.getParameter("val"); // http://ip:port/RestWeb/index.jsp?val1=100&val2=jack&val3=9000

	if(s==null || s.trim().equals(""))
	{
		out.print("Please enter id");
	}
	else
	{
		String id=s;
		//out.print(id);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			//Class.forName("org.hsqldb.jdbc.JDBCDriver");
			System.out.println("Driver loaded...");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","root");
			//Connection con=DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb","SA","");
			System.out.println("Connected...");
			
			PreparedStatement ps=con.prepareStatement("select * from citystate where state=?");
			//PreparedStatement ps=con.prepareStatement("select * from employee where EMPNO=?");
			ps.setString(1,id);
			ResultSet rs=ps.executeQuery();
			System.out.println("Query fired..got the result.....");
		    
			int count=0;
			out.print("<select>");
			while(rs.next())
			{   
				
				out.print("<option>"+rs.getString(3)+"</option>");
				//out.print(rs.getInt(1)+" "+rs.getString(2)+ " "+rs.getString(3));
			}
			out.print("</select");
			System.out.println("ResultSet is sent....");
			
			con.close();
			System.out.println("Connection closed.......");
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
%>