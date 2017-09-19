package com.hm.ecshop.testutils;

import java.io.File;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

public class EcshopTestListener extends TestListenerAdapter {
	
	WebDriver driver = null;

	//在浏览器关闭前，进行截图操作
	@Override
	public void onTestFailure(ITestResult tr) {
		
		String name = tr.getMethod().getMethodName();
		//System.err.println("----------->监听器");//在driver关闭之前，监听器先被触发了
		
		//通过getInstance()拿到obj对象，再通过对象拿到类，通过类拿到里面的域，通过域拿到driver的值
		Object obj = tr.getInstance();
		Class<?> clazz = obj.getClass();
		//System.out.println(clazz.getName());//从对象反射出类
		try {
			Field field = clazz.getField("driver");//Field反射一个field 
			driver = (WebDriver)field.get(obj);
			System.out.println(driver);//取得driver
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		//强制转换driver
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//getScreenshot的返回类型就是file
		String path = "screenshot";//在screenshot目录下
		SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");//指定日期格式
		String filename = clazz.getName()+ "."+name+"_"+df.format(new Date())+".png";
		File pathfile = new File(path,filename);
		screenshot.renameTo(pathfile);
		
		
		Reporter.log("<label style='color:red'>"+name+"执行失败，详情请看日志，截图存放在screenshot目录中</label>");
	}
}
