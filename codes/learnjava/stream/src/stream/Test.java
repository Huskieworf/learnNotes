package stream;

import java.io.*;

public class Test {

	public static void main(String[] args) {
		//源地址
		String resources="C:\\Users\\Administrator\\Music\\music.rar";
		//目标地址
		String direction="C:\\Users\\Administrator\\Desktop\\webclass\\reference\\music.rar";
		//声明必须在try外面且赋值为null，否则又要抛出异常，而且还要在finnally中关闭流
		InputStream input = null;
		OutputStream output = null;
		
		//IO流的初始化将抛出FileNotFoundException和其他IO异常
		try {
			long startTime = System.currentTimeMillis();
			//获取要操作的文件对象
			File file=new File(resources);
			//初始化输入流和输出流
			input = new FileInputStream(file);
			output=new FileOutputStream(direction);
			//每次读取文件的长度,4kb
			byte[] pertime = new byte[1024*4];
			int len =0;//实际读取的文件长度,最后一次可能用不完pertime的长度
			//输入流输入，输出到输出流，实现copy
			while((len=input.read(pertime)) != -1) {
				output.write(pertime, 0, len);
			}
			System.out.println("copy结束");
			long time=System.currentTimeMillis()-startTime;
			System.out.println("用时："+time+"ms");
		}catch(FileNotFoundException e) {
			System.out.println("文件没找到");
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
