package sikuli;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.*;

public class YoutubeTest {

	public static void main(String args[]) throws FindFailed{
		Screen s = new Screen();
		

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yiaoping\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "https://www.youtube.com/watch?v=3IQVNjWH60A";
		System.out.println(url);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Pattern pauseImg = new Pattern("C:\\Users\\Yiaoping\\eclipse-workspace\\Selenium\\imgs\\pause.png");
		Pattern thumbsUp = new Pattern("C:\\Users\\Yiaoping\\eclipse-workspace\\Selenium\\imgs\\thumbsup.png");
		s.wait(pauseImg, 2000);
		s.click();
		s.click(thumbsUp);
		
		
	}
}
