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
	
	public static WebDriver driver;
	public static Screen s;
	public static void main(String args[]) throws FindFailed {
		s = new Screen();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yiaoping\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		//open url
		String url = "https://google.ca";
		openURL(url);
		
		
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Kardium");
		searchBox.sendKeys(Keys.ENTER);
		
		//Use sikuli to find image
		Pattern kardiumLink = new Pattern("C:\\Users\\Yiaoping\\eclipse-workspace\\Selenium\\imgs\\kardium.PNG").similar(0.8);
		s.wait(kardiumLink, 1);
		s.click();

		//Use Selenium to find the contact menu link and click it
		WebElement contactLink = driver.findElement(By.linkText("CONTACT"));
		contactLink.click();
		
		//scroll page down once
		s.type(Key.PAGE_DOWN);
		
		//get the email address on the page using xpath
		String email = driver.findElement(By.xpath("//li[@class='x-li-icon'][2]")).getText();
		System.out.println(email);
		
		
		//calls the method to compose a new email through mail app. Passes in email
		composeMail(email);
				
	}
	
	//creates new chromedriver object to open up google chrome and goes to link
	public static void openURL(String url) {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	
	//method for opening up mail application and composing a new mail with addressee
	public static void composeMail(String email) throws FindFailed {
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
