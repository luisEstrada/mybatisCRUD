package org.luis.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.luis.mybatis.domain.Blog;

public interface BlogMapper {
	
	@Insert("INSERT INTO BLOG(blog_name, created_on) VALUES (#{blogName}, #{createdOn})")
	@Options(useGeneratedKeys=true, keyProperty="blogId")
	public void insertBlog(Blog blog);
	
	@Select("SELECT blog_id AS blogId, blog_name AS blogName, created_on AS createdOn FROM blog WHERE blog_id = #{blogId}")
	public Blog getBlogById(Integer blogId);
	
	@Select("SELECT * FROM blog")
	@Results({
		@Result(id=true, property="blogId", column="blog_id"),
		@Result(property="blogName", column="blog_name"),
		@Result(property="createdOn", column="created_on")		
	})
	public List<Blog> getAllBlogs();
	
	@Update("UPDATE blog SET blog_name=#{blogName}, created_on=#{createdOn} WHERE blog_id=#{blogId}")
	public void updateBlog(Blog blog);
	
	@Delete("DELETE FROM blog WHERE blog_id=#{blogId}")
	public void deleteBlog(Integer blogId);
	

}
