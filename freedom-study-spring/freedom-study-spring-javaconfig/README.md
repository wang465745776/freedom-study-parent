# freedom-study-spring-javaconfig
此项目用于验证在SpringMVC项目中如何使用Java Config，彻底抛弃xml配置。

## 项目解析
1. 定义一个类WebAppInitializer继承抽象类AbstractAnnotationConfigDispatcherServletInitializer
为什么需要继承AbstractAnnotationConfigDispatcherServletInitializer类，这是为了满足一个需求。就是如何在项目启动的时候，如何去寻找Spring相关的配置。你可能会说，通过指定注解@ComponentScan设置扫描的包，然后在需要转配的地方使用@Controller、@Service、@Component等。那么问题来了，如何去设置@ComponentScan，从而可以让这个注解生效。你可能会说全局扫描。那么AbstractAnnotationConfigDispatcherServletInitializer类就是一个类似的功能。只要是继承了AbstractAnnotationConfigDispatcherServletInitializer类，那么就会被容器加载。
继承AbstractAnnotationConfigDispatcherServletInitializer类要实现三个方法。如下所示：

	* getRootConfigClasses 返回根上下文的配置Class
	* getServletConfigClasses 返回Servlet的上下文的配置Class
	* getServletMappings 设置DispatcherServlet的servlet mapping,这个默认拦截全部，所以设置`/`就可以了
	
那么现在的重点就在于根上下文的配置类和Servlet上下文的配置类了。

2. 根上下文的配置类-RootConfig
我们给RootConfig类加入了注解@Configuration，表示这是一个配置类。在类中定义的配置，可以被使用。因为这是一个根上下文。比如，我定义了一个bean,如下所示：
```java
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
```

这个代码就是设置一个Bean的写法。其类似于

```
<bean id="personBean" class="com.wangguitang.freedom.study.spring.javaconfig.entity.PersonBean">
	<property name="name" value="freedom wang" />
</bean>
```

定义了bean,就可以在其他地方进行注入。

```
	@Autowired
	private PersonBean personBean;
```

3. Servelt的上下文配置-WebConfig
给类添加了注解@Configuration，表示这是一个配置类
给类添加了注解@EnableWebMvc，表示这个配置类实现了Spring MVC的配置
给类添加了注解@ComponentScan(basePackages = { "com.wangguitang.freedom.study.spring.javaconfig.controller" }),设置了会自动扫描的包
这样子，类LoginController就能够被扫描并注册了。因为其使用了注解@RestController。

还定义了一个消息解析器，使用的是阿里巴巴的fastjson提供的FastJsonHttpMessageConverter,用于把请求从json转换为对象，返回数据时，把对象转换为json
```

	/**
	 * 新增一个消息转换器
	 * @param converters
	 * @author freedom wang
	 * @date 2018年4月17日上午10:09:27
	 * @since 3.0.0
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
```
