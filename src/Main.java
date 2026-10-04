import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value;

        while (true) {
            System.out.print("Enter a number: ");
            String line = scanner.nextLine().trim();

            if (line.isEmpty()) {
                System.out.println("Input cannot be empty or whitespace.");
                continue;
            }

            try {
                value = Integer.parseInt(line);

                if (value < 0) {
                    System.out.println("Input cannot be negative.");
                    continue;
                }

                break;
            } catch (NumberFormatException e) {
                System.out.println("'" + line + "' is not a valid input.");
            }
        }

        System.out.println(value);
        scanner.close();
    }
}