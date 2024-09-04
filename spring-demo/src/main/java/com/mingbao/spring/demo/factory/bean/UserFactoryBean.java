package com.mingbao.spring.demo.factory.bean;

import com.mingbao.spring.demo.pojo.UserPojo;
import org.springframework.beans.factory.FactoryBean;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 工厂Bean
 *
 * @author ming
 * @since 2024/7/23
 */
public class UserFactoryBean implements FactoryBean<UserPojo> {

	private AtomicInteger count = new AtomicInteger(1);

	@Override
	public UserPojo getObject() {
		return new UserPojo("FactoryUser" + count.getAndIncrement());
	}

	@Override
	public Class<?> getObjectType() {
		return UserPojo.class;
	}
}
