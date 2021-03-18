package ma.youcode.api.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ma.youcode.api.model.Appointment;
import ma.youcode.api.model.Dates;
import ma.youcode.api.model.User;
import ma.youcode.api.service.AdminService;

@Controller
public class AdminController {
	private String isAppointmentCreated = null;

	@Autowired
	private AdminService adminService;

	@GetMapping(value = "/admin")
	public String admin(Model model, HttpSession session) {
		List<User> usersList = adminService.loadUsers();
		List<Appointment> appointmentsList = adminService.loadAppointments();

		model.addAttribute("users", usersList);
		model.addAttribute("appointmentsList", appointmentsList);
		model.addAttribute("isAppointmentCreated", isAppointmentCreated);

		User user = (User) session.getAttribute("currentUser");

		if (user != null) {

			return "admin";
		} else {
			return "redirect:/";
		}
	}

	@PostMapping(value = "/accept")
	public String accept(User user) {

		adminService.acceptUser(user.getId().toString(), user.getEmail());

		return "redirect:/admin";
	}

	@PostMapping(value = "/reject")
	public String reject(User user) {
		System.out.println("Reject User: " + user);

		adminService.rejectUser(user.getId().toString(), user.getEmail());

		return "redirect:/admin";
	}

	@PostMapping(value = "/acceptAppointment")
	public String acceptAppointment(Appointment appointment) {

		adminService.acceptAppointment(appointment.getId(), appointment.getUser().getEmail(), appointment.getDateId());

		return "redirect:/admin";
	}

	@PostMapping(value = "/rejectAppointment")
	public String rejectAppointment(Appointment appointment) {

		adminService.rejectAppointment(appointment.getId(), appointment.getUser().getEmail());

		return "redirect:/admin";
	}

	@PostMapping(value = "/createDate")
	public String createDate(Dates date) {

		int affectedRow = adminService.createAppointment(date);

		if (affectedRow > 0) {
			isAppointmentCreated = "true";
		} else {
			isAppointmentCreated = "false";
		}

		return "redirect:/admin";
	}

}
