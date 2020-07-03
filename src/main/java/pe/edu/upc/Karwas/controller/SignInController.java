package pe.edu.upc.Karwas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.Karwas.model.entity.Person;
import pe.edu.upc.Karwas.model.entity.User;
import pe.edu.upc.Karwas.service.PersonService;
import pe.edu.upc.Karwas.service.UserService;

@Controller
@RequestMapping("karwas/signin")
@SessionAttributes("user")
public class SignInController {

	@Autowired
	private UserService userService;

	@Autowired
	private PersonService personService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	private String password;

	@GetMapping("/driver")
	public String signInDriver(Model model) {
		User user = new User();
		Person person = new Person();
		user.addRoles("ROLE_DRIVER");
		user.setEnable(true);
		model.addAttribute("user", user);
		model.addAttribute("person", person);
		return "/user/signin";
	}

	@GetMapping("/manager")
	public String signInManager(Model model) {
		User user = new User();
		Person person = new Person();
		user.addRoles("ROLE_MANAGER");
		user.setEnable(true);
		model.addAttribute("user", user);
		model.addAttribute("person", person);
		return "/user/signin";
	}

	@PostMapping("/save")
	public String saveManager(@ModelAttribute("user") User user, @ModelAttribute("person") Person person, Model model,
			SessionStatus status) {
		try {
			this.password = user.getPassword();
			user.setPassword(passwordEncoder.encode(this.password));
			userService.create(user);
			personService.create(person);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/karwas/login";
	}

	@GetMapping("/edit/{id}")
	public String editUser(@PathVariable("id") Long id, Model model) {
		try {
			Optional<User> optional = userService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("user", optional.get());
				List<Person> persons = personService.readAll();
				model.addAttribute("persons", persons);
			} else {
				return "redirect:/karwas";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/user/edit";
	}

	/**
	 * @GetMapping("/del/{id}") public String delUser(@PathVariable("id") Long id,
	 * Model model) { try { Optional<User> optional = userService.findById(id); if
	 * (optional.isPresent()) { userService.deleteById(id); } else { return
	 * "redirect:/karwas/user/start"; } } catch (Exception e) { e.printStackTrace();
	 * }
	 * 
	 * return "redirect:/karwas/user/start"; }
	 */
}
