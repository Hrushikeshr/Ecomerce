package springmvc.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import springmvc.entity.Product;
import springmvc.service.ProductService;

@Controller
public class ReController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/menproduct")
	public String getMenProduct(Model model) {
		List<Product> productList = productService.getProductByCategory("men");
		System.out.println("Hello This is men url");
		model.addAttribute("getProduct",productList);
		return "shop";
		}
	
	@RequestMapping("/womenproduct")
	public String getWomenProduct(Model model) {
		List<Product> productList = productService.getProductByCategory("women");
		System.out.println("Hello This is women url");
		model.addAttribute("getProduct",productList);
		return "shop";
		}
	
	@RequestMapping("/babyproduct")
	public String getBabyProduct(Model model) {
		List<Product> productList = productService.getProductByCategory("kid");
		System.out.println("Hello This is kid url");
		model.addAttribute("getProduct",productList);
		return "shop";
		}
}
