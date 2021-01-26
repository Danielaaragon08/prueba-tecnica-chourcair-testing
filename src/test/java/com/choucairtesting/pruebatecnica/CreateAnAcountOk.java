package com.choucairtesting.pruebatecnica;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAnAcountOk {

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
// Clic boton y redireccionamiento login
		driver.findElement(By.className("login")).click();
		Thread.sleep(5000);
// Capturar caja de correo, escribir y confirmar
		WebElement email = driver.findElement(By.id("email_create"));
		email.clear();
		email.sendKeys("lizetharagon18@gmail.com");
		driver.findElement(By.id("SubmitCreate")).click();
		Thread.sleep(3000);
// Rellenar formulario para crear cuenta
// Radio Mr - Mrs
		WebElement radio = driver.findElement(By.xpath("//input[@value='2']"));
		radio.click();
//  First name
		driver.findElement(By.id("customer_firstname")).sendKeys("Daniela");
//Last name
		driver.findElement(By.id("customer_lastname")).sendKeys("Aragón");
// Password
		driver.findElement(By.id("passwd")).sendKeys("Daniela12345");
//Fecha
		WebElement day = driver.findElement(By.id("days"));
		Select selectDay = new Select(day);
		selectDay.selectByValue("23");
		WebElement month = driver.findElement(By.id("months"));
		Select selectMonth = new Select(month);
		selectMonth.selectByIndex(3);
		WebElement year = driver.findElement(By.id("years"));
		Select selectYear = new Select(year);
		selectYear.selectByValue("1996");
//Suscribir - ofertas
		driver.findElement(By.id("newsletter")).click();
		driver.findElement(By.id("optin")).click();
//Validación campos First name y Last name
		String firstName = driver.findElement(By.id("firstname")).getText();
		String lastName = driver.findElement(By.id("lastname")).getText();
		assertEquals(firstName, driver.findElement(By.id("customer_firstname")).getText());
		assertEquals(lastName, driver.findElement(By.id("customer_lastname")).getText());
//Company
		driver.findElement(By.id("company")).sendKeys("Chourcaer");
//Adress
		driver.findElement(By.id("address1")).sendKeys("Cll 45-34b");
//City
		driver.findElement(By.id("city")).sendKeys("AUSTIN");
//State
		WebElement state = driver.findElement(By.id("id_state"));
		Select selectState = new Select(state);
		selectState.selectByIndex(43);
//Zip/Postal Code
		driver.findElement(By.id("postcode")).sendKeys("00000");
//Country
		WebElement country = driver.findElement(By.id("id_country"));
		Select selectCountry = new Select(country);
		selectCountry.selectByVisibleText("United States");
//Additional information
		driver.findElement(By.id("other")).sendKeys("Additional information");
		driver.findElement(By.id("phone_mobile")).sendKeys("3215648975");
		Thread.sleep(3000);
		driver.findElement(By.id("submitAccount")).click();
		Thread.sleep(3000);
	}
}
