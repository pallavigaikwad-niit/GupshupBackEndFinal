package com.niit.dao;

import java.util.List;

import com.niit.model.Blog;
import com.niit.model.BlogComment;

public interface BlogDao {

	public boolean addBlog(Blog blog);
	public boolean deleteBlog(Blog blog);
	public boolean updateBlog(Blog blog);
	public boolean approveBlog(Blog blog);
	public boolean rejectBlog(Blog blog);
	public Blog getBlog(int blogId);
	public List<Blog> listBlog();
	public boolean incrementLikes(Blog blog);
	
	public boolean addBlogComment(BlogComment blogComment);
	public boolean deleteBlogComment(BlogComment blogComment);
	public BlogComment getBlogComment(int blogcommentId);
	public List<BlogComment> listBlogComments(int blogId);

}
