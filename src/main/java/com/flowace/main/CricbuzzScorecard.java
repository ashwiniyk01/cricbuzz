package com.flowace.main;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CricbuzzScorecard {

	@FindBy(xpath = "//div[starts-with(@id,'innings_1')]/div[1]//div[contains(@class,'cb-col cb-col-8 text-right text-bold')]")
	private List<WebElement> batsmentRunElements;

	@FindBy(xpath = "//div[starts-with(@id,'innings_1')]/div[1]//div[@class='cb-col cb-col-8 text-right']")
	private List<WebElement> batsmentBoundriesElement;

	@FindBy(xpath = "//div[starts-with(@id,'innings_1')]/div[1]//div[@class='cb-col cb-col-8 text-bold cb-text-black text-right']")
	private WebElement extras;

	@FindBy(xpath = "//div[starts-with(@id,'innings_1')]/div[1]//div[@class='cb-col cb-col-8 text-bold text-black text-right']")
	private WebElement total;

	@FindBy(xpath = "//div[starts-with(@id,'innings_1')]/div[1]//span[text()='run out (M Dhoni)']/../../div[1]")
	private WebElement runOutPlayer;

	public CricbuzzScorecard(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getBatsmentRunElements() {
		return batsmentRunElements;
	}

	public List<WebElement> getBatsmentBoundriesElement() {
		return batsmentBoundriesElement;
	}

	public WebElement getExtras() {
		return extras;
	}

	public WebElement getTotal() {
		return total;
	}

	public WebElement getRunOutPlayer() {
		return runOutPlayer;
	}

}
