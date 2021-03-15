package ma.youcode.api.service;

import ma.youcode.api.model.Dates;
import ma.youcode.api.model.User;

public interface UserService {
	int saveUser(User user);

	User login(String email, String password);
	
	int makeAppointment(Dates date, int id);
	
	boolean validateSignup(User user);
	
	boolean validateAppointment(Dates date);
	
	boolean validateLogin(String email, String password);
	
}