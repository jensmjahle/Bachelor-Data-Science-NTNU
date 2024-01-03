
class Øving2_Oppgave2 {
    public static void main(String[] args) {
        double kjøttdeig_a = 35.9 / 0.45;
        double kjøttdeig_b = 39.50 / 0.5;

        System.out.println("Kiloprisen til kjøttmerke A: " + String.format("%.2f", kjøttdeig_a) + "kr");
        System.out.println("Kiloprisen til kjøttmerke B: " + kjøttdeig_b + "kr");

        if (kjøttdeig_a > kjøttdeig_b) {
            System.out.println("Kjøttmerke B er billigst");
        } else {
            System.out.println("Kjøttmerke A er billigst");
        }

    }
}