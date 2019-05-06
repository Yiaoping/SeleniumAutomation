package sikuli;

import java.util.List;
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

public class SendEmailKardium {
	
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
		
		//sikuli
		Pattern kardiumLink = new Pattern("C:\\Users\\Yiaoping\\eclipse-workspace\\Selenium\\imgs\\kardium.PNG").similar(0.8);
		s.wait(kardiumLink, 2);
		s.click();
		
		//find the contact link and click it
		WebElement contactLink = driver.findElement(By.linkText("CONTACT"));
		contactLink.click();
		
		//scroll page down once
		s.type(Key.PAGE_DOWN);
		
		//get the email address on the page using xpath
		String email = driver.findElement(By.xpath("//li[@class='x-li-icon'][2]")).getText();
		System.out.println(email);
		
		//open up mail
		Pattern window = new Pattern("C:\\Users\\Yiaoping\\eclipse-workspace\\Selenium\\imgs\\window.PNG");
		s.click(window);
		s.type("mail");
		s.type(Key.ENTER);
		
		
		//compose a new mail
		Pattern newMail = new Pattern("C:\\Users\\Yiaoping\\eclipse-workspace\\Selenium\\imgs\\newmail.PNG");
		s.wait(newMail, 2);
		s.click();
		
		//clicks on toBox
		Pattern toBox = new Pattern("C:\\Users\\Yiaoping\\eclipse-workspace\\Selenium\\imgs\\toBox.PNG").similar(0.8);
		s.click(toBox);
		s.type(email);
		
	}

}
