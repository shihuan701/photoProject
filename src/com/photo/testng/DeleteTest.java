package com.photo.testng;

import org.testng.annotations.Test;

import com.photo.pageobject.LoginPage;
import com.photo.pageobject.PhotoListPage;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class DeleteTest {
  
  public WebDriver driver;
  public String url = "http://www.photo.163.com";
  
  @BeforeMethod(groups={"deleteTest"})
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
  
  @Test(priority=5,groups={"deleteTest"})
  public void deleteTest(){
 	 PhotoListPage plp= new PhotoListPage(driver);
 	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 	 Actions act = new Actions(driver);
 	 Action hover = act.moveToElement(plp.getHoverBy()).build();
 	 hover.perform();
 	 plp.clickDeleteBtn(driver);
 	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 	 plp.clickAcceptBtn(driver);
  }
}
