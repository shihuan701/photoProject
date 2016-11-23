package com.photo.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DownLoadPage {
	@FindBy(id="J-iphone")
	private WebElement iphoneBtn;
	
	public void clickToKownMoreBtn(){
		this.iphoneBtn.click();
	}
	
	public DownLoadPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
}
