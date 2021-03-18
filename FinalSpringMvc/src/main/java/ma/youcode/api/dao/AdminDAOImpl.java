package ma.youcode.api.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ma.youcode.api.model.Appointment;
import ma.youcode.api.model.Dates;
import ma.youcode.api.model.User;

@Repository
public class AdminDAOImpl implements AdminDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session session = null;

	@Override
	public List<User> loadUsers() {
		session = sessionFactory.openSession();

		session.beginTransaction();

		String hql = "From User WHERE isAuthenticated = 0";

		List<User> usersList = session.createQuery(hql).getResultList();

		session.close();

		return usersList;

	}

	@Override
	public int acceptUser(String id) {
		String hqlUpdate = "UPDATE User SET isAuthenticated = 1 WHERE id = :id";

		session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery(hqlUpdate);
		query.setParameter("id", Integer.parseInt(id));

		int affectedRows = query.executeUpdate();
		session.getTransaction().commit();

		return affectedRows;

	}

	@Override
	public int rejectUser(String id) {
		String hqlDelete = "DELETE FROM User WHERE id = :id";

		session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery(hqlDelete);
		query.setParameter("id", Integer.parseInt(id));

		int affectedRows = query.executeUpdate();
		session.getTransaction().commit();

		return affectedRows;
	}

	@Override
	public List<Appointment> loadAppointments() {

		String hql = "FROM Appointment AS a WHERE a.isAccepted != 1";

		session = sessionFactory.openSession();

		session.beginTransaction();

		List<Appointment> appointments = session.createQuery(hql).getResultList();

		session.close();

		return appointments;

	}

	@Override
	public int acceptAppointment(Integer id, int dateId) {

		deleteDate(dateId);

		String updateQuery = "UPDATE Appointment SET isAccepted = 1 WHERE id = :id";
		session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery(updateQuery);
		query.setParameter("id", id);

		int affectedRows = query.executeUpdate();
		session.getTransaction().commit();

		return affectedRows;
	}

	@Override
	public int rejectAppointment(Integer id) {
		String deleteQuery = "DELETE FROM Appointment WHERE id = :id";

		session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery(deleteQuery);
		query.setParameter("id", id);

		int affectedRows = query.executeUpdate();
		session.getTransaction().commit();

		return affectedRows;
	}

	@Override
	public int createAppointment(Dates date) {
		String appointmentDate = date.getAppointmentDate();
		String appointmentTime = date.getAppointmentTime();
		int seatsNumber = date.getSeatsNumber();

		Dates d = new Dates(appointmentDate, appointmentTime, seatsNumber);

		session = sessionFactory.openSession();
		session.beginTransaction();

		int affectedRows = (int) session.save(d);

		session.getTransaction().commit();

		return affectedRows;

	}

	@Override
	public void deleteDate(int id) {
		String deleteQuery = "DELETE FROM Dates WHERE id = :id";

		session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery(deleteQuery);
		query.setParameter("id", id);
		query.executeUpdate();

		session.getTransaction().commit();

	}

}
