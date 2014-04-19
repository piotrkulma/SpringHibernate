package peter.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import peter.model.User;

public class UserDao implements IUserDao {
	@Autowired
	public SessionFactory sessionFactory;
	
	public UserDao() {
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> getAllUsers() {
		Query query = getCurrentSession().createQuery("FROM " + User.class.getName());
		List<User> users = query.list();
		return users;
	}
	
	@Transactional
	public void addUser(User user) {
		getCurrentSession().save(user);
	}

	@Override
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
