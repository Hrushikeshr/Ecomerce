package springmvc.contoller;



import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.entity.Product;
import springmvc.entity.UserData;
import springmvc.service.CartService;
import springmvc.service.ProductService;
import springmvc.service.UserService;


@Controller
@RequestMapping
public class HomeController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private CartService cartService;
	
	
	//url controller for loading page 
	@RequestMapping("/")
	public String home() {
		System.out.println("This home url");
		return "home";
	}
	
	@RequestMapping("/home")
	public String myHome() {
		System.out.println("This home url");
		return "home";
	}
	
	@RequestMapping("/checkout")
	public String checkout() {
		System.out.println("Hello This is checkout url");
		return "checkout";
	}
	
	@RequestMapping("/help")
	public String help() {
		System.out.println("Hello This is help url");
		return "help";
	}
	
	@RequestMapping("/details/{productId}")
	public String details(@PathVariable int productId,  Model model) {
		System.out.println("Hello This is details url");
		Product product = productService.getProductById(productId);
		System.out.println(product);
		model.addAttribute("getProduct",product);
		return "details";
	}
	
	@RequestMapping("/shop")
	public String shop(Model model ) {
		List<Product> plist = productService.getAllProducts();
		System.out.println("Hello This is shop url");
		model.addAttribute("getProduct",plist);
		return "shop";
	}
	@RequestMapping("/login")
	public String login() {
		System.out.println("Hello This is login url");
		return "login";
	}
	@RequestMapping("/registration")
	public String registration() {
		System.out.println("Hello This is registration url");
		return "registration";
	}
	
	//Mapping for data transform
	
	@PostMapping(path = "/signupp")
	public String signup(@ModelAttribute UserData userData,Model m) {
		
		System.out.println(userData);
		List<UserData> userList = userService.getAllUserData();
		for (UserData user: userList) {
			if (user.getEmail().equals(userData.getEmail())) {
				m.addAttribute("faieldMsg", "You are already register!");
				return "registration";
				
			}
		}
		int i =this.userService.createUser(userData);
		System.out.println(i);
		m.addAttribute("succesmsg","User Registerd Sucessfully!");
		return "login";
		
	}
	@RequestMapping(path = "/addproduct", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute Product product) {
		
		System.out.println(product);
		int i =this.productService.createUser(product);
		System.out.println(i);
		return "addproduct";
	}
		
	//load user data
	@GetMapping("userdetails")
	public String loadEmployee(Model model) {
		model.addAttribute("user", userService.getAllUserData());
		model.addAttribute("titel","User Details");
		
		System.out.println(model.toString());
		return "userdetails";
		
	}
	
	@RequestMapping(path = "/loginuser", method = RequestMethod.POST)
	public String loginuser(@RequestParam("username") String uname, @RequestParam("password") String upassword,Model m) {
		List<UserData> list = userService.getAllUserData();
		if (uname.equals("admin@gmail.com") && upassword.equals("1234")) {
			return "addproduct";
		}
		Iterator<UserData> itr = list.iterator();
		while (itr.hasNext()) {
			UserData userData = itr.next();
			if (userData.getEmail().equals(uname) && userData.getPass().equals(upassword)) {
				HttpSession session =request.getSession();
				session.setAttribute("username", userData.getName());
				session.setAttribute("userId", userData.getId());
				System.out.println(session.getAttribute("username"));
				return"home";	
			}
		}
		m.addAttribute("succeserr","Inavalid email or pass try again");
		return "login";
	}
	
	@RequestMapping(path = "/logout")
	public String logout(HttpSession sessions) {
		sessions.invalidate();
		return "home";
	}
}
