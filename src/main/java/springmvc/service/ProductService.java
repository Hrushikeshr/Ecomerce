package springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.dao.ProductDao;
import springmvc.entity.Product;


@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;
	public int createUser(Product product) {
		return this.productDao.createProduct(product);
	}
	
	public List<Product> getAllProducts() {
		return this.productDao.getProducts();
	}
	
	public Product getProductById(int id) {
		return this.productDao.getProductById(id);
	}
	
	public List<Product> getProductByCategory(String category){
		return this.productDao.getProductByCategory(category);
	}
}
