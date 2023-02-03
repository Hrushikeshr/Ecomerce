package springmvc.dao;

import java.util.List;

import springmvc.entity.CartProduct;

public interface CartDao {
	public int createCart(CartProduct cartProduct);
	public List<CartProduct> getCarts();
	public void deleteCart(int id);
	public CartProduct getCartById(int id);
	public void deleAll();
	public void updateById(int id, int quantity);
		
	
}
