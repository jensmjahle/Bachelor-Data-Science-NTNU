package Oving10Oppgave2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static Scanner in = new Scanner(System.in);
  public MenyRegister menyRegister = new MenyRegister();


  public static void main(String[] args) {


        Main main = new Main();
        main.testData();
        while (true) {
          main.visMeny();
        }
      }

  /**
   * Metoden lager en sett med retter for å teste programmet.
   */
  public void testData() {
        menyRegister.registrerNyRett("Hest", "Forrett", 60, "Aner ikke");
        menyRegister.registrerNyRett("Hvitløksbrød", "Forrett", 40, "Aner ikke");
        menyRegister.registrerNyRett("Pizza", "Hovedrett", 110, "Aner ikke");
        menyRegister.registrerNyRett("Burger", "Hovedrett", 120, "Aner ikke");
        menyRegister.registrerNyRett("Biff", "Hovedrett", 150, "Aner ikke");
        menyRegister.registrerNyRett("Brownie", "Dessert", 85, "Aner ikke");
        menyRegister.registrerNyRett("Karamellpudding", "Dessert", 100, "Aner ikke");
      }

  /**
   * Metoden fungerer som hovedmeny og gir bruker mulighet til å registrere ny retter, søke og opprette menyer.
   */
  public void visMeny() {
        System.out.println("");
        System.out.println("Tast 1 for å registrere en ny rett");
        System.out.println("Tast 2 for å finne en rett, gitt navnet");
        System.out.println("Tast 3 for å finne alle retter av en gitt type");
        System.out.println("Tast 4 for å registrere ny meny");
        System.out.println("Tast 5 for å finne alle menyer med totalpris innen gitt intervall");

        int menyInput = in.nextInt();
        switch (menyInput) {
          case 1:
            nyRett();
            break;
          case 2:
            finnRettMedNavn();
            break;
          case 3:
            finnRetterMedType();
            break;
          case 4:
            nyMeny();
            break;
          case 5:
            finnMenyerMedPris();
            break;
          default:
            System.out.println("Du må skrive et tall fra 1-5");
            break;
        }
      }

  /**
   * Metoden lager en ny rett.
   */
      public void nyRett() {
        in.nextLine();
        System.out.print("Navn: "); String navn = in.nextLine();
        // Sjekker om det eksisterer en rett med samme navn
        if (menyRegister.getRettNavn(navn).size() > 0) {
          System.out.println("Det er allerede registrert en rett med dette navnet");
        } else {
          System.out.print("Type: "); String type = in.nextLine();
          System.out.print("Pris: "); int pris = in.nextInt();
          in.nextLine();
          System.out.print("Oppskrift: "); String oppskrift = in.nextLine();

          Rett nyRett = menyRegister.registrerNyRett(navn, type, pris, oppskrift);
          System.out.println("Retten ble registrert: ");
          System.out.println(nyRett.toString());
        }
      }

  /**
   * Metoden finner en rett ut ifra rettens navn.
   */
      public void finnRettMedNavn() {
        in.nextLine();
        System.out.print("Navn: "); String navn = in.nextLine();
        ArrayList<Rett> retter = menyRegister.getRettNavn(navn);
        if (retter.size() > 0) {
          for (int i = 0; i < retter.size(); i++) {
            System.out.println(retter.get(i).toString());
          }
        } else {
          System.out.println("Fant ingen retter som heter " + navn);
        }
      }

  /**
   * Metoden finner alle retter som har den gitte typen.
   */
  public void finnRetterMedType() {
        in.nextLine();
        System.out.print("Type: "); String type = in.nextLine();
        ArrayList<Rett> retter = menyRegister.getRettType(type);
        if (retter.size() > 0) {
          for (int i = 0; i < retter.size(); i++) {
            System.out.println(retter.get(i).toString());
          }
        } else {
          System.out.println("Fant ingen retter som er en " + type);
        }
      }

  /**
   * Metoden lager en ny meny med eksisterende retter.
   */
  public void nyMeny() {
        boolean ferdig = false;
        ArrayList<Rett> retter = new ArrayList<Rett>();

        String alleRetter = "";
        for (int i = 0; i < menyRegister.getRetter().size(); i++) {
          if (i != 0) {
            alleRetter = alleRetter + ", ";
          }
          alleRetter = alleRetter + menyRegister.getRetter().get(i).toSmallString();
        }
        System.out.println("Registrerte retter:");
        System.out.println(alleRetter);

        in.nextLine();
        while (!ferdig) {
          if (retter.size() < 1) {
            System.out.print("Skriv inn navn på rett som skal være med i menyen: ");
          } else {
            System.out.print("Tast 1 for å registere menyen eller skriv inn navn på rett som skal være med i menyen: ");
          }
          String navn = in.nextLine();
          if (navn.equals("1")) {
            ferdig = true;
          } else {
            ArrayList<Rett> nyRett = menyRegister.getRettNavn(navn);
            if (nyRett.size() > 0) {
              retter.add(nyRett.get(0));
              System.out.println(navn + " ble lagt til i menyen");
            } else {
              System.out.println("Fant ingen retter som heter " + navn);
            }
          }
        }

        System.out.println("Menyen ble registrert");
        menyRegister.NyMeny(retter);
      }

  /**
   * Metoden finner alle menyer med totalpris innen et gitt intervall.
   */
      public void finnMenyerMedPris() {
        System.out.print("Nedre pris: "); int min = in.nextInt();
        System.out.print("Øvre pris: "); int max = in.nextInt();
        ArrayList<Meny> menyer = menyRegister.getMenyerMedPrisintervall(min, max);
        System.out.println("Menyer med pris mellom " + min + " og " + max + ":");
        for (int i = 0; i < menyer.size(); i++) {
          System.out.println("Meny nr " + (i + 1) + ":");
          System.out.println(menyer.get(i).toString());
          System.out.println("");
        }
      }
    }


