package ma.youcode.api.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.ModelAttribute;

import ma.youcode.api.model.Appointment;
import ma.youcode.api.model.User;

public class AppointmentRowMapper implements RowMapper<Appointment> {
	

	@Override
	public Appointment mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setFirstName(rs.getString("first_name"));
		user.setLastName(rs.getString("last_name"));
		user.setEmail(rs.getString("email"));
		
		Appointment appointment = new Appointment(
				rs.getInt("id"), rs.getString("appointment_date"),
				rs.getString("appointment_time"), 
				rs.getString("seats_number"), rs.getBoolean("isTaken"),
				rs.getBoolean("isAccepted"), user);
		
		System.out.println(appointment.getUser());
		return appointment;
	}

}