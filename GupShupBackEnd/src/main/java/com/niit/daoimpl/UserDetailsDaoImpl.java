package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.UserDetailDao;
import com.niit.model.UserDetail;

@Repository("userDao")
public class UserDetailsDaoImpl implements UserDetailDao{

	@Autowired
	SessionFactory sessionFactory;


	@Transactional
	public boolean registerUser(UserDetail userDetail) {

		try {
			sessionFactory.getCurrentSession().save(userDetail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public boolean checkLogin(UserDetail userDetail) {

		try {
			
			Session session = sessionFactory.openSession();
			Query query = session.createQuery("from UserDetail where loginName=:loginName and password=:password");
			query.setParameter("loginName", userDetail.getLoginName());
			query.setParameter("password", userDetail.getPassword());
			UserDetail users = (UserDetail) query.list().get(0);
			if (users == null)
				return false;
			else	
				return true;

			}catch (Exception e) {
				return false;
			}
	}

	@Transactional
	public boolean updateOnlineStatus(String status, UserDetail userDetail) {
		
		try {
			userDetail.setStatus(status);
			sessionFactory.getCurrentSession().update(userDetail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public UserDetail getUser(String loginName) {
		UserDetail userDetail = sessionFactory.getCurrentSession().get(UserDetail.class, loginName );
		return userDetail;
	}

	@Transactional
	public boolean deleteUser(UserDetail userDetail) {
		try {
			sessionFactory.getCurrentSession().delete(userDetail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public boolean updateUser(UserDetail userDetail) {
		try {
			sessionFactory.getCurrentSession().update(userDetail);
			return true;
		} catch (Exception e) {
			return false;
		}	}

	public List<UserDetail> listUsers() {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			List<UserDetail> userList = null;
			Query query = session.createQuery("FROM UserDetail");
			userList = query.list();
			return userList;
		} catch (Exception e) {
			return null;
		}

	}
}
