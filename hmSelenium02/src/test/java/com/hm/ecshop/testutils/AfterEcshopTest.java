/**2017-8-26 周六下午13:30-15:30
 * 在EcshopTest结束后需要进行的测试
 * 
 */

package com.hm.ecshop.testutils;

import org.testng.annotations.AfterSuite;

import com.hm.webdriver.utils.WebDriverUtils;

public class AfterEcshopTest {
	
	//监听器监听整个Suite,在整个测试结束之后
	@AfterSuite
	public void stopService(){
		WebDriverUtils.stopService();
	}
}
