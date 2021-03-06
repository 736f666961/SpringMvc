package ma.youcode.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.youcode.api.dao.AdminDAO;
import ma.youcode.api.model.Appointment;
import ma.youcode.api.model.Dates;
import ma.youcode.api.model.User;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDAO adminDao;
	
	@Autowired
	private MailServiceImpl mailServiceImpl;
	
	@Override
	public List<User> loadUsers() {
		List<User> usersList = adminDao.loadUsers();
		return usersList;
	}

	@Override
	public void acceptUser(String id, String email) {
		int affectedRow = adminDao.acceptUser(id);
		
		if (affectedRow > 0) {
			mailServiceImpl.sendSimpleMessage(email, "Accepted", "Youcode has accepted you");
		}
	}

	@Override
	public void rejectUser(String id, String email) {
		int affectedRow = adminDao.rejectUser(id);
		
		if (affectedRow > 0) {
			mailServiceImpl.sendSimpleMessage(email, "Rejected", "Youcode has rejected you");
		}
	}

	@Override
	public List<Appointment> loadAppointments() {
		List<Appointment> appointmentsList = adminDao.loadAppointments();
		return appointmentsList;
	}

	@Override
	public void acceptAppointment(Integer id, String email, int dateId) {
		int affectedRow = adminDao.acceptAppointment(id, dateId);
		
		if (affectedRow > 0) {
			mailServiceImpl.sendSimpleMessage(email, "Accepted", "Youcode has accepted your appointment");
		}
		
	}

	@Override
	public void rejectAppointment(Integer id, String email) {
		int affectedRow = adminDao.rejectAppointment(id);
		
		if (affectedRow > 0) {
			mailServiceImpl.sendSimpleMessage(email, "Rejected", "Youcode has rejected your appointment");
		}
		
	}

	@Override
	public int createAppointment(Dates date) {
		int affectedRow = adminDao.createAppointment(date);
		return affectedRow;
	}

}
