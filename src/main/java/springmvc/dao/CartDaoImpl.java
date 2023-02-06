package springmvc.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import springmvc.entity.CartProduct;

@Repository
public class CartDaoImpl implements CartDao{

	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Transactional
	@Override
	public int createCart(CartProduct cartProduct) {
		return (Integer)this.hibernateTemplate.save(cartProduct);
	}

	@Override
	public List<CartProduct> getCarts() {
		return this.hibernateTemplate.loadAll(CartProduct.class);
	}
	
	@Transactional
	@Override
	public void deleteCart(CartProduct cartProduct) {
		this.hibernateTemplate.delete(cartProduct);
	}

	@Override
	public CartProduct getCartById(int id) {
		return this.hibernateTemplate.get(CartProduct.class, id);
	}


	@Transactional
	@Override
	public void updateById(int id, int quantity) throws NullPointerException {
		CartProduct cartProduct = hibernateTemplate.get(CartProduct.class, id);
		cartProduct.setQuantity(quantity);
		this.hibernateTemplate.update(cartProduct);
		
	}

	@Transactional
	@Override
	public List<CartProduct> getCartsByUserId(int userId) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query<CartProduct> query = session.createQuery("from CartProduct where userId ="+ userId);
		session.flush();
		return query.getResultList();
	}
	
	@Transactional
	@Override
	public void deleteAll(int userId) {
		sessionFactory.getCurrentSession().createQuery("delete from CartProduct where userId = "+userId).executeUpdate();
	}

}
