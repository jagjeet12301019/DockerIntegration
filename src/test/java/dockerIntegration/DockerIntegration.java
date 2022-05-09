package dockerIntegration;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DockerIntegration {
	public WebDriver driver;
	
	@BeforeMethod	
	
	public void setUp() throws MalformedURLException {
	//ChromeOptions op = new ChromeOptions();	// Stop Docker container for Firefox and start for Chrome image
	FirefoxOptions op = new FirefoxOptions();		
	URL url = new URL("http://localhost:4444");
	driver = new RemoteWebDriver(url,op);
	driver.get("https://demo.nopcommerce.com/");
	}
	
	@Test
	public void f() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
		System.out.println("Integrated Docker");
	}	
}
