package com.InterviewDemoProject.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	
	
	//public Base() {
	public void readProperties() {
		prop=new Properties();
		File file=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\InterViewDemoProject\\config\\config.properties");

		dataProp=new Properties();
		File file1=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\InterviewDemoProject\\testdata\\testData.properties");
				try{
					FileInputStream dataFis=new FileInputStream(file1);
					dataProp.load(dataFis);
				}catch(Exception e) {
					e.printStackTrace();
				}
		try{
		FileInputStream fis= new FileInputStream(file);
		prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}
	
	public WebDriver intializebrowserAndopenUrl(String name) {
		if(name.contains("chrome")) {
			driver=new ChromeDriver();	
		}
		else if(name.contains("firefox")){
			driver=new FirefoxDriver();
		}
		else if(name.contains("edge")) {
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get(prop.getProperty("url"));
		return driver;
	}

	public void takeScreehShot() {
		
	}
	
	
}
