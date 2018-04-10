package com.niit.GupShupBackEnd;

import java.util.Date;

import com.niit.controller.DBConfig;
import com.niit.dao.BlogDao;
import com.niit.daoimpl.BlogDaoImpl;
import com.niit.model.Blog;

/**
 * Hello world!
 *
 */
public class App 
{
	private static DBConfig dbconfig;
	private static BlogDao blogDao;
    public static void main( String[] args )
    {
    	/*dbconfig=new DBConfig();
    	blogDao=new BlogDaoImpl();
    	
    	dbconfig.getSessionFactory();
    	
    	Blog blog=new Blog();
    	blog.setLoginName("Pallavi");
		blog.setBlogName("DIY");
		blog.setBlogContent("This is Pallavi's blog");
		blog.setCreateDate(new Date());
		blog.setStatus("NA");
    	
    	if(blogDao.addBlog(blog))
    	{
    		System.out.println("Sussesful");
    	}
    	else
    	{
    		System.out.println("UnSussesful");
    	}*/
    	
    	System.out.println( "Hello World!" );
        
        
    }
}
