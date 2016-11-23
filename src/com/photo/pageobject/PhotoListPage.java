package com.photo.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhotoListPage {
	@FindBy(xpath="//div[@id='photo-163-com-container']/div[1]/div[2]/div[1]//div[1]")
	private WebElement firstPhoto;
	@FindBy(linkText="创建相册")
	private WebElement createAlbumBtn;
	@FindBy(name="fm-a")
	private WebElement saveAlbumBtn;
	@FindBy(xpath="//div[@id='photo-163-com-container']//div[@class='ln0']/ul/li[3]//span[@class='hd']")
	private WebElement sortElement;
	@FindBy(linkText="自定义排序")
	private WebElement selfDefinedSort;
	@FindBy(xpath="//div[@class='ln ln0'][1]")
	private WebElement hoverBy;
	@FindBy(xpath="//div[@class='item on']//a[@title='删除']")
	private WebElement deleteBtn;
	@FindBy(xpath="//div[@class='lay-btn']/button[1]")
	private WebElement acceptBtn;
	public void clickFirstPhoto(WebDriver driver){
		this.firstPhoto.click();
	}
	public void clickCreateAlbumBtn(WebDriver driver){
		this.createAlbumBtn.click();
	}
	public void clickSaveAlbumBtn(WebDriver driver){
		this.saveAlbumBtn.click();
	}
	public void clickSortElement(WebDriver driver){
		this.sortElement.click();
	}
	public void clickSelfDefinedSort(WebDriver driver){
		this.selfDefinedSort.click();
	}
	
	public void clickDeleteBtn(WebDriver driver){
		this.deleteBtn.click();
	}
	
	public void clickAcceptBtn(WebDriver driver){
		this.acceptBtn.click();
	}
	
	public WebElement getHoverBy(){
		return this.hoverBy;
	}
	public PhotoListPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	
	public WebElement element(WebDriver driver, String path){
		return driver.findElement(By.xpath("//div[@title='"+path+"']"));
	}
	
	
}
