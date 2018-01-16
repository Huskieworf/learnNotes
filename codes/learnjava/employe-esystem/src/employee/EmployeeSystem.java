package employee;

import java.util.ArrayList;
/**
 * 
 * @ClassName:  EmployeeSystem   
 * @Description:员工管理系统类，对员工进行操作  
 * @author: Huskie Worf 
 * @date:   2018年1月16日 上午9:51:02
 */
public class EmployeeSystem {
	/*员工编号，唯一*/
	private static int employeeID = 0;
	/*存放员工信息的数组表*/
	private ArrayList<Employee> employees = new ArrayList<>();
	
	/**
	 * 添加员工，e为员工对象
	 * @param e,员工对象
	 * @return  是否添加成功
	 */
	public boolean addEmployee(Employee e) {
		employeeID++;
		e.setEmployeeID(employeeID);
		return employees.add(e);
	}
	/**
	 * 根据员工号找员工
	 * @param employeeID
	 * @return
	 */
	public Employee selectEmployeeById(int employeeID) {
		Employee e = null;
		for (Employee employee : employees) {
			if(employee.getEmployeeID() == employeeID) {
				e = employee;
				break;
			}
		}
		return e;
	}
	/**
	 * 显示所有的员工信息
	 */
	public void showAllEmployee() {
		for (Employee employee : employees) {
			System.out.println(employee.toString());
		}
	}
	/**
	 * 根据工号修改薪水
	 * @param employeeID
	 * @param salary
	 */
	public void updateSalaryById(int employeeID,double salary) {
		Employee e = selectEmployeeById(employeeID);
		if(e == null) {
			System.out.println("查无此人");
			return ;
		}
		e.setSalary(salary);
	}
	/**
	 * 根据员工号删除员工
	 * @param employeeID
	 */
	public void deleteEmployeeById(int employeeID) {
		Employee e = selectEmployeeById(employeeID);
		if(e != null) {
			employees.remove(e);
		}else {
			System.out.println("查无此人，无法删除");
		}
	}
	/**
	 * 冒泡排序
	 * 工资从高到低排序
	 */
	public void sort() {
		for (int i = 0; i < employees.size() - 1 ; i++) {
			for (int j = 0; j < employees.size() - 1 - i; j++) {
				if(employees.get(j).getSalary() < employees.get(j+1).getSalary()) {
					Employee e = employees.get(j);
					employees.set(j, employees.get(j+1));
					employees.set(j+1, e);
				}
			}
		}
	}
	/**
	 * 找最高工资的人
	 * @return
	 */
	public Employee maxSalary() {
		sort();
		return employees.get(0);
	}
	
	/**
	 * 找最低工资的人
	 * @return
	 */
	public Employee minSalary() {
		sort();
		return employees.get(employees.size()-1);
	}
	/**
	 * 平均工资
	 * @return
	 */
	public double avgSalary() {
		double total = 0;
		for (Employee employee : employees) {
			total += employee.getSalary();
		}
		return total/employees.size();
	}
}
