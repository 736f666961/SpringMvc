package ma.youcode.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.youcode.api.dao.UserDAO;
import ma.youcode.api.model.Appointment;
import ma.youcode.api.model.Dates;
import ma.youcode.api.model.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public int saveUser(User user) {
		if (this.validateSignup(user)) {
			int affectedRow = userDAO.saveUser(user);
			return affectedRow;
		} else {
			return 0;
		}
	}

	@Override
	public User login(String email, String password) {
		if (validateLogin(email, password)) {
//			System.out.println("UserServiceImpl not null");
			return userDAO.login(email, password);
		} else {
			System.out.println("UserServiceImpl null");
			return null;
		}
	}

	@Override
	public int makeAppointment(Dates date, int id, int dateId) {
		String appointmentDate;
		String appointmentTime;
		String seatsNumber;
		
		try {
			if (this.validateAppointment(date)) {
				String str = date.getAppointmentDate() ;
				String[] arrOfStr = str.split(",");
				appointmentDate = arrOfStr[0];
				appointmentTime = date.getAppointmentTime();
				seatsNumber = date.getSeatsNumber().toString();
				
				int affectedRow = userDAO.makeAppointment(appointmentDate, appointmentTime, seatsNumber, id, dateId);
				return affectedRow;
			} else {
				return 0;
			}
		}catch(NullPointerException nl) {
			return 0;
		}

	}

	@Override
	public boolean validateSignup(User user) {
		if (!(user.getFirstName().isBlank() && user.getLastName().isBlank() && user.getEmail().isBlank()
				&& user.getPassword().isBlank())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean validateAppointment(Dates date) {
		if (date.getAppointmentDate() != null && date.getAppointmentTime() != null && date.getSeatsNumber() != null) {
			if (!(date.getAppointmentDate().isBlank() && date.getAppointmentTime().isBlank()
					&& date.getSeatsNumber() != 0)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public boolean validateLogin(String email, String password) {
		if (email != null && password != null && !(email.isBlank() && password.isBlank())) 
			return true;
		return false;
	}

}
