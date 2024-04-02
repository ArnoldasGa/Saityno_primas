package lt.viko.eif.agaigalas.onlinerentalserverapp.meniu;

import lt.viko.eif.agaigalas.onlinerentalserverapp.database.DatabaseAdd;
import lt.viko.eif.agaigalas.onlinerentalserverapp.database.DatabaseJaxb;
import lt.viko.eif.agaigalas.onlinerentalserverapp.database.DatabaseLoad;
import lt.viko.eif.agaigalas.onlinerentalserverapp.model.*;
import lt.viko.eif.agaigalas.onlinerentalserverapp.util.JaxbUtil;
import lt.viko.eif.agaigalas.onlinerentalserverapp.util.XmlToPojo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is to manage the program and displays the menu options
 */
public class MenuOptions {
    /**
     * Menu options and inputs for the user
     */
    public static void menu(){

        int choice;
        do{
            choice = option();
            switch (choice){
                case 1:
                    loadMovies();
                    break;
                case 2:
                    addMovie();
                    break;
                case 3:
                    DatabaseJaxb.loadAllMovies();
                    break;
                case 4:
                    XmlToPojo.xmlToPojo();
                    break;
                case 5:
                    JaxbUtil.validateXml("movies.xml" , "JAXBObject.xsd");
                    break;
                case 0:
                    System.out.println("Good Bye.");
                    break;
                default:
                    System.out.println("No option like that.");
                    break;
            }
        } while (choice != 0);

    }
    /**
     * Displays the menu options and returns the user's choice.
     *
     * @return The user's choice.
     */
    protected static int option () {
        System.out.println("Select one of the options: ");
        System.out.println("1.Print all movies");
        System.out.println("2.Add new movie");
        System.out.println("3.JAXB form POJO to xml");
        System.out.println("4.JAXB from xml to POJO");
        System.out.println("5.Validate");
        System.out.println("0.End program");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    /**
     * Adds a new movie to the database based on user input.
     */

    protected static void addMovie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input movie name: ");
        String movieName =scanner.nextLine();
        System.out.println("How many actors there will be ?");
        int option = scanner.nextInt();
        scanner.nextLine();
        ArrayList<String> actorsList = new ArrayList<String>();
        for (int i = 0;i<option;i++) {
            System.out.println("Input actors first name: ");
            String firstName = scanner.nextLine();
            System.out.println("Input actors last name: ");
            String lastName = scanner.nextLine();
            actorsList.add(firstName+","+lastName);
            System.out.println(actorsList);
        }
        System.out.println("How many genres there will be ?");
        ArrayList<String> genresList = new ArrayList<String>();
        option = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0;i<option;i++) {
            System.out.println("Input genre: ");
            String genre = scanner.nextLine();
            genresList.add(genre);
            System.out.println(genresList);
        }
        System.out.println("Input director first name:");
        String directorFirstName = scanner.nextLine();
        System.out.println("Input director last name:");
        String directorLastName = scanner.nextLine();
        Director director = new Director(directorFirstName,directorLastName);
        System.out.println("Input studio:");
        String input = scanner.nextLine();
        ProductionCompany studio = new ProductionCompany(input);
        DatabaseAdd.addMovie(movieName,actorsList,genresList,director,studio);
    }
    /**
     * Loads all movies from the database.
     */
    protected static void loadMovies() {
        DatabaseLoad.loadAllMovies();
    }

}
