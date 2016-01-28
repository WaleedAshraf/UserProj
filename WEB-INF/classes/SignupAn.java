import javax.servlet.* ;
import javax.servlet.http.* ;
import java.io.* ;
import java.util.* ;
import java.sql.* ;

public class SignupAn extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		Cookie [] cArr = req.getCookies() ;
		boolean flag = false ;
		if (cArr != null)
		{
			for (int i = 0 ; i < cArr.length ;i++)
			{
				Cookie c0 = cArr[i];
				if (c0.getName().equals("Name") && !c0.getValue().equals("Logout"))
				{
					res.sendRedirect("index.html");
					flag = true ;
				}
			}
		}
		if (flag == false)
			res.sendRedirect("Signup.html");
	}
}