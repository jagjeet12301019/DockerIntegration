package dockerIntegration;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DockerIntegrationSimpleTest {
	public WebDriver driver;
	
	

	public static void main(String[] args) throws MalformedURLException {
		//ChromeOptions op = new ChromeOptions();
		
		FirefoxOptions op = new FirefoxOptions();		
		URL url = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url,op);
		driver.get("https://demo.nopcommerce.com/");
		String title = driver.getTitle();
		System.out.println(title);		
		driver.quit();

	}

}
