

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class username {
	
	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yiaoping\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.gmail.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("identifierId")).sendKeys("yiao2874@gmail.com");
		driver.findElement(By.className("CwaK9")).click();
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "gmail";
		driver.close();
		if(ActualTitle.equalsIgnoreCase(ExpectedTitle)) {
			System.out.println("Test sucessful");
		}else {
			System.out.println("Test failed!!");
		}
		
		
	}

}
