package stream;

import java.io.*;

public class Test {

	public static void main(String[] args) {
		// 字节流测试
		// 复制单个文件
		String fileFrom = "C:\\Users\\Administrator\\Music\\music.rar";
		String fileTo = "C:\\Users\\Administrator\\Desktop\\webclass\\reference";
		copy(fileFrom, fileTo);

		// 复制文件夹
		String filesFrom = "C:\\Users\\Administrator\\Desktop\\webclass\\day7";
		String filesTo = "C:\\\\Users\\\\Administrator\\\\Desktop\\\\webclass\\\\reference";
		copyDir(filesFrom, filesTo);

		// 删除指定文件夹
		String fileDelete = "C:\\Users\\Administrator\\Desktop\\webclass\\daydayday";
		deleteDir(fileDelete);
	}

	/**
	 * 文件拷贝
	 * 
	 * @Title: copy
	 * @param from
	 * @param to
	 */
	public static void copy(String from, String to) {
		// 源地址
		String resources = from;
		// 获取要操作的文件对象
		File file = new File(resources);
		// 目标地址
		String direction = to + File.separator + file.getName();
		// 声明必须在try外面且赋值为null，否则又要抛出异常，而且还要在finnally中关闭流
		InputStream input = null;
		OutputStream output = null;

		// IO流的初始化将抛出FileNotFoundException和其他IO异常
		try {
			input = new FileInputStream(file);
			output = new FileOutputStream(direction);
			// 每次读取文件的长度,4kb
			byte[] pertime = new byte[1024 * 4];
			long startTime = System.currentTimeMillis();
			int len = 0;// 实际读取的文件长度,最后一次可能用不完pertime的长度
			// 输入流输入，输出到输出流，实现copy
			while ((len = input.read(pertime)) != -1) {
				output.write(pertime, 0, len);
			}
			System.out.println("copy结束");
			long time = System.currentTimeMillis() - startTime;
			System.out.println("用时：" + time + "ms");
		} catch (FileNotFoundException e) {
			System.out.println("文件没找到");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (output != null) {
					output.close();
				}
				if (input != null) {
					input.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * 文件夹拷贝
	 * 
	 * @Title: copyDir
	 * @param from
	 * @param to
	 */
	public static void copyDir(String from, String to) {
		File fromFile = new File(from);
		// 被拷贝的必须是文件夹
		if (fromFile.isDirectory()) {
			File toFile = new File(to + File.separator + fromFile.getName());
			// 如果拷贝到的目的地不存在该文件夹就新建一个同名的文件夹
			if (!toFile.exists()) {
				toFile.mkdirs();
			}
			// 开始处理fromFile文件夹里面的内容
			File[] files = fromFile.listFiles();
			for (File file : files) {
				String fromPath = file.getPath();
				String direction = toFile.getPath();
				if (file.isFile()) {
					// 拷贝文件
					copy(fromPath, direction);
				} else if (file.isDirectory()) {
					// 拷贝文件夹
					copyDir(fromPath, toFile.getPath());
				}
			}
			System.out.println("copy文件夹成功");

		}
	}

	/**
	 * 删除指定文件夹
	 * 
	 * @Title: deleteDir
	 * @param fileName
	 */
	public static void deleteDir(String fileName) {
		File deleteFile = new File(fileName);
		if (deleteFile.isFile()) {
			deleteFile.delete();
			System.out.println("删除文件  " + deleteFile.getName() + "  成功");
		}
		if (deleteFile.isDirectory()) {

			File[] files = deleteFile.listFiles();
			for (File file : files) {
				if (file.isFile()) {
					file.delete();
				} else if (file.isDirectory()) {
					deleteDir(file.getPath());
				}
				file.delete();
			}
			deleteFile.delete();
			System.out.println("删除文件夹  " + deleteFile.getName() + "  成功");
		}
	}

	/**
	 * 字符流读取文本文件
	 * 
	 * @Title: ReaderChar
	 * @param filePathAndName
	 */
	public static String ReaderChar(String filePathAndName) {
		File file = new File(filePathAndName);
		// 设置字符流read,Reader为抽象类，需要用子类实例化
		Reader read = null;
		StringBuilder sb = new StringBuilder();
		try {
			read = new FileReader(file);
			// 设置每次读取长度,1k
			char[] chars = new char[1024];
			// 实际每次读取的长度
			int len = 0;
			// 读取
			while ((len = read.read(chars)) != 0) {
				sb.append(chars, 0, len);
			}
		} catch (FileNotFoundException e) {
			System.out.println("找不到指定文件");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (read != null) {
				try {
					read.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
	
	
	/**
	 * 写出文本文件
	 * @param path
	 * @param content
	 */
	public static void writeFile(String path,String content) {
		//第二个参数是内容是否追加  true为追加  false为覆盖   没有第二个参数默认是覆盖
		Writer writer = null;
		try {
			writer = new FileWriter(path, false);
			writer.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
