import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Socket  socket = null;
        try {
            socket = new Socket("127.0.0.1",2018);
            while (true){
                //input message to Server
                Scanner scanner = new Scanner(System.in);
                System.out.println("please input message to Server:");
                String content = scanner.nextLine();
                OutputStream outputStream =  socket.getOutputStream();
                PrintWriter printWriter = new PrintWriter(outputStream,true);
                printWriter.println(content);
                System.out.println("send successfully");
                if(content.equals("end")){
                    break;
                }
                //accept message from Server
                InputStream inputStream = socket.getInputStream();
                InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
                BufferedReader bufferedReader= new BufferedReader(inputStreamReader);
                String accept = bufferedReader.readLine();
                System.out.println("Server says:"+ accept);
            }
        }catch (UnknownHostException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
