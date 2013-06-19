package org.luis.mybatis;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.luis.mybatis.domain.Blog;
import org.luis.mybatis.service.BlogService;

public class BlogServiceTest {

	static BlogService blogService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		blogService = new BlogService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		blogService = null;
	}

	@Test
	public void testInsertBlog(){
		Blog blog = new Blog();
		blog.setBlogName("Luis Blog" + System.currentTimeMillis());
		blog.setCreatedOn(new Date());
		blogService.insertBlog(blog);
		assertTrue(blog.getBlogId() != 0);
		Blog createdBlog = blogService.getBlogById(blog.getBlogId());
		assertNotNull(createdBlog);
		assertEquals(createdBlog.getBlogName(), blog.getBlogName());
		
	}
	
	@Test
	public void testGetBlogById() {
		Blog blog = blogService.getBlogById(1);
		assertNotNull(blog);
		System.out.println(blog);
	}

	@Test
	public void testGetAllBlogs(){
		List<Blog> blogs = blogService.getAllBlogs();
		assertNotNull(blogs);
		for (Blog blog : blogs) {
			System.out.println(blog);
		}
	}
	
	@Test
	public void testUpdateBlog(){
		Blog blog = blogService.getBlogById(1);
		blog.setBlogName("IBK blog " + System.currentTimeMillis());
		blog.setCreatedOn(new Date());
		blogService.updateBlog(blog);
		Blog updatedBlog = blogService.getBlogById(1);
		assertEquals(updatedBlog.getBlogName(), blog.getBlogName());
	}
	
	
	@Test
	public void testDeleteBlog(){
		
		blogService.deleteBlog(2);
		Blog deletedBlog = blogService.getBlogById(2);
		assertNull(deletedBlog);
	}
}
