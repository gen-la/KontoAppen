import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AccountRegister register = new AccountRegister();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        //int value = getIntInput(scanner);
        //System.out.println("Du skrev: " + value);
        //scanner.close();
    }

    public static int getIntInput(Scanner scanner) {

        while (true) {
            System.out.print("Skriv en siffra: ");
            String line = scanner.nextLine().trim();

            if (line.isEmpty()) {
                System.out.println("Ogiltig inmatning");
                continue;
            }

            try {
                int value = Integer.parseInt(line);

                if (value < 0) {
                    System.out.println("Siffror kan inte vara negativa");
                    continue;
                }

                return value;

            } catch (NumberFormatException e) {
                System.out.println("'" + line + "' ogiltigt.");
            }
        }
    }
}