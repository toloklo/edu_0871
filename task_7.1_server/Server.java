package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    static ArrayList<Socket> clients = new ArrayList<>();
    public static void main(String[] args) {
        int num = 1;
         ArrayList<String> users = new ArrayList<>();

        Socket socket = null;
        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            System.out.println("Сервер запущен");
            while (true){
                socket = serverSocket.accept();
                clients.add(socket);
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                System.out.println("Клиент подключился");
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            out.writeUTF("Введите своё имя");
                            String clientName = in.readUTF();
                            users.add(clientName);
                            broadcastMsg("А вот и "+clientName+"! Как всегда, вовремя.");

                            while (true){
                                String str = in.readUTF();
                                broadcastMsg(clientName+": "+str);
                                System.out.println("Клиент "+clientName+" прислал сообщение: "+str);
                            }
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
                if (users.size()==0) broadcastMsg("В чате "+num+" человек(а)");
                else broadcastMsg("В чате "+num+" человек(а). Это "+users+" и "+(num - users.size())+" ещё не представились.");
                num++;
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static void broadcastMsg(String str) throws IOException{
        DataOutputStream out;
        for (Socket socket : clients){
            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(str);
        }
    }
}
