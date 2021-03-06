package ma.youcode.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "appointments")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "appointment_date")
	private String appointmentDate;

	@Column(name = "appointment_time")
	private String appointmentTime;

	@Column(name = "seats_number")
	private String seatsNumber;

	@Column(name = "date_id")
	private int dateId;

	@Column(name = "isTaken")
	private boolean isTaken;

	@Column(name = "isAccepted")
	private boolean isAccepted;

	@ManyToOne
	private User user;

	public Appointment() {
		super();
	}

	public Appointment(Integer id, String appointmentDate, String appointmentTime, String seatsNumber, boolean isTaken,
			boolean isAccepted, User user) {
		super();
		this.id = id;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.seatsNumber = seatsNumber;
		this.isTaken = isTaken;
		this.isAccepted = isAccepted;
		this.user = user;
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

	public String getSeatsNumber() {
		return seatsNumber;
	}

	public void setSeatsNumber(String seatsNumber) {
		this.seatsNumber = seatsNumber;
	}

	public boolean isTaken() {
		return isTaken;
	}

	public void setTaken(boolean isTaken) {
		this.isTaken = isTaken;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getDateId() {
		return dateId;
	}

	public void setDateId(int dateId) {
		this.dateId = dateId;
	}

	public boolean isAccepted() {
		return isAccepted;
	}

	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", appointmentDate=" + appointmentDate + ", appointmentTime=" + appointmentTime
				+ ", seatsNumber=" + seatsNumber + ", isTaken=" + isTaken + ", isAccepted=" + isAccepted + ", user="
				+ user + "]";
	}

}
