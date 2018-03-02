##### 1. 浅拷贝和深拷贝

​	如果想要深拷贝一个对象， 这个对象必须要实现Cloneable接口，实现clone方法，并且在clone方法内部，把该对象引用的其他对象也要clone一份 ， 这就要求这个被引用的对象必须也要实现Cloneable接口并且实现clone方法。 

​	浅拷贝是指在拷贝对象时，对于基本数据类型的变量会重新复制一份，而对于引用类型的变量只是对引用进行拷贝，没有对引用指向的对象进行拷贝。而深拷贝是指在拷贝对象时，同时会对引用指向的对象进行拷贝。区别就在于是否对 对象中的引用变量所指向的对象进行拷贝。

##### 2.==和equals的区别

​	使用==比较原生类型如：boolean、int、char等等，使用equals()比较对象。

​	如果两个引用指向相同的对象，==返回true；equals()的返回结果依赖于具体业务实现

 	字符串的对比使用equals()代替==操作符。

​	ps：instanceof是Java的一个二元操作符，和==，>，<是同一类东东。由于它是由字母组成的，所以也是Java的保留关键字。它的作用是测试它左边的对象是否是它右边的类的实例，返回boolean类型的数据。举个例子：

　　String s = "I AM an Object!";
　　boolean isObject = s instanceof Object;

##### 3.自动装箱和拆箱机制

​	自动装箱就是Java自动将原始类型值转换成对应的对象，比如将int的变量转换成Integer对象，这个过程叫做装箱，反之将Integer对象转换成int类型值，这个过程叫做拆箱。因为这里的装箱和拆箱是自动进行的非人为转换，所以就称作为自动装箱和拆箱。

​	原始类型byte,short,char,int,long,float,double,boolean。

​	对应的封装类型Byte,Short,Character,Integer,Long,Float,Double,Boolean。

​	自动装箱有一个问题，那就是在一个循环中进行自动装箱操作的情况，如下面的例子就会**创建多余的对象**，影响程序的性能。

```
Integer sum = 0;
 for(int i=1000; i<5000; i++){
   sum+=i;
}
```



##### 4.java异常体系。受检异常，运行时异常，封装一个API的时候什么情况下抛出异常？

CheckedException

除了runtimeException以外的异常，都属于checkedException，它们都在java.lang库内部定义。Java编译器要求程序必须捕获或声明抛出这种异常。

常见的受检异常：

- ClassNotFoundException
- CloneNotSupportedException
- InterruptedException
- IOException（是吧？
- ）

RuntimeException

运行时异常是可能被程序员避免的异常。与检查性异常相反，运行时异常可以在编译时被忽略

常见的运行时异常：

- ArithmeticException（比如除数为0）
- ArrayIndexOutOfBoundsException（访问数组越界）
- NullPointerException（空指针异常，访问一个值为null的对象的方法或值）
- NumberFormatException。当应用程序试图将字符串转换成一种数值类型，但该字符串不能转换为适当格式时，抛出该异常
- ​

##### 5.String常量池，可变类和不可变类。

​	Java中字符串对象创建有两种形式，一种为字面量形式，如String str = "droid";，另一种就是使用new这种标准的构造对象的方法，如String str = new String("droid");

	>   String str1 = "droid";
	>
	>   JVM检测这个字面量，这里我们认为没有内容为`droid`的对象存在。JVM通过字符串常量池查找不到内容为`droid`的字符串对象存在，那么会创建这个字符串对象，然后将刚创建的对象的引用放入到字符串常量池中,并且将引用返回给变量str1。
	>
	>   同样JVM还是要检测这个字面量，JVM通过查找字符串常量池，发现内容为”droid”字符串对象存在，于是将已经存在的字符串对象的引用返回给变量str2。
	>
	>   System.out.println(str1 == str2);
	>
	>   结果为`true`。
	>
	>   这种形式建立在String类不可变上。
	>
	>   String str3 = new String("droid");
	>
	>   当我们使用了new来构造字符串对象的时候，不管字符串常量池中有没有相同内容的对象的引用，新的字符串对象都会创建。
	>
	>   String str3 = new String("droid");
	>   System.out.println(str1 == str3);
	>
	>   结果为`false`
	>
	>   对于上面使用new创建的字符串对象，如果想将这个对象的引用加入到字符串常量池，可以使用intern方法。
	>
	>   调用intern后，首先检查字符串常量池中是否有该对象的引用，如果存在，则将这个引用返回给变量，否则将引用加入并返回给变量。
	>
	>   String str4 = str3.intern();
	>   System.out.println(str4 == str1);
	>
	>   输出的结果为`true`。

可变类和不可变类(Mutable and Immutable Objects)的初步定义： 
可变类：当你获得这个类的一个实例引用时，你可以改变这个实例的内容。 
不可变类：当你获得这个类的一个实例引用时，你不可以改变这个实例的内容。不可变类的实例一但创建，其内在成员变量的值就不能被修改。 
举个例子：String和StringBuilder，String是immutable的，每次对于String对象的修改都将产生一个新的String对象，而原来的对象保持不变，而StringBuilder是mutable，因为每次对于它的对象的修改都作用于该对象本身，并没有产生新的对象。



##### 6.Hash冲突，常见的解决方法。HashMap在高并发的情况下不当使用，会导致什么极端情况？

1.开放定址法：当关键码的散列地址一旦产生冲突，就去寻找下一个空的散列地址。它的方法主要有以下三种：

> 1.线性探测：对于键值key，设H(key)=d，避散列表的长度为m，当发生冲突时，寻找下一个的单列地址为
> Hi=（H(key)+di）%m ；di=1,2,3,...m
> 2.二次探测：散列地址公式：
> Hi=（H(key)+di）%m (di=1,-1,4,-4.....,q的平法且q<m/2)
>
> 线性补偿探测法的基本思想是：将线性探测的步长从 1 改为 Q ,要求 Q 与 m 是互质的，以便能探测到哈希表中的所有单元。
>
> 3.随机探测：
> Hi=（H(key)+di）%m;di是一个随机数列。

2.拉链法：Java中的HashMap采用这中算法。

![img](http://img.blog.csdn.net/20150316234322762?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQva2luZ3ptYQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

3.公共溢出区

散列表包含基本表和溢出表，将发起冲突的记录存储在溢出表。查找时，对给定通过散列函数计算散列地址，如果基本表相应单元中的值相等，则查找成功，否则去溢出表中按顺序查找。

4.再散列（双重散列，多重散列）

当发生冲突时，使用第二个、第三个、哈希函数计算地址，直到无冲突时。缺点：计算时间增加。



如ArrayList、LinkedList、HashMap、HashSet和StringBuilder等等。首先，如果没有写操作，那么这些都是线程安全的，只有读写同时发生时才会出现不安全的情况。

**以HashMap为例，会导致数据错乱，丢失数据，极端情况下会导致死循环。**

> ①HashMap的数据结构
>
> 实际存储过程中，HashMap是一个数组，每个数组元素存储了一个单向链表的头，后面挂着一个单向链表。链表的每个元素都是一个Entry（包含了key，value，Next引用，Hash值），无论是get还是put操作都会先根据传入对象的hashCode找到数组的下标，然后根据该数组元素对应的单向链表找到指定的Entry——即Entry的key和传入对象的key是一致的。若到了链表的尾部都未找到，就返回null。
>
> ②rehash
>
> 如果插入节点的时候，Hash表的节点总数大于threshold，就会resize这个数组，即数组大小会发生扩容，通常扩容为原来的2倍。扩容过程中会导致同样的元素计算出的数组下标发生变化，所以需要遍历所有的Hash表的所有节点，即遍历每一个单向链表，每个节点按照新的hash表来结算自己的位置，逐个迁移到新的hash表上来，该过程叫做rehash。
>
> ③两个线程插入同样的key
>
> 两个线程同时写入相同key，因为在判断的时候，这两个线程都发现这个key不存在，而key相同，识别出的下标也相同，说明在同一个链表当中，这时如果value不同，那么就违背了hash表中要求数据不允许重复的规定，叫做数据错乱。
>
> ④两个线程同时插入两个不同的key，但是key的hash相同
>
> 两个线程同时写入不同的key，但是key的hash相同，所以写入相同的数组元素对应的链表中。链表表头写入操作会将新的元素的next指向原先的第一个链表位置，最后再将头指针指向新的元素，那么这两个同时插入新元素肯定会丢一个。
>
> ⑤两个线程同时写入的时候发生rehash
>
> 线程A写入数据，发现需要rehash，在rehash某个数组元素对应的链表的时候，另一个线程进行了对这个链表的插入操作，但是A做rehash时不知道这个元素，所以这个元素就丢了。
>
> 如果B线程写入数据后，A的rehash还没完成，由于Table引用还未修改，看到的依然是老的数组，发现长度不够，也要做rehash，即基于老数组做rehash。这个过程中线程A做完rehash后将Table引用修改为A创建的新数组，B还在做rehash，所以不知道A创建的新Hash表是否发生了写入操作。在B做rehash的时间里，新的写入时对A创建的数组进行的（一个HashMap只有一个table，此时table引用指向了A创建的数组，一会儿就指向B创建的数组了），B在rehash后依然会将Table引用修改到B创建的数组上，所以期间所有的写入数据都会丢失！
>
> 即使数据不丢失，如果多个线程同时做rehash，在JVM中会创建非常多的垃圾内存。
>
> ⑥死循环
>
> resize的transfer方法会导致同一个链表中的不同entry相互指向，这样在查找的时候就会发生死循环。
>
> [Java之HashMap在多线程情况下导致死循环的问题](http://www.cnblogs.com/RGogoing/p/5285361.html)

##### 7.HashMap和Hashtable谁是线程安全的。

Hashtable。(尴尬的命名)

ps：HashMap不是线程安全的；Hashtable 线程安全，但效率低，因为是 Hashtable 是使用 synchronized 的，所有线程竞争同一把锁；而 ConcurrentHashMap 不仅线程安全而且效率高，因为它包含一个 segment 数组，将数据分段存储，给每一段数据配一把锁，也就是所谓的锁分段技术。

ConcurrentHashMap，JDK8的版本与JDK6的版本有很大的差异。实现线程安全的思想也已经完全变了，它摒弃了Segment（锁段）的概念，而是启用了一种全新的方式实现,利用CAS算法。它沿用了与它同时期的HashMap版本的思想，底层依然由“数组”+链表+红黑树的方式思想，但是为了做到并发，又增加了很多辅助的类，例如TreeBin，Traverser等对象内部类。

##### 8.HashMap/ConcurrentHashMap数据结构实现，扩容机制。

HashMap默认初始化数组的大小为16，HashTable为11。前者扩容时乘2，使用位运算取得哈希，效率高于取模。而后者为乘2加1，都是素数和奇数，这样取模哈希结果更均匀。

HashMap数据结构

``` Java 
transient  Node<K,V>[] table;
static class Node<K,V> implements Map.<Entry><K,V>{
  		
  		final int hash;
        final K key;
        V value;
        Node<K,V> next;
  
  
        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }
        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }
        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }
        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                if (Objects.equals(key, e.getKey()) &&
                    Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
}
```



##### 9.ArrayList和LinkedList的区别

​     1.ArrayList是实现了基于动态数组的数据结构，LinkedList基于链表的数据结构。 
​     2.对于随机访问get和set，ArrayList觉得优于LinkedList，因为LinkedList要移动指针。 
​     3.对于新增和删除操作add和remove，LinedList比较占优势，因为ArrayList要移动数据。

##### 10.拷贝数组的方式，clone，system.arraycopy，哪个效率最高。

system.arraycopy最高，clone次之，for循环效率最低。

##### 11.http协议，在设计http接口时需要考虑什么问题？

？？？？状态码，重定向，客户端错误， 服务器错误，错误处理，数据缓存，并发控制，User-Agent等等

[http协议设计指南](http://hai0378.iteye.com/blog/2270071)

##### 12.常见的通信协议

TCP/IP是个协议组，可分为四个层次：网络接口层、网络层、传输层和应用层。
在网络层有IP协议、ICMP协议、ARP协议、RARP协议和BOOTP协议。
在传输层中有TCP协议与UDP协议。
在应用层有FTP、HTTP、TELNET、SMTP、DNS等协议。

##### 13.http的各个method的语义

options：

OPTIONS方法表明请求想得到请求/响应链上关于此请求里的URI（Request-URI）指定资源的通信选项信息。此方法允许客户端去判定请求资源的选项和/或需求，或者服务器的能力，而不需要利用一个资源动作

get：

GET方法意思是获取被请求URI（Request-URI）指定的信息（以实体的格式）

 head：

HEAD方法和GET方法一致，除了服务器不能在响应里返回消息主体。HEAD请求响应里HTTP头域里的元信息应该和GET请求响应里的元信息一致。此方法被用来获取请求实体的元信息而不需要传输实体主体（entity-body）。此方法经常被用来测试超文本链接的有效性，可访问性，和最近的改变。.

post：

POST 方法被用于请求源服务器接受请求中的实体作为请求资源的一个新的从属物

put：

PUT方法请求服务器去把请求里的实体存储在请求URI（Request-URI）标识下。

delete：

DELETE方法请求源服务器删除请求URI指定的资源。

trace：

TRACE方法被用于激发一个远程的，应用层的请求消息回路（译注：TRACE方法让客户端测试到服务器的网络通路，回路的意思如发送一个请返回一个响应，这就是一个请求响应回路，）。

connect：

此方法是为了能用于能动态切换到隧道的代理服务器



##### 14.HTTP/2

多路复用：

多路复用允许同时通过单一的 HTTP/2 连接发起多重的请求-响应消息。

二进制分帧：

在二进制分帧层中， HTTP/2 会将所有传输的信息分割为更小的消息和帧（frame）,并对它们采用二进制格式的编码，其中 HTTP1.x 的首部信息会被封装到 HEADER frame，而相应的 Request Body  则封装到 DATA frame 里面。HTTP/2 通信都在一个连接上完成，这个连接可以承载任意数量的双向数据流。

首部压缩：

 HTTP/2 则使用了专门为首部压缩而设计的 [HPACK](https://link.zhihu.com/?target=http%3A//http2.github.io/http2-spec/compression.html) 算法。

服务端推送（Server Push）：

服务端推送是一种在客户端请求之前发送数据的机制。在 HTTP/2 中，服务器可以对客户端的一个请求发送多个响应。

##### 15.https的实现

HTTPS 和HTTP 协议相比提供了：

- 数据完整性：内容传输经过完整性校验
- 数据隐私性：内容经过对称加密，每个连接生成一个唯一的加密密钥
- 身份认证：第三方无法伪造服务端（客户端）身份

![https实现](C:\Users\Administrator\Desktop\webclass\day2018.3.1\https实现.png)

1. **客户端发起https请求**。SSL  连接总是由客户端启动，在 SSL  会话开始时，执行 SSL  握手。用户在浏览器里输入一个https 网址，然后连接到server 的443 端口。
2. **服务器端的配置。**采用HTTPS 协议的服务器必须要有一套数字证书，可以自己制作，也可以向组织申请。区别就是自己颁发的证书需要客户端验证通过，才可以继续访问，而使用受信任的公司申请的证书则不会弹出提示页面。这套证书其实就是一对公钥和私钥。
3. **传送证书。**服务器端返回以下：服务器端选出的一套加密算法和 Hash  算法；服务器生成的随机数 `server_random``SSL`  数字证书（服务器使用带有 `SSL`  的 `X.509 V3`  数字证书），这个证书包含网站地址，公钥 `public_key` ，证书的颁发机构，过期时间等等。
4. **客户端解析证书。**1，验证证书有效性；2.如果证书没有问题，那么浏览器根据步骤 3 的 `server_random`  生成一个随机值 `premaster_secret` （前 2 个字节是协议版本号，后 46 字节是用在对称加密密钥的随机数字）和 `master_secret 。 master_secret`  的生成需要 `premaster_key` ，并需要 `client_random`  和 `server_random`  作为种子。现在，各方面已经有了主密钥 `master_secret` ，根据协议约定，我们需要利用`PRF` 生成这个会话中所需要的各种密钥，称之为“密钥块”（Key Block ）。
5. **客户端传送加密信息。**客户端发送公钥 `public_key`  加密的 `premaster secret` 。目的就是让服务端得到这个随机值，以后客户端和服务端的通信就可以通过这个随机值来进行加密解密了。
6. **服务端解密信息**
7. **服务器传送加密信息**
8. **客户端解密信息**

##### 16.编译装载链接初始化的过程

​	java从源文件到程序运行需要经历两个步骤
​	.java文件经过最初的编译成为.class字节码，成为机器识别的二进制语言。
​	.class文件由JVM解释成所对应不同的硬件平台操作系统能够执行的代码。 
​	（编译器是与平台无关，编译生成的中间码也与平台无关（一次编译，到处运行），中间码再由解释器解释执行，解释器是与平台相关的，也就是不同的平台需要不同的解释器.java程序也通过运行在不同jvm上实现跨平台）

解释有以下的三个步骤

- 装载：通过classLoader 把字节码文件装载到内存中，程序只有加载到内存才能运行。创建对应类的实例，在堆区建立一个java.lang.Class对象。
- 链接：链接又分为以下三个步骤 
  - 验证：验证内存中的字节码文件是否符合jvm规范，符合规范的文件才能够在javm下运行
  - 准备： 将类的成员变量分配内存空间，初始化默认值。（虽然类的变量有初始值，但此时不会对变量进行初始化）（对于类的成员变量，不管程序有没有显式的进行初始化，Java虚拟机都会先自动给它初始化为默认值。但是局部变量，java虚拟机就不会对他进行默认初始化，所以声明时必须对它进行显示初始化）
  - 解析：为类、接口、方法、成员变量的符号引用定位直接引用。
- 初始化：按照顺序执行静态代码块，将类的静态变量赋予正确的初始值（这个初始值是显示初始化的值，没有显示初始化的值还是系统为他分配的默认值），只有当类第一次主动使用时（new，反射，初始化子类等…）才会去初始化类 

假如这个类还没有被加载和连接，那就先进行加载和连接。初始化一定在加载链接之后，如果父类还没有被初始化，那就先初始化父类。（接口的初始化，不会引起父类接口的初始化），依次执行初始化语句。 

##### 17.多态的实现

父类引用调用子类的方法。

满足的三个条件：1，继承	2，子类重写父类方法	3，向上转型

##### 18.对oop的理解

**封装**

​	隐藏内部细节，要访问该类的代码和数据，必须通过严格的接口控制。封装最主要的功能在于我们能修改自己的实现代码，而不用修改那些调用我们代码的程序片段。

**继承**

​	继承就是子类继承父类的特征和行为，使得子类对象（实例）具有父类的实例域和方法，或子类从父类继承方法，使得子类具有父类相同的行为。

**多态**

​	多态是同一个行为具有多个不同表现形式或形态的能力。比如对于打印机的打印这个行为，彩色打印机会进行彩色打印，黑白打印机则进行黑白打印。

##### 19.动态类型语言和静态类型语言的区别，强类型和弱类型语言。

- *trapped errors*。导致程序终止执行，如除0，Java中数组越界访问
- *untrapped errors*。 出错后继续执行，但可能出现任意行为。如C里的缓冲区溢出、Jump到错误地址
- 语言设计时，可以定义一组*forbidden behaviors*. 它必须包括所有untrapped errors, 但可能包含trapped errors.


- *well behaved*: 如果程序执行不可能出现forbidden behaviors, 则为*well behaved*。
  - *ill behaved: 否则为ill behaved...*

*强类型strongly typed*: 如果一种语言的所有程序都是well behaved——即不可能出现forbidden behaviors，则该语言为strongly typed。

*弱类型weakly typed*: 否则为weakly typed。比如C语言的缓冲区溢出，属于trapped errors，即属于forbidden behaviors..故C是弱类型。

*静态类型 statically*: 如果在编译时拒绝ill behaved程序，则是statically typed;

*动态类型dynamiclly*: 如果在运行时拒绝ill behaviors, 则是dynamiclly typed。

无类型： 汇编
弱类型、静态类型 ： C/C++
弱类型、动态类型检查： Perl/PHP
强类型、静态类型检查 ：Java/C#
强类型、动态类型检查 ：Python, Scheme
静态**显式**类型 ：Java/C
静态隐式类型 ：Ocaml, Haskell

##### 20.常见的代码坏味道有哪些，重构的方法。

[22种代码的坏味道，一句话概括](http://blog.csdn.net/windcao/article/details/25773219)

**1.Duplicated Code(重复的代码)**

难以维护

[解决方法]：提取公共函数

**2.Long Method(过长方法)**

函数过长，难以理解

[解决方法]：拆分成若干函数。

**3.Large Class(过大类)**

类过大，东西太多，难以理解

[解决方法]：拆分成若干类。

**4.Long Parameter List(过长参数列)**

参数多，难用难理解

[解决方法]：将参数封装成结构或者类。

**5.Divergent Change(发散式变化)**

[解决方法]：拆，将总是一起变化的东西放在一块儿。

##### 21.git的简单使用

	> git add
	>
	> git  commit  -m " message"
	>
	> git push  



##### 22.静态代理和动态代理

##### 23.java9的新特性

##### 24.maven中如何规避，解决依赖冲突

##### 25.为什么Boolean.valueOf（success）比return true好？

### 算法

- 字符串相似度匹配（动态规划）
- 打麻将游戏，打一张牌之后服务端算法处理（指针追赶）。
- 链表翻转。
- 找数游戏。从一个数组中找出满足符合条件的元素:它大于或等于前面所有元素,小于或等于后面所有元素
- 一摞烙饼的排序
- 买书问题
- 求二进制数中1的个数
- 寻找发帖“水王”
- 寻找最大的K个数
- 最大公约数问题
- 找符合条件的整数
- 寻找数组中的最大值和最小值
- 快速寻找满足条件的两个数
- 子数组的最大乘积
- 求数组的子数组之和的最大值
- 子数组之和的最大值（二维）
- 求数组中最长递增子序列
- 数组循环移位
- 有一个无序、元素个数为2n的正整数数组，要求：如何能把这个数组分割为两个子数组，子数组的元素个数不限，并使两个子数组之和最接近。
- 区间重合判断
- 字符串移位包含的问题
- 电话号码对应英语单词问题
- 计算字符串的相似度
- 从无头单链表中删除节点
- 最短摘要的生成
- 编程判断两个链表是否相交
- 队列中取最大值操作问题
- 求二叉树中节点的最大距离
- 分层遍历二叉树
- 偶数个数只有两个不是成对出现的，快速定位到这两个不成对的数

### 并发

- 举例Java线程安全的实现方法，原理、区别
- 线程同步的方法
- 线程池原理，使用，调优
- ThreadLocal 作用和实现机制
- Lock与synchronized 的区别,锁的粒度：类级别和对象级别
- 读写锁,CountDownLatch等的使用
- ConcurrentHashMap get是否需要加锁，是如何保证高并发情况下的性能的？(分段锁，hashEntry的final字段结构，segment中volidate类型的count字段的设计)
- 分布式锁的实现方式（redis,zk）
- 代码实现一个读取缓存，缓存失效透传后端的功能。考擦点：如何避免高并发同一key多个同时透传后端，缓存击穿的问题 putifabsent等CAS操作是否会用
- java 之DelayQueue，synchronizedQueue原理
- 普通Java中的ReentrantLock ，countdownLatch实现原理（如何保证高性能），和synchronized 之间的区别。什么时候选择去用它 
- volitale的作用，为什么要指令重排序
- AQS的理解，如何运用
- 还了解concurrent包下的哪些类，使用场景是什么
- 死锁如何产生，如何避免
- 如何理解Java内存模型，及内存可见性

### JVM

- ava的类加载器体系结构和双亲委托机制
- Jvm堆内存区，有两个S区有什么作用，谈下java对象在JVM的生命周期
- 有遇到过OOM么，什么情况，怎么发现的，怎么查原因的
- 线上JVM参数都怎么设置的，为什么要这么设置，什么时候需要调优。
- young gc和full gc触发条件
- 垃圾回收算法及垃圾回收器的选择

jvm内存结构

- FGC的可能原因，以及解决办法。

日常调优的技巧（常见的性能优化策略）

- 如何判断对象存活
- 常见让java服务器挂掉的内存溢出(栈,堆, 持久态)以及原因
- jvm监控工具
- CMS工作原理，相比Paralle GC的优劣
- 有了CMS，为什么还需要G1 GC
- JVM常用参数适用及理解
- 常见的JVM字节码及含义等



### 数据库

- 数据库事务+事务传播机制
- MySQL索引使用的数据结构
- MyISAM,InnoDB有什么区别,各有什么特点
- 慢查询如何分析
- 使用事务的时候应该注意什么？比如事务中不应该有执行时间过长的业务流程。
- 充值和提现，事务如何保证的，或者以银行A/B用户之间转账的例子将一下，这个场景中事务是如何保证的。 (两阶段提交,分布式事务 2.本地事务,本地落地,补偿发送)
- 分布式事务（实时一致性【事务补偿机制】还是【基于消息的最终一致性】最终一致性）
- 联合索引
- 为什么使用B+树做索引(磁盘IO+范围搜索)
- 事务的4个隔离级别？分别存在哪些问题？举例说明
- 有哪些锁？如何解决幻读？
- MVCC机制
- 分库分表的思路





