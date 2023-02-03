package springmvc.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.entity.CartProduct;

@Repository
public class CartDaoImpl implements CartDao{

	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
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
	public void deleteCart(int id) {
		this.hibernateTemplate.delete(id);
	}

	@Override
	public CartProduct getCartById(int id) {
		return this.hibernateTemplate.get(CartProduct.class, id);
	}

	@Transactional
	@Override
	public void deleAll() {
		this.hibernateTemplate.delete(CartProduct.class);
		
	}

	@Transactional
	@Override
	public void updateById(int id, int quantity) throws NullPointerException {
		CartProduct cartProduct = hibernateTemplate.get(CartProduct.class, id);
		cartProduct.setQuantity(quantity);
		this.hibernateTemplate.update(cartProduct);
		
	}

}
