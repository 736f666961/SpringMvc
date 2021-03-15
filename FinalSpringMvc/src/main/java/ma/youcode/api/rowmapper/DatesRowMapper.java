package ma.youcode.api.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ma.youcode.api.model.Dates;

public class DatesRowMapper implements RowMapper<Dates> {

	@Override
	public Dates mapRow(ResultSet rs, int rowNum) throws SQLException {
		Dates date = new Dates(rs.getInt("id"), rs.getString("appointment_date"), rs.getString("appointment_time"),
				rs.getInt("seats_number"));

		return date;
	}

}