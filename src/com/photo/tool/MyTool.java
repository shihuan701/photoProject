package com.photo.tool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyTool {
	public static void switchWindow(WebDriver driver){
		for(String handle:driver.getWindowHandles()){
			driver.switchTo().window(handle);
		}
	}
	
	public static WebDriver switchIframe(WebDriver driver,WebElement element){
		return driver.switchTo().frame(element);
	}
}
