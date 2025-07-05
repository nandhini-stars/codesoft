import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Exchange rates (approximate and for demo purpose only)
        double inrToUsd = 1 / 83.25;
        double eurToUsd = 1 / 1.09;
        double jpyToUsd = 1 / 157.30;
        double usdToUsd = 1;

        // Display welcome message
        System.out.println("----- Currency Converter -----");
        System.out.println("Available currencies: USD, INR, EUR, JPY");

        // Get base currency from user
        System.out.print("Enter base currency: ");
        String base = scanner.next().toUpperCase();

        // Get target currency from user
        System.out.print("Enter target currency: ");
        String target = scanner.next().toUpperCase();

        // Get amount to convert
        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        // Step 1: Convert base currency to USD
        double amountInUSD = 0;

        if (base.equals("USD")) {
            amountInUSD = amount;
        } else if (base.equals("INR")) {
            amountInUSD = amount * inrToUsd;
        } else if (base.equals("EUR")) {
            amountInUSD = amount * eurToUsd;
        } else if (base.equals("JPY")) {
            amountInUSD = amount * jpyToUsd;
        } else {
            System.out.println("Invalid base currency.");
            scanner.close();
            return;
        }

        // Step 2: Convert USD to target currency
        double convertedAmount = 0;

        if (target.equals("USD")) {
            convertedAmount = amountInUSD * usdToUsd;
        } else if (target.equals("INR")) {
            convertedAmount = amountInUSD * 83.25;
        } else if (target.equals("EUR")) {
            convertedAmount = amountInUSD * 1.09;
        } else if (target.equals("JPY")) {
            convertedAmount = amountInUSD * 157.30;
        } else {
            System.out.println("Invalid target currency.");
            scanner.close();
            return;
        }

        // Display result
        System.out.printf("%.2f %s = %.2f %s\n", amount, base, convertedAmount, target);

        scanner.close();
    }
}
