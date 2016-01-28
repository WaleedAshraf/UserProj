import javax.servlet.* ;
import javax.servlet.http.* ;
import java.io.* ;
import java.util.* ;
import java.sql.* ;

public class LogoutAn extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		boolean flag = false ;
		Cookie [] cArr = req.getCookies() ;
		if (cArr != null)
		{
			for (int i = 0 ; i < cArr.length ;i++)
			{
				Cookie c0 = cArr[i];
				System.out.print(c0.getValue());
				if (c0.getName().equals("Name") && !c0.getValue().equals("Logout"))
				{
					System.out.println(" True");
					c0.setMaxAge(0);
					Cookie c = new Cookie("Name" , "Logout");
					res.addCookie(c);
					flag = true ;
					res.sendRedirect("index.html");
				}
			}
		}
		if (flag == false)
			res.sendRedirect("LoginMessage.html");
	}
}