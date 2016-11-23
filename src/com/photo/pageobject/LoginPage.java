package com.photo.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(name="username")
	private WebElement usernameInput;
	@FindBy(className="js-cur")
	private WebElement scapejs;	
	@FindBy(name="password")
	private WebElement passwordInput;
	@FindBy(id="photo_index_login")
	private WebElement loginBtn;
	@FindBy(className="name")
	private WebElement enterBtn;
	@FindBy(partialLinkText="了解更多")
	private WebElement toKnowMoreBtn;
	
	
	public void login(WebDriver driver,String username,String password){
		this.usernameInput.sendKeys(username);
		this.scapejs.click();
		this.passwordInput.sendKeys(password);
		this.loginBtn.click();
		this.enterBtn.click();
	}
	
	public boolean checkIfLoginSucceed(WebDriver driver,String username,String password){
		LoginPage lp = PageFactory.initElements(driver,LoginPage.class);
		lp.login(driver, username, password);
		return driver.getTitle().equals(username+"的网易相册_"+username+"个人相册相片存储_网易相册");
	}
	
	public void clickToKownMoreBtn(){
		this.toKnowMoreBtn.click();
	}
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
}
