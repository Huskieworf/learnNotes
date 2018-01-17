package employee;

/**
 * @ClassName: Test
 * @Description:测试
 * @author: Huskie Worf
 * @date: 2018年1月16日 上午10:46:56
 */
public class Test {

	public static void main(String[] args) {
		// es为员工管理系统对象
		EmployeeSystem es = new EmployeeSystem();
		// e,e1,e2,e3为新建员工对象
		Employee e = new Employee(0, "张三", 500);
		Employee e1 = new Employee(0, "李四", 300);
		Employee e2 = new Employee(0, "王五", 900);
		Employee e3 = new Employee(0, "赵六", 200);
		// 添加员工
		es.addEmployee(e);
		es.addEmployee(e1);
		es.addEmployee(e2);
		es.addEmployee(e3);
		// 显示所有员工
		es.showAllEmployee();
		// 排序
		System.out.println();
		es.sort();
		es.showAllEmployee();
		// 删除员工
		es.deleteEmployeeById(3);
		System.out.println();
		es.showAllEmployee();
		System.out.println();
		
		System.out.println("map實現測試");
		// emsys为员工管理系统map實現对象
		EmployeeSystem emsys = new EmployeeSystem();
		// e4,e5,e6,e7为新建员工对象
		Employee e4 = new Employee(0, "张七", 500);
		Employee e5 = new Employee(0, "李八", 300);
		Employee e6 = new Employee(0, "王十", 900);
		Employee e7 = new Employee(0, "赵十一", 200);
		// 添加员工
		emsys.addEmployee(e4);
		emsys.addEmployee(e5);
		emsys.addEmployee(e6);
		emsys.addEmployee(e7);
		// 显示所有员工
		emsys.showAllEmployee();
		// 删除员工
		emsys.deleteEmployeeById(6);
		System.out.println();
		emsys.showAllEmployee();
	}
}
