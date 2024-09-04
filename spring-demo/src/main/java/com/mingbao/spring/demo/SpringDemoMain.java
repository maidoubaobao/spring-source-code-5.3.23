package com.mingbao.spring.demo;

import com.mingbao.spring.demo.factory.bean.UserFactoryBean;
import com.mingbao.spring.demo.pojo.UserPojo;
import com.mingbao.spring.demo.scan.ScanUserPojo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description: spring启动入口
 * 这个类主要调试spring的主流程，包括：xml配置文件解析、bean的注入、bean的实例化、BeanFactoryPostProcessor的处理、
 * BeanPostProcessor的处理以及<context:component-scan>注解对应的ConfigurationClassPostProcessor的处理
 *
 * @author Wind の Wound
 * @since 2022/11/13
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

		// 通过实现 FactoryBean 注入的类
		UserPojo factoryUser = (UserPojo) context.getBean("factoryUser");
		System.out.println(factoryUser);
		// 获取 FactoryBean 工厂类
		UserFactoryBean userFactoryBean = (UserFactoryBean) context.getBean("&factoryUser");
		UserPojo factoryUserBak = userFactoryBean.getObject();
		System.out.println(factoryUserBak);
	}
}
