package com.utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	DriverManager manager;
	
	@After
	public void destroy() {
		manager = DriverManager.getInstance();
		manager.closeDriver();
	}
}
