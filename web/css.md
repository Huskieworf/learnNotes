##### [列表属性list-style-type](http://www.runoob.com/cssref/pr-list-style-type.html)

##### [CSS list-style 属性](http://www.runoob.com/cssref/pr-list-style.html)

* initial

- 空格，目录编码20%，用于路径之类

- <em></em>文本斜体标签

- 创建链接和锚

  - 设置锚的id，在链接中url+#idname跳转，当前页面省略url。

- <a>标签[rel属性](http://www.runoob.com/tags/att-a-rel.html)

- [text-decoration设置文本装饰]( http://www.runoob.com/cssref/pr-text-text-decoration.html)

- [font所有属性值](http://www.runoob.com/cssref/pr-font-font.html )

  - font-style

  - font-weight(字体粗细，不改变字体大小)

  - line-height

  - font-family（

    font-family 可以把多个字体名称作为一个"回退"系统来保存。如果浏览器不支持第一个字体，则会尝试下一个。）

    - [五种字体家族](https://www.cnblogs.com/hunter001/articles/2076102.html)

  - font-size 

  - ```
    - <p "font:caption">浏览器使用 captioned 控件。</p>
      <p style="font:icon">浏览器使用 icon 标签。</p>
      <p style="font:menu">浏览器使用被下拉列表使用的字体。</p>
      <p style="font:message-box">浏览器使用被对话框使用的字体。</p>
      <p style="font:small-caption"> caption 字体的小型版本。</p>
      <p style="font:status-bar">浏览器使用被窗口状态栏使用的字体。</p>
      <p><b>注意：</b>字体的呈现效果依赖于浏览器。</p>
    - <pre></pre>标签
    ```

    ​


- <hr>水平分割线

- <br>

- <address></address>

- <blockquote></blockquote>标签与<q id=" " cite="url"></q> 

- 短语标签

  - <em>强调文本</em><br>
    <strong>加粗文本</strong><br>
    <dfn>定义项目</dfn><br>
    <code>一段电脑代码</code><br>
    <samp>计算机样本</samp><br>
    <kbd>键盘输入</kbd><br>
    <var>变量</var>

- mark标签：突出文本

- 特出字符的字符实体

  - http://www.utf8-chartable.de/

- 居中

  - text-align :center 设置div中文本居中
  - margin：auto,设置div在页面中居中（将margin-left和margin-right设置为auto，将实现水平居中）

- 控制大小

  - 为了正确显示，用min-width ,min-height,max-width,max-height.
  - overview :scroll,auto ,hidden ,visible .

- 浮动和消除浮动

  - float :right ,left,none;文本将环绕文本元素。
  - clear：right，left，none，both。

- 其他选择器

  - 后代选择器

    - ``` Java script 
      p span.classname { font-weight : bold;}，p 和 span都匹配
      ```

  - 子代选择器

    - ``` Java script 
      p > span.classname { font-weight:bold;}//子代选择器更加严格，都符合才会被控制
      ```

  - 兄弟选择器

    - 如h1 + p，与h1的第一个p段落匹配。
    - h1 ~ p ，与h1 标签里的所有段落都匹配。

- [伪类](https://developer.mozilla.org/zh-CN/docs/Web/CSS/Pseudo-classes)

  - first-letter，指定元素的首字母样式

  - hover

    - 用hover创建一个下拉列表

      ``` javascript
      //CSS 部分
      div.menu-bar ul ul {
        display: none;
      }

      div.menu-bar li:hover > ul {
        display: block;
      }

      //HTML 部分
      <div class="menu-bar">
        <ul>
          <li>
            <a href="example.html">Menu</a>
            <ul>
              <li>
                <a href="example.html">Link</a>
              </li>
              <li>
                <a class="menu-nav" href="example.html">Submenu</a>
                <ul>
                  <li>
                    <a class="menu-nav" href="example.html">Submenu</a>
                    <ul>
                      <li><a href="example.html">Link</a></li>
                      <li><a href="example.html">Link</a></li>
                      <li><a href="example.html">Link</a></li>
                      <li><a href="example.html">Link</a></li>
                    </ul>
                  </li>
                  <li><a href="example.html">Link</a></li>
                </ul>
              </li>
            </ul>
          </li>
        </ul>
      </div>
      ```

  - default

    ``` javascript
    // html
    <input type="radio" name="season" id="spring">
    <label for="spring">Spring</label>

    <input type="radio" name="season" id="summer" checked>
    <label for="spring">Summer</label>

    <input type="radio" name="season" id="fall">
    <label for="spring">Fall</label>

    <input type="radio" name="season" id="winter">
    <label for="spring">Winter</label>

    //CSS 
    input:default {
      box-shadow: 0 0 2px 1px coral;
    }

    input:default + label {
      color: coral;
    }
    ```

  - dir控制文本的书写方 向，取值有ltr,rtr。

- 属性选择器

  ```javascript
  //以下选择器和p.classname 等效，但更重要的是，属性选择器可以根据属性名和值来选择元素
  p[class ="classname"]{property: value;}

  //匹配以空格分隔的属性值列表
  p[class  =~ "classname1"]{property:value；}
  //和下列代码等效
  <p class = "classname classname1">This is a paragraph<p>
    
  //可以不指定属性值
  p[class] {property: value;} 
  ```






##### 第九章：在网页中使用图像

- 在线图片编辑网站

  - http://pixlr.com
  - www.picmonkey.com

- software

  - PS 
  - IrfanView

- 设置图像对齐方式，属性vertical-align

  - baseline: 图像下边缘与文本基线对齐
  - middle
  - bottom
  - text-bottom
  - top： 图像下边缘与文本上边缘对齐
  - text-top ：上边缘与文本上边缘对齐
  - sub
  - sup 上标形式
  - length： 指定特定的距离
  - %，已line-height为基准调整

- 图片作为背景

  - 在元素中写:background-image: url(“image_address”)
  - background-repeat : repeat , repeat-x ,repeat-y, no-repeat.
  - background-position :两个百分比数值，或者（left，center，right）（left ,center ,right ）只写一个，另一个默认center。
  - background-attachment :scroll (default ),fixed ,local .

- list-style-image ,将图像作为列表符号。一般还设置list-style-type，找不到图像时使用[项目符号样式](http://www.runoob.com/cssref/pr-list-style-type.html)

- map创建图像映射（图像不同的部分，不一样的链接）

  - ```javascript
    <img src="planets.gif" width="145" height="126" alt="Planets" usemap="#planetmap">

    <map name="planetmap">//name是map必需的属性
      <area shape="rect" coords="0,0,82,126" alt="Sun" href="sun.htm">
      <area shape="circle" coords="90,58,3" alt="Mercury" href="mercur.htm">
      <area shape="circle" coords="124,58,8" alt="Venus" href="venus.htm">
    </map>
    ```

  - shape：

    ``` javascript
    <area shape="default|rect|circle|poly">
    ```



-   - coords坐标

    - shape为rect,*x1,y1,x2,y2*，该值规定矩形左上角和右下角的坐标
    - 如果 shape 属性设置为 "circ"，则该值规定圆心的坐标和半径。
    - x1,y1,x2,y2,..,xn,yn，如果 shape 属性设置为 "poly"，则该值规定多边形各顶点的值。如果第一个坐标和最后一个坐标不一致，那么为了关闭多边形，浏览器必须添加最后一对坐标。

-   ``` javascript
          <style>
          ul 
          {
          	list-style-image:url('sqpurple.gif');
          }
          ul.a {list-style-type:circle;}
          ul.b {list-style-type:square;}
          ol.c {list-style-type:upper-roman;}
          ol.d {list-style-type:lower-alpha;}
          </style>
    ```

    - 确定区域软件

      - Mapedit 
      - www.image-maps.com      

##### 第十章 使用表格

```javascript

<table border="1" cellspacing="8">          //border设置表格边框大小,cellspacing单元格间距
  <caption>表格标题</caption> //表格标题
  <caption>
  	<details>				//默认隐藏，用户点击展开
  		<summary>表格摘要</summary>
		<p>表格详细描述</p>
  	</details>
  </caption>
  <tr>                      //tr行标签
    <th>Month</th>          //th元素head标签
    <th>Savings</th>		//td元素标签
  </tr>
  <tr>
    <td colspan="2">January</td>  //跨越多列
    <td>$100</td>
  </tr> 
  <tr>
    <td rowspan="2">February</td> //跨越多行
    <td>$80</td>
  </tr>
  <tr>
	 <td>$90</td> 
  </tr>	 
</table>

将列编组，设置列的样式.

  <table>
  <colgroup span="2" style="background:red"></colgroup>
  <colgroup span="4 " style="background:green">
    <col span="1" style="width:50px;">
    <col span="2" style="width:20px;">
    <col span="1" style="width:30px;">    
  </colgroup>
  </table>

<thead>标签

<tbody>

<tfoot>
```

##### 第十一章 使用CSS元素



