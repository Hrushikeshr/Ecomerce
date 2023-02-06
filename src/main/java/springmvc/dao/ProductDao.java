package springmvc.dao;

import java.util.List;

import springmvc.entity.Product;

public interface ProductDao {
	public int createProduct(Product product);
	public List<Product> getProducts();
	public void deleteProduct(int pid);
	public Product getProductById(int pid);
	public List<Product> getProductByCategory(String category);
	
}
