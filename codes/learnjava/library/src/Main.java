import java.util.List;
import java.util.Scanner;

import dao.BookDao;
import dao.CatelogDao;
import dao.UserDao;
import entity.Book;
import entity.Catelog;
import entity.UserEntity;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		UserDao userDao = new UserDao();
		BookDao bookDao = new BookDao();
		CatelogDao catelogDao = new CatelogDao();
		UserEntity currentUser = null;

		while (true) {
			System.out.println();
			System.out.println("请选择 1.注册 2.登陆 3.退出");
			int choose = scanner.nextInt();
			switch (choose) {
			case 1:
				System.out.println("请输入账号");
				String username = scanner.next();
				System.out.println("请输入密码");
				String password = scanner.next();
				System.out.println("请输入昵称");
				String nickname = scanner.next();
				UserEntity userEntity = new UserEntity(0, username, password, nickname);
				if (userDao.reg(userEntity)) {
					System.out.println("注册成功");
				} else {
					System.out.println("注册失败");
				}
				break;
			case 2:
				System.out.println("请输入账号");
				username = scanner.next();
				System.out.println("请输入密码");
				password = scanner.next();
				currentUser = userDao.login(username, password);
				if (currentUser != null) {
					System.out.println("登录成功");
					login: while (true) {
						// System.out.println("当前拥有的书如下:");
						List<Book> books = bookDao.selectBook();
						// for(Book book : books) {
						// System.out.println(book);
						// }
						System.out.println("请选择： 1.增加 2.删除 3.修改 4.退出 5.显示拥有的书籍  6.分类操作");
						choose = scanner.nextInt();
						switch (choose) {
						case 1:
							boolean flag = addBook(bookDao, catelogDao);
							if (flag) {
								System.out.println("添加成功");
							}
							break;

						case 2:
							System.out.println("请输入要删除书籍的编号");
							int bid = scanner.nextInt();
							flag = bookDao.deleteBook(bid);
							if (flag) {
								System.out.println("删除成功");
							}
							break;
						case 3:
							flag = updateBook(bookDao, catelogDao);
							if (flag) {
								System.out.println("修改成功");
							}
							break;
						case 4:
							break login;
						case 5:
							
							System.out.println("1.显示指定编号 2.显示所有");
							int choose1 = scanner.nextInt();
							switch (choose1) {
							case 1:
								System.out.println("输入编号");
								int bianhao = scanner.nextInt();
								Book book1 = bookDao.selectOneBook(bianhao);
								System.out.println(book1);
								break;
							case 2:
								System.out.println("当前拥有的书如下:");
								books = bookDao.selectBook();
								for (Book book : books) {
									System.out.println(book);
								}
								System.out.println();
								break;
							default:
								break;
							}
							break;
						case 6:
							loop1: while (true) {
								System.out.println("1.增加分类 2. 删除分类 3.显示分类 4.退出");
								choose = scanner.nextInt();
								switch (choose) {
								case 1:
									addCatelog(catelogDao);
									break;
								case 2:
									System.out.println("请输入要删除分类的编号");
									int cid = scanner.nextInt();
									flag = catelogDao.deleteCatelog(cid);
									if (flag) {
										System.out.println("删除成功");
									}
									break;
								case 3:
									List<Catelog> catelogs = catelogDao.selectCatelog();
									for (Catelog catelog1 : catelogs) {
										System.out.println(catelog1);
									}
									break;
								case 4:
									break loop1;
								}
							}
							break;

						default:
							break;
						}
					}

				} else {
					System.out.println("登录失败");
				}
				break;
			default:
				break;
			}
			if (choose == 3) {
				System.out.println("执行退出");
				break;
			}
		}
	}

	/**
	 * 添加书籍
	 * 
	 * @param bookDao
	 * @param catelogDao
	 * @return
	 */
	public static boolean addBook(BookDao bookDao, CatelogDao catelogDao) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入书籍的名字");
		String name = scanner.next();
		System.out.println("请输入书籍的作者");
		String author = scanner.next();
		System.out.println("请输入书籍的出版社");
		String publish = scanner.next();
		System.out.println("请输入书籍的价格");
		double price = scanner.nextDouble();
		System.out.println("请输入书籍的简介");
		String introduce = scanner.next();
		System.out.println("请选择分类");
		List<Catelog> catelogs = catelogDao.selectCatelog();
		for (Catelog catelog : catelogs) {
			System.out.println(catelog);
		}
		int cid = scanner.nextInt();
		Catelog catelog = new Catelog(cid, null, null);
		Book book = new Book(0, name, author, publish, price, introduce, catelog);
		return bookDao.insertBook(book);
	}

	/**
	 * 修改书籍
	 */
	public static boolean updateBook(BookDao bookDao, CatelogDao catelogDao) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入要修改书籍的编号");
		int bid = scanner.nextInt();
		Book book = bookDao.selectOneBook(bid);
		int choose;
		String name = book.getName();
		String author = book.getAuthor();
		String publish = book.getPublish();
		double price = book.getPrice();
		String introduce = book.getIntroduce();
		Catelog catelog = book.getCatelog();
		loop: while (true) {

			System.out.println("请选择要修改的字段：");
			System.out.println("1.名字 2.作者. 3.出版社 4.价格 5.简介 6.分类 7.退出");
			choose = scanner.nextInt();
			switch (choose) {
			case 1:
				System.out.println("请输入修改后书籍的名字");
				name = scanner.next();
				book.setName(name);
				break;
			case 2:
				System.out.println("请输入修改后书籍的作者");
				author = scanner.next();
				book.setAuthor(author);
				break;
			case 3:
				System.out.println("请输入修改后书籍的出版社");
				publish = scanner.next();
				book.setPublish(publish);
				break;
			case 4:
				System.out.println("请输入修改后书籍的价格");
				price = scanner.nextDouble();
				book.setPrice(price);
				break;
			case 5:
				System.out.println("请输入修改后书籍的简介");
				introduce = scanner.next();
				book.setIntroduce(introduce);
				break;
			case 6:
				System.out.println("请选择分类");
				List<Catelog> catelogs = catelogDao.selectCatelog();
				for (Catelog catelog1 : catelogs) {
					System.out.println(catelog1);
				}
				int cid = scanner.nextInt();
				catelog = new Catelog(cid, null, null);
				book.setCatelog(catelog);
				break;
			case 7:
				break loop;

			default:
				break;
			}

		}

		return bookDao.updateBook(book);
	}

	public static boolean addCatelog(CatelogDao catelogDao) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入分类名字");
		String name = scanner.next();
		System.out.println("请输入分类简介");
		String introduce = scanner.next();
		Catelog catelog = new Catelog(0, name, introduce);
		boolean flag = catelogDao.insertCatelog(catelog);
		System.out.println("分类详细信息：");
		List<Catelog> catelogs = catelogDao.selectCatelog();
		for (Catelog catelog1 : catelogs) {
			System.out.println(catelog1);
		}
		return flag;
	}

}
