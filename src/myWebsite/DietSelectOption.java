package myWebsite;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DietSelectOption {
	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yiaoping\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "http://yiaoshu.tk/health/diet.html";
		System.out.println(url);
		driver.get(url);
		driver.manage().window().maximize();
		Select selectDiet = new Select(driver.findElement(By.id("selectDiet")));
		selectDiet.selectByVisibleText("I want to lose weight");
		
		String actualString = driver.findElement(By.id("selectedChoice")).getText();
		System.out.println(actualString);
		String expectedString = "You selected:\nI want to lose weight";
		
		if(expectedString.equalsIgnoreCase(actualString)) {
			System.out.println("Test Successful");

		}
		else {
			System.out.println("Failed");

		}
	}
		
}
