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


public class SendEmailKardium {
	
	private static WebDriver driver;
	private static Screen s;
	private static final Pattern expectedResult = new Pattern("C:\\Users\\Yiaoping\\eclipse-workspace\\Selenium\\imgs\\expectedResult.PNG").similar(0.7);
	
	
	public static void main(String args[]) throws FindFailed {
		s = new Screen();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yiaoping\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		//open url
		String url = "https://google.ca";
		openURL(url);
		
		//look for links and images
		String email= findElements();
		
		//calls the method to compose a new email through mail app. Passes in email
		composeMail(email);
		
		//check to see if final result compares to expected result
		if(s.exists(expectedResult)!=null) {
			System.out.println("Successful");
		}else
			System.out.println("Failed");
				
	}
	
	//creates new chromedriver object to open up google chrome and goes to link
	public static void openURL(String url) {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public static String findElements() throws FindFailed {
		//looks for search box and enters input
		WebElement searchBox = driver.findElement(By.name("q"));	
		searchBox.sendKeys("Kardium");								
		searchBox.sendKeys(Keys.ENTER);
		
		sikuliImage();		
		
		//looks for contact link
		WebElement contactLink = driver.findElement(By.linkText("CONTACT"));		
		contactLink.click();
		
		//scrolls down to grab email link
		s.type(Key.PAGE_DOWN);		
		String email = driver.findElement(By.xpath("//li[@class='x-li-icon'][2]")).getText();	
		System.out.println(email);
		return email;
	}
	
	//method to look for image
	public static void sikuliImage() throws FindFailed {
		Pattern kardiumLink = new Pattern("C:\\Users\\Yiaoping\\eclipse-workspace\\Selenium\\imgs\\kardium.PNG").similar(0.8);
		s.wait(kardiumLink, 1);
		s.click();
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
