package com.amazon.project.AmazonProject;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Amazon {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Nagarajan\\eclipse-workspace\\IPT-Mini-Project\\Amazonpro\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		

		driver.get("https://www.amazon.com/");
		Thread.sleep(3000);

		WebElement all = driver.findElement(By.id("searchDropdownBox"));

		Select sc = new Select(all);

		// sc.selectByVisibleText("Electronics");

		// all.click();

		List<WebElement> search = sc.getOptions();
		Thread.sleep(2000);
		String expected = "Baby";

		for (int i = 0; i < search.size(); i++) {

			String Actual = search.get(i).getText();

			if (expected.equalsIgnoreCase(Actual)) {

				sc.selectByVisibleText(Actual);

			} else {
				continue;
			}
		}

		WebElement sear = driver.findElement(By.xpath("//*[@type='text']"));
		String searchVlue = "Toys";
		sear.sendKeys(searchVlue);

		Thread.sleep(1000);

		List<WebElement> listeditem = driver
				.findElements(By.xpath("//*[@class='autocomplete-results-container']/child::div"));
		

		for (int j = 1; j < listeditem.size(); j++) {
			Thread.sleep(2000);
			WebElement textWeb = driver.findElement(
					By.xpath("//*[@class='autocomplete-results-container']/child::div[" + j + "]/div/div"));
			
			String text = textWeb.getText();

			if (searchVlue.equalsIgnoreCase(text)) {
				textWeb.click();

			}

		}

		List<WebElement> searlis = driver.findElements(By.xpath("//*[@id='nav-flyout-searchAjax']/child::div[2]"));
		for (WebElement ip : searlis) {

			String lis = ip.getText();
			System.out.println(lis);
		}

		List<WebElement> result = driver
				.findElements(By.xpath("(//div[@class='sg-col-inner'])[3]/descendant::div[4]/child::div"));
		for (WebElement searchResult : result) {

			System.out.println(searchResult.getText());

		}

	}
}
