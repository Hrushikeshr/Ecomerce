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
	
	public void delete(int id) {
		this.cartDao.deleteCart(id);
	}
	
	public CartProduct getCartProductById(int id) {
		return this.cartDao.getCartById(id);
	}
	
	public void deletAll() {
		this.cartDao.deleAll();
	}
	
	
	public void updateById(int id, int quantity) {
		this.cartDao.updateById(id, quantity);
	}
}
