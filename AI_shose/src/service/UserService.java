package service;

import java.util.List;

import bean.User;
import dao.UserDao;

public class UserService {
	private UserDao userDao;

	public UserService() {
		super();
		// TODO Auto-generated constructor stub
		userDao=new UserDao();
	}
	public String UserLogin1(User user){
		User selectUser=userDao.selectUserByName(user);
		if(selectUser==null){
			return "用户名不存在";
		}
		System.out.println("3333username==="+user.getUsername()+"888888");
		System.out.println("3333password==="+user.getPassword()+"888888");
		System.out.println("2222username==="+selectUser.getUsername()+"0000000000");
		System.out.println("2222password==="+selectUser.getPassword()+"0000000000");
		if(selectUser.getPassword().equals(user.getPassword())){
			return "登录成功";
		}
		return "密码错误";
	}
	public int UserLogin2(User user){
		User selectUser=userDao.selectUserByName(user);
		if(selectUser==null){
			return 0;
		}
		if(selectUser.getPassword()==user.getPassword()){
			return 1;
		}
		return 2;
	}
	public User UserLogin3(User user){
		User selectUser=userDao.selectUserByName(user);
		
		if(selectUser==null){
			return null;
		}
		else if(selectUser.getPassword().equals(user.getPassword())&selectUser.getLevel().contains("vip")){
			return selectUser;
		}
		if(selectUser.getPassword().equals(user.getPassword())&selectUser.getLevel().contains("guest")){
			return selectUser;
		}
		else {
			return null;
		}
	}
	public List<User> SelectAllUserService(){
		List<User> info=userDao.SelectAllUser();
		return info;
	}
	public User UserLoginById(User user){
	return  userDao.selectUserById(user);
		
	}
	public String UserRegister(User user) {
		// TODO Auto-generated method stub
		User selectUser=userDao.selectUserByName(user);
		if(selectUser==null){
			 int i=userDao.AddUser(user);
			if(i==0){
				return "注册失败";
			}else{
				return "注册成功";
			}
		}
		else{
			return "用户名已经存在！";
		}
	}
	public int UpdateUser(User user) {
		
	int	updateservice=userDao.UpdateUser(user);
		if (updateservice==0) {
			return 0;
		}
		else {
			return 1;
		}
	}
}
