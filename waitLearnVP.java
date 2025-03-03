package seleniumBasics;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitLearnVP {

	public static void main(String[] args) {
		// ImplicitlyWait , WebDriverWait , switchTo()Frame , switchTo()DefaultContent
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String Title =driver.getTitle();
		System.out.println(Title);
		List<WebElement> ele = driver.findElements(By.cssSelector(".vcVZ7d>div>a"));
		for (WebElement e : ele) {
			System.out.println(e.getText());
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='callout']")));
		System.out.println("Frame Switched...");
		String signInPopup= driver.findElement(By.xpath("//button[@jsname='ZUkOIc']")).getText();
		System.out.println(signInPopup);
		
		driver.switchTo().defaultContent();
		WebElement googleImg = driver.findElement(By.xpath("//img[@alt='Google']"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(googleImg));
		System.out.println("WebDriverWait is done...");
		WebElement googleLink = driver.findElement(By.xpath("//a[@href='https://www.google.com/']"));
		System.out.println(googleImg.isDisplayed());
		System.out.println(googleLink.isDisplayed());
		driver.quit();	
	}
}
