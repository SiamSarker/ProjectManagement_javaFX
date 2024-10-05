package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;

public class Controller {

    @FXML
    TextArea allTextArea;
    @FXML
    TextField msgTextField;

    @FXML
    TextArea noticeTextArea;


    @FXML
    TextArea chat2TextArea;
    @FXML
    TextField chat2TextField;

    @FXML
    TextArea assign2TextArea;
    @FXML
    TextField assign2TextField;

    final private BufferedWriter writer;
    final private BufferedReader reader;

    public Controller() throws IOException {
        String myName = "TeamMember 2";

        Socket socket = new Socket("127.0.0.1", 123);

        OutputStreamWriter o = new OutputStreamWriter(socket.getOutputStream());
        writer = new BufferedWriter(o);

        InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        reader = new BufferedReader(isr);

        writer.write(myName+"\n");
        writer.flush();

        Thread t = new Thread(){
            public void run(){
                String condition;
                try {
                    while (true){
                        condition = reader.readLine() + "\n";
                        if (condition.contains("AllMsg")){
                            String line = reader.readLine() + "\n";
                            allTextArea.appendText(line);
                        }
                        else if (condition.contains("notice")){
                            String line = reader.readLine() + "\n";
                            noticeTextArea.appendText(line);
                        }
                        else if (condition.contains("assign2")){
                            String line = reader.readLine() + "\n";
                            assign2TextArea.appendText(line);
                        }

                        else if (condition.contains("chat2")){
                            String line = reader.readLine() + "\n";
                            chat2TextArea.appendText(line);
                        }

                        else if (condition.contains("allNotice")){
                            String line = reader.readLine() + "\n";
                            noticeTextArea.appendText(line);
                        }
                        else if (condition.contains("allAssign1")){
                            String line = reader.readLine() + "\n";
                            assign2TextArea.appendText(line);
                        }

                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }


    @FXML
    void msgSend() throws IOException {
        String msg = msgTextField.getText() +"\n";
        msgTextField.setText("");
        writer.write("AllMsg\n");
        writer.flush();
        writer.write(msg);
        writer.flush();

    }

    @FXML
    void chat2() throws IOException {
        String msg = chat2TextField.getText() +"\n";
        chat2TextField.setText("");
        writer.write("chat2\n");
        writer.flush();
        writer.write(msg);
        writer.flush();
    }

    @FXML
    void begin2() throws IOException {
        String msg = assign2TextField.getText() +"\n";
        assign2TextField.setText("");
        writer.write("assign2\n");
        writer.flush();
        writer.write("[Beggining] "+msg);
        writer.flush();
    }

    @FXML
    void run2() throws IOException {
        String msg = assign2TextField.getText() +"\n";
        assign2TextField.setText("");
        writer.write("assign2\n");
        writer.flush();
        writer.write("[Running] "+msg);
        writer.flush();
    }

    @FXML
    void end2() throws IOException {
        String msg = assign2TextField.getText() +"\n";
        assign2TextField.setText("");
        writer.write("assign2\n");
        writer.flush();
        writer.write("[Ended] "+msg);
        writer.flush();
    }
}
