package springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.entity.OrderProduct;

@Repository
@Transactional
public class OrderDaoImpl implements OrderDao{
	

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int createCart(OrderProduct orderProduct) {
		return (Integer)this.hibernateTemplate.save(orderProduct);
	}
	
	@Transactional
	@Override
	public List<OrderProduct> getCartsByUserId(int userId) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query<OrderProduct> query = session.createQuery("from OrderProduct where userId ="+ userId);
		session.flush();
		return query.getResultList();
	}

}
