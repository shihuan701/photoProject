package com.photo.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhotoDetailPage {
	@FindBy(xpath="//div[@class='j-main']//iframe")
	private WebElement commentIframe;
	
	@FindBy(xpath="//body")
	private WebElement commentInput;
	
	@FindBy(xpath="//div[@class='zbtn']/input[1]")
	private WebElement commentBtn;

	public WebElement getCommentIframe(){
		return commentIframe;
	}
	
	public WebElement getCommentInput(){
		return commentInput;
	}
	
	public PhotoDetailPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void clickCommentBtn(){
		this.commentBtn.click();
	}
}
