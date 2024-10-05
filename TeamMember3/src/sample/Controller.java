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
    TextArea chat3TextArea;
    @FXML
    TextField chat3TextField;

    @FXML
    TextArea assign3TextArea;
    @FXML
    TextField assign3TextField;

    final private BufferedWriter writer;
    final private BufferedReader reader;

    public Controller() throws IOException {
        String myName = "TeamMember 3";

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
                        else if (condition.contains("assign3")){
                            String line = reader.readLine() + "\n";
                            assign3TextArea.appendText(line);
                        }

                        else if (condition.contains("chat3")){
                            String line = reader.readLine() + "\n";
                            chat3TextArea.appendText(line);
                        }

                        else if (condition.contains("allNotice")){
                            String line = reader.readLine() + "\n";
                            noticeTextArea.appendText(line);
                        }
                        else if (condition.contains("allAssign1")){
                            String line = reader.readLine() + "\n";
                            assign3TextArea.appendText(line);
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
    void chat3() throws IOException {
        String msg = chat3TextField.getText() +"\n";
        chat3TextField.setText("");
        writer.write("chat3\n");
        writer.flush();
        writer.write(msg);
        writer.flush();
    }

    @FXML
    void begin3() throws IOException {
        String msg = assign3TextField.getText() +"\n";
        assign3TextField.setText("");
        writer.write("assign3\n");
        writer.flush();
        writer.write("[Beggining] "+msg);
        writer.flush();
    }

    @FXML
    void run3() throws IOException {
        String msg = assign3TextField.getText() +"\n";
        assign3TextField.setText("");
        writer.write("assign3\n");
        writer.flush();
        writer.write("[Running] "+msg);
        writer.flush();
    }

    @FXML
    void end3() throws IOException {
        String msg = assign3TextField.getText() +"\n";
        assign3TextField.setText("");
        writer.write("assign3\n");
        writer.flush();
        writer.write("[Ended] "+msg);
        writer.flush();
    }
}
