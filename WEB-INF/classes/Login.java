import javax.servlet.* ;
import javax.servlet.http.* ;
import java.io.* ;
import java.util.* ;
import java.sql.* ;

public class Login extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		ArrayList<String> ar = new ArrayList<String>() ;
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
		try
		{
			String name = req.getParameter("tLogUserN2");

			String s1 = req.getParameter("pass");
			String checkedName = checkinDatabase(name , s1);
			if (!checkedName.equals(null))
			{
				Cookie c = new Cookie("Name" , name  );
				c.setMaxAge(20);
				res.addCookie(c);
				res.sendRedirect("index.html");
			}
			else
			{
				out.println("Login Failed");
			}

			out.close() ;
		}
		catch (Exception ex)
		{

		}
	}

	public String checkinDatabase(String uname , String pass) throws Exception
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/library";
	    	Connection con=DriverManager.getConnection(url,"root","root");
	    	PreparedStatement ps = con.prepareStatement("Select first_name , last_name from logins where user_name = ? and password_ = ?" );
	    	ps.setString(1 , uname);
	    	ps.setString(2 , pass );
	    	ResultSet rs = ps.executeQuery() ;
	    	if (rs.next())
	    	{
	    		return (rs.getString(1) + " " + rs.getString(2));
	    	}
	    	else
	    	{
	    		return null ;
	    	}

		    
	    }
	    catch (SQLException ex)
	    {
	    	return null ;
	    }
	    catch (Exception ex)
	    {
	    	return null ;
	    }
	}
}