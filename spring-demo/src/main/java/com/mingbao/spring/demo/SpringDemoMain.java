package com.mingbao.spring.demo;

import com.mingbao.spring.demo.pojo.UserPojo;
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
		UserPojo user = (UserPojo) context.getBean("user");
		System.out.println(user);
		UserPojo mingbao = (UserPojo) context.getBean("mingbao");
		System.out.println(mingbao);
	}
}
