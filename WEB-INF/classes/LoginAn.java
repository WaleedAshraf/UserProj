import javax.servlet.* ;
import javax.servlet.http.* ;
import java.io.* ;
import java.util.* ;
import java.sql.* ;

public class LoginAn extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		ArrayList<String> ar = new ArrayList<String>() ;
		boolean flag = false ;
		Cookie [] cArr = req.getCookies() ;
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
			res.sendRedirect("Login.html");
	}
}