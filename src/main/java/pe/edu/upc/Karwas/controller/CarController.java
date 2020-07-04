package pe.edu.upc.Karwas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
 
import pe.edu.upc.Karwas.model.entity.Car;
import pe.edu.upc.Karwas.model.entity.User;
import pe.edu.upc.Karwas.service.CarService;
import pe.edu.upc.Karwas.service.UserService;

@Controller
@RequestMapping("karwas/car")
@SessionAttributes("car")
public class CarController {

	@Autowired
	private CarService carService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/mycars")
	public String listAll(Model model) {
		try {
			List<Car> cars = carService.readAll();
			model.addAttribute("cars", cars);
		} catch (Exception e) {
		}
		return "/car/start";
	}

	@GetMapping("/newcar")
	public String newCar(Model model) {
		Car car = new Car();
		model.addAttribute("car",car);
		try {
			List<User> users = userService.readAll();
			model.addAttribute("users", users);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/car/login";
	}
	
	@PostMapping("/savecar")
	public String saveCar(@ModelAttribute("car") Car car, Model model, SessionStatus status) {
		try {
			carService.create(car);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/karwas/car/mycars";
	}
	
	@GetMapping("/edit/{id}")
	public String editCar(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Car> optional = carService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("car", optional.get());	
				List<User> users = userService.readAll();
				model.addAttribute("users", users);
			} else {
				return "redirect:/karwas/car/mycars";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/car/edit";
	}
	
	@GetMapping("/del/{id}")
	public String delCar(@PathVariable("id") Integer id,  Model model) {
		try {
			Optional<Car> optional = carService.findById(id);
			if (optional.isPresent()) {
				carService.deleteById(id);
			} else {
				return "redirect:/karwas/car/mycars";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/karwas/car/mycars";
	}	
	
}
