package myWebsite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitle {
	public static int main(String args[]) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yiaoping\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("yiaoshu.tk");
		driver.manage().window().maximize();
		String aTitle = driver.getTitle();
		String ExpectedTitle = "yiaoshu.tk";
		driver.close();
		if(aTitle.equalsIgnoreCase(ExpectedTitle)) {
			System.out.println("Test successful");
			return 1;
		}
		else {
			System.out.println("Failed");
			return -1;
		}
	}
}
