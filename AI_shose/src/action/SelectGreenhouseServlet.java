package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.GreenHouse;
import service.GreenHouseService;

/**
 * Servlet implementation class SelectGreenhouseServlet
 */
@WebServlet("/SelectGreenhouseServlet")
public class SelectGreenhouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private GreenHouseService greenHouseService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectGreenhouseServlet() {
        super();
        // TODO Auto-generated constructor stub
        greenHouseService=new GreenHouseService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String search=request.getParameter("search");
		String chock=request.getParameter("chock");
		String value =request.getParameter("value");
		GreenHouse g=new GreenHouse();
	    GreenHouse greenhouse= null;
		if(search.contains("id")&chock.contains("2")){
			g.setId(Integer.parseInt(value));
			greenhouse=greenHouseService.selectGreenhouseById(g);
		}
		
//		g.setId(Integer.parseInt(id));
//		GreenHouse greenhouse=greenHouseService.selectGreenhouseById(g);
		request.setAttribute("greenhouse", greenhouse);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/GreenHouseList2.jsp");
		dispatcher.forward(request, response);

		System.out.println(greenhouse);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
