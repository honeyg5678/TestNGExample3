package com.honey.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FirstTestNGExample {
	WebDriver driver;

	@Parameters("browser")
	@BeforeTest
	public void launchbrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.westernunion.com/us/en/web/user/register");

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("https://www.westernunion.com/us/en/web/user/register");
		}
		else{
			System.out.println("pass the valid parameter value in testing.xml");
		}

	}

	@Test
	public void testApplication() {
		System.out.println(driver.getTitle());

	}

	@AfterTest
	public void closebrowser() {
		driver.close();

	}
}
