package com.hm.test.demo;

import static org.testng.Assert.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


//执行顺序为：beforeClass→beforeMethod→test1→afterMethod→beforeMethod→test2→afterMethod→afterClass
public class TestNGDemo2 {
	
	//在类执行之前执行
	@BeforeClass
	public void beforeClass(){
		System.out.println("beforeTestNGDemo2Class...");
	}
	@AfterClass
	public void afterClass(){
		System.out.println("afterTestNGDemo2Class...");
	}
	
	
	
	@BeforeMethod  //类似与测试用例中的前置条件，比如可以做打开浏览器的操作
	public void beforeMethod(){
		System.out.println("beforeMethod...");
	}
	@AfterMethod  //做一些收尾工作，测完之后要恢复原样的，关掉浏览器这种的操作
	public void afterMethod(){
		System.out.println("afterMethod...");
	}
	
	@Test
	public void test1(){
		System.out.println("test1...");
		assertEquals(10, 10);
	}
	
	@Test
	public void test2(){
		System.out.println("test2...");
		assertEquals(10, 10);
	}
}
