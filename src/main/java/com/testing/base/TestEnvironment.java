package com.testing.base;

/**
 * Model for the TestEnvironment object used to load settings about a particular
 * test environment including authentication info
 * 
 */

public class TestEnvironment {

	private String servertUrl;
	private String testUsername;
	private String testPassword;
	private String testUrl;
	private String browser;
	private String proxyEnabled;

	
	
	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}
	
	public String getTestUrl() {
		return testUrl;
	}

	public void setTestUrl(String testUrl) {
		this.testUrl = testUrl;
	}

	public String getServertUrl() {
		return servertUrl;
	}

	public void setServertUrl(String servertUrl) {
		this.servertUrl = servertUrl;
	}

	public String getTestUsername() {
		return testUsername;
	}

	public void setTestUsername(String testUsername) {
		this.testUsername = testUsername;
	}

	public String getTestPassword() {
		return testPassword;
	}

	public void setTestPassword(String testPassword) {
		this.testPassword = testPassword;
	}


	public String getProxyEnabled() {
		return proxyEnabled;
	}

	public void setProxyEnabled(String proxyEnabled) {
		this.proxyEnabled = proxyEnabled;
	}

}
