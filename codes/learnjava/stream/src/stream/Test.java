package stream;

import java.io.*;

public class Test {

	public static void main(String[] args) {
		String fileFrom = "C:\\Users\\Administrator\\Music\\music.rar";
		String fileTo = "C:\\Users\\Administrator\\Desktop\\webclass\\reference";
		copy(fileFrom, fileTo);
		String filesFrom = "C:\\Users\\Administrator\\Desktop\\webclass\\day7";
		String filesTo = "C:\\\\Users\\\\Administrator\\\\Desktop\\\\webclass\\\\reference";
		copyDir(filesFrom, filesTo);
		String fileDelete = "C:\\Users\\Administrator\\Desktop\\webclass\\daydayday";
		deleteDir(fileDelete);
	}

	// �ļ�����
	/**
	 * 
	 * @Title: copy
	 * @param from
	 * @param to
	 */
	public static void copy(String from, String to) {
		// Դ��ַ
		String resources = from;
		// ��ȡҪ�������ļ�����
		File file = new File(resources);
		// Ŀ���ַ
		String direction = to + File.separator + file.getName();
		// ����������try�����Ҹ�ֵΪnull��������Ҫ�׳��쳣�����һ�Ҫ��finnally�йر���
		InputStream input = null;
		OutputStream output = null;

		// IO���ĳ�ʼ�����׳�FileNotFoundException������IO�쳣
		try {
			input = new FileInputStream(file);
			output = new FileOutputStream(direction);
			// ÿ�ζ�ȡ�ļ��ĳ���,4kb
			byte[] pertime = new byte[1024 * 4];
			long startTime = System.currentTimeMillis();
			int len = 0;// ʵ�ʶ�ȡ���ļ�����,���һ�ο����ò���pertime�ĳ���
			// ���������룬������������ʵ��copy
			while ((len = input.read(pertime)) != -1) {
				output.write(pertime, 0, len);
			}
			System.out.println("copy����");
			long time = System.currentTimeMillis() - startTime;
			System.out.println("��ʱ��" + time + "ms");
		} catch (FileNotFoundException e) {
			System.out.println("�ļ�û�ҵ�");
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

	// �ļ��п���
	/**
	 * 
	 * @Title: copyDir
	 * @param from
	 * @param to
	 */
	public static void copyDir(String from, String to) {
		File fromFile = new File(from);
		// �������ı������ļ���
		if (fromFile.isDirectory()) {
			File toFile = new File(to + File.separator + fromFile.getName());
			// �����������Ŀ�ĵز����ڸ��ļ��о��½�һ��ͬ�����ļ���
			if (!toFile.exists()) {
				toFile.mkdirs();
			}
			// ��ʼ����fromFile�ļ������������
			File[] files = fromFile.listFiles();
			for (File file : files) {
				String fromPath = file.getPath();
				String direction = toFile.getPath();
				if (file.isFile()) {
					// �����ļ�
					copy(fromPath, direction);
				} else if (file.isDirectory()) {
					// �����ļ���
					copyDir(fromPath, toFile.getPath());
				}
			}
			System.out.println("copy�ļ��гɹ�");

		}
	}

	public static void deleteDir(String fileName) {
		File deleteFile = new File(fileName);
		if (deleteFile.isFile()) {
			deleteFile.delete();
			System.out.println("ɾ���ļ�  " + deleteFile.getName() + "  �ɹ�");
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
			System.out.println("ɾ���ļ���  " + deleteFile.getName() + "  �ɹ�");
		}
	}

}
