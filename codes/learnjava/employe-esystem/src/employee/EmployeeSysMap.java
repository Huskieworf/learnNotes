package employee;

import java.util.HashMap;
import java.util.Map;

/**
 * 用map实现员工管理系统，map存储员工信息
 * 
 * @ClassName: EmployeeSysMap
 * @author: Huskie worf
 * @date: 2018年1月17日 上午10:59:07
 * @Copyright: 2018 Huskie Worf Inc. All rights reserved.
 */
public class EmployeeSysMap {
	/* 员工编号，唯一 */
	private static Integer employeeID = 0;
	/* 存放员工信息的map表 */
	private Map<Integer, Employee> employees = new HashMap<>();

	/**
	 * 添加员工，e为员工对象
	 * 
	 * @param e,员工对象
	 */
	public void addEmployee(Employee e) {
		employeeID++;
		e.setEmployeeID(employeeID);
		employees.put(employeeID, e);
	}

	/**
	 * 根据员工号找员工
	 * 
	 * @param employeeID
	 * @return
	 */
	public Employee selectEmployeeById(int employeeID) {
		Employee e = null;
		for (Integer key : employees.keySet()) {
			if (key == employeeID) {
				e = employees.get(key);
				break;
			}
		}
		if (e == null) {
			System.out.println("查无此人");
		}
		return e;
	}

	/**
	 * 根据工号修改薪水
	 * 
	 * @param employeeID
	 * @param salary
	 */
	public void updateSalaryById(int employeeID, double salary) {
		Employee e = selectEmployeeById(employeeID);
		if (e == null) {
			return;
		}
		e.setSalary(salary);
	}

	/**
	 * 显示所有的员工信息
	 */
	public void showAllEmployee() {
		for (Integer key : employees.keySet()) {
			System.out.println(employees.get(key).show());
		}
	}

	/**
	 * 根据员工号删除员工
	 * @param employeeID
	 */
	public void deleteEmployeeById(int employeeID) {
		for (Integer key : employees.keySet()) {
			if(key == employeeID) {	
				employees.remove(employeeID);
				}
			else {
				System.out.println("查无此人");
			}
		}
	}

	
}
