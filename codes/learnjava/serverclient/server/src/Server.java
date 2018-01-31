import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            //create a Server with port 2018
            serverSocket = new ServerSocket(2018);
            //waiting to connect with Client
            Socket socket = serverSocket.accept();
            while (true) {
                //accept the message from Client
                InputStream inputStream = socket.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String message = bufferedReader.readLine();
                System.out.println("Client Says:" + message);
                //send message to Client
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter out = new PrintWriter(outputStream, true);
                if (message.equals("Nice to meet you.")) {
                    out.println("Nice to meet you too.");
                    System.out.println("Nice to meet you too.");
                } else if (message.equals("end")) {
                    System.out.println("end too");
                    break;
                } else {
                    System.out.println("please input message to Client:");
                    Scanner scanner = new Scanner(System.in);
                    String content = scanner.nextLine();
                    out.println(content);
                    System.out.println("send successfully");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
