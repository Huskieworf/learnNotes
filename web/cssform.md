```javascript
<form action="URL" method=post>

</form>
```

**post：**不会将表单数据提交到URL末尾，将URL和数据一起发给服务器。

**get：**将表单数据提交到URL末尾，并用问号分开。

表单字段的字段，都应该使用<label>标签，并设置for属性，包含时则不用。

```javascript
<label for="control" >Who is your favorite girl?</label>
<input type="text" id="control"> 
<input type="text" id="contr" name="contr" size="15" maxlength="15" minlength="5" value="Enter your text ">
<!-- 等同于 --->
<label>Who is your favorite girl?<input type="text"> </label>

```

**value**作为数去前默认显示时，如果用户没有更新输入，在提交表单时value值也会被提交。如果不想被提交，可使用属性**placeholder**。（长度尽量不超过size）

用户必填项可以添加属性**required**。

```
<input id="idname" required>
```

使用**datalist**给文本字段添加可供选择的值。

```javascript
<form>
<input list="browsers" name="browser">
<datalist id="browsers">
    <option value="Internet Explorer">
    <option value="Firefox">
    <option value="Chrome">
    <option value="Opera">
    <option value="Safari">
</datalist>
</form>
```

