package com.wangguitang.freedom.study.spring.message.converter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wangguitang.freedom.study.spring.message.converter.entity.PersonBean;

/**
 * 声明根上下文
 * @author freedom wang
 * @date 2018年4月16日下午4:28:19
 * @since 3.0.0
 */
@Configuration
public class RootConfig {

	/**
	 * 定义一个Bean。这里只是用于模拟证明根上下文上定义的Bean也可以被使用，其实可以添加注解@Component进行添加
	 * @return
	 * @author freedom wang
	 * @date 2018年4月17日上午11:27:21
	 * @since 1.0.0
	 */
	@Bean
	public PersonBean personBean() {
		PersonBean bean = new PersonBean();
		bean.setName("freedom wang");
		return bean;
	}
}
