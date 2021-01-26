package com.choucairtesting.pruebatecnica;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateEmailAccountOk {

	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/DriverChrome/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}

	@After
	public void tearDown() throws Exception {

		driver.quit();

	}

	@Test
	public void test() throws InterruptedException {
		driver.findElement(By.className("login")).click();
		Thread.sleep(5000);

		WebElement email = driver.findElement(By.id("email_create"));
		email.clear();
		email.sendKeys("daniAragon08@gmail.com");

		driver.findElement(By.id("SubmitCreate")).click();

		Thread.sleep(3000);
		String seccion = driver.findElement(By.className("page-heading")).getText();
		assertEquals("CREATE AN ACCOUNT", seccion);
	}

}