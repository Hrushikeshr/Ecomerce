package springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.dao.CartDao;
import springmvc.entity.CartProduct;

@Service
public class CartService {
	
	@Autowired
	private CartDao cartDao;
	
	public int createCart(CartProduct cartProduct) {
		return this.cartDao.createCart(cartProduct);
	}
	
	public List<CartProduct> getCartProducts() {
		return this.cartDao.getCarts();
	}
	
	public void delete(CartProduct cartProduct) {
		this.cartDao.deleteCart(cartProduct);
	}
	
	public CartProduct getCartProductById(int id) {
		return this.cartDao.getCartById(id);
	}

	public void updateById(int id, int quantity) {
		this.cartDao.updateById(id, quantity);
	}
	
	public List<CartProduct> getCartsByUserId(int userId){
		return this.cartDao.getCartsByUserId(userId);
	}
	public void deleteAll(int userId) {
		this.cartDao.deleteAll(userId);
	}
}
