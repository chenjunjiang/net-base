package com.chenjj.net.base;

import java.io.*;
import java.net.Socket;

/**
 * Created by Administrator on 2015/10/31 0031.
 */
public class EchoClient {
    private String host = "localhost";
    private int port = 8888;
    private Socket socket;

    public EchoClient() throws IOException {
        socket = new Socket(host, port);
    }

    private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        return new PrintWriter(outputStream);
    }

    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    public void talk() {
        try {
            BufferedReader reader = getReader(socket);
            PrintWriter writer = getWriter(socket);
            BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in));
            String msg = null;
            while ((msg = localReader.readLine()) != null) {
                writer.println(msg);
                writer.flush();// 必须刷新
                System.out.println(reader.readLine());
                if (msg.equals("bye")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new EchoClient().talk();
    }
}
