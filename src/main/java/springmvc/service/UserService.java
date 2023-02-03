package springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.dao.UserDao;
import springmvc.entity.UserData;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	public int createUser(UserData userData) {
		return this.userDao.saveUser(userData);
	}
	
	public List<UserData> getAllUserData(){
		return userDao.getAllUserData();
	}
	
	public UserData checkData(int id) {
		return userDao.getUserDataById(id);
	}

}
