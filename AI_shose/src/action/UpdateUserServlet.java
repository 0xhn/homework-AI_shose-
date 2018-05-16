package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import service.UserService;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private UserService userService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        userService=new UserService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
	  String id=request.getParameter("id");
	  String username=request.getParameter("username");
	  String password=request.getParameter("password");
	  
	  User user=new User();
	  user.setId(Integer.parseInt(id));
	  user.setUsername(username);
	  user.setPassword(password);
	  int result=userService.UpdateUser(user);
	  response.setContentType("text/html;charset=UTF-8");
	  PrintWriter printWriter=response.getWriter();
	  if (result>=1) {
		request.setAttribute("user", user);
		request.getRequestDispatcher("WEB-INF/index-user.jsp").forward(request, response);
	}
	  else {
		printWriter.write("修改失败");
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
