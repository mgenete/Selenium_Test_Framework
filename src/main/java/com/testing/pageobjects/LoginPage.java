package com.testing.pageobjects;

public interface LoginPage {
	
	
	/**
	 * Logs in using the provided credentials
	 * @param user   username
	 * @param pass   password
	 * @return       A new instance of WelcomePage
	 */
	public WelcomePage loginAs(String user, String pass);

}
