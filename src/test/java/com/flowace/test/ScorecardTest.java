package com.flowace.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flowace.main.BaseClass;
import com.flowace.main.CricbuzzHomepage;
import com.flowace.main.CricbuzzScorecard;

public class ScorecardTest extends BaseClass {

	private CricbuzzHomepage homepage;
	private CricbuzzScorecard scorecard;
	private static Integer totalOfSrilankanBatsmen = 0;
	private static Integer totalBoundriesOfSrilankanBatsmen = 0;

	@BeforeClass
	public void initialize() throws InterruptedException, IOException {
		initializeProperties();
		initializeBrowser();
		homepage = new CricbuzzHomepage(driver);
		scorecard = new CricbuzzScorecard(driver);
	}

	@BeforeMethod
	public void openScorecard() throws InterruptedException {
		homepage.clickscorecard();
	}

	@Test(priority = 1)
	public void totalScoreOfEachBatsment() {
		List<WebElement> runElements = scorecard.getBatsmentRunElements();
		for (int i = 1; i <= 8; i++) {
			totalOfSrilankanBatsmen += Integer.parseInt(runElements.get(i).getText());
		}
	}

	@Test(priority = 3)
	public void checkTotalAndExtras() {
		WebElement extras = scorecard.getExtras();
		WebElement total = scorecard.getTotal();
		assertEquals(totalOfSrilankanBatsmen + Integer.parseInt(extras.getText()), Integer.parseInt(total.getText()));
	}

	@Test(priority = 2)
	public void totalBoundriesBySrilankanTeam() {
		List<WebElement> boundryElements = scorecard.getBatsmentBoundriesElement();
		for (int i = 1; i <= 8; i++) {
			totalBoundriesOfSrilankanBatsmen += Integer.parseInt(boundryElements.get(i).getText());
		}
		System.out.println(totalBoundriesOfSrilankanBatsmen);
	}

	@Test(priority = 4)
	public void runOutPlayerName() {
		WebElement runOutPlayer = scorecard.getRunOutPlayer();
		assertEquals(runOutPlayer.getText(), "Nuwan Kulasekara");
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
