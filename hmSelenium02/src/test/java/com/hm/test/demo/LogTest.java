/**2017-08-29 周二 20:30-22:30
 * https://logging.apache.org/log4j/2.x/
 * 可以通过Maven来下载
 * 自动配置的优先级有10个
 * 配置的话可以用xml文件来配置，https://logging.apache.org/log4j/2.x/manual/configuration.html
 * 名称必须为log4j2-test.xml
 * 配置的示例：https://logging.apache.org/log4j/2.x/articles.html
 * <RollingFile name="rollingLogfile" filename="${log_home}/rollingtest.log"
			filePattern="${log_home}/$${date:yyyy-MM/test-%d{yyyy-MM-dd}-%i.log">
			<PatternLayout
				pattern="%d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n" />
			<SizeBasedTriggeringPolicy size="20MB" />
			<DefaultRolloverStrategy max="20" />
 *</RollingFile>
 * 表示rollingtest.log的文件超过20M的时候，就把文件存到filePattern="${log_home}/$${date:yyyy-MM/test-%d{yyyy-MM-dd}-%i.log">的路径下
 * 
 */


package com.hm.test.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LogTest {
	private static Logger logger = LogManager.getLogger();
	@Test
	public  void logTest1(){
		logger.info("哈哈，test1");
	}
	@Test
	public  void logTest2(){
		logger.warn("哈哈，test2");
	}
	@Test
	public  void logTest3(){
		logger.debug("哈哈，test3");
	}
	@Test
	public  void logTest4(){
		logger.error("哈哈，test4");
	}
}
