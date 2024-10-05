import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client implements Runnable {
    final private BufferedReader reader;
    final private BufferedWriter writer;
    ArrayList<Client> clients;
    String clientname;


    public Client(Socket socket, ArrayList<Client> clients) throws IOException {
        InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        reader = new BufferedReader(isr);

        OutputStreamWriter o = new OutputStreamWriter(socket.getOutputStream());
        writer = new BufferedWriter(o);


        clientname = reader.readLine();

        this.clients = clients;
    }




    @Override
    public void run() {

        String clientData = null;
        String condition = null;

        try {

            condition = reader.readLine()+"\n";

            System.out.println((new File("Data.txt")).exists());
            File file = new File("Data.txt");
            File file1 = new File("Data1.txt");
            File file2 = new File("Data2.txt");
            File file3 = new File("Data3.txt");

            FileWriter fileWriter;

            clientData = reader.readLine()+"\n";

            if (condition.contains("AllMsg")|| condition.contains("chat"))
                clientData = clientname + " : "+clientData;

            else if (condition.contains("notice")){
                clientData = "==> "+clientData;
                fileWriter = new FileWriter(file,  true);
                fileWriter.append(clientData);
                fileWriter.close();
            }

            else if (condition.contains("assign1")){
                fileWriter = new FileWriter(file1, true);
                fileWriter.append(clientData);
                fileWriter.close();
            }

            else if (condition.contains("assign2")){
                fileWriter = new FileWriter(file2, true);
                fileWriter.append(clientData);
                fileWriter.close();
            }

            else if (condition.contains("assign3")){
                fileWriter = new FileWriter(file3, true);
                fileWriter.append(clientData);
                fileWriter.close();
            }

            while (clientData != null) {
                for (Client client : clients){
                    synchronized (client.writer) {
                        if (condition.contains("AllMsg")){
                            client.writer.write("AllMsg\n");
                            client.writer.flush();
                        }
                        else if (condition.contains("notice")){
                            client.writer.write("notice\n");
                            client.writer.flush();

                        }
                        else if (condition.contains("assign1")){
                            client.writer.write("assign1\n");
                            client.writer.flush();
                        }
                        else if (condition.contains("assign2")){
                            client.writer.write("assign2\n");
                            client.writer.flush();
                        }
                        else if (condition.contains("assign3")){
                            client.writer.write("assign3\n");
                            client.writer.flush();
                        }
                        else if (condition.contains("chat1")){
                            client.writer.write("chat1\n");
                            client.writer.flush();
                        }
                        else if (condition.contains("chat2")){
                            client.writer.write("chat2\n");
                            client.writer.flush();
                        }
                        else if (condition.contains("chat3")){
                            client.writer.write("chat3\n");
                            client.writer.flush();
                        }
                        else if (condition.contains("allNotice")){
                            Scanner readFile = new Scanner(file);

                            while (readFile.hasNextLine()){
                                client.writer.write("allNotice\n");
                                client.writer.flush();
                                client.writer.write(readFile.nextLine()+"\n");
                                client.writer.flush();
                            }

                            client.writer.write("allNotice\n");
                            client.writer.flush();
                        }
                        else if (condition.contains("allAssign1")){
                            Scanner readFile = new Scanner(file1);

                            while (readFile.hasNextLine()){
                                client.writer.write("allAssign1\n");
                                client.writer.flush();
                                client.writer.write(readFile.nextLine()+"\n");
                                client.writer.flush();
                            }

                            client.writer.write("allAssign1\n");
                            client.writer.flush();
                        }
                        else if (condition.contains("allAssign2")){
                            Scanner readFile = new Scanner(file2);

                            while (readFile.hasNextLine()){
                                client.writer.write("allAssign2\n");
                                client.writer.flush();
                                client.writer.write(readFile.nextLine()+"\n");
                                client.writer.flush();
                            }

                            client.writer.write("allAssign2\n");
                            client.writer.flush();
                        }
                        else if (condition.contains("allAssign3")){
                            Scanner readFile = new Scanner(file3);

                            while (readFile.hasNextLine()){
                                client.writer.write("allAssign3\n");
                                client.writer.flush();
                                client.writer.write(readFile.nextLine()+"\n");
                                client.writer.flush();
                            }

                            client.writer.write("allAssign3\n");
                            client.writer.flush();
                        }

                        client.writer.write(clientData);
                        client.writer.flush();
                    }
                }

                condition = reader.readLine()+"\n";
                clientData = reader.readLine()+"\n";

                if (condition.contains("AllMsg") || condition.contains("chat"))
                    clientData = clientname + " : "+clientData;

                else if (condition.contains("notice")){
                    clientData = "==> "+clientData;
                    fileWriter = new FileWriter(file,  true);
                    fileWriter.append(clientData);
                    fileWriter.close();
                }

                else if (condition.contains("assign1")){
                    fileWriter = new FileWriter(file1, true);
                    fileWriter.append(clientData);
                    fileWriter.close();
                }

                else if (condition.contains("assign2")){
                    fileWriter = new FileWriter(file2, true);
                    fileWriter.append(clientData);
                    fileWriter.close();
                }

                else if (condition.contains("assign3")){
                    fileWriter = new FileWriter(file3, true);
                    fileWriter.append(clientData);
                    fileWriter.close();
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}