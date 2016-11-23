package com.photo.testng;

import org.testng.annotations.Test;

import com.photo.pageobject.LoginPage;
import com.photo.pageobject.PhotoListPage;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AlertTest {
  
  public WebDriver driver;
  public String url = "http://www.photo.163.com";

  @BeforeMethod(groups={"alertTest"})
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "E:\\eclipseworkspace\\jar\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get(url);
	  driver.manage().window().maximize();
	  LoginPage lp = new LoginPage(driver);
	  lp.login(driver, "1335077456@qq.com","helloseven123456");
  }
  
  
  @AfterMethod(alwaysRun=true)
  public void afterTest() {
	  driver.quit();
  }
 
 @Test(priority=3,groups={"alertTest"})
 public void alertTest(){
	 PhotoListPage plp= new PhotoListPage(driver);
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 plp.clickCreateAlbumBtn(driver);
	 plp.clickSaveAlbumBtn(driver);
	 Alert alert = driver.switchTo().alert();
	 Assert.assertEquals("请输入相册名称！",alert.getText());
	 alert.accept();
 }
}
