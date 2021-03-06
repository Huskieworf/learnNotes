##### 一些注释模板

**file：**

``` java
/**  
 * @Title:  ${file_name}   
 * @Package ${package_name}   
 * @Description:    ${todo}(用一句话描述该文件做什么)   
 * @author: Huskie worf     
 * @date:   ${date} ${time}   
 * @version V1.0 
 * @Copyright: ${year} Huskie Worf Inc. All rights reserved. 
 * 注意：本内容仅限于学习交流，禁止用于其他的商业目的
 */
```

**class:**

``` java
/**   
 * @ClassName:  ${type_name}     
 * @author: Huskie worf 
 * @date:   ${date} ${time}   
 * @Copyright: ${year} Huskie Worf Inc. All rights reserved. 
 */
```



**二、注释规范**

**1、   类注释**

在每个类前面必须加上类注释

**2、   属性注释**

在每个属性前面必须加上属性注释，注释模板如下：

```java
/** 提示信息 */

private String strMsg = null;

 

```



**3、   方法注释**

在每个方法前面必须加上方法注释，注释模板如下：

```java
/** 
 * @Title: ${enclosing_method} 
 * ${tags}
 * @return ${return_type}  
 * @throws 
 */
```



**4、   构造方法注释**

``` java
在每个构造方法前面必须加上注释，注释模板如下：

/**
* 构造方法的详细使用说明
* @param 参数1 参数1的使用说明
* @throws 
*
*/
```

 

**5、   方法内部注释**

在方法内部使用单行或者多行注释，该注释根据实际情况添加。

如：//背景颜色

       Color bgColor = Color.RED





Java命名规范

**一、命名规范**

1、 **项目名全部小写**

**2、 包名全部小写**

3**、 类名首字母大写，如果类名由多个单词组成，每个单词的首字母都要大写。**

如：public class MyFirstClass{}

**4、 变量名、方法名首字母小写，如果名称由多个单词组成，每个单词的首字母都要大写。**

如：int index=0;

       public void toString(){}

**5、 常量名全部大写**

如：public static final String GAME_COLOR=”RED”;

6、所有命名规则必须遵循以下规则：

1)、名称只能由字母、数字、下划线、$符号组成

2)、不能以数字开头

3)、名称不能使用JAVA中的关键字。

4)、坚决不允许出现中文及拼音命名。

 