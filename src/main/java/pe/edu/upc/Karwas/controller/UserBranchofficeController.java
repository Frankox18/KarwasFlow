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

import pe.edu.upc.Karwas.model.entity.BranchOffice;
import pe.edu.upc.Karwas.model.entity.Company;
import pe.edu.upc.Karwas.model.entity.User;
import pe.edu.upc.Karwas.model.entity.UserBranchoffice;
import pe.edu.upc.Karwas.service.BranchOfficeService;
import pe.edu.upc.Karwas.service.CompanyService;
import pe.edu.upc.Karwas.service.UserBranchOfficeService;
import pe.edu.upc.Karwas.service.UserService;

@Controller
@RequestMapping("karwas/userbranchoffice")
@SessionAttributes("userbranchoffice")
public class UserBranchofficeController {
	
	@Autowired
	private UserBranchOfficeService userBranchOfficeService;
	
	@Autowired
	private BranchOfficeService branchOfficeService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/mycompanys")
	public String ListAll(Model model) {
		try {
			List<UserBranchoffice> user_branch = userBranchOfficeService.readAll();
			model.addAttribute("user_branch", user_branch);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/user_branchoffice/start";
	}
	
	@GetMapping("/newcompany")
	public String newCompany(Model model) {
		UserBranchoffice user_branch = new UserBranchoffice();
		BranchOffice branchoffice = new BranchOffice();
		Company company = new Company();
		user_branch.setBranchOffice(branchoffice);
		user_branch.getBranchOffice().setCompany(company);
		model.addAttribute("user_branch", user_branch);
		try {
			List<User> users = userService.readAll();
			model.addAttribute("users", users);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/user_branchoffice/new";
	}
	
	@PostMapping("/savecompany")
	public String saveCompany(@ModelAttribute("user_branch") UserBranchoffice userBranchoffice, Model model, SessionStatus status) {
		try {
			userBranchOfficeService.create(userBranchoffice);
			branchOfficeService.create(userBranchoffice.getBranchOffice());
			companyService.create(userBranchoffice.getBranchOffice().getCompany());
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/karwas/userbranchoffice/mycompanys";
	}
	
	@GetMapping("/edit/{id}")
	public String editBranchOffice(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<UserBranchoffice> optional = userBranchOfficeService.findById(id);
			if (optional.isPresent()) {				
				model.addAttribute("user_branch", optional.get());
				List<User> users = userService.readAll();
				model.addAttribute("users", users);
			} else {
				return "redirect:/karwas/userbranchoffice/mycompanys";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/user_branchoffice/edit";
	}

	@GetMapping("/del/{id}")
	public String delBranchOffice(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<UserBranchoffice> optional = userBranchOfficeService.findById(id);
			if (optional.isPresent()) {
				userBranchOfficeService.deleteById(id);
			} else {
				return "redirect:/karwas/userbranchoffice/mycompanys";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/karwas/userbranchoffice/mycompanys";
	}
	
}
