package com.hm.ecshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


//Ecshop首页操作
public class EcshopIndexPage {
	
	/**
	 * 首页免费注册的链接
	 */
	@FindBy(linkText="免费注册")
	private WebElement register_link;
	
	/**
	 * 首页登录链接
	 */
	@FindBy(xpath="//a[@href='user.php']")
	private WebElement login_link;
	
	//构造方法
	public EcshopIndexPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}//页面初始化
	
	
	/**
	 * 点击免费注册链接
	 */
	//去注册
	public void goRegist(){
		register_link.click();
	}
	
	/**
	 * 点击登录链接
	 */
	public void goLogin(){
		login_link.click();
	}
}
