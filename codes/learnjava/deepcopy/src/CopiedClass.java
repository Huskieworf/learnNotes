public class CopiedClass implements Cloneable{
    private int age;
    private String name;
    private  Address addr;
    private  Weather weather;

    public CopiedClass(int age, String name, Address addr, Weather weather) {
        this.age = age;
        this.name = name;
        this.addr = addr;
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "CopiedClass{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", addr=" + addr +
                ", weather=" + weather +
                '}';
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }

    public CopiedClass() {
    }

    public CopiedClass(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public CopiedClass(int age, String name, Address addr) {
        this(age,name);
        this.addr = addr;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone()  {
        CopiedClass copy = null;
        try{
            copy = (CopiedClass)super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        copy.weather=(Weather)weather.clone();
        return  copy;
    }
}
class Address  {
    private String addr;

    public Address(String addr) {
        this.addr = addr;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addr='" + addr + '\'' +
                '}';
    }
}

class Weather implements Cloneable{
    private String weather;

    public Weather(String weather) {
        this.weather = weather;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "weather='" + weather + '\'' +
                '}';
    }

    @Override
    protected Object clone() {
        Weather weatherCopy = null;
        try {
            weatherCopy = (Weather)super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return weatherCopy;
    }
}