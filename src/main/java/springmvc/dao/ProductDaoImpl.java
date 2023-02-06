package springmvc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import springmvc.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private SessionFactory sessionFactory;

	// create
	@Transactional
	@Override
	public int createProduct(Product product) {
		return (Integer) this.hibernateTemplate.save(product);
	}

	// get all products
	@Override
	public List<Product> getProducts() {
		return this.hibernateTemplate.loadAll(Product.class);
	}
	
	@Transactional
	@Override
	public void deleteProduct(int pid) {
		Product p = this.hibernateTemplate.load(Product.class, pid);
		this.hibernateTemplate.delete(p);
	}
	// get the single product
	@Override
	public Product getProductById(int pid) {
		return this.hibernateTemplate.get(Product.class, pid);
	}

	@Transactional
	@Override
	public List<Product> getProductByCategory(String category) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query<Product> query = session.createQuery("from Product where category =: category");
		query.setParameter("category", category);
		session.flush();
		return query.getResultList();
	}
	
}
