package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.GreenHouse;
import service.GreenHouseService;

/**
 * Servlet implementation class UpdateGreenHouseServlet
 */
@WebServlet("/UpdateGreenHouseServlet")
public class UpdateGreenHouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GreenHouseService greenHouseService; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateGreenHouseServlet() {
        super();
        greenHouseService =new GreenHouseService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		String temperature=request.getParameter("temperature");
		String humidity=request.getParameter("humidity");
		String illumination=request.getParameter("illumination");
		String isbreed=request.getParameter("isbreed");
		String type=request.getParameter("type");
		String area=request.getParameter("area");
		GreenHouse g=new GreenHouse();
		g.setId(Integer.parseInt(id));
		g.setTemperature(Integer.parseInt(temperature));
		g.setHumidity(Integer.parseInt(humidity));
		g.setIllumination(Integer.parseInt(illumination));
		g.setIsbreed(Boolean.parseBoolean(isbreed));
		g.setType(type);
		g.setArea(Double.parseDouble(area));
		int n=greenHouseService.UpdateGreenHouse(g);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter print=response.getWriter();	
		if(n>=1){
			print.write("删除成功！");
		}else{
			print.write("删除失败！");
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
