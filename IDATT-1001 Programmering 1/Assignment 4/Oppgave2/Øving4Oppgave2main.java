import java.util.Scanner;

class Øving4Oppgave2 {

    public static void main(String[] args) {

        Player playerA = new Player(0, "playerAName");
        Player playerB = new Player(0, "playerBName");

        Scanner in = new Scanner(System.in);

        System.out.println(
                "Hællæ! \n Har du lyst til å spille terningspill? \n Tast 1 for å spille \n Tast 0 for å avslutte");
        int valg = in.nextInt();
        int round = 1;

        if (valg == 1) {
            /* Gir navn til player A og player B */
            System.out.println("Name player A:");
            playerA.playerName = in.next();
            System.out.println("Name player B:");
            playerB.playerName = in.next();
        } else if (valg != 0) {
            System.out.println("Du må gi gyldig input");
            main(args);
        }

        while (valg == 1) {

            playerA.sumPoeng = playerA.kastTerning(playerA.sumPoeng); /* legger til et terningkast til poengsummen */
            playerB.sumPoeng = playerB.kastTerning(playerB.sumPoeng);

            System.out.println(String.format("Runde: %d %s har %d poeng %s har %d poeng", round, playerA.playerName,
                    playerA.sumPoeng, playerB.playerName, playerB.sumPoeng));

            if (playerA.sumPoeng == 100 && playerB.sumPoeng == 100) {
                System.out.println("Det ble uavgjort!");
                main(args);
            } else if (playerA.sumPoeng == 100) {
                System.out.println(String.format("%s vant terningspillet på runde %d", playerA.playerName, round));
                main(args);
            } else if (playerB.sumPoeng == 100) {
                System.out.println(String.format("%s vant terningspillet på runde %d", playerB.playerName, round));
                main(args);
            }
            round++;

        }
        System.out.println("Håper du vil spille en annen gang, HADE!");
        in.close();
    }
}