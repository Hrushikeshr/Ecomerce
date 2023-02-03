package springmvc.dao;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.entity.UserData;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	

	@Transactional
	public int saveUser(UserData userData) {
	return (Integer) this.hibernateTemplate.save(userData);				
	}
	@Override
	public List<UserData> getAllUserData() {  
		return this.hibernateTemplate.loadAll(UserData.class);
	}
	@Override
	public UserData getUserDataById(int id) {
		
		return this.hibernateTemplate.get(UserData.class, id);
	}



	
	


	
	

}
