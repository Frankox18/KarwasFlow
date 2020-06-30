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

import pe.edu.upc.Karwas.model.entity.Washed;
import pe.edu.upc.Karwas.model.entity.Announcement;
import pe.edu.upc.Karwas.model.entity.TypeWashed;
import pe.edu.upc.Karwas.service.WashedService;
import pe.edu.upc.Karwas.service.AnnouncementService;
import pe.edu.upc.Karwas.service.TypeWashedService;

@Controller
@RequestMapping("karwas/washed")
@SessionAttributes("washed")
public class WashedController {
	
	@Autowired
	private WashedService washedService;
	
	@Autowired
	private AnnouncementService announcementService;
	
	@Autowired
	private TypeWashedService typewashedService;
	
	@GetMapping("/start")
	public String listAll(Model model) {
		try {
			List<Washed> washeds = washedService.readAll();
			model.addAttribute("washeds", washeds);
		} catch (Exception e) {
		}
		return "/washed/start";
	}

	@GetMapping("/new")
	public String newService(Model model) {
		Washed washed = new Washed();
		model.addAttribute("washed", washed);
		
		try {
			List<Announcement> announcements = announcementService.readAll();
			model.addAttribute("announcements", announcements);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			List<TypeWashed> typewasheds = typewashedService.readAll();
			model.addAttribute("typewasheds", typewasheds);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "/washed/nuevo";
	}
	
	@PostMapping("/save")
	public String saveService(@ModelAttribute("washed") Washed washed, Model model, SessionStatus status) {
		try {
			washedService.create(washed);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/karwas/washed/start";
	}
	
	@GetMapping("/edit/{id}")
	public String editService(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Washed> optional = washedService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("washed", optional.get());	
				List<Announcement> announcements = announcementService.readAll();
				model.addAttribute("announcements", announcements);					
			} else {
				return "redirect:/karwas/washed/start";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Optional<Washed> optional = washedService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("washed", optional.get());	
				List<TypeWashed> typewasheds = typewashedService.readAll();
				model.addAttribute("typewasheds", typewasheds);				
			} else {
				return "redirect:/karwas/washed/start";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/washed/edit";
	}
	
	@GetMapping("/del/{id}")
	public String delService(@PathVariable("id") Integer id,  Model model) {
		try {
			Optional<Washed> optional = washedService.findById(id);
			if (optional.isPresent()) {
				washedService.deleteById(id);
			} else {
				return "redirect:/karwas/washed/start";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/karwas/washed/start";
	}	

}
