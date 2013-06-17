package org.luis.mybatis.domain;

import java.util.Date;
import com.google.common.base.Objects;

public class Blog {
	
	private Integer blogId;
	private String blogName;
	private Date createdOn;
	
	
	
	@Override
	public String toString() {
		return Objects.toStringHelper(this)
			.add("blogId", blogId)
			.add("blogName", blogName)
			.add("createdOn", createdOn)
			.toString();
	}
	
	public Integer getBlogId() {
		return blogId;
	}
	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}
	public String getBlogName() {
		return blogName;
	}
	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	
	
}
