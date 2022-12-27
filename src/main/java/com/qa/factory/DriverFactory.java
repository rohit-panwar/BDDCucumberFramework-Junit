package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlLocal = new ThreadLocal<>();

	/**
	 * This method is used to initialize the threadLocal driver on the basis of
	 * given browser
	 * 
	 * @param browser
	 * @return WebDriver
	 */
	public WebDriver init_driver(String browser) {
		System.out.println("browser value is: " + browser);

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlLocal.set(new ChromeDriver());
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlLocal.set(new FirefoxDriver());
		} else {
			System.out.println("Incorrect browser value is passed: " + browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();

		return getDriver();
	}

	/**
	 * This is used to get the driver with threadLocal
	 * 
	 * @return WebDriver
	 */
	public static synchronized WebDriver getDriver() {
		return tlLocal.get();
	}
}
