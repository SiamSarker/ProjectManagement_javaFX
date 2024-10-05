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
    TextField noticeTextField;

    @FXML
    TextArea assign1TextArea;
    @FXML
    TextField assign1TextField;

    @FXML
    TextArea assign2TextArea;
    @FXML
    TextField assign2TextField;

    @FXML
    TextArea assign3TextArea;
    @FXML
    TextField assign3TextField;

    @FXML
    TextArea chat1TextArea;
    @FXML
    TextField chat1TextField;

    @FXML
    TextArea chat2TextArea;
    @FXML
    TextField chat2TextField;

    @FXML
    TextArea chat3TextArea;
    @FXML
    TextField chat3TextField;



    final private BufferedWriter writer;
    final private BufferedReader reader;

    public Controller() throws IOException {
        String myName = "Leader";

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
                        else if (condition.contains("assign2")){
                            String line = reader.readLine() + "\n";
                            assign2TextArea.appendText(line);
                        }
                        else if (condition.contains("assign3")){
                            String line = reader.readLine() + "\n";
                            assign3TextArea.appendText(line);
                        }
                        else if (condition.contains("chat1")){
                            String line = reader.readLine() + "\n";
                            chat1TextArea.appendText(line);
                        }
                        else if (condition.contains("chat2")){
                            String line = reader.readLine() + "\n";
                            chat2TextArea.appendText(line);
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
                            assign1TextArea.appendText(line);
                        }
                        else if (condition.contains("allAssign2")){
                            String line = reader.readLine() + "\n";
                            assign2TextArea.appendText(line);
                        }
                        else if (condition.contains("allAssign3")){
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
    void noticeSend() throws IOException {
        String msg = noticeTextField.getText() +"\n";
        noticeTextField.setText("");
        writer.write("notice\n");
        writer.flush();
        writer.write(msg);
        writer.flush();

    }

    @FXML
    void assign1() throws IOException {
        String msg = assign1TextField.getText() +"\n";
        assign1TextField.setText("");
        writer.write("assign1\n");
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
    void assign2() throws IOException {
        String msg = assign2TextField.getText() +"\n";
        assign2TextField.setText("");
        writer.write("assign2\n");
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
    void assign3() throws IOException {
        String msg = assign3TextField.getText() +"\n";
        assign3TextField.setText("");
        writer.write("assign3\n");
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
    void allnotice() throws IOException {
        chat3TextField.setText("");
        writer.write("allNotice\n");
        writer.flush();
        writer.write("\n");
        writer.flush();
    }

    @FXML
    void allAssign1() throws IOException {

        assign1TextField.setText("");
        writer.write("allAssign1\n");
        writer.flush();
        writer.write("\n");
        writer.flush();
    }

    @FXML
    void allAssign2() throws IOException {
        assign1TextField.setText("");
        writer.write("allAssign2\n");
        writer.flush();
        writer.write("\n");
        writer.flush();
    }

    @FXML
    void allAssign3() throws IOException {
        assign1TextField.setText("");
        writer.write("allAssign3\n");
        writer.flush();
        writer.write("\n");
        writer.flush();
    }
}
