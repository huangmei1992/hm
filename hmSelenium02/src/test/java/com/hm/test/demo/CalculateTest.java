package com.hm.test.demo;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hm.testdata.TestDataFactory;
import com.huangmei.demo.Calculate;

public class CalculateTest {
	private Calculate calc;
	@BeforeClass
	public void init(){
		calc = new Calculate();
	}
	
	/*@DataProvider(name="calc_test_data")    //测试类里面应该只做测试工作，测试数据不要放进来，所以建了个TestFactory的类
	public Object[][] calcTestData(){
		Object[][] objs = new Object[][]{
			{10,20,30},
			{30,10,20},
			{30,30,60}
			
		};
		return objs;
	}*/
	
	@Test(dataProviderClass=TestDataFactory.class,dataProvider="calc_mysql_data")
	public void testCompute1(int x,int y,int expected){
		int actual=calc.compute(x, y);
		assertEquals(actual, expected);
	}
	
}
