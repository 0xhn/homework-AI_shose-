package service;

import bean.GreenHouse;
import dao.GreenhouseDao;

public class GreenHouseService {
	private GreenhouseDao greenhouseDao;
	
	public GreenHouseService() {
		super();
		// TODO Auto-generated constructor stub
		greenhouseDao=new GreenhouseDao();
	}

	public GreenHouse selectGreenhouseById(GreenHouse g){
		return greenhouseDao.selectGreenhouseById(g);
	}

	public int UpdateGreenHouse(GreenHouse g) {
		// TODO Auto-generated method stub
		return greenhouseDao.UpdateGreenHouse(g);
	}
}
