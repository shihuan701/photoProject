package com.photo.testng;

import org.testng.annotations.Test;

import com.photo.pageobject.LoginPage;
import com.photo.pageobject.PhotoDetailPage;
import com.photo.pageobject.PhotoListPage;
import com.photo.tool.MyTool;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommentTest {
  
  public WebDriver driver;
  public String url = "http://www.photo.163.com";

  @BeforeMethod(groups={"commentTest"})
  public void beforeMethod() {
	  driver = new FirefoxDriver();
	  driver.get(url);
	  driver.manage().window().maximize();
	  LoginPage lp = new LoginPage(driver);
	  lp.login(driver, "1335077456@qq.com","helloseven123456");
  }
  
  
  @AfterMethod(alwaysRun=true)
  public void afterTest() {
	  driver.quit();
  }
 
 @Test(priority=2,groups={"commentTest"})
 public void commentTest(){
	 PhotoListPage plp= new PhotoListPage(driver);
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 plp.clickFirstPhoto(driver);
	 PhotoDetailPage pdp = new PhotoDetailPage(driver);
	 MyTool.switchIframe(driver, pdp.getCommentIframe());
	 pdp.getCommentInput().sendKeys(String.valueOf(System.currentTimeMillis()));
	 driver.switchTo().defaultContent();
	 pdp.clickCommentBtn();
 }
}
