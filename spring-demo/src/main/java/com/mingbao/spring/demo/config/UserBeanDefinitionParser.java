package com.mingbao.spring.demo.config;

import com.mingbao.spring.demo.pojo.UserPojo;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * description: 自定义标签元素的解析器，参考 {@link org.springframework.context.annotation.ComponentScanBeanDefinitionParser}
 * 参考上面那个类，实现的是 {@link BeanDefinitionParser} 接口
 * 写法是参考 {@link org.springframework.beans.factory.xml.BeanDefinitionParserDelegate} 中处理bean标签的逻辑
 *
 * 还可以继承 {@link org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser}，重写 doParse 方法
 * date: 2022-12-15
 *
 * @author Wind の Wound
 */
public class UserBeanDefinitionParser implements BeanDefinitionParser {

	/**
	 * 这里定义标签的属性
	 */
	public static final String ID_ATTRIBUTE = "id";
	public static final String NAME_ATTRIBUTE = "name";
	public static final String AGE_ATTRIBUTE = "age";
	public static final String SEX_ATTRIBUTE = "sex";

	@Override
	public BeanDefinition parse(Element element, ParserContext parserContext) {
		// id作为bean的名称
		String id = element.getAttribute(ID_ATTRIBUTE);
		// 下面是bean的属性
		String name = element.getAttribute(NAME_ATTRIBUTE);
		String age = element.getAttribute(AGE_ATTRIBUTE);
		String sex = element.getAttribute(SEX_ATTRIBUTE);

		// 定义一个bean定义信息对象
		BeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClassName(UserPojo.class.getName());
		beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(NAME_ATTRIBUTE, name));
		beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(AGE_ATTRIBUTE, age));
		beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(SEX_ATTRIBUTE, sex));
		BeanDefinitionHolder beanDefinitionHolder = new BeanDefinitionHolder(beanDefinition, id, new String[0]);

		// 注入到bean工厂中
		BeanDefinitionReaderUtils.registerBeanDefinition(beanDefinitionHolder, parserContext.getRegistry());

		// 这里返不返回其实无所谓，因为接收值的地方不用它
		return null;
	}
}
