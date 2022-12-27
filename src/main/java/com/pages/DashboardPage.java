package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {

	private WebDriver driver;

	private By dashboardSections = By.xpath("//nav[@class='woocommerce-MyAccount-navigation']/ul/li/a");

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getDashboardPageTitle() {
		return driver.getTitle();
	}

	public int getDashboardSectionCount() {
		return driver.findElements(dashboardSections).size();
	}

	public List<String> getDashboardSectionList() {
		List<String> dashboardList = new ArrayList<>();
		List<WebElement> dashboardSectionList = driver.findElements(dashboardSections);

		for (WebElement e : dashboardSectionList) {
			String text = e.getText();
			System.out.println(text);
			dashboardList.add(text);
		}
		return dashboardList;
	}
}
