package peter.dao;

import java.util.List;

import peter.model.User;

public interface IUserDao {	
	public List<User> getAllUsers();
	public void addUser(User user);
	public void deleteUser(User user);
}
