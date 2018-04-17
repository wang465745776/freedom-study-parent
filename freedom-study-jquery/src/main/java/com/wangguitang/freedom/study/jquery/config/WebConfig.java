package com.wangguitang.freedom.study.jquery.config;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * 声明DispatcherServlet的上下文
 * @author freedom wang
 * @date 2018年4月16日下午4:25:23
 * @since 1.0.0
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.wangguitang.freedom.study.jquery" })
public class WebConfig implements WebMvcConfigurer {

	/**
	 * 定义一个视图解析器
	 * @return
	 * @author freedom wang
	 * @date 2018年4月16日下午4:41:49
	 * @since 1.0.0
	 */
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		return viewResolver;
	}

	/**
	 * 新增一个消息转换器
	 * @param converters
	 * @author freedom wang
	 * @date 2018年4月17日上午10:09:27
	 * @since 1.0.0
	 */
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		// 创建一个消息转换器
		FastJsonHttpMessageConverter messageConverter = new FastJsonHttpMessageConverter();

		// 设置默认编码
		messageConverter.setDefaultCharset(Charset.forName("UTF-8"));

		// 设置转换器支持的类型
		messageConverter.setSupportedMediaTypes(Arrays.asList(new MediaType("application", "json"),
				new MediaType("text", "html", Charset.forName("UTF-8"))));

		// 设置JSON工具的配置
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setFeatures(Feature.AllowSingleQuotes);
		messageConverter.setFastJsonConfig(fastJsonConfig);

		converters.add(messageConverter);
	}
}
