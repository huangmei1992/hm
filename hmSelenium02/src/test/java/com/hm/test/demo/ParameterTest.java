package com.hm.test.demo;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
	@Parameters(value={"name","age"})
	@Test
	
	//变量名不一定要跟上面的参数名一样
	public void test1(String n,int a){
		System.out.println("--->"+n+","+a);
	}
}
