package employee;

/**
 * @ClassName: Test
 * @Description:����
 * @author: Huskie Worf
 * @date: 2018��1��16�� ����10:46:56
 */
public class Test {

	public static void main(String[] args) {
		// esΪԱ������ϵͳ����
		EmployeeSystem es = new EmployeeSystem();
		// e,e1,e2,e3Ϊ�½�Ա������
		Employee e = new Employee(0, "����", 500);
		Employee e1 = new Employee(0, "����", 300);
		Employee e2 = new Employee(0, "����", 900);
		Employee e3 = new Employee(0, "����", 200);
		// ���Ա��
		es.addEmployee(e);
		es.addEmployee(e1);
		es.addEmployee(e2);
		es.addEmployee(e3);
		// ��ʾ����Ա��
		es.showAllEmployee();
		// ����
		System.out.println();
		es.sort();
		es.showAllEmployee();
		// ɾ��Ա��
		es.deleteEmployeeById(3);
		System.out.println();
		es.showAllEmployee();
		System.out.println();
		
		System.out.println("map���F�yԇ");
		// emsysΪԱ������ϵͳmap���F����
		EmployeeSystem emsys = new EmployeeSystem();
		// e4,e5,e6,e7Ϊ�½�Ա������
		Employee e4 = new Employee(0, "����", 500);
		Employee e5 = new Employee(0, "���", 300);
		Employee e6 = new Employee(0, "��ʮ", 900);
		Employee e7 = new Employee(0, "��ʮһ", 200);
		// ���Ա��
		emsys.addEmployee(e4);
		emsys.addEmployee(e5);
		emsys.addEmployee(e6);
		emsys.addEmployee(e7);
		// ��ʾ����Ա��
		emsys.showAllEmployee();
		// ɾ��Ա��
		emsys.deleteEmployeeById(6);
		System.out.println();
		emsys.showAllEmployee();
	}
}
