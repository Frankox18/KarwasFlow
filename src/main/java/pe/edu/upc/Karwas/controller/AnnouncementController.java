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

import pe.edu.upc.Karwas.model.entity.Announcement;
import pe.edu.upc.Karwas.model.entity.BranchOffice;
import pe.edu.upc.Karwas.service.AnnouncementService;
import pe.edu.upc.Karwas.service.BranchOfficeService;

@Controller
@RequestMapping("karwas/announcement")
@SessionAttributes("announcement")
public class AnnouncementController {
	
	@Autowired
	private AnnouncementService announcementService;
	
	@Autowired
	private BranchOfficeService branchOfficeService;
	
	@GetMapping
	public String listAll(Model model) {
		try {
			List<Announcement> announcements = announcementService.readAll();
			model.addAttribute("announcements", announcements);
		} catch (Exception e) {
		}
		return "/announcement/start";
	}

	@GetMapping("/new")
	public String newAnnouncement(Model model) {
		Announcement announcement = new Announcement();
		model.addAttribute("announcement", announcement);
		
		try {
			List<BranchOffice> branchOffices = branchOfficeService.readAll();
			model.addAttribute("branchOffices", branchOffices);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return "/announcement/nuevo";
	}
	
	@PostMapping("/save")
	public String saveAnnouncement(@ModelAttribute("announcement") Announcement announcement, Model model, SessionStatus status) {
		try {
			announcementService.create(announcement);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/karwas/announcement";
	}
	
	@GetMapping("/edit/{id}")
	public String editAnnouncement(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Announcement> optional = announcementService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("announcement", optional.get());	
				List<BranchOffice> branchOffices = branchOfficeService.readAll();
				model.addAttribute("branchOffices", branchOffices);
			} else {
				return "redirect:/karwas/announcement";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/announcement/edit";
	}
	
	@GetMapping("/del/{id}")
	public String delAnnouncement(@PathVariable("id") Integer id,  Model model) {
		try {
			Optional<Announcement> optional = announcementService.findById(id);
			if (optional.isPresent()) {
				announcementService.deleteById(id);
			} else {
				return "redirect:/karwas/announcement";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/karwas/announcement";
	}	
}
