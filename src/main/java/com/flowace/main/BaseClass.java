package com.flowace.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public WebDriver driver;
	private Properties props;

	public void initializeBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", props.getProperty("selenium.webdriver.path"));

		// create object of chrome driver class by providing reference of the webdriver
		driver = new ChromeDriver(); // classname objectname =new classname();

		// enter url
		driver.get("https://www.cricbuzz.com/cricket-scores/2215/ind-vs-sl-final-icc-world-cup-2011");

		driver.manage().window().maximize();

		Thread.sleep(2000);
	}

	public void initializeProperties() throws IOException {
		InputStream inputStream = null;
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			inputStream = loader.getResourceAsStream("configuration.properties");
			props = new Properties();
			props.load(inputStream);
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}

	}
}
