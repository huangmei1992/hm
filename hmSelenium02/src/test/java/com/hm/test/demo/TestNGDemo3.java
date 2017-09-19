package com.hm.test.demo;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


//执行顺序为：beforeClass→beforeMethod→test1→afterMethod→beforeMethod→test2→afterMethod→afterClass
public class TestNGDemo3 {
	
	//要对testng_demo.xml<test></test>内的所有的类都要做的放在BeforeTest里面,如统一的初始化
	/*@BeforeTest
	public void beforeTest(){
		System.out.println("beforeTest---3...");
	}
	@AfterTest
	public void afterTest(){
		System.out.println("afterTest---3...");
	}
	*/
	
	
	//在类执行之前执行
	@BeforeClass
	public void beforeClass(){
		System.out.println("beforeTestNGDemo3Class...");
	}
	@AfterClass
	public void afterClass(){
		System.out.println("afterTestNGDemo3Class...");
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
	public void test3(){
		System.out.println("test3...");
		assertEquals(10, 10);
	}
	
	@Test
	public void test4(){
		System.out.println("test4...");
		assertEquals(10, 10);
	}
}
