/**2017-8-26 周六 13:30-15:30
 * 监听器：TestNG  http://testng.org/doc/documentation  →  5.17 - TestNG Listeners
 * 
 * 可以继承ITestListener这个接口，并必须实现其未实现的方法，只要实现其中的一块就可以，其他可以空着
 * 在G:\web\eclipse\workspace\hmSelenium02\target\surefire-reports中查看index.html的报告
 * 失败的用例在G:\web\eclipse\workspace\hmSelenium02\target\surefire-reports中有一个testng-failed.xml文件
 * 在testng_demo3.xml文件中添加执行错误用例的语句，就可以对执行错误的用例进行重跑，在surefire-reports中查看index.html的报告的时候可以看到Falied suite
 * 需要重跑几次，就复制几个<suite-file>
 * 常用的监听器有两个，一个是suite监听器：在整个suite执行过程中的，不能监听到每个方法，只能监听整个suite存在与否
 * 二是test监听器：就是此次所用的就是test监听器
 */


package com.hm.test.demo;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

public class MyListener extends TestListenerAdapter{
	@Override
	public void onTestFailure(ITestResult tr) {
		String name = tr.getMethod().getMethodName();
		Reporter.log("测试方法:"+name+"执行失败了");//不会在这上面直接显示，会在报告中显示，TestNG自己提供的报告格式，在index.html的Reporter output中显示
		System.err.println("----> "+name);
	}


}
