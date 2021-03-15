package ma.youcode.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dates {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "appointment_date")
	private String appointmentDate;

	@Column(name = "appointment_time")
	private String appointmentTime;

	@Column(name = "seats_number")
	private Integer seatsNumber;

	public Dates(Integer id, String appointmentDate, String appointmentTime, Integer seatsNumber) {
		super();
		this.id = id;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.seatsNumber = seatsNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public Integer getSeatsNumber() {
		return seatsNumber;
	}

	public void setSeatsNumber(Integer seatsNumber) {
		this.seatsNumber = seatsNumber;
	}

	@Override
	public String toString() {
		return "Dates [id=" + id + ", appointmentDate=" + appointmentDate + ", appointmentTime=" + appointmentTime
				+ ", seatsNumber=" + seatsNumber + "]";
	}

}
