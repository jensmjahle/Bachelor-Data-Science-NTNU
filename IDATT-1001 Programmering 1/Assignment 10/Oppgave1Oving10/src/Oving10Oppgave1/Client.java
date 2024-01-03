package Oving10Oppgave1;

import java.util.Scanner;

/**
 * The class represents a client program that has methods for searching, sorting and adding in the event register.
 */
public class Client {

  private static Scanner in = new Scanner(System.in);
  private static EventRegister eventRegister = new EventRegister();

  public static void main(String[] args) {

  boolean clientRunning = true;
  while (clientRunning){
    int mainMenuChoice = mainMenu();
    switch (mainMenuChoice){
      case 1 -> printAllEvents();
      case 2 -> addNewEvent();
      case 3 -> search();
      case 4 -> sort();
      case 5 -> clientRunning = false;

    }
  }

  }

  /**
   * The method represents the main menu in the client program.
   * It gives the user opportunity to print all the events in the register, add a new event, search for events
   * or sort the register.
   * @return
   */
  public static int mainMenu(){
    System.out.println("Main Menu");
    System.out.println("Press 1 to print all the events");
    System.out.println("Press 2 to add a new Event");
    System.out.println("Press 3 to search");
    System.out.println("Press 4 to print a sorted list");
    System.out.println("Press 5 to exit the program");
    int choice = in.nextInt();
    return choice;
  }

  /**
   * The method gives the user opportunity to print all the events in the register.
   */
  public static void printAllEvents(){
    boolean printAllEventsRunning = true;
    do {
      System.out.println(eventRegister);
      System.out.println("Thanks for printing!");
      System.out.println("Press 1 to print again.");
      System.out.println("Press 2 to go back to the main menu.");
      int choice = in.nextInt();
      switch (choice){
        case 1 -> System.out.println("Printing again...");
        case 2 -> printAllEventsRunning = false;
      }
    } while(printAllEventsRunning);
  }

  /**
   * The method gives the user opportunity to add an event to the register.
   */
  public static void addNewEvent(){
    System.out.println("You are now adding a new event.");
    System.out.println("Event number:");
    in.nextLine();
    String newEventNumber = in.nextLine();
    System.out.println("Event name:");
    String newEventName = in.nextLine();
    System.out.println("Event place:");
    String newEventPlace = in.nextLine();
    System.out.println("Event organizer:");
    String newEventOrganizer = in.nextLine();
    System.out.println("Event type:");
    String newEventType = in.nextLine();
    System.out.println("Event time (YYYYMMDDTTTT):");
    double newEventTimestamp = in.nextDouble();
    eventRegister.addNewEvent(newEventNumber,newEventName,newEventPlace,newEventOrganizer,newEventType,newEventTimestamp);
    System.out.println("Thanks for adding an event.");
    System.out.println("Press 1 to add a new event.");
    System.out.println("Press 2 to go back to the main menu.");
    int choice = in.nextInt();
    switch (choice){
      case 1 -> addNewEvent();
      case 2 -> System.out.println("Going back to the main menu.");
    }
  }

  /**
   * The method gives the user opportunity to search for a specific date, a specific place and a time interval between
   * two dates in the event register.
   */
  public static void search(){
    boolean search = true;
    do {
      System.out.println("Press 1 to search for a date");
      System.out.println("Press 2 to search for a place ");
      System.out.println("Press 3 to search in a time interval");
      System.out.println("Press 4 to go back to the main menu");

      int searchChoice = in.nextInt();
      switch (searchChoice){
        case 1 -> {
          System.out.println("Type in date on the form YYYYMMDD");
          int date = in.nextInt();
          System.out.println(eventRegister.getEventsFromDate(date));
        }
        case 2 -> {
          in.nextLine();
          System.out.println("Type in the place");
          String place = in.nextLine();
          System.out.println(eventRegister.getEventsInPlace(place));
        }
          case 3 -> {
            System.out.println("Start date:");
            int startDate = in.nextInt();
            System.out.println("End date:");
            int endDate = in.nextInt();
            System.out.println(eventRegister.getEventsFromTimeInterval(startDate, endDate));

          }
            case 4 -> search = false;

      }
    } while (search);
  }

  /**
   * The method gives the user opportunity to sort the event register by time, place and type of event.
   */
  public static void sort() {
    boolean sort = true;
    do {
      System.out.println("Press 1 to sort by date");
      System.out.println("Press 2 to sort by place");
      System.out.println("Press 3 to sort by type");
      System.out.println("Press 4 to go back to the main menu");
      int choice = in.nextInt();
      switch (choice) {
        case 1 -> System.out.println(eventRegister.getEventRegisterSortedTime());
        case 2 -> System.out.println(eventRegister.getEventRegisterSortedPlace());
        case 3 -> System.out.println(eventRegister.getEventRegisterSortedType());
        case 4 -> sort = false;
      }
    } while (sort);
  }
}