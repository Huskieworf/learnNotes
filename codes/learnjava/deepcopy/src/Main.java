import java.io.Serializable;

public class Main {
    public static void main(String[] args) {
        Address address=new Address("北京");
        Weather weather = new Weather("暴雨");
        CopiedClass original = new CopiedClass(12345, "original",address,weather);
        CopiedClass deepcopy = (CopiedClass) original.clone();
        CopiedClass copy = original;

        System.out.println("original和copy是否相等：");
        System.out.println(original==copy);
        System.out.println("original和deepcopy是否相等：");
        System.out.println(original==deepcopy);

        original.setAge(54321);
        original.setName("copy");
        //address未实现Cloneabel接口内容改变会导致original和deepcopy内容都改变
        address.setAddr("上海");
        //weather实现了Cloneable接口，且CopiedClass的clone()中显示调用了weather的clone方法
        weather.setWeather("晴朗");

        System.out.println(original);
        System.out.println(copy);
        System.out.println(deepcopy);


    }
}
