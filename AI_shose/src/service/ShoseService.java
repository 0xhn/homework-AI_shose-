package service;

import bean.ShoseBean;
import dao.ShoseDao;

public class ShoseService {
	ShoseDao sDao;
		public ShoseService() {
			super();
			sDao=new ShoseDao();
			// TODO Auto-generated constructor stub
		}
		
		//通过id查询数据
		public int ShoseServiceById(ShoseBean sBean) {
			  return sDao.ShoseDaoById(sBean);
		}
	
}
