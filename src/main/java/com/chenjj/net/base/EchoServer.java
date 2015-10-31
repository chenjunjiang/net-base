package com.chenjj.net.base;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2015/10/31 0031.
 */
public class EchoServer {
    private int port = 8888;
    private ServerSocket serverSocket;

    public EchoServer() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("服务器已经启动");
    }

    public String echo(String msg) {
        return "echo:" + msg;
    }

    private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        return new PrintWriter(outputStream);
    }

    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    public void service() {
        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();// 等待客户端连接
                System.out.println("New connection accepted:" + socket.getInetAddress()
                        + ":" + socket.getPort());
                BufferedReader reader = getReader(socket);
                PrintWriter writer = getWriter(socket);

                String msg = null;
                while ((msg = reader.readLine()) != null) {
                    System.out.println(msg);
                    writer.println(echo(msg));
                    writer.flush();// 必须刷新
                    if (msg.equals("bye")) {
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (socket != null) {
                    try {
                        socket.close();// 断开连接
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new EchoServer().service();
    }
}
