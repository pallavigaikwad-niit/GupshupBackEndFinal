package com.niit.Blogtest;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.BlogDao;
import com.niit.model.Blog;

public class BlogDaoTest {

	private static AnnotationConfigApplicationContext context;
	private static BlogDao blogDao;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		blogDao = (BlogDao) context.getBean("blogDao");
	}

	@Test
	//@org.junit.Ignore
	public void testInsertBlog() {
		Blog blog = new Blog();
		blog.setLoginName("Ganesh");
		blog.setBlogName("Ganesh blog");
		blog.setBlogContent("This is Ganesh blog");
		blog.setCreateDate(new Date());
		blog.setStatus("NA");

		assertEquals("Insert Blog failed", true, blogDao.addBlog(blog));

	}
	
	@Test
	@org.junit.Ignore
	public void testListBlog() {
		List<Blog> listBlog = blogDao.listBlog();
		assertEquals("List Blog Failed",3,listBlog.size());
	}

	@AfterClass
	public static void teardown() {
		context.close();
	}
}
