package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    static ArrayList<Socket> clients = new ArrayList<>();
    static ArrayList<String> users = new ArrayList<>();
    static ArrayList<Integer> numAll = new ArrayList<>();
    public static void main(String[] args) {


        try {

            ServerSocket serverSocket = new ServerSocket(8188);
            System.out.println("Сервер запущен");
            while (true){
                Socket socket = serverSocket.accept();
                clients.add(socket);
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                System.out.println("Клиент подключился");
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String clientName = null;
                        try {
                            out.writeUTF("Введите своё имя");
                            clientName = in.readUTF();
                            users.add(clientName);
                            broadcastMsg(false,"А вот и "+clientName+"! Как всегда, вовремя.");

                            while (true) {
                                String str = in.readUTF();
                                broadcastMsg(true, clientName+": "+str);
                                System.out.println("Клиент "+clientName+" прислал сообщение: "+str);
                            }
                        } catch (IOException e) {
                            System.out.println("Клиент "+users+" отключился");

                        }finally {

                            try {
                                numAll.remove(0);
                                if (clientName==null) broadcastMsg( false,"От нас ушёл кто-то неизвестный.");
                                else  broadcastMsg (false,clientName+" нас покинул.");
                                clients.remove(socket);
                                users.remove(clientName);
                                socket.close();



                            }catch (IOException exception){
                                exception.printStackTrace();
                            }
                        }
                    }
                });
                numAll.add(0);
                thread.start();
                if (users.size()==0) broadcastMsg(false,"В чате "+numAll.size()+" человек(а). Пока никто не представился.");

            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static void broadcastMsg(Boolean setResponseArray, String str) throws IOException{
        DataOutputStream out;
        for (Socket socket : clients){
            out = new DataOutputStream(socket.getOutputStream());
            if (setResponseArray== false) out.writeUTF(str);
            else {
                if (users.size()== numAll.size() ) out.writeUTF("В чате "+numAll.size()+" человек(а). Это "+users+"##"+str);
                else out.writeUTF("В чате "+numAll.size()+" человек(а). Это "+users+" и "+(numAll.size() - users.size())+" ещё не представились.##"+str);


            }
        }
    }
}
