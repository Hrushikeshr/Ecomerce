package springmvc.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReController {
	
	@RequestMapping("/showcart")
	public String showCart() {
		
		
		return "cart";
		}
}
