package ma.youcode.api.dao;

import ma.youcode.api.model.User;

public interface UserDAO {
	int saveUser(User user);

	User login(String email, String password);
	
	int makeAppointment(String appointmentDate, String appointmentTime, String seatsNumber, int id, int dateId);
}
