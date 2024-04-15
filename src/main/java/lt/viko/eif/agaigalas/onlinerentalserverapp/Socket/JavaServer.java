package lt.viko.eif.agaigalas.onlinerentalserverapp.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;

    private BufferedReader in;

    public static void startServer() {
        JavaServer server = new JavaServer();
        server.start(6666);
    }

    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);


            in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            String greeting = in.readLine();
            if ("hello java server ".equals(greeting)) {
                out.println("ok");
                while (true) {
                    greeting = in.readLine();
                    System.out.println("Message received: " + greeting);

                    switch (greeting) {

/*                        case "1":

                            DBLoader.ListOrder().forEach(lst -> out.println(lst));
                            out.println("Finished");
                            break;
                        case "2":
                            DBLoader.ListDispatch().forEach(lst -> out.println(lst));
                            out.println("Finished");
                            break;
                        case "3":
                            DBLoader.ListDriver().forEach(lst -> out.println(lst));
                            out.println("Finished");

                            break;
                        case "4":
                            DBLoader.ListClient().forEach(lst -> out.println(lst));
                            out.println("Finished");
                            break;
                        case "5", "6":
                            out.println(DBLoader.ListOrderXML());
                            out.println("Finished");
                            break;*/

                        case "7":
                            out.println("Goodbye");
                            stop();
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + greeting);
                    }


                }

            } else {
                out.println("unrecognised greeting");
            }

        } catch (IOException e) {
            System.out.println("Exception occured:" + e.getMessage());

        } finally {
            if (serverSocket != null) {
                stop();
            }

        }
    }


    public void stop() {
        try {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            System.out.println("Exception occured:" + e.getMessage());
        }
    }
}
