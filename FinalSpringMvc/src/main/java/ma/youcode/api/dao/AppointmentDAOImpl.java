package ma.youcode.api.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ma.youcode.api.model.Dates;

@Repository
public class AppointmentDAOImpl implements AppointmentDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session session = null;

	@Override
	public List<Dates> getAllDates() {

		session = sessionFactory.openSession();

		session.beginTransaction();

		String hql = "From Dates";

		List<Dates> datesList = session.createQuery(hql).getResultList();

		session.close();

		return datesList;
	}

}
