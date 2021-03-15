package ma.youcode.api.service;

import java.util.List;

import ma.youcode.api.model.Appointment;
import ma.youcode.api.model.Dates;
import ma.youcode.api.model.User;

public interface AdminService {
	List<User> loadUsers();

	void acceptUser(String id, String email);

	void rejectUser(String id, String email);
	
	List<Appointment> loadAppointments();

	void acceptAppointment(Integer id, String email);

	void rejectAppointment(Integer id, String email);

	int createAppointment(Dates date);
}
