package springmvc.dao;

import java.util.List;

import springmvc.entity.CartProduct;

public interface CartDao {
	public int createCart(CartProduct cartProduct);
	public List<CartProduct> getCarts();
	public List<CartProduct> getCartsByUserId(int userId);
	public void deleteCart(CartProduct cartProduct);
	public CartProduct getCartById(int id);
	public void updateById(int id, int quantity);
	public void deleteAll(int userId);
		
	
}
