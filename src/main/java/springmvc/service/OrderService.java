package springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.dao.OrderDao;
import springmvc.entity.OrderProduct;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;
	
	public int createCart(OrderProduct orderProduct) {
		return this.orderDao.createCart(orderProduct);
	}
	
	public List<OrderProduct> getCartsByUserId(int userId){
		return this.orderDao.getCartsByUserId(userId);
	}
}
