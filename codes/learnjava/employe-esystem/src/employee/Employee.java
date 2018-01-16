package employee;

 /**   
 * @ClassName:  Employee   
 * @Description:员工类，拥有编号，姓名，工资属性。  
 * @author: Huskie Worf 
 * @date:   2018年1月16日 上午10:46:46   
 */
public class Employee {
	/*员工编号*/
	private int employeeID;
	/*员工姓名*/
	private String name;
	/*员工工资*/
	private double salary;
	/**
	 * 构造函数
	 * @param employeeID 员工编号
	 * @param name 员工姓名
	 * @param salary 员工工资
	 */
	public Employee(int employeeID, String name, double salary) {
		super();
		this.employeeID = employeeID;
		this.name = name;
		this.salary = salary;
	}
	/**
	 * 获取员工编号
	 * @return int 员工编号
	 */
	public int getEmployeeID() {
		return employeeID;
	}
	/**
	 * 
	 * @Title: setEmployeeID 
	 * @Description: 设置员工id
	 * @param int employeeID    
	 * @return void  
	 * @throws
	 */
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	/**
	 * 
	 * @Title: getName 
	 * @Description: 获取员工姓名
	 * @return String  
	 * @throws
	 */
	public String getName() {
		return name;
	}
	/**
	 * @Title: setName 
	 * @Description: 设置员工姓名
	 * @param name 员工姓名
	 * @return void  
	 * @throws
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @Title: getSalary 
	 * @Description: 获取员工工资
	 * @return double  员工工资
	 * @throws
	 */
	public double getSalary() {
		return salary;
	}
	/**
	 * 设置员工工资
	 * @Title: setSalary 
	 * @param salary 员工新的工资
	 * @return void  
	 * @throws
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	/**
	 * 显示员工各种信息
	 */
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", name=" + name + ", salary=" + salary + "]";
	}
}
