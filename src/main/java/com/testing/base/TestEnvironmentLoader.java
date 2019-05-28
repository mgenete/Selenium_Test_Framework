package com.testing.base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;

/**
 * Helper class for loading a TestEnvironment from a json file 

 */

public class TestEnvironmentLoader {
	public static TestEnvironmentLoader INSTANCE = new TestEnvironmentLoader();
	
	private TestEnvironmentLoader() {
		
	}
	
	public TestEnvironment loadConfiguration(String env) throws FileNotFoundException {
		BufferedReader reader = new BufferedReader(new FileReader("settings.json"));
		TestEnvironment environment = new Gson().fromJson(reader, TestEnvironment.class);
				return environment;
	}

}
