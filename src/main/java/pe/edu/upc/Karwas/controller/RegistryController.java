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
import pe.edu.upc.Karwas.model.entity.Payment;
import pe.edu.upc.Karwas.model.entity.Registry;
import pe.edu.upc.Karwas.model.entity.Washed;
import pe.edu.upc.Karwas.service.CarService;
import pe.edu.upc.Karwas.service.PaymentService;
import pe.edu.upc.Karwas.service.RegistryService;
import pe.edu.upc.Karwas.service.WashedService;

@Controller
@RequestMapping("karwas/registry")
@SessionAttributes("registry")
public class RegistryController {
	
	@Autowired
	private RegistryService registryService;
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private WashedService washedService;
	
	@Autowired
	private PaymentService peymentService;
	
	
	@GetMapping("/myregister")
	public String listAll(Model model) {
		try {
			List<Registry> registers = registryService.readAll();
			model.addAttribute("registers", registers);
		} catch (Exception e) {
		}
		return "/registry/start";
	}

	@GetMapping("/newregister")
	public String newRegister(Model model) {
		Registry registry = new Registry();
		Payment payment = new Payment();
		registry.setPayment(payment);
		model.addAttribute("registry",registry);
		try {
			List<Car> cars = carService.readAll();
			model.addAttribute("cars", cars);
			List<Washed> washeds = washedService.readAll();
			model.addAttribute("washeds", washeds);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/registry/nuevo";
	}
	
	@PostMapping("/saveregister")
	public String saveRegistry(@ModelAttribute("registry") Registry registry, Model model, SessionStatus status) {
		try {
			registryService.create(registry);
			peymentService.create(registry.getPayment());
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/karwas/registry/myregister";
	}
	
	@GetMapping("/edit/{id}")
	public String editResgistry(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Registry> optional = registryService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("registry", optional.get());	
				List<Car> cars = carService.readAll();
				model.addAttribute("cars", cars);
				List<Washed> washeds = washedService.readAll();
				model.addAttribute("washeds", washeds);
			} else {
				return "redirect:/karwas/car/mycars";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/registry/edit";
	}
	
	@GetMapping("/del/{id}")
	public String delRegistry(@PathVariable("id") Integer id,  Model model) {
		try {
			Optional<Registry> optional = registryService.findById(id);
			if (optional.isPresent()) {
				registryService.deleteById(id);
			} else {
				return "redirect:/karwas/registry/myregister";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/karwas/registry/myregister";
	}	

	
}
