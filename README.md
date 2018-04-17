# freedom-study-parent
此项目为一些技术学习、技术验证的项目。

## 项目概略
* freedom-study-parent **父模块** **pom**
	* freedom-study-solrj **验证使用solrj访问solr** **jar**
	* freedom-study-jquery **jquery的学习项目** *war*
	* freedom-study-spring **spring技术学习相关的项目** **pom**
		* freedom-study-spring-javaconfig **spring mvc java config 验证** **war**
		* freedom-study-spring-message-converter **spring mvc 消息转换器学习** **war**
		
## 导入到Eclipse的方法
1. 先把项目Fork到自己的仓库
2. 确保Eclipse拥有git插件
3. 选择`File-->Import...`
4. 选择`Projects from Git`
5. 选择`Clone URI`
6. 在URI输入框中输入URI，通常是：`网址+.git`,比如我需要输入：`https://github.com/wang465745776/freedom-study-parent.git`
7. 输入User和Password,点击Next
8. 选择分支master,点击Next
9. 设置Directory为项目放置的地方，点击Next
10. 选择`Import as general project`，点击Next
11. 设置项目名称为`freedom-study-parent`，点击Finish
12. 选择`File-->Import...`
13. 选择`Existing Maven Projects`
14. 在`Root Directory`选择框中，选择`freedom-study-parent`项目放置的位置，下面Projects框中会出现其所拥有的子模块，将这些子模块的复选框选中
15. 选中`Add project(s) to working set`复选框，并在下面的输入框中输入`freedom-study-parent`，此操作用于将所有的子模块都将加入到`freedom-study-parent`工作集中，方便管理
16. 点击Finish
17. 在`Package Explorer`界面中将`freedom-study-parent`项目也拖到`freedom-study-parent`工作集中
18. 右键`freedom-study-parent`项目，选择`Configure-->Convert to Maven Project`
