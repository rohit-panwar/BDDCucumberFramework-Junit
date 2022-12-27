package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	// 1. By locators
	/*
	 * private By emailIdTextBox = By.id("email"); private By passwordTextBox =
	 * By.id("pass"); private By signInButton = By.id("send2"); private By
	 * forgotPwdLink = By.linkText("Forgot Your Password?");
	 */
	private By emailIdTextBox = By.id("username");
	private By passwordTextBox = By.id("password");
	private By signInButton = By.name("login");
	private By forgotPwdLink = By.linkText("Lost your password??");

	// 2. Constructor of Page Class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean forgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}

	public void enterUserName(String userName) {
		driver.findElement(emailIdTextBox).sendKeys(userName);
	}

	public void enterPassword(String pwd) {
		driver.findElement(passwordTextBox).sendKeys(pwd);
	}

	public void clickOnLogin() {
		driver.findElement(signInButton).click();
	}

	public DashboardPage doLogin(String uid, String pwd) {
		System.out.println("Login into application using " + uid + " and " + pwd);
		driver.findElement(emailIdTextBox).sendKeys(uid);
		driver.findElement(passwordTextBox).sendKeys(pwd);
		driver.findElement(signInButton).click();

		return new DashboardPage(driver);
	}
}
