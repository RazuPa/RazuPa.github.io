import java.util.Scanner;

public class ChargingTimeCalculatorTwo {
    private static final double SQRT_3 = Math.sqrt(3);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Electric Car Charging Time Calculator");
        
        System.out.print("Enter battery capacity (kWh): ");
        double batteryCapacity = getValidDouble(scanner);
        
        System.out.print("Enter current (A): ");
        int current = getValidInt(scanner);
        
        System.out.print("Enter voltage (V): ");
        int voltage = getValidInt(scanner);
        
        System.out.print("Is it a three-phase connection? (yes/no): ");
        boolean isThreePhase = scanner.next().equalsIgnoreCase("yes");
        
        double powerKW = isThreePhase ? (current * voltage * SQRT_3) / 1000.0 : (current * voltage) / 1000.0;
        double chargingTime = batteryCapacity / powerKW;
        
        powerKW = Math.round(powerKW * 100.0) / 100.0;
        chargingTime = Math.round(chargingTime * 100.0) / 100.0;
        
        System.out.printf("Charging Power: %.2f kW\n", powerKW);
        System.out.printf("Estimated Charging Time: %.2f hours\n", chargingTime);
        
        scanner.close();
    }
    
    private static double getValidDouble(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.next());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }
    
    private static int getValidInt(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }
}
