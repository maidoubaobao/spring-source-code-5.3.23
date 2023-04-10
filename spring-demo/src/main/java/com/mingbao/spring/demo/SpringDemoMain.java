package com.mingbao.spring.demo;

import com.mingbao.spring.demo.pojo.UserPojo;
import com.mingbao.spring.demo.scan.ScanUserPojo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description: spring启动入口
 * date: 2022/11/13
 *
 * @author Wind の Wound
 */
public class SpringDemoMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// 通过bean标签正儿八经注入的类
		UserPojo user = (UserPojo) context.getBean("user");
		System.out.println(user);

		// 通过自动定义标签<mingbao:user/>注入的类
		UserPojo mingbao = (UserPojo) context.getBean("mingbao");
		System.out.println(mingbao);

		// 通过<context:component-scan/>标签扫描注入的类
		ScanUserPojo scanUserPojo = context.getBean(ScanUserPojo.class);
		System.out.println(scanUserPojo);
	}
}
