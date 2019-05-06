package sikuli;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Kardium {
	
	public static void main(String args[]) throws FindFailed {
		Screen s = new Screen();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yiaoping\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "https://google.ca";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Kardium");
		searchBox.sendKeys(Keys.ENTER);
		
		Pattern kardiumLink = new Pattern("C:\\Users\\Yiaoping\\eclipse-workspace\\Selenium\\imgs\\kardium.PNG").similar(0.8);
		Pattern careers = new Pattern("C:\\Users\\Yiaoping\\eclipse-workspace\\Selenium\\imgs\\careers.PNG").similar(0.8);
		Pattern testEngineer = new Pattern("C:\\Users\\Yiaoping\\eclipse-workspace\\Selenium\\imgs\\testEngineer.PNG").similar(0.8);
		
		s.wait(kardiumLink, 2);
		s.click();
		s.wait(careers, 2);
		s.click();
		int count = 0;
		while(count<20) {
			s.type(Key.PAGE_DOWN);
			if(s.exists(testEngineer, 2) != null) {
				break;
			}
			count++;
		}
		s.wait(testEngineer, 2);
		s.click();
		Pattern testEngineerDescription = new Pattern("C:\\Users\\Yiaoping\\eclipse-workspace\\Selenium\\imgs\\testEngineerDescription.PNG");

		
		if(s.exists(testEngineerDescription,2) != null) {
			System.out.println("Sucessful!");
		}
		else {
			System.out.println("Failed!");
		}
	}

}
