package ma.youcode.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.youcode.api.dao.AppointmentDAO;
import ma.youcode.api.model.Appointment;
import ma.youcode.api.model.Dates;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	@Autowired
	private AppointmentDAO appointmentDao;
	
	@Override
	public List<Dates> getAllDates() {
		List<Dates> datesList = appointmentDao.getAllDates();
		
		return datesList;
	}

}
