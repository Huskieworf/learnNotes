package employee;

import java.util.HashMap;
import java.util.Map;

/**
 * ��mapʵ��Ա������ϵͳ��map�洢Ա����Ϣ
 * 
 * @ClassName: EmployeeSysMap
 * @author: Huskie worf
 * @date: 2018��1��17�� ����10:59:07
 * @Copyright: 2018 Huskie Worf Inc. All rights reserved.
 */
public class EmployeeSysMap {
	/* Ա����ţ�Ψһ */
	private static Integer employeeID = 0;
	/* ���Ա����Ϣ��map�� */
	private Map<Integer, Employee> employees = new HashMap<>();

	/**
	 * ���Ա����eΪԱ������
	 * 
	 * @param e,Ա������
	 */
	public void addEmployee(Employee e) {
		employeeID++;
		e.setEmployeeID(employeeID);
		employees.put(employeeID, e);
	}

	/**
	 * ����Ա������Ա��
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
			System.out.println("���޴���");
		}
		return e;
	}

	/**
	 * ���ݹ����޸�нˮ
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
	 * ��ʾ���е�Ա����Ϣ
	 */
	public void showAllEmployee() {
		for (Integer key : employees.keySet()) {
			System.out.println(employees.get(key).show());
		}
	}

	/**
	 * ����Ա����ɾ��Ա��
	 * @param employeeID
	 */
	public void deleteEmployeeById(int employeeID) {
		for (Integer key : employees.keySet()) {
			if(key == employeeID) {	
				employees.remove(employeeID);
				}
			else {
				System.out.println("���޴���");
			}
		}
	}

	
}
