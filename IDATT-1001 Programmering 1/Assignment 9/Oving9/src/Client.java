import java.util.Scanner;

public class Client {
  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    TaskCollection taskCollection = new TaskCollection();

    boolean showMeny = true;
    do{
      System.out.println(" Meny \n Tast 1 for informasjon \n Tast 2 for å gjøre endringer \n Tast 3 for å avslutte");
      int menyChoice = in.nextInt();
      if (menyChoice == 1) {
        System.out.println(taskCollection);
      } else if (menyChoice == 2) {
        System.out.println(" Tast 1 for å legge til en student \n Tast 2 for øke antall oppgaver til en student");
        int innerMenyChoice = in.nextInt();
        if (innerMenyChoice == 1) {
          in.nextLine();
          System.out.println("Tast inn navn:");
          String name = in.nextLine();
          System.out.println("Tast inn antall oppgaver:");
          int tasks = in.nextInt();
          taskCollection.addNewStudent(name, tasks);
        } else if (innerMenyChoice == 2) {
          in.nextLine();
          System.out.println("Hvilken student");
          String studName = in.nextLine();
          int id = taskCollection.getStudId(studName);
          try {
            Student student = taskCollection.getStudent(id);
            System.out.println("hvor stor økning?");
            int increasement = in.nextInt();
            student.increaseTaskAmount(increasement);
          } catch (IndexOutOfBoundsException e) {
            System.out.println("studenten finnes ikke");
          }
        }
      } else if (menyChoice == 3) {
        showMeny = false;
      }

    } while (showMeny);


  }


}