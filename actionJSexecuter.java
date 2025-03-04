package seleniumBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionJSexecuter {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		WebElement ele = driver.findElement(By.xpath("//textarea[@name='q']"));
		Actions act = new Actions(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("Waited for KeyBoard sendKeys .perform...");
		act.sendKeys(ele, "selenium").perform();
		Thread.sleep(3000);
		ele.clear();
		System.out.println("Clear the textbox..");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String title = js.executeScript("return document.title;").toString();
		Thread.sleep(3000);
		System.out.println(title);
		js.executeScript("document.getElementById('APjFqb').value='HI VP'");
				
		//driver.close();
		driver.quit();
		
	}	
		
}
