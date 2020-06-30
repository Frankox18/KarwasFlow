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

import pe.edu.upc.Karwas.model.entity.TypeWashed;
import pe.edu.upc.Karwas.service.TypeWashedService;

@Controller
@RequestMapping("karwas/typewashed")
@SessionAttributes("typewashed")
public class TypeWashedController {
	
	@Autowired
	private TypeWashedService typewashedService;
	

	@GetMapping("/start")
	public String listAll(Model model) {
		try {
			List<TypeWashed> typewasheds = typewashedService.readAll();
			model.addAttribute("typewasheds", typewasheds);
		} catch (Exception e) {
		}
		return "/typewashed/start";
	}

	@GetMapping("/new")
	public String newTypewashed(Model model) {
		TypeWashed typewashed = new TypeWashed();
		model.addAttribute("typewashed", typewashed);
		
		try {
			List<TypeWashed> typewasheds = typewashedService.readAll();
			model.addAttribute("typewasheds", typewasheds);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return "/typewashed/nuevo";
	}
	
	@PostMapping("/save")
	public String saveTypewashed(@ModelAttribute("typewashed") TypeWashed typewashed, Model model, SessionStatus status) {
		try {
			typewashedService.create(typewashed);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/karwas/typewashed/start";
	}
	
	@GetMapping("/edit/{id}")
	public String editTypewashed(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<TypeWashed> optional = typewashedService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("typewashed", optional.get());	
				List<TypeWashed> typewasheds = typewashedService.readAll();
				model.addAttribute("typewasheds", typewasheds);
			} else {
				return "redirect:/karwas/typewashed/start";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/typewashed/edit";
	}
	
	@GetMapping("/del/{id}")
	public String delTypewashed(@PathVariable("id") Integer id,  Model model) {
		try {
			Optional<TypeWashed> optional = typewashedService.findById(id);
			if (optional.isPresent()) {
				typewashedService.deleteById(id);
			} else {
				return "redirect:/karwas/typewashed/start";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/karwas/typewashed/start";
	}	
}
