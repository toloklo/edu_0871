package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Controller {
    public Socket socket;
    public DataInputStream in;
    public DataOutputStream out;
    @FXML
    TextArea messageWindow;

    @FXML
    TextArea userList;

    @FXML
    TextField textField;

    @FXML
    private void send(){
        String str = textField.getText();
        try {
            out.writeUTF(str);
            textField.clear();
            textField.requestFocus();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void startClient(){
        try {
            socket = new Socket("localhost",8188);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            String response = in.readUTF();
            messageWindow.appendText("\n"+response);
            Thread responseThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        String response = null;
                        try {
                            response = in.readUTF();
                            if (response.indexOf("##")!=-1) {
                                String[] responseArray = response.split("##");
                                userList.setText(responseArray[0]);
                                messageWindow.appendText("\n" + responseArray[1]);
                            }
                            else messageWindow.appendText("\n"+response);
                        } catch (IOException exception) {
                            System.out.println("ERROR");
                        }
                    }
                }
            });
            responseThread.start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
