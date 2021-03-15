package ma.youcode.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ma.youcode.api.model.Dates;
import ma.youcode.api.model.User;
import ma.youcode.api.service.AppointmentService;
import ma.youcode.api.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private AppointmentService appointmentService;

	private String isSignedUp = null;
	private String isLoggedIn = null;
	private User currentUser = null;
	private String isAppointmentMade = null;

	@GetMapping(value = "/")
	public String home(Model model) {
		List<Dates> datesList = appointmentService.getAllDates();
		
		model.addAttribute("isSignedUp", isSignedUp);
		model.addAttribute("isLoggedIn", isLoggedIn);
		model.addAttribute("isAppointmentMade", isAppointmentMade);
		model.addAttribute("datesList", datesList);
		
		return "home";
	}

	@PostMapping(value = "/signup")
	public String signup(User user) {
		System.out.println("User: " + user);
		int affectedRow = userService.saveUser(user);

		if (affectedRow > 0) {
			isSignedUp = "true";
		} else {
			isSignedUp = "false";
		}

		return "redirect:/";
	}
	
	@PostMapping(value = "/login")
	public String login(Model model, User user, HttpSession session) {
		
		User theUser = userService.login(user.getEmail(), user.getPassword());
		
		if (theUser != null) {
			isLoggedIn = "true";
			this.currentUser = theUser;
			
			if (this.currentUser.getRole().equals("admin")) {
//				model.addAttribute("currentUser", this.currentUser);
				session.setAttribute("currentUser", this.currentUser);
				
				System.out.println("Current user is admin ");
				return "redirect:/admin";
			}
			
			
		} else {
			isLoggedIn = "false";
		}

		return "redirect:/";
	}

	@GetMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		
		isSignedUp = null;
		isLoggedIn = null;
		isAppointmentMade = null;
		currentUser = null;
		
		
		return "redirect:/";
	}
	
	@PostMapping(value = "/appointment")
	public String makeAppointment(Dates date) {
		if (currentUser != null) {
			int affectedRow = userService.makeAppointment(date, currentUser.getId());
			System.out.println("Current User: " + currentUser);
			
			if (affectedRow > 0) {
				isAppointmentMade = "true";
			} else {
				isAppointmentMade = "false";
			}
		}else {
			isAppointmentMade = "false";
		}
		return "redirect:/";
	}

}