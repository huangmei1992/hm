package com.hm.test.demo;

import static org.testng.Assert.*;//Assert类下面的所有方法，属性

import org.testng.annotations.Test;

public class TestNGDemo1 {
	@Test(description="简单测试")
	public void test1(){
		assertEquals(10, 10);
	}
	
	@Test(dependsOnMethods="test1",alwaysRun=true)
	public void test2(){
		assertEquals(10,10);
	}
	@Test(enabled=true)//enabled=false表示暂时不启用
	public void test3(){
		assertEquals(10,10);
	}
	@Test(invocationCount=4,threadPoolSize=3)//表示运行四次,3个同时运行
	public void test4(){
		assertEquals(10,10);
	}
	@Test
	public void test5(){
		assertEquals(10,11);
	
	}
}
