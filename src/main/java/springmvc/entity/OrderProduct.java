package springmvc.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int productId;
	private int userId;
	private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderProduct [id=" + id + ", productId=" + productId + ", userId=" + userId + ", quantity=" + quantity
				+ "]";
	}

	public OrderProduct(int id, int productId, int userId, int quantity) {
		super();
		this.id = id;
		this.productId = productId;
		this.userId = userId;
		this.quantity = quantity;
	}

	public OrderProduct() {
		super();
		// TODO Auto-generated constructor stub
	}



	

	
}
