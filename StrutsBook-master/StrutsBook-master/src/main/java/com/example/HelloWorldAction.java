package com.example;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport {

	public String execute() {
		return "index";
	}

	public String greet() {
		return "SUCCESS";
	}
}