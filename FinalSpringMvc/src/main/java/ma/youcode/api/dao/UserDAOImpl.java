package ma.youcode.api.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ma.youcode.api.model.Appointment;
import ma.youcode.api.model.Dates;
import ma.youcode.api.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session session = null;

	@Override
	public int saveUser(User user) {
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String email = user.getEmail();
		String password = user.getPassword();

		User u = new User(firstName, lastName, email, password);

		session = sessionFactory.openSession();
		session.beginTransaction();

		int affectedRows = (int) session.save(u);

		session.getTransaction().commit();

		return affectedRows;

	}

	@Override
	public User login(String email, String password) {
		System.out.println("Login Called");
		session = sessionFactory.openSession();

		session.beginTransaction();

		String hql = "From User WHERE email = :email AND password = :password";

		User user = (User) session.createQuery(hql).setParameter("email", email).setParameter("password", password)
				.uniqueResult();

		if (user != null) {
			System.out.println("UserDaoImpl not null");
			return user;
		} else {
			System.out.println("UserDaoImpl null");
			return null;
		}

	}

	@Override
	public int makeAppointment(String appointmentDate, String appointmentTime, String seatsNumber, int id, int dateId) {

		User u = new User();
		u.setId(id);

		Appointment a = new Appointment();
		a.setAppointmentDate(appointmentDate);
		a.setAppointmentTime(appointmentTime);
		a.setSeatsNumber(seatsNumber);
		a.setDateId(dateId);
		a.setUser(u);
		a.setTaken(true);

		session = sessionFactory.openSession();
		session.beginTransaction();

		int affectedRows = (int) session.save(a);

		session.getTransaction().commit();

		return affectedRows;
	}

}
