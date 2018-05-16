package test;

import bean.User;
import dao.UserDao;
import service.UserService;

public class t1 {

	public static void main(String[] args) {
		User user =new User();
		user.setId(2);
		user.setPassword("aaaa");
		UserDao userDao=new UserDao();
		UserService userService=new UserService();
		int result=userService.UpdateUser(user);
		System.out.println(result);
	}
}
