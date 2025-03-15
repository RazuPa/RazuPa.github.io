/**
 * Electric Car Charging Time Calculator
 * 
 * This program calculates the charging time of an electric car battery
 * given different current and voltage combinations.
 *
 * Steps:
 * 1. Define constants for battery capacity and voltage levels.
 * 2. Compute the charging power for each combination.
 * 3. Calculate the charging time based on the power output.
 * 4. Round results to two decimal places using Math.round().
 * 5. Display the results in a tabular format using printf().
 */

 public class PrintTable {
    // Constants
    private static final double BATTERY_CAPACITY_KWH = 35.8;
    private static final int VOLTAGE_SINGLE_PHASE = 230;
    private static final int VOLTAGE_THREE_PHASE = 400;
    private static final double SQRT_3 = Math.sqrt(3);

    public static void main(String[] args) {
        // Define current values
        int[] currents = {10, 16, 32, 16, 32};
        int[] voltages = {VOLTAGE_SINGLE_PHASE, VOLTAGE_SINGLE_PHASE, VOLTAGE_SINGLE_PHASE, VOLTAGE_THREE_PHASE, VOLTAGE_THREE_PHASE};
        boolean[] isThreePhase = {false, false, false, true, true};
        
        // Print table header
        System.out.printf("%-10s %-10s %-15s %-15s\n", "Current (A)", "Voltage (V)", "Charging Power (kW)", "Charging Time (h)");
        System.out.println("------------------------------------------------------------");
        
        // Compute and display results
        for (int i = 0; i < currents.length; i++) {
            double powerKW;
            if (isThreePhase[i]) {
                powerKW = (currents[i] * voltages[i] * SQRT_3) / 1000.0;
            } else {
                powerKW = (currents[i] * voltages[i]) / 1000.0;
            }
            
            double chargingTime = BATTERY_CAPACITY_KWH / powerKW;
            powerKW = Math.round(powerKW * 100.0) / 100.0;
            chargingTime = Math.round(chargingTime * 100.0) / 100.0;
            
            System.out.printf("%-10d %-10d %-15.2f %-15.2f\n", currents[i], voltages[i], powerKW, chargingTime);
        }
    }
}