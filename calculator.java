import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vítejte v kalkulačce!");

        while (true) {
            System.out.println("Vyberte operaci:");
            System.out.println("1 - Sčítání");
            System.out.println("2 - Odčítání");
            System.out.println("3 - Násobení");
            System.out.println("4 - Dělení");
            System.out.println("0 - Konec");

            int volba = scanner.nextInt();

            if (volba == 0) {
                System.out.println("Konec programu.");
                break;
            }

            System.out.println("Zadejte první číslo:");
            double cislo1 = scanner.nextDouble();
            System.out.println("Zadejte druhé číslo:");
            double cislo2 = scanner.nextDouble();

            switch (volba) {
                case 1:
                    System.out.println("Výsledek: " + (cislo1 + cislo2));
                    break;
                case 2:
                    System.out.println("Výsledek: " + (cislo1 - cislo2));
                    break;
                case 3:
                    System.out.println("Výsledek: " + (cislo1 * cislo2));
                    break;
                case 4:
                    if (cislo2 == 0) {
                        System.out.println("Nelze dělit nulou!");
                    } else {
                        System.out.println("Výsledek: " + (cislo1 / cislo2));
                    }
                    break;
                default:
                    System.out.println("Neplatná volba, zadejte prosím znovu.");
            }
        }

        scanner.close();
    }
}
