package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import service.UserService;

/**
 * Servlet implementation class SelectAllUser
 */
@WebServlet("/SelectAllUser")
public class SelectAllUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService uService;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAllUser() {
        super();
        uService=new UserService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		User user=new User();
		List<User> result=new ArrayList<>();
		result=uService.SelectAllUserService();
		System.out.println("11111"+result);
		request.getSession().setAttribute("results", result);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/admin-alluser.jsp");
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
