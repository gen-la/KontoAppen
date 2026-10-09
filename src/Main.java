import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AccountRegister register = new AccountRegister();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 6){
            System.out.println();
            System.out.println("1. Skapa konto");
            System.out.println("2. Lista alla konton");
            System.out.println("3. Sök");
            System.out.println("4. Sätt in pengar");
            System.out.println("5. Ta ut pengar");
            System.out.println("6. Avsluta");
            System.out.print("Val: ");
            choice = getIntInput(scanner);

            if (choice == 1){
                System.out.print("Namn: ");
                String name = scanner.nextLine();
                System.out.print("Startsaldo: ");
                int balance = getIntInput(scanner);
                register.createAccount(name, balance);
                System.out.println("Kontot skapat.");
            } else if (choice == 2){
                register.printAll();
            } else if (choice == 3){
                System.out.print("Sök på namn: ");
                String name = scanner.nextLine();
                Account found = register.findAccount(name);
                if (found != null){
                    System.out.println(name);
                } else {
                    System.out.println("Kunde inte hitta " + name);
                }
            } else if (choice == 4){
                System.out.print("Namn: ");
                String name = scanner.nextLine();
                Account found = register.findAccount(name);
                if (found != null){
                    System.out.print("Belopp: ");
                    int amount = getIntInput(scanner);
                    found.deposit(amount);
                    System.out.println("Nytt saldo: " + found.getBalance());
                } else {
                    System.out.println("Konto saknas: " + name);
                }
            } else if (choice == 5){
                System.out.print("Namn: ");
                String name = scanner.nextLine();
                Account found = register.findAccount(name);
                if (found != null){
                    System.out.print("Belopp: ");
                    int amount = getIntInput(scanner);
                    if (amount > found.getBalance()){
                        System.out.println("Ogiltig summa, inte tillräckligt med pengar på kontot. Ditt saldo: " + found.getBalance());
                    } else {
                        found.withdraw(amount);
                        System.out.println("Nytt saldo: " + found.getBalance());
                    }
                } else {
                    System.out.println("Konto saknas: " + name);
                }
            } else if (choice == 6){
                System.out.println("Hej då!");
            } else {
                System.out.println("Ogiltigt val!");
            }
        }
    }

    public static int getIntInput(Scanner scanner) {

        while (true) {
            String line = scanner.nextLine().trim();

            if (line.isEmpty()) {
                System.out.print("Ogiltig inmatning. Ange en siffra: ");
                continue;
            }

            try {
                int value = Integer.parseInt(line);

                if (value < 0) {
                    System.out.print("Input kan inte vara negativt. Ange ett positivt tal: ");
                    continue;
                }

                return value;

            } catch (NumberFormatException e) {
                System.out.print("'" + line + "' är inte ett giltigt val. Ange en siffra: ");
            }
        }
    }
}