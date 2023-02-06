package springmvc.dao;

import java.util.List;


import springmvc.entity.OrderProduct;

public interface OrderDao {
	public int createCart(OrderProduct orderProduct);
	public List<OrderProduct> getCartsByUserId(int userId);
}
