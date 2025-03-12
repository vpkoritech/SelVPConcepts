package seleniumSessionsVP;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiWindowsDeepSeek {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.onlinesbi.sbi/");
		Thread.sleep(4000);
		driver.manage().window().maximize();
		
		// Get the handle of the main window
		String PWID = driver.getWindowHandle();
		System.out.println("Main Window Handle: " + PWID);
		Thread.sleep(3000);
		// Click a link/button that opens a new Window
		WebElement first = driver.findElement(By.xpath("(//a[@class='how'])[2]")); 
		first.click();
		//For New Window use : driver.switchTo().newWindow(WindowType.WINDOW);
		WebElement second = driver.findElement(By.xpath("(//a[@class='how'])[1]"));
		second.click();
		WebElement third = driver.findElement(By.xpath("(//a/span[contains(text(),'Customer Care')])[2]"));
		third.click();

		Set<String> allWindowHandles = driver.getWindowHandles();
		 for (String windowHandle : allWindowHandles) {
	            if (!windowHandle.equals(PWID)) {
	                // Switch to the new window
	                driver.switchTo().window(windowHandle);
	                System.out.println("Switched to New Window: " + windowHandle);
	                // Perform actions in the new window
	                System.out.println("Title of New Window: " + driver.getTitle());
	                // Close the new window (optional)
	                driver.close();
	            }
	        }
		 driver.switchTo().window(PWID);
	        System.out.println("Switched back to Main Window: " + PWID);
	        // Perform actions in the main window
	        System.out.println("Title of Main Window: " + driver.getTitle());
	        // Close the main window
	        driver.quit();
	}
}
