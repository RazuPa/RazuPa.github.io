import java.util.Scanner; // import the Scanner Class

public class ProfileGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a scanner object

        // Ask for name
        System.out.println("Enter your name: ");
        String name = scanner.nextLine(); // Read a String input

        // Ask for age
        System.out.println("Enter your age: ");
        int age = scanner.nextInt(); // Read an int input

        // Ask for grade
        System.out.print("Who do you like?: ");
        char letter = scanner.next().charAt(0); // Read a single character input

        // Ask for favorite item price
        System.out.println("What should a bottle of water cost?: ");
        double price = scanner.nextDouble(); // Read a double input

        // Ask if Java is fun
        boolean isJavaFun = false;
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Do you think java is fun? (true/false): ");
            if (scanner.hasNextBoolean()) {
                isJavaFun = scanner.nextBoolean(); // Read a boolean input
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter true or false.");
                scanner.next(); // Consume the invalid input
            }
        }

        // Print a summary
        System.out.println("\n--- Profile Summary ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Who do you like?: " + letter);
        System.out.printf("What should a bottle of water cost?: $%.2f\n", price); // Format to 2 decimal places
        System.out.println("Likes Java: " + isJavaFun);

        // Bonus: Add a comment about Java
        if (isJavaFun) {
            System.out.println("That's solid! Keep it going!");
        } else {
            System.out.println("No worries, there are other programming languages available!");
        }

        scanner.close(); // Close the scanner to free resources
    }
}