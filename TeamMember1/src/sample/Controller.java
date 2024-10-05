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
    TextArea chat1TextArea;
    @FXML
    TextField chat1TextField;

    @FXML
    TextArea assign1TextArea;
    @FXML
    TextField assign1TextField;

    final private BufferedWriter writer;
    final private BufferedReader reader;

    public Controller() throws IOException {
        String myName = "TeamMember 1";

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
                        else if (condition.contains("assign1")){
                            String line = reader.readLine() + "\n";
                            assign1TextArea.appendText(line);
                        }

                        else if (condition.contains("chat1")){
                            String line = reader.readLine() + "\n";
                            chat1TextArea.appendText(line);
                        }
                        else if (condition.contains("allNotice")){
                            String line = reader.readLine() + "\n";
                            noticeTextArea.appendText(line);
                        }
                        else if (condition.contains("allAssign1")){
                            String line = reader.readLine() + "\n";
                            assign1TextArea.appendText(line);
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
    void chat1() throws IOException {
        String msg = chat1TextField.getText() +"\n";
        chat1TextField.setText("");
        writer.write("chat1\n");
        writer.flush();
        writer.write(msg);
        writer.flush();
    }

    @FXML
    void begin1() throws IOException {
        String msg = assign1TextField.getText() +"\n";
        assign1TextField.setText("");
        writer.write("assign1\n");
        writer.flush();
        writer.write("[Beggining] "+msg);
        writer.flush();
    }

    @FXML
    void run1() throws IOException {
        String msg = assign1TextField.getText() +"\n";
        assign1TextField.setText("");
        writer.write("assign1\n");
        writer.flush();
        writer.write("[Running] "+msg);
        writer.flush();
    }

    @FXML
    void end1() throws IOException {
        String msg = assign1TextField.getText() +"\n";
        assign1TextField.setText("");
        writer.write("assign1\n");
        writer.flush();
        writer.write("[Ended] "+msg);
        writer.flush();
    }
}
