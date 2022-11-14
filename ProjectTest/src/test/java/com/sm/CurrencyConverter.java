package com.sm;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

class CurrencyConverter {


	WebDriver driver;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	void setUp() throws Exception {
		driver = new ChromeDriver();
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	void test() {
		driver.manage().window().maximize();
		driver.get("http://localhost:3000/");
		WebElement amount = driver.findElement(By.name("curr"));
		WebElement fromCurrency = driver.findElement(By.name("fromCurr"));
		WebElement toCurrency = driver.findElement(By.name("toCurr"));
		WebElement submitBtn = driver.findElement(By.cssSelector("button"));
		
		amount.sendKeys("8");
		fromCurrency.sendKeys("USD");
		toCurrency.sendKeys("INR");
		submitBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement div = driver.findElement(By.id("result"));
		System.out.println(div);
		String result = div.getText();
		
		
		assertEquals("656.00", result);
		
	}

}
