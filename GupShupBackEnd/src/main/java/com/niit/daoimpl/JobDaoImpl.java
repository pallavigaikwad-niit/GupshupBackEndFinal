package com.niit.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.JobDao;
import com.niit.model.ApplyJob;
import com.niit.model.Job;

@Repository("jobDao")
public class JobDaoImpl implements JobDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean addJob(Job job) {
		
		try {
			sessionFactory.getCurrentSession().save(job);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Transactional
	public boolean deleteJob(Job job) {
		try {
			sessionFactory.getCurrentSession().delete(job);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public boolean updateJob(Job job) {
		try {
			sessionFactory.getCurrentSession().update(job);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Job getJob(int jobId) {
		Job job  = sessionFactory.getCurrentSession().get(Job.class, jobId);
		return job;
	}

	public List<Job> listAllJobs() {

/*		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			List<Job> jobList = new ArrayList<Job>();
			Query query = session.createQuery("FROM Job");
			jobList = query.list();
			return jobList;
		} catch (Exception e) {
			return null;
		}
*/		
		List<Job> listAllJob =null;
		try {
			
			listAllJob = sessionFactory.openSession().createQuery("FROM Job").list();

		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
		return listAllJob;
	}

	@Transactional
	public boolean applyJob(ApplyJob applyJob) {

		try {
			sessionFactory.getCurrentSession().save(applyJob);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<ApplyJob> getAllAppliedJobDetails() {

		try {
		List<ApplyJob> applyjoblist = sessionFactory.openSession().createQuery("from ApplyJob").list();
		return applyjoblist;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
}
