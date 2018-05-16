package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.GreenHouse;
import bean.User;
import service.GreenHouseService;
import service.UserService;

/**
 * Servlet implementation class SelectGreenHouseById
 */
@WebServlet("/SelectUserById")
public class SelectUserById extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private User user;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectUserById() {
        super();
        userService =new UserService();
        user= new User();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		User u=new User();
		u.setId(Integer.parseInt(id));
		User user=userService.UserLoginById(u);
		request.setAttribute("user", user);
		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/index-user.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
