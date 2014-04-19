package peter.dao;

import java.util.List;

import org.hibernate.Session;

import peter.model.User;

public interface IUserDao {	
	public List<User> getAllUsers();
	public void addUser(User user);
	
	public Session getCurrentSession();
}
