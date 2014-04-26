package peter.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<T> {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveEntity(T t) {
		getCurrentSession().save(t);
	}
	
	public void deleteEntity(T t) {
		getCurrentSession().delete(t);
	}
	
	public Query createQuery(String string) {
		Query query = getCurrentSession().createQuery(string);
		return query;
	}
		
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
