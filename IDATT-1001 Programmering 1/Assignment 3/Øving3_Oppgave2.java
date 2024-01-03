import java.util.Scanner;

class oving3Oppgave2 {
    public static void main(String[] args) {
        check();
    }

    public static void check() {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Skriv inn et tall som du lurer på om er et primtall:");
            int tall = in.nextInt();
            boolean primtall = true;

            for (int i = 2; i < tall; i++) {

                if (tall % i == 0) {
                    primtall = false;
                    break;

                }
            }

            if (tall < 2) {
                primtall = false;
            }

            if (primtall) {
                System.out.println(String.format("%d er et primtall.", tall));
            } else {
                System.out.println(String.format("%d er ikke et primtall.", tall));
            }

            check();
        }
    }

}
