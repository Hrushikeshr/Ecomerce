package springmvc.dao;

import java.util.List;

import springmvc.entity.UserData;

public interface UserDao {
	public int saveUser(UserData userData);
	public List<UserData> getAllUserData();
	public UserData getUserDataById(int id);
	
}
