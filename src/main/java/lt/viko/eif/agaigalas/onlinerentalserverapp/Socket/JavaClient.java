package lt.viko.eif.agaigalas.onlinerentalserverapp.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class JavaClient {
    private ServerSocket serverSocket;
    private static Socket clientSocket;
    private static PrintWriter out;
    private static BufferedReader in;

    /**
     *
     *  Client socket Start
     *  Calls server socket with Greeting waits until server returns respone "ok"
     *  Waits for user input to send request to server socket
     */
    public static void startClient() {
        JavaClient client = new JavaClient();
        try {
            //GenericList<Object> genericList = new GenericList<>();

            client.startConnection("localhost", 6666);
            client.sendMessage("hello java server ");
            String response = client.receiveMessage();
            System.out.println("Server responded: " + response);
            String xmlString = "";
           /* if (Objects.equals(response, "ok")) {
                String Input;
                do {
                    Menu.showMenu();
                    Input = Integer.toString(Menu.selection());
                    client.sendMessage(Input);
                    if(Input.equals("7")) {
                        break;
                    }
                    response = client.receiveMessage();

                    if (Input.equals("5") || Input.equals("6")) {
                        xmlString = printXMLMessage(client);
                        FileOperations.writeToFile("XMLObjectReceived.xml", xmlString);
                        if(Input.equals("5"))
                        {
                            System.out.println(xmlString);
                        }
                        Boolean xmlBool = xmlValidationMessage();
                        if (Input.equals("6") && xmlBool) {
                            //genericList = JaxbUtil.transformToPOJO(Object.class, new File("XMLObjectReceived.xml"), new File("JAXBObject.xsd"));
                            //genericList.getData().forEach(System.out::println);
                            OrderList orderList = JaxbUtil.transformToPOJOGeneratedClass(new File("XMLObjectReceived.xml"), new File("JAXBObject.xsd"));
                            orderList.getOrder().forEach(System.out::println);

                        }
                        else
                        {
                            System.out.println("XML File Failed to Validate");
                        }

                    }
                    else {
                        printMessage(client);
                    }
                    //System.out.println(response);



                } while (!Input.equals("7"));
            }*/
        } catch (IOException e) {
            System.out.println("Exception occured: " + e.getMessage());
        }
        finally {
            client.stopConnection();
        }
    }

    /**
     *
     *  Receives XML string and combines them into single string for processing
     * @param client Client socket to receive server socket response in private method
     * @return returns Completed XML string
     * @throws IOException Exception
     */
    private static String printXMLMessage(JavaClient client) throws IOException {
        String response = "";
        StringBuilder xmlString = new StringBuilder();
        do {
            // System.out.println(response);
            xmlString.append(response).append("\n");
            response = client.receiveMessage();

        } while (!response.equals("Finished"));
        return xmlString.toString();
    }

/*
    */
/**
     *  Outputs ValidateXMLFile validate XMLSchema result to console returns boolean as well
     * @return returns validation output
     *//*

    private static boolean xmlValidationMessage()
    {
        if((ValidateXMLFile.validateXMLSchema("JAXBObject.xsd", "XMLObjectReceived.xml")))
        {
            System.out.println("XML File Successfully Validated");
            return true;
        }
        else
        {
            System.out.println("XML File Failed To Validated");
            return false;
        }
    }
    */
/**
     *
     *  Prints received message from server socket
     * @param client Client socket to receive server socket response in private method
     * @throws IOException Exception
     *//*

    public static void printMessage(JavaClient client) throws IOException {

        String response = "";
        do {
            System.out.println(response);

            response = client.receiveMessage();

        } while (!response.equals("Finished"));

    }
*/

    /**
     *
     * starts connection to server socket
     * @param ip Server ip
     * @param port server port
     * @throws IOException Exception
     */
    public static void startConnection(String ip, int port) throws IOException {

        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));


    }

    /**
     *
     * Send message to server socket
     * @param msg Message to send string
     * @throws IOException Exception
     */
    public static void sendMessage(String msg) throws IOException {
        out.println(msg);

    }

    /**
     *
     * Receive message from server socket
     * @return returns received string from server
     * @throws IOException Exception
     */
    public static String receiveMessage() throws IOException {
        return in.readLine();
    }

    /**
     *
     * Stop connection to server
     */
    public static   void stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();

        } catch (IOException e) {
            System.out.println("Exception occured: " + e.getMessage());
        }

    }


}
