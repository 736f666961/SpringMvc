package ma.youcode.api.dao;

import ma.youcode.api.model.Dates;
import ma.youcode.api.model.User;

public interface UserDAO {
	int saveUser(User user);

	User login(String email, String password);
	
	int makeAppointment(Dates dates, int id);
}