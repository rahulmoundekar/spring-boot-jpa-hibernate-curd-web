package com.spring.boot.hibernate.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.boot.hibernate.model.User;

@Repository
@Transactional
public class UserDao {

	@Autowired
	private SessionFactory _sessionFactory;

	public void save(User user) {
		System.out.println("save dao" + user.getEmail() + "\t" + user.getName());
		_sessionFactory.openSession().save(user);
	}

	public void delete(User user) {
		_sessionFactory.openSession().delete(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		return _sessionFactory.openSession().createQuery("from User").list();
	}

	public User getByEmail(String email) {
		return (User) _sessionFactory.openSession().createQuery("from User where email = :email")
				.setParameter("email", email).uniqueResult();
	}

	public User getById(long id) {
		return (User) _sessionFactory.openSession().load(User.class, id);
	}

	public void update(User user) {
		_sessionFactory.openSession().update(user);
	}

}
