package peter.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import peter.model.User;

@Repository
public class UserDao extends AbstractDao<User> implements IUserDao {	
	public UserDao() {}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> getAllUsers() {
		Query query = createQuery("FROM " + User.class.getName());
		List<User> users = query.list();
		return users;
	}
	
	@Transactional
	public void addUser(User user) {
		//tutaj dzieje sie zajebiste przetwarzanie usera
		saveEntity(user);
	}
	
	@Transactional
	public void deleteUser(User user) {
		//tutaj dzieje sie zajebiste przetwarzanie usera
		deleteEntity(user);
	}
}
