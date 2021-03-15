package ma.youcode.api.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ma.youcode.api.model.Appointment;
import ma.youcode.api.model.Dates;
import ma.youcode.api.rowmapper.AppointmentRowMapper;
import ma.youcode.api.rowmapper.DatesRowMapper;

@Repository
public class AppointmentDAOImpl implements AppointmentDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Dates> getAllDates() {
		String sql = "SELECT * FROM dates";
		List<Dates> datesList = jdbcTemplate.query(sql, new DatesRowMapper());
		return datesList;
	}

}