package stream;

import java.io.*;

public class Test {

	public static void main(String[] args) {
		//Դ��ַ
		String resources="C:\\Users\\Administrator\\Music\\music.rar";
		//Ŀ���ַ
		String direction="C:\\Users\\Administrator\\Desktop\\webclass\\reference\\music.rar";
		//����������try�����Ҹ�ֵΪnull��������Ҫ�׳��쳣�����һ�Ҫ��finnally�йر���
		InputStream input = null;
		OutputStream output = null;
		
		//IO���ĳ�ʼ�����׳�FileNotFoundException������IO�쳣
		try {
			long startTime = System.currentTimeMillis();
			//��ȡҪ�������ļ�����
			File file=new File(resources);
			//��ʼ���������������
			input = new FileInputStream(file);
			output=new FileOutputStream(direction);
			//ÿ�ζ�ȡ�ļ��ĳ���,4kb
			byte[] pertime = new byte[1024*4];
			int len =0;//ʵ�ʶ�ȡ���ļ�����,���һ�ο����ò���pertime�ĳ���
			//���������룬������������ʵ��copy
			while((len=input.read(pertime)) != -1) {
				output.write(pertime, 0, len);
			}
			System.out.println("copy����");
			long time=System.currentTimeMillis()-startTime;
			System.out.println("��ʱ��"+time+"ms");
		}catch(FileNotFoundException e) {
			System.out.println("�ļ�û�ҵ�");
		}
		 catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(output!=null) {
					output.close();
				}
				if(input != null) {
					input.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
				
		}

	}

}
