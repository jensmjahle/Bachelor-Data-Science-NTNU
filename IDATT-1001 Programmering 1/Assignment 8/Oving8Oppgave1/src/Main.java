import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);


    Person person = new Person("Jens Martin", "Jahle", 2000);
    WorkTaker workTaker = new WorkTaker(person, 3, 2010, 18000, 20);

    int menyChoice;

    do {
      System.out.println("Velkommen, du har følgende valg: \n Tast 1 for å printe informasjon \n Tast 2 for å gjøre endringer \n Tast 3 for å avslutte");
      menyChoice = in.nextInt();


      if (menyChoice == 1) {
        System.out.println("Fult navn: " + workTaker.getName());
        System.out.println("Fornavn: " + workTaker.getFirstname());
        System.out.println("Etternavn: " + workTaker.getSurname());
        System.out.println("Fødselsår: " + workTaker.getBirthYear());
        System.out.println("Alder: " + workTaker.getAge());
        System.out.println("Arbeidsnummer: " + workTaker.getWorkTakerNr());
        System.out.println("Ansettelsesår: " + workTaker.getYearOfHire());
        System.out.println("Månedslønn: " + workTaker.getMonthlySalary());
        System.out.println("Skatt prosent: " + workTaker.getTaxPercent());
        System.out.println("Månedlig skatt: " + workTaker.getmonthlyTax());
        System.out.println("Årlig brutto lønn: " + workTaker.getYearlyBruttoSalary());
        System.out.println("Årlig skatt: " + workTaker.getYearlyTax());
        System.out.println("Antall år i bedriften: " + workTaker.getYearsInCompany());
      } else if (menyChoice == 2) {
        System.out.println("Tast 1 for å endre lønn " +
                "\nTast 2 for å endre skatteprosent " +
                "\nTast 3 for å sjekke om personen har jobbet i bedriften et bestemt antall år");
        int choice = in.nextInt();
        if (choice == 1) {
          System.out.println("Hva er den nye månedslønnen?");
          double newSalary = in.nextDouble();
          workTaker.setMonthlySalary(newSalary);
          System.out.println("Ny lønn: " + workTaker.getMonthlySalary());
        } else if (choice == 2) {
          System.out.println("Hva er den nye skatteprosenten:");
          double newTaxPercentage = in.nextDouble();
          if (0 <= newTaxPercentage && newTaxPercentage <= 100) {
            workTaker.setTaxPercent(newTaxPercentage);
            System.out.println("NY skatteprosent: " + workTaker.getTaxPercent());

          } else {
            System.out.println("Prosenten må være mellom 0 og 100");
          }
        } else if (choice == 3) {
          System.out.println("Skriv inn antall år for å sjekke om personen har jobbet her så lenge");
          int year = in.nextInt();
          System.out.println(workTaker.hasThePersonWorkedForMoreThan(year));

        } else {
          System.out.println("Prøv igjen!");
        }
      } else if (menyChoice == 3) {
        System.out.println("Prekæs!");

      } else {
        System.out.println("Tast inn et gyldig tall");
      }


    } while (menyChoice != 3);


  }

}