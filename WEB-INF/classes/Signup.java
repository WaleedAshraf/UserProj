import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.* ;
import java.util.* ;

public class Signup extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		ArrayList <String> arr = new ArrayList<String>();
		Cookie [] cArr = req.getCookies() ;
		if (cArr != null)
		{
			for (int i = 0 ; i < cArr.length ;i++)
			{
				if (cArr[i].getName().equals("Name"))
				{
					if (cArr[i].getValue().equals("Logout"))
					{
						cArr[i].setMaxAge(0);
					}
					else
					{
						res.sendRedirect("index.html");
					}
					break ;
				}
			}
		}
		
		PrintWriter out = res.getWriter();

		arr.add(req.getParameter("tfn_UserName")) ;
		arr.add(req.getParameter("tffn_Name")) ;
		arr.add(req.getParameter("tfLn_Name")) ;
		arr.add(req.getParameter("passwordd")) ;
		arr.add(req.getParameter("emaill")) ;
		arr.add(req.getParameter("phone")) ;
		arr.add(req.getParameter("dob")) ;
		arr.add(req.getParameter("ooptions")) ;
		arr.add(req.getParameter("Addresss")) ;
		arr.add(req.getParameter("Gender")) ;
		

		out.println(req.getParameter("ooptions"));
		out.println(req.getParameter("dob"));
		out.println(req.getParameter("Gender"));





		try
		{
			int i = saveToDatabase(arr) ;

			if( i == 0 )
			{
				out.println("Record not inserted due to " + arr.get(arr.size()-1));
			}
			else if( i == 1)
			{
				Cookie c = new Cookie("Name" , arr.get(0) );
				res.addCookie(c);
				res.sendRedirect("index.html");
			}
			else if( i == 2)
			{

				out.println("Record is not entered due to " + arr.get(arr.size()-1));
			}
		}
		catch (Exception ex)
		{
			out.close() ;
		}

		out.close() ;
	}

	public int saveToDatabase(ArrayList<String> ar) throws Exception
	{
		Connection con = null ;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/library";
	    	con=DriverManager.getConnection(url , "root","root");
	    	PreparedStatement ps = con.prepareStatement("insert into logins  values (? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )" );
	    	String idd = "max(login_id)+1";
	    	ps.setString(1 , idd) ;
	    	ps.setString(2 , ar.get(0).toLowerCase());
	    	ps.setString(3 , ar.get(1).toLowerCase());
	    	ps.setString(4 , ar.get(2).toLowerCase());
	    	ps.setString(5 , ar.get(3).toLowerCase());
	    	ps.setString(6 , ar.get(4).toLowerCase());
	    	ps.setString(7 , ar.get(5).toLowerCase());
	    	String date1 = ar.get(6) ; 
	    	ps.setDate(8 , java.sql.Date.valueOf(date1)) ;
	    	ps.setString(9 , ar.get(7).toLowerCase());
	    	ps.setString(10 , ar.get(8).toLowerCase());
	    	ps.setString(11 , ar.get(9).toLowerCase());
	    	ps.setString(12 , "not active");
	    	int result1 = ps.executeUpdate();
	    	con.close() ;
			return result1 ;
	    }
	    catch (SQLException ex)
	    {
	    	con.close() ;
	    	ar.add(ex.getMessage());
	    	return 2 ;
	    }
	    catch (Exception ex)
	    {
	    	con.close() ;
	    	ar.add(ex.getMessage());
	    	return 0 ;
	    }
	}
}