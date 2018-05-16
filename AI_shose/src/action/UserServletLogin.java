package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import service.UserService;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServletLogin() {
        super();
        // TODO Auto-generated constructor stub
        userService=new UserService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		System.out.println("username==="+username+"0000000000");
		String password=request.getParameter("password");
		System.out.println("password==="+password+"aaaaaaaaaa");
		String level=request.getParameter("level");
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setLevel(level);
		User result=userService.UserLogin3(user);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter print=response.getWriter();
//		print.write(result);
		if(level.contains("vip")&result.getLevel().equals(user.getLevel()))
		{
			//response.sendRedirect("WEB-INF/select.jsp");
			request.getSession().setAttribute("user", result);
		    request.getRequestDispatcher("WEB-INF/admin-index.jsp").forward(request, response);
		    Cookie cookie=new Cookie("jesession", request.getSession().getId());
		    cookie.setMaxAge(30*60);
		    cookie.setPath("/AI_shose");
		    response.addCookie(cookie);
		}
		else if (level.contains("guest ")&result.getLevel().equals(user.getLevel())) {
			request.getRequestDispatcher("WEB-INF/guest-admin.jsp").forward(request, response);}
  		else{
			print.write("登录失败");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
