/**2017-8-26 周六下午13:30-15:30
 * 登录测试
 * 
 * 
 */


package com.hm.ecshop.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.hm.ecshop.pages.EcshopIndexPage;
import com.hm.ecshop.pages.EcshopLoginPage;
import com.hm.ecshop.testutils.BaseTest;
import com.hm.testdata.TestDataFactory;
public class LoginTest extends BaseTest {
	
	@Test(dataProviderClass=TestDataFactory.class,dataProvider = "ecshop_login_data")
	public void loginTest1(String username, String password, String result){
		driver.get("http://localhost/ecshop");
		EcshopIndexPage indexPage = new  EcshopIndexPage(driver);
		indexPage.goLogin();//点击去登录
		EcshopLoginPage  loginPage = new EcshopLoginPage(driver);
		loginPage.doLogin(username, password);
		//System.out.println(driver.getPageSource());//获取 登录成功的xpath地址,获取完就不需要了
		loginPage.assertLoginResult(result);//检查点
	}
	
	//场景恢复
	@AfterMethod
	public void restoreUser(){
		driver.close();
		//连接数据库，调用清理注册用户的存储过程，需要开发写在里面，只要调用就行
	}
}
