package springmvc.contoller;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import springmvc.entity.CartProduct;
import springmvc.entity.Product;
import springmvc.service.CartService;
import springmvc.service.ProductService;


@Controller
@RequestMapping
public class DataController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductService productService;
	

	
	
	@RequestMapping("/cart")
	public String cart(HttpSession sessions, Model model) {	
		System.out.println("Hello This is cart url");
		//Getting the session value
		String myName =(String) sessions.getAttribute("username");
		if (myName != null) {
			List<CartProduct> list = cartService.getCartProducts();
			Iterator<CartProduct> itr= list.iterator();
			ArrayList<Product> pList = new ArrayList<Product>();
			while (itr.hasNext()) {
				CartProduct cp = itr.next();
				int productId = cp.getProductId();
				Product product = productService.getProductById(productId);
				pList.add(product);
			}
			
			
			//calculating price * quantity
			Iterator<Product> pitr= pList.iterator();
			Iterator<CartProduct> citr= list.iterator();
			ArrayList<Long> priceList = new ArrayList<Long>();
			while (citr.hasNext() && pitr.hasNext()) {
				CartProduct cp = citr.next();
				Product p = pitr.next();
				priceList.add(cp.getQuantity()*p.getPrice());
			}
			model.addAttribute("priceList", priceList);
			
			//Calculating total price
			double totalPrice = 0.0;
			Iterator<Long> litr = priceList.iterator();
			while (litr.hasNext()) {
				totalPrice += litr.next();
			}
			
			
			//passing model attribute
			double shippingCharge = 10;
			double total = totalPrice+shippingCharge;
			model.addAttribute("subTotal", totalPrice);
			model.addAttribute("getCart",pList);
			model.addAttribute("getQuantity", list);
			model.addAttribute("shippingCharge", shippingCharge);
			model.addAttribute("total", total);
			return "cart";
		}
		return "login";
	}
	
	@RequestMapping("/cart/{id}")
	public String myCart(@PathVariable int id, HttpSession sessions) {			
		System.out.println("Hello This is cart url"+ id );

		//List for iterating cart product
		List<CartProduct> myCartList = cartService.getCartProducts();
		for(CartProduct cartProduct2 : myCartList) {
			if (cartProduct2.getProductId() == id) {
				int quantity = cartProduct2.getQuantity()+1;
				this.cartService.updateById(cartProduct2.getId(), quantity);
				return "redirect:/cart";
			}
		}
		CartProduct cartProduct = new CartProduct();
		cartProduct.setProductId(id);
		cartProduct.setUserId(Integer.parseInt(sessions.getAttribute("userId").toString()));
		cartProduct.setQuantity(1);
		this.cartService.createCart(cartProduct);
	
		return "redirect:/cart";
	}
}
