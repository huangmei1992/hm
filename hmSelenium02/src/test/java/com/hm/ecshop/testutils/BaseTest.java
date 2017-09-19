/**2017-8-26 周六下午13:30-15:30
 * 基础测试用例
 * 
 */

package com.hm.ecshop.testutils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.hm.testdata.ConfigReader;
import com.hm.webdriver.utils.WebDriverUtils;

public class BaseTest {
	public WebDriver driver;
	@BeforeMethod  //在方法之前要指定一下浏览器
	public void openBrowser(){
		driver = WebDriverUtils.getDriver(ConfigReader.getConfig(ConfigReader.BROWSER),this.getClass());//读取浏览器
		String wt = ConfigReader.getConfig(ConfigReader.WAITTIME);//取出来的时间是String类型的
		//driver = WebDriverUtils.getDriver("chrome",this.getClass());//方法是被人继承的，谁继承BaseTest.java谁就是用这个类
		driver.manage().timeouts().implicitlyWait(Long.parseLong(wt), TimeUnit.SECONDS);//将String类型的wt进行转换
	}
	@AfterMethod
	public void closeBrowser(){
		System.err.println("------------> close windows");
		driver.quit();
	}
}
