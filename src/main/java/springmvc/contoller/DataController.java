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
import springmvc.entity.OrderProduct;
import springmvc.entity.Product;
import springmvc.service.CartService;
import springmvc.service.OrderService;
import springmvc.service.ProductService;

@Controller
@RequestMapping
public class DataController {

	@Autowired
	private CartService cartService;

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

	@RequestMapping("/cart")
	public String cart(HttpSession sessions, Model model) {
		System.out.println("Hello This is cart url");
		// Getting the session value
		String myName = (String) sessions.getAttribute("username");
		if (myName != null) {
			int myId = (Integer) sessions.getAttribute("userId");
			List<CartProduct> list = cartService.getCartsByUserId(myId);
			Iterator<CartProduct> itr = list.iterator();
			ArrayList<Product> pList = new ArrayList<Product>();
			while (itr.hasNext()) {
				CartProduct cp = itr.next();
				int productId = cp.getProductId();
				Product product = productService.getProductById(productId);
				pList.add(product);
			}

			// calculating price * quantity
			Iterator<Product> pitr = pList.iterator();
			Iterator<CartProduct> citr = list.iterator();
			ArrayList<Long> priceList = new ArrayList<Long>();
			while (citr.hasNext() && pitr.hasNext()) {
				CartProduct cp = citr.next();
				Product p = pitr.next();
				priceList.add(cp.getQuantity() * p.getPrice());
			}
			model.addAttribute("priceList", priceList);

			// Calculating total price
			double totalPrice = 0.0;
			Iterator<Long> litr = priceList.iterator();
			while (litr.hasNext()) {
				totalPrice += litr.next();
			}

			// passing model attribute
			
			model.addAttribute("subTotal", totalPrice);
			model.addAttribute("getCart", pList);
			model.addAttribute("getQuantity", list);
			return "cart";
		}
		return "login";
	}

	@RequestMapping("/cart/{id}")
	public String myCart(@PathVariable int id, HttpSession sessions) {
		System.out.println("Hello This is cart url" + id);

		// List for iterating cart product
		List<CartProduct> myCartList = cartService.getCartProducts();
		for (CartProduct cartProduct2 : myCartList) {
			if (cartProduct2.getProductId() == id) {
				int quantity = cartProduct2.getQuantity() + 1;
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

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		CartProduct cartProduct = cartService.getCartProductById(id);
		System.out.println(cartProduct);
		cartService.delete(cartProduct);
		return "redirect:/cart";
	}

	@RequestMapping("/checkout")
	public String checkout(HttpSession sessions) {
		System.out.println("Hello This is checkout url");
		int myId = (Integer) sessions.getAttribute("userId");
		List<CartProduct> cartList = cartService.getCartsByUserId(myId);
		Iterator<CartProduct> itr = cartList.iterator();
		OrderProduct orderProduct = new OrderProduct();
		while (itr.hasNext()) {
			CartProduct cartProduct = itr.next();
			orderProduct.setProductId(cartProduct.getProductId());
			orderProduct.setQuantity(cartProduct.getQuantity());
			orderProduct.setUserId(cartProduct.getUserId());
			orderService.createCart(orderProduct);
		}

		return "redirect:/showcheck";
	}

	@RequestMapping("/showcheck")
	public String showCheck(Model model, HttpSession sessions) {
		String myName = (String) sessions.getAttribute("username");
		if (myName != null) {
			int myId = (Integer) sessions.getAttribute("userId");
			List<OrderProduct> orderList = orderService.getCartsByUserId(myId);
			ArrayList<Product> pList = new ArrayList<Product>();
			Iterator<OrderProduct> itr = orderList.iterator();
			double total = 0.0;
			while (itr.hasNext()) {
				OrderProduct orderProduct = itr.next();
				int productId = orderProduct.getProductId();
				Product product = productService.getProductById(productId);
				pList.add(product);
				total += product.getPrice();
			}
			cartService.deleteAll(myId);
			model.addAttribute("getOrder", orderList);
			model.addAttribute("getProduct", pList);
			model.addAttribute("subTotal", total);
			
			return "checkout";
		}
		return "login";
	}
}
