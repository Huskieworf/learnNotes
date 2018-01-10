[TOC]





![img](https://images2015.cnblogs.com/blog/690292/201609/690292-20160923095944481-1758567758.png)



（1）对于public修饰符，它具有最大的访问权限，可以访问任何一个在CLASSPATH下的类、接口、异常等。它往往用于对外的情况，也就是对象或类对外的一种接口的形式。

（2）对于protected修饰符，它主要的作用就是用来保护子类的。它的含义在于子类可以用它修饰的成员，其他的不可以，它相当于传递给子类的一种继承的东西。

（3）对于default来说，有的时候也成为friendly（友员），它是针对本包访问而设计的，任何处于本包下的类、接口、异常等，都可以相互访问，即使是父类没有用protected修饰的成员也可以。

（4）对于private来说，它的访问权限仅限于类的内部，是一种封装的体现，例如，大多数的成员变量都是修饰符为private的，它们不希望被其他任何外部的类访问。

区别：注意：Java的访问控制是停留在编译层的，也就是它不会在.class文件中留下任何的痕迹，只在编译的时候进行访问控制的检查。其实，通过反射的手段，是可以访问任何包下任何类中的成员，例如，访问类的私有成员也是可能的。

（1）public：可以被所有其他类所访问。

（2）private：只能被自己访问和修改。

（3）protected：自身，子类及同一个包中类可以访问。

（4）default（默认）：同一包中的类可以访问，声明时没有加修饰符，认为是friendly。

##### [JAVA中的反射机制](http://blog.csdn.net/liujiahan629629/article/details/18013523)

[反射机制](http://blog.csdn.net/sinat_38259539/article/details/71799078)

##### [如何理解和使用Java package包](http://blog.csdn.net/zhenyusoso/article/details/6174834)

[【java】Static解读和public static void main(String[] args)详细分析](http://blog.csdn.net/lzm18064126848/article/details/50074581)

[重写和重载](https://www.cnblogs.com/bluestorm/archive/2012/03/01/2376236.html)

##### 重载（overloading）：

（1） 方法重载是让类以统一的方式处理不同类型数据的一种手段。多个同名函数同时存在，具有不同的参数个数/类型。

重**载Overloading是一个类中多态性的一种表现。**

    （2） Java的方法重载，就是在类中可以创建多个方法，它们具有相同的名字，但具有不同的参数和不同的定义。

调用方法时通过传递给它们的不同参数个数和参数类型来决定具体使用哪个方法, 这就是多态性。

    （3） 重载的时候，方法名要一样，但是参数类型和个数不一样，返回值类型可以相同也可以不相同。**无法以返回型别作为重载函数的区分标准**。

##### 重写（**Overriding**）

   （1） 父类与子类之间的多态性，对父类的函数进行重新定义。如果在子类中定义某方法与其父类有相同的名称和参数，我们说该方法被重写 (Overriding)。在[Java](http://java.chinaitlab.com/)中，子类可继承父类中的方法，而不需要重新编写相同的方法。

但有时子类并不想原封不动地继承父类的方法，而是想作一定的修改，这就需要采用方法的重写。

方法重写又称**方法覆盖**。

    （2）若子类中的方法与父类中的某一方法具有相同的方法名、返回类型和参数表，则新方法将覆盖原有的方法。

**如需父类中原有的方法，可使用super关键字，该关键字引用了当前类的父类。**

    （3）子类函数的访问修饰权限不能少于父类的；



**重写方法的规则**：

1、参数列表必须完全与被重写的方法相同，否则不能称其为重写而是重载。

2、返回的类型必须一直与被重写的方法的返回类型相同，否则不能称其为重写而是重载。

3、访问修饰符的限制一定要大于被重写方法的访问修饰符（public>protected>default>private）

4、重写方法一定不能抛出新的检查异常或者比被重写方法申明更加宽泛的检查型异常。例如：

父类的一个方法申明了一个检查异常IOException，在重写这个方法是就不能抛出Exception,只能抛出IOException的子类异常，可以抛出非检查异常。

 

**而重载的规则：**

1、必须具有不同的参数列表；

2、可以有不责骂的返回类型，只要参数列表不同就可以了；

3、可以有不同的访问修饰符；

4、可以抛出不同的异常；



##### **eclipse 常用快捷键**

(3)Ctrl+/ 
说明:添加/消除//注释,在eclipse2.0中,消除注释为Ctrl+\

(4)Ctrl+Shift+/ 
说明:添加/* */注释

(5)Ctrl+Shift+\ 
说明:消除/* */注释

(6)Ctrl+Shift+F 
说明:自动格式化代码

(7)Ctrl+1 
说明:批量修改源代码中的变量名,此外还可用在catch块上.

(8)Ctril+F6 
说明:界面切换

(9)Ctril+Shift+M 
说明:查找所需要得包

(10)Ctril+Shift+O 
说明:自动引入所需要得包



##### Object类成员方法

Object类有12个成员方法，按照用途可以分为以下几种 

![Object类的函数](http://img.blog.csdn.net/20161205181623207)



1，构造函数 

2，hashCode和equale函数用来判断对象是否相同, hashCode返回一个哈希值，equale返回一个bool值。

3，wait(),wait(long),wait(long,int),notify(),notifyAll() 

​	notify():唤醒在此对象监视器上等待的单个线程

​	notifyAll():唤醒在此对象监视器上等待的所有线程

​	wait()：在其他线程调用此对象的 notify() 方法或 notifyAll() 方法前，导致当前线程等待。

4，toString()

5，getClass(),返回此 `Object` 的运行时类 

6，clone() 创建并返回此对象的一个副本。

7，finalize()用于在垃圾回收



##### 多态class

含义：指一个引用类型子在不同情况下的不同状态。

另一种理解：指使用父类指针访调用在不同子类中实现的方法。

重要性：多态是面向对象过程中设计代码重用的一个重要机制。

三个必要条件：

- 子类重写父类方法
- 继承或者实现接口
- 父类引用指向子类对象（向上转型）



##### 多态网上查阅

https://www.cnblogs.com/chenssy/p/3372798.html



所谓多态就是指程序中定义的引用变量所指向的具体类型和通过该引用变量发出的方法调用在编程时并不确定，而是在程序运行期间才确定，即一个引用变量倒底会指向哪个类的实例对象，该引用变量发出的方法调用到底是哪个类中实现的方法，必须在由程序运行期间才能决定。因为在程序运行时才确定具体的类，这样，不用修改源程序代码，就可以让引用变量绑定到各种不同的类实现上，从而导致该引用调用的具体方法随之改变，即不修改程序代码就可以改变程序运行时所绑定的具体代码，让程序可以选择多个运行状态，这就是多态性。



##### 多态自己写的代码示例

```java
public abstract class Animal {
	//抽象类可以有也可以没有抽象方法
	public String name;
	public Animal(String name) {
		this.name= name;
	}
	//获得name
	public String getName() {
		return name;
	}
	// 发出叫声
	public abstract void bark();
	
	//吃食物
	public abstract void eat(Food food);
}

public class Cat extends Animal {
	// 构造方法
	public Cat() {
		super("cat");
	}

	// 重写bark方法
	public void bark() {
		System.out.println("猫叫：喵喵喵！！");
	}

	public void eat(Food food) {
		if(food instanceof Fish){
		System.out.println(super.getName()+"吃"+ food.getName() +"!");
		}
		else {
			System.out.println(super.getName()+"不吃"+food.getName() +"!");
		}
	}

}

public class Dog extends Animal{

	// 构造方法
		public Dog() {
			super("dog");
		}

		// 重写bark方法
		public void bark() {
			System.out.println("狗叫:汪汪汪！！");
		}

		public void eat(Food food) {
			if(food instanceof Bone){
			System.out.println(super.getName()+"吃"+ food.getName() +"!");
			}
			else {
				System.out.println(super.getName()+"不吃"+food.getName() +"!");
			}
		}

}

public class Food {
	public String name;
	public Food(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
}

public class Fish extends Food {
	public Fish() {
		super("fish");
	}
}

public class Bone extends Food {
	public Bone() {
		super("bone");
	}
}

public class Hostman {

	//喂食
	public void food(Animal animal,Food food) {
		animal.eat(food);
	}
	
}

public class Test {

	public static void main(String[] args) {
		Animal cat = new Cat();
		Animal dog = new Dog();
		cat.bark();
		dog.bark();
		Hostman man=new Hostman();
		Fish fish=new Fish();
		Bone bone=new Bone();
		man.food(cat, fish);
		man.food(dog,bone);
		man.food(cat, bone);
		man.food(dog,fish);	
	}

}
```

##### 接口（来源于[菜鸟教程](http://www.runoob.com/java/java-interfaces.html)）

接口（英文：Interface），在JAVA编程语言中是一个抽象类型，是抽象方法的集合，接口通常以interface来声明。一个类通过继承接口的方式，从而来继承接口的抽象方法。

接口并不是类，编写接口的方式和类很相似，但是它们属于不同的概念。**类描述对象的属性和方法。接口则包含类要实现的方法。**

**除非实现接口的类是抽象类，否则该类要定义接口中的所有方法。**

接口无法被实例化，但是可以被实现。一个实现接口的类，必须实现接口内所描述的所有方法，否则就必须声明为抽象类。另外，*在 Java 中，接口类型可用来声明一个变量，他们可以成为一个空指针，或是被绑定在一个以此接口实现的对象。*



##### 接口与类相似点：

- 一个接口可以有多个方法。
- 接口文件保存在 .java 结尾的文件中，文件名使用接口名。
- 接口的字节码文件保存在 .class 结尾的文件中。
- 接口相应的字节码文件必须在与包名称相匹配的目录结构中。



##### 接口与类的区别：

- 接口不能用于实例化对象。
- 接口没有构造方法。
- 接口中所有的方法必须是抽象方法。
- 接口不能包含成员变量，除了 static 和 final 变量。
- 接口不是被类继承了，而是要被类实现。
- 接口支持多继承。

```java
//接口的声明
interface Animal {
   public void eat();
   public void travel();
}

//接口的实现
public class MammalInt implements Animal{
 
   public void eat(){
      System.out.println("Mammal eats");
   }
 
   public void travel(){
      System.out.println("Mammal travels");
   } 
 
   public int noOfLegs(){
      return 0;
   }
 
   public static void main(String args[]){
      MammalInt m = new MammalInt();
      m.eat();
      m.travel();
   }
}
```

##### 接口的继承

一个接口能继承另一个接口，和类之间的继承方式比较相似。接口的继承使用extends关键字，子接口继承父接口的方法。

下面的Sports接口被Hockey和Football接口继承：

```java
// 文件名: Sports.java
public interface Sports
{
   public void setHomeTeam(String name);
   public void setVisitingTeam(String name);
}
 
// 文件名: Football.java
public interface Football extends Sports
{
   public void homeTeamScored(int points);
   public void visitingTeamScored(int points);
   public void endOfQuarter(int quarter);
}
 
// 文件名: Hockey.java
public interface Hockey extends Sports
{
   public void homeGoalScored();
   public void visitingGoalScored();
   public void endOfPeriod(int period);
   public void overtimePeriod(int ot);
}
```

Hockey接口自己声明了四个方法，从Sports接口继承了两个方法，这样，实现Hockey接口的类需要实现六个方法。

相似的，实现Football接口的类需要实现五个方法，其中两个来自于Sports接口。

```java
//接口允许多继承
public interface Hockey extends Sports, Event
```

##### 标记接口

没有任何方法的接口被称为标记接口。标记接口主要用于以下两种目的：

- **建立一个公共的父接口：**正如EventListener接口，这是由几十个其他接口扩展的Java API，你可以使用一个标记接口来建立一组接口的父接口。例如：当一个接口继承了EventListener接口，Java虚拟机(JVM)就知道该接口将要被用于一个事件的代理方案。
- **向一个类添加数据类型：**这种情况是标记接口最初的目的，实现标记接口的类不需要定义任何接口方法(因为标记接口根本就没有方法)，但是该类通过多态性变成一个接口类型。



##### 接口中的成员变量

​	只能是final类型和static类型，默认是static类型。

##### 访问修饰符以外的其他修饰符

**final 变量：**

final 变量能被显式地初始化并且只能初始化一次。被声明为 final 的对象的引用不能指向不同的对象。但是 final 对象里的数据可以被改变。也就是说 final 对象的引用不能改变，但是里面的值可以改变。

final 修饰符通常和 static 修饰符一起使用来创建类常量。

```java
public class Test{
  final int value = 10;
  // 下面是声明常量的实例
  public static final int BOXWIDTH = 6;
  static final String TITLE = "Manager";
 
  public void changeValue(){
     value = 12; //将输出一个错误
  }
}
```

**final 方法：**

类中的 final 方法可以被子类继承，但是不能被子类修改。

声明 final 方法的主要目的是防止该方法的内容被修改。

如下所示，使用 final 修饰符声明方法。

```java
public class Test{
    public final void changeName(){
       // 方法体
    }
}
```

**final 类:**

final 类不能被继承，没有类能够继承 final 类的任何特性。

**synchronized 修饰符:**

synchronized 关键字声明的方法同一时间只能被一个线程访问。synchronized 修饰符可以应用于四个访问修饰符。

**transient 修饰符:**

序列化的对象包含被 transient 修饰的实例变量时，java 虚拟机(JVM)跳过该特定的变量。

该修饰符包含在定义变量的语句中，用来预处理类和变量的数据类型。

**volatile 修饰符:**

volatile 修饰的成员变量在每次被线程访问时，都强制从共享内存中重新读取该成员变量的值。而且，当成员变量发生变化时，会强制线程将变化值回写到共享内存。这样在任何时刻，两个不同的线程总是看到某个成员变量的同一个值。

一个 volatile 对象引用可能是 null。



##### 







