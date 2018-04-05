package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.ForumDao;
import com.niit.model.Forum;
import com.niit.model.ForumComment;

@Repository("forumDao")
public class ForumDaoImpl implements ForumDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean addForum(Forum forum) {

		try {
			sessionFactory.getCurrentSession().save(forum);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean deleteForum(Forum forum) {
		
		try {
			sessionFactory.getCurrentSession().delete(forum);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateForum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	public boolean approveForum(Forum forum) {

		try {
			forum.setStatus("A");
			sessionFactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}		
	}

	public boolean rejectForum(Forum forum) {

		try {
			forum.setStatus("NA");
			sessionFactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}		

		
	}

	public Forum getForum(int forumId) {

		try {
			
			Session session=sessionFactory.openSession();
			Forum forum=session.get(Forum.class,forumId);
			session.close();
			return forum;
		}
		catch(Exception e)
		{
			return null;
		}

	}

	public List<Forum> listForum(String username) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("From Forum ");
		List<Forum> listForum = query.list();
		return listForum;
	}
	
	@Transactional
	public boolean addForumComment(ForumComment forumComment) {
		try {
			sessionFactory.getCurrentSession().save(forumComment);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Transactional
	public boolean deleteForumComment(ForumComment forumComment) {
		try {
			sessionFactory.getCurrentSession().delete(forumComment);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public ForumComment getForumComment(int forumCommentId) {
		try {
			Session session = sessionFactory.openSession();
			ForumComment forumComment = session.get(ForumComment.class, forumCommentId);
			session.close();
			return forumComment;
		} catch (Exception e) {
			return null;
		}
	}

	public List<ForumComment> listForumComments(int forumId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from ForumComment where forumId=:forumId");
		query.setParameter("forumId", forumId);
		List<ForumComment> listForumComment = query.list();
		return listForumComment;
	}
	
}
