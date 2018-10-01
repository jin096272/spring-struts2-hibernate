package com.sy.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.sy.domain.User;
import com.sy.service.UserService;

@SuppressWarnings("serial")
@Action(value = "userAction", results = {
		@Result(name = "success", location = "/WEB-INF/jsp/success.jsp"),
		@Result(name = "error", location = "/WEB-INF/jsp/error.jsp") })
public class UserAction extends ActionSupport {
	@Autowired
	private UserService userService;
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// @Action(value = "addUser")
	public String addUser() {
		try {
			userService.addUser(user);
		} catch (Exception e) {
			System.out.println(e);
			return "error";
		}
		return "success";
	}

}
