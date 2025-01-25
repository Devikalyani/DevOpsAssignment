package com.Amazon.BrowserTest;

import java.net.MalformedURLException;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AmazonBrowser_DockerTest {

	WebDriver driver;

	@Parameters({"bName"})
	
	@Test
	public void browserTest(String BrowserName) throws MalformedURLException, URISyntaxException, InterruptedException {
		
		if(BrowserName.equalsIgnoreCase("chrome")) {
			
			ChromeOptions opt=new ChromeOptions();
			driver=new RemoteWebDriver(new URL("http://localhost:4444"),opt);

			System.out.println("Connection Established with Chrome Browser");
		}
		
		else if(BrowserName.equalsIgnoreCase("mozilla")) {
			
			FirefoxOptions opt=new FirefoxOptions();
			driver=new RemoteWebDriver(new URL("http://localhost:4444"),opt);
			
			System.out.println("Connection Established with Firefox Browser");
		}
		
		else if(BrowserName.equalsIgnoreCase("edge")) {
			
			EdgeOptions opt=new EdgeOptions();
			driver=new RemoteWebDriver(new URL("http://localhost:4444"),opt);

			System.out.println("Connection Established with Microsoft Edge Browser");
			
		}
		
		Thread.sleep(10000);
		driver.get("http://www.amazon.com");
		Thread.sleep(6000);
		System.out.println("Application executing parallely...");

	}
}
