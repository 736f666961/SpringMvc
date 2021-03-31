package ma.youcode.api.dao;

import java.util.List;

import ma.youcode.api.model.Appointment;
import ma.youcode.api.model.Dates;
import ma.youcode.api.model.User;

public interface AdminDAO {
	List<User> loadUsers();

	int acceptUser(String id);

	int rejectUser(String id);

	List<Appointment> loadAppointments();

	int acceptAppointment(Integer id, int dateId);

	int rejectAppointment(Integer id);

	int createAppointment(Dates date);
	
	int decrementSeatsNumber(int id);
	
}	
