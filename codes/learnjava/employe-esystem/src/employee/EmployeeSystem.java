package employee;

import java.util.ArrayList;
/**
 * 
 * @ClassName:  EmployeeSystem   
 * @Description:Ա������ϵͳ�࣬��Ա�����в���  
 * @author: Huskie Worf 
 * @date:   2018��1��16�� ����9:51:02
 */
public class EmployeeSystem {
	/*Ա����ţ�Ψһ*/
	private static int employeeID = 0;
	/*���Ա����Ϣ�������*/
	private ArrayList<Employee> employees = new ArrayList<>();
	
	/**
	 * ���Ա����eΪԱ������
	 * @param e,Ա������
	 * @return  �Ƿ���ӳɹ�
	 */
	public boolean addEmployee(Employee e) {
		employeeID++;
		e.setEmployeeID(employeeID);
		return employees.add(e);
	}
	/**
	 * ����Ա������Ա��
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
	 * ��ʾ���е�Ա����Ϣ
	 */
	public void showAllEmployee() {
		for (Employee employee : employees) {
			System.out.println(employee.toString());
		}
	}
	/**
	 * ���ݹ����޸�нˮ
	 * @param employeeID
	 * @param salary
	 */
	public void updateSalaryById(int employeeID,double salary) {
		Employee e = selectEmployeeById(employeeID);
		if(e == null) {
			System.out.println("���޴���");
			return ;
		}
		e.setSalary(salary);
	}
	/**
	 * ����Ա����ɾ��Ա��
	 * @param employeeID
	 */
	public void deleteEmployeeById(int employeeID) {
		Employee e = selectEmployeeById(employeeID);
		if(e != null) {
			employees.remove(e);
		}else {
			System.out.println("���޴��ˣ��޷�ɾ��");
		}
	}
	/**
	 * ð������
	 * ���ʴӸߵ�������
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
	 * ����߹��ʵ���
	 * @return
	 */
	public Employee maxSalary() {
		sort();
		return employees.get(0);
	}
	
	/**
	 * ����͹��ʵ���
	 * @return
	 */
	public Employee minSalary() {
		sort();
		return employees.get(employees.size()-1);
	}
	/**
	 * ƽ������
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
