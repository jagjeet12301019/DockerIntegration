package dockerIntegration;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridDockerIntegrationTestNG {
	
	@Test
	public void test1() throws MalformedURLException {
		ChromeOptions op = new ChromeOptions();
		
		URL url = new URL("http://localhost:4444/wd/hub");
		
		RemoteWebDriver driver = new RemoteWebDriver(url,op);
		
		driver.get("https://demo.nopcommerce.com/");
		System.out.println(driver.getTitle());
		driver.quit();
	}
	
	@Test
	public void test2() throws MalformedURLException {
		ChromeOptions op = new ChromeOptions();
		
		URL url = new URL("http://localhost:4444/wd/hub");
		
		RemoteWebDriver driver = new RemoteWebDriver(url,op);
		
		driver.get("https://www.google.com/?gws_rd=ssl");
		System.out.println(driver.getTitle());
		driver.quit();
	}
	
	@Test
	public void test3() throws MalformedURLException {
		ChromeOptions op = new ChromeOptions();
		
		URL url = new URL("http://localhost:4444/wd/hub");
		
		RemoteWebDriver driver = new RemoteWebDriver(url,op);
		
		driver.get("https://www.amazon.co.uk/");
		System.out.println(driver.getTitle());
		driver.quit();
	}
	
	@Test
	public void test4() throws MalformedURLException {
		FirefoxOptions op = new FirefoxOptions();
		
		URL url = new URL("http://localhost:4444/wd/hub");
		
		RemoteWebDriver driver = new RemoteWebDriver(url,op);
		
		driver.get("https://mail.google.com/mail/u/0/");
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
