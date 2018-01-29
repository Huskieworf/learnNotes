import java.io.*;

public class FileUtil {

    /**
     * 文件拷贝的方法
     * @param from
     * @param to
     */
    public static void copy(String from ,String to) {
        File toFile = new File(to);
        if(toFile.exists()) {
            //处理文件存在的情况
        }
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(from);
            os = new FileOutputStream(to);
            byte [] bytes = new byte[1024*40];
            int len = 0;//当前读取了多少个数据
            while((len = is.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //流使用了以后一定要关闭
            try {
                if(os != null) {
                    os.close();
                }
                if(is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 拷贝文件夹
     * @param from   d:/soft
     * @param to  c:/
     */
    public static void copyDir(String from,String to) {
        File fromFile = new File(from);
        //被拷贝的必须是文件夹
        if(fromFile.isDirectory()) {
            File toFile = new File(to+File.separator+fromFile.getName());
            //如果拷贝到的目的地不存在该文件夹就新建一个同名的文件夹
            if(!toFile.exists()) {
                toFile.mkdirs();
            }
            //开始处理fromFile文件夹里面的内容
            File [] files = fromFile.listFiles();
            for (File file : files) {
                String f = file.getPath();
                String t = toFile.getPath()+File.separator+file.getName();
                if(file.isFile()) {
                    //拷贝文件
                    copy(f,t);
                }else if(file.isDirectory()) {
                    //拷贝文件夹
                    copyDir(f,toFile.getPath());
                }
            }

        }
    }
    /**
     * 删除文件夹
     * @param path
     */
    public static void delDir(String path) {
        File pathFile = new File(path);
        //判断是不是文件夹
        if(pathFile.isDirectory()) {
            File [] files = pathFile.listFiles();
            //先删除文件夹里面的内容
            for (File file : files) {
                if(file.isFile()) {
                    //如果是文件直接删除
                    file.delete();
                }else if(file.isDirectory()) {
                    //如果是文件夹就调用删除文件夹的方法删除
                    delDir(file.getPath());
                }
            }
            //里面的文件删除完成以后删除自己
            pathFile.delete();
        }
    }
    /**
     * 读取文本文件
     * @param path
     * @return
     */
    public static String readFile(String path) {
        Reader r = null;//字符输入流
        StringBuilder sb = new StringBuilder();
        try {
            r = new FileReader(path);
            char [] chars = new char[1024];
            int len = 0;
            while((len = r.read(chars)) != -1) {
                sb.append(chars, 0, len);
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(r != null) {
                try {
                    r.close();
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


    /**
     * 读取文本文件
     * @param path
     * @return
     */
    public static String readBufferedFile(String path) {
        Reader r = null;//字符输入流
        //缓冲字符输入流
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        try {
            r = new FileReader(path);
            br = new BufferedReader(r);
            String str = null;
            while((str = br.readLine()) != null) {
                sb.append(str);
                sb.append("\n");
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(r != null) {
                try {
                    r.close();
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
    public static void writeBufferedFile(String path,String content) {
        //第二个参数是内容是否追加  true为追加  false为覆盖   没有第二个参数默认是覆盖
        Writer writer = null;
        BufferedWriter bw = null;
        try {
            writer = new FileWriter(path, false);
            bw = new BufferedWriter(writer);
            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            if(bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 字节流转换成字符流
     * @param path
     * @return
     */
    public static String readFileByInputStream(String path) {
        InputStream is = null;
        InputStreamReader isr = null;//字节输入流转字符输入流
        //字节输出流转字符输出流  OutputStreamWriter
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        try {
            is = new FileInputStream(path);
            isr = new InputStreamReader(is, "gbk");
            br = new BufferedReader(isr);
            String str = null;
            while ((str = br.readLine()) != null) {
                sb.append(str);
                sb.append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    //对象流        序列化
}
