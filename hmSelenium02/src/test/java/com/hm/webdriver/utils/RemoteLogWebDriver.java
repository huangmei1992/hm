/**带有log的WebDriver
 * 目的是 每次在查找元素的时候，能够识别到底有没有真的找到元素
 * 
 * 
 */

package com.hm.webdriver.utils;

import java.net.URL;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;


public class RemoteLogWebDriver extends RemoteWebDriver {
	
	private  Logger logger;
	
	//以下为构造方法
	public RemoteLogWebDriver(URL url, Capabilities caps, Class<?> clazz){
		super(url,caps);//调用父类RemoteWebDriver
		logger = LogManager.getLogger(clazz);
	}
	
	
	//将EcshopIndexPage、EcshopLoginPage中的定位方法进行重写，有其他的方法的时候也要再写进来，如果写的麻烦的话，还可以进行封装
	//这边只对RemoteWebDriver进行重写，但没有用起来，用的话是在WebDriverUtils.java中用
	@Override
	public WebElement findElementByLinkText(String using) {
		try{
			WebElement element = super.findElementByLinkText(using);//引用父类的findElementByLinkText（）方法
			logger.info(using+"定位已找到元素");//能够找到元素的话就打印日志
			return element;
		}catch(NoSuchElementException e){
			logger.error(using+"定位未找到元素");
			throw e;//程序出错就抛出
		}
		
	}
	
	@Override
	public WebElement findElementByXPath(String using) {
		try{
			WebElement element = super.findElementByXPath(using);//引用父类的findElementByLinkText（）方法
			logger.info(using+"定位已找到元素");//能够找到元素的话就打印日志
			return element;
		}catch(NoSuchElementException e){
			logger.error(using+"定位未找到元素");
			throw e;//程序出错就抛出
		}
		
	}
	
	@Override
	public WebElement findElementByName(String using) {
		try{
			WebElement element = super.findElementByName(using);//引用父类的findElementByLinkText（）方法
			logger.info(using+"定位已找到元素");//能够找到元素的话就打印日志
			return element;
		}catch(NoSuchElementException e){
			logger.error(using+"定位未找到元素");
			throw e;//程序出错就抛出
		}
		
	}
}
