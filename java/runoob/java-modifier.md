##### 访问修饰符

- public
- private
- protected
- default 



##### 非访问修饰符

- static
- final
- abstract
- synchronized（同步的）
- transient（瞬态）
- volatile(不稳定的)

​       synchronized 关键字声明的方法同一时间只能被一个线程访问。synchronized 修饰符可以应用于四个访问修饰符。

​	序列化的对象包含被 transient 修饰的实例变量时，java 虚拟机(JVM)跳过该特定的变量。

​	该修饰符包含在定义变量的语句中，用来预处理类和变量的数据类型。java的transient关键字十分便利，只需要实现Serilizable接口，将不需要序列化的属性前添加关键字transient，序列化对象的时候，这个属性就不会序列化到指定的目的地中。

> 如定义类：
>
> public class People implements Serializable { 
>
> private static final long serialVersionUID = 8294180014912103005L; 
>
> /**
>
> * 用户名
>
> */ 
>
> private String username; 
>
> /**
>
> * 密码
>
> */ 
>
> private transient String password; 
>
> } 
>
>
> 密码字段为transient，这时候如果对该对象进行序列化，这个密码字段是不会被保存的。
>
>
> 以下例子展示了这个行为：
>
> public static void main(String[] args) throws Exception { 
>
> People p = new People(); 
>
> p.setUsername("snowolf"); 
>
> p.setPassword("123456"); 
>
>
> System.err.println("------操作前------"); 
>
> System.err.println("username: " + p.getUsername()); 
>
> System.err.println("password: " + p.getPassword()); 
>
>
> ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream( 
>
> "people.txt")); 
>
> oos.writeObject(p); 
>
> oos.flush(); 
>
> oos.close(); 
>
>
> ObjectInputStream ois = new ObjectInputStream(new FileInputStream( 
>
> "people.txt")); 
>
> p = (People) ois.readObject(); 
>
>
> ois.close(); 
>
>
> System.err.println("------操作后------"); 
>
> System.err.println("username: " + p.getUsername()); 
>
> System.err.println("password: " + p.getPassword()); 
>
> } 
>
> 执行结果是：
>
> ------操作前------ 
>
> username: snowolf 
>
> password: 123456 
>
> ------操作后------ 
>
> username: snowolf 
>
> password: null

​	volatile 修饰的成员变量在每次被线程访问时，都强制从共享内存中重新读取该成员变量的值。而且，当成员变量发生变化时，会强制线程将变化值回写到共享内存。这样在任何时刻，两个不同的线程总是看到某个成员变量的同一个值。

​	一个 volatile 对象引用可能是 null。