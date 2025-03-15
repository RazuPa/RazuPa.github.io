import java.util.Scanner;

public class CalculatorOne
 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Simple Calculator");
        System.out.print("Enter first number: ");
        double num1 = getValidNumber(scanner);
        
        System.out.print("Enter operation (+, -, *, /): ");
        char operation = getValidOperation(scanner);
        
        System.out.print("Enter second number: ");
        double num2 = getValidNumber(scanner);
        
        double result = calculate(num1, num2, operation);
        System.out.println("Result: " + result);
        
        scanner.close();
    }

    private static double getValidNumber(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.next());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }

    private static char getValidOperation(Scanner scanner) {
        while (true) {
            String input = scanner.next();
            if (input.length() == 1 && "+-*/".contains(input)) {
                return input.charAt(0);
            }
            System.out.print("Invalid operation. Enter one of (+, -, *, /): ");
        }
    }

    private static double calculate(double num1, double num2, char operation) {
        switch (operation) {
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            case '/': return num2 != 0 ? num1 / num2 : Double.NaN;
            default: return Double.NaN;
        }
    }
}
