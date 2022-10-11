package com.flowace.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CricbuzzHomepage {

	@FindBy(xpath = "//a[text()='Scorecard']")
	private WebElement scorecard;

	public CricbuzzHomepage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void clickscorecard() throws InterruptedException {
		scorecard.click();
	}

}
