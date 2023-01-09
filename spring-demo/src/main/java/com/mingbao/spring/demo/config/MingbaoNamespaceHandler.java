package com.mingbao.spring.demo.config;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * description: 自定义标签处理器，参考 {@link org.springframework.context.config.ContextNamespaceHandler}
 * date: 2022-12-15
 *
 * @author Wind の Wound
 */
public class MingbaoNamespaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
	}
}
