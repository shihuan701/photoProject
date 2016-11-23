package com.photo.testng;

import org.testng.annotations.Test;

import com.photo.pageobject.DownLoadPage;
import com.photo.pageobject.LoginPage;
import com.photo.tool.MyTool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DownLoadTest {
  
  public WebDriver driver;
  public String url = "http://www.photo.163.com";

  @BeforeMethod(groups={"downLoadTest"})
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  driver.get(url);
	  driver.manage().window().maximize();
  }
  
  
  @AfterMethod(alwaysRun=true)
  public void afterTest() {
	  driver.quit();
  }
 
  
@Test(priority=1,groups={"downLoadTest"})
 public void downLoadTest() {
		LoginPage lp = new LoginPage(driver);
		lp.clickToKownMoreBtn();
		MyTool.switchWindow(driver);
		DownLoadPage dp =new DownLoadPage(driver);
		dp.clickToKownMoreBtn();
  }
 
}
