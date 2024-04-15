package lt.viko.eif.agaigalas.onlinerentalserverapp.meniu;

import lt.viko.eif.agaigalas.onlinerentalserverapp.Socket.JavaClient;
import lt.viko.eif.agaigalas.onlinerentalserverapp.Socket.JavaServer;

import java.util.Random;
import java.util.Scanner;

public class StartMenu {
    public static void startMenu() {
        int choice;
        do {
            choice = option();
            switch (choice) {
                case 1:
                    JavaServer.startServer();
                    break;
                    case 2:
                        JavaClient.startClient();
                        break;
                default:
                    System.out.println("No option like that.");
                    break;
            }
        } while (choice !=0);
    }
    protected static int option () {
        System.out.println("Select one of the starting options: ");
        System.out.println("1.Start server");
        System.out.println("2.Start client");
        //System.out.println("3.JAXB form POJO to xml");
        //System.out.println("4.JAXB from xml to POJO");
        //System.out.println("5.Validate");
        //System.out.println("0.End program");
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
