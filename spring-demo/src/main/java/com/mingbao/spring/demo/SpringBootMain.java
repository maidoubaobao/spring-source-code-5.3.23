package com.mingbao.spring.demo;

import com.mingbao.spring.demo.scan.ScanUserPojo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * description: springboot启动入口
 * 这个类主要调试spring的Import注解导入的过程
 *
 * @author Wind の Wound
 * @since 2023/9/3
 */
@SpringBootApplication
public class SpringBootMain {

	/**
	 * 因为spring这个版本需要jdk11才能跑，这里集成了springBoot后，启动会警告：
	 * WARNING: An illegal reflective access operation has occurred
	 * WARNING: Illegal reflective access by org.springframework.cglib.core.ReflectUtils$1
	 * ...
	 *
	 * 不知道啥原因，据说是jdk版本高了就会出现这个警告，但是这里直接引用了spring的源码，不能降低版本
	 * 在启动命令里加这样一行可以消除这个警告：--add-opens java.base/java.lang=ALL-UNNAMED
	 */
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootMain.class);

		// 注解注入的类
		ScanUserPojo scanUserPojo = context.getBean(ScanUserPojo.class);
		System.out.println(scanUserPojo);
	}
}
