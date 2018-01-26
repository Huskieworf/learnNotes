##### File类

```
public class File
     
      extends 
      Object
     
     
      implements 
      Serializable, 
      Comparable<File>
```
-  对于 UNIX 平台，绝对路径名的前缀始终是 `"/"`。相对路径名没有前缀。表示根目录的绝对路径名的前缀为 `"/"` 且名称序列为空。 
-  对于 Microsoft Windows 平台，包含盘符的路径名前缀由驱动器号和一个 `":"` 组成。如果路径名是绝对路径名，还可能后跟 `"\\"`。UNC 路径名的前缀是 `"\\\\"`；主机名和共享名是名称序列中的前两个名称。没有指定驱动器的相对路径名没有前缀。 

**`File` 类的实例是不可变的；也就是说，一旦创建，`File` 对象表示的抽象路径名将永不改变。** 

静态成员变量：

 **static   String 	separator**

  与系统有关的默认名称分隔符，为了方便，它被表示为一个字符串。

**static   char 	separatorChar**

  与系统有关的默认名称分隔符。

方法：

 **boolean 	canExecute()**
  测试应用程序是否可以执行此抽象路径名表示的文件。


 **boolean 	canRead()**
测试应用程序是否可以读取此抽象路径名表示的文件。


 **boolean 	canWrite()**
测试应用程序是否可以修改此抽象路径名表示的文件。


 **boolean 	delete()**
删除此抽象路径名表示的文件或目录。


 **boolean 	equals(Object obj)**
测试此抽象路径名与给定对象是否相等。


 **boolean 	exists()**
测试此抽象路径名表示的文件或目录是否存在。


 **File 	getAbsoluteFile()**
返回此抽象路径名的绝对路径名形式。


 **String 	getAbsolutePath()**
返回此抽象路径名的绝对路径名字符串。


 **File 	getCanonicalFile()**
返回此抽象路径名的规范形式。


 **String 	getCanonicalPath()**
返回此抽象路径名的规范路径名字符串。


 **String 	getName()**
返回由此抽象路径名表示的文件或目录的名称。
 

**String 	getParent()**
返回此抽象路径名父目录的路径名字符串；如果此路径名没有指定父目录，则返回 null。


 **File 	getParentFile()**
 返回此抽象路径名父目录的抽象路径名；如果此路径名没有指定父目录，则返回 null。


 **String 	getPath()**
 将此抽象路径名转换为一个路径名字符串。


 **boolean 	isAbsolute()**
测试此抽象路径名是否为绝对路径名。


 **boolean 	isDirectory()**
测试此抽象路径名表示的文件是否是一个目录。


 **boolean 	isFile()**
测试此抽象路径名表示的文件是否是一个标准文件。


 **boolean 	isHidden()**
测试此抽象路径名指定的文件是否是一个隐藏文件。


 **long 	lastModified()**
返回此抽象路径名表示的文件最后一次被修改的时间。


 **long 	length()**
返回由此抽象路径名表示的文件的长度。


 **String[] 	list()**
返回一个字符串数组，这些字符串指定此抽象路径名表示的目录中的文件和目录。



 **File[] 	listFiles()**
返回一个抽象路径名数组，这些路径名表示此抽象路径名表示的目录中的文件。

 
**static File[] 	listRoots()**
列出可用的文件系统根。
 **boolean 	mkdir()**
创建此抽象路径名指定的目录。
 **boolean 	mkdirs()**
创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。

 **String 	toString()**
 返回此抽象路径名的路径名字符串。


 **URI 	toURI()**
构造一个表示此抽象路径名的 file: URI。
 **URL 	toURL()**
**已过时**。 此方法不会自动转义 URL 中的非法字符。建议新的代码使用以下方式将抽象路径名转换为 URL：首先通过 toURI 方法将其转换为 URI，然后通过 URI.toURL 方法将 URI 装换为 URL。



 boolean 	renameTo(File dest)
重新命名此抽象路径名表示的文件。
 boolean 	setExecutable(boolean executable)
设置此抽象路径名所有者执行权限的一个便捷方法。
 boolean 	setExecutable(boolean executable, boolean ownerOnly)
设置此抽象路径名的所有者或所有用户的执行权限。
 boolean 	setLastModified(long time)
设置此抽象路径名指定的文件或目录的最后一次修改时间。
 boolean 	setReadable(boolean readable)
设置此抽象路径名所有者读权限的一个便捷方法。
 boolean 	setReadable(boolean readable, boolean ownerOnly)
设置此抽象路径名的所有者或所有用户的读权限。
 boolean 	setReadOnly()
标记此抽象路径名指定的文件或目录，从而只能对其进行读操作。
 boolean 	setWritable(boolean writable)
设置此抽象路径名所有者写权限的一个便捷方法。
 boolean 	setWritable(boolean writable, boolean ownerOnly)
设置此抽象路径名的所有者或所有用户的写权限。







