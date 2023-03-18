package org.stepdefinition;

import java.io.IOException;

import org.baseclass.BaseClass;

import io.cucumber.java.Before;

public class BrowserLaunch extends BaseClass {
	
	@Before
	public void browserLaunch() throws IOException {
		
		if(driver==null) {
			BaseClass.browser("chrome");
			BaseClass.launchUrl(readProp("url"));
		}
		
	}

}
