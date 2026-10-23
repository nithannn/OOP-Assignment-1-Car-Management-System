
/*
 * CarApp.java
 * Main class: accepts input and lets the user interact with a Car object.
 */
import java.util.Scanner;

public class CarApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== CAR MANAGEMENT SYSTEM ====");
       
        // Read information to create the car object
        System.out.print("Enter car brand: ");
        String brand = input.nextLine();

        System.out.print("Enter car model: ");
        String model = input.nextLine();

        System.out.print("Enter manufacturing year: ");
        int year = input.nextInt();

        System.out.print("Enter price (RM): ");
        double price = input.nextDouble();

        System.out.print("Enter mileage (km): ");
        int mileage = input.nextInt();
        input.nextLine(); // consume the remaining newline

        System.out.print("Enter fuel type: ");
        String fuelType = input.nextLine();

        // Validate the availability response.
        String answer;
        while (true) {
            System.out.print("Is the car available? (yes/no): ");
            answer = input.nextLine().trim();

            if (answer.equalsIgnoreCase("yes")
                    || answer.equalsIgnoreCase("no")) {
                break;
            }

            System.out.println("Invalid response. Please enter yes or no.");
        }

        boolean available = answer.equalsIgnoreCase("yes");

        // Create an object using the parameterized constructor
        Car car1 = new Car(brand, model, year, price,
                           mileage, fuelType, available);

        int choice;

        // The do-while loop repeats the menu until option 6 is selected
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. View car details");
            System.out.println("2. Update mileage");
            System.out.println("3. Estimate resale value");
            System.out.println("4. Check service requirement");
            System.out.println("5. Change availability");
            System.out.println("6. Exit");

            // Validate that the menu choice is a number from 1 to 6.
            while (true) {
                System.out.print("Choose an option: ");

                if (input.hasNextInt()) {
                    choice = input.nextInt();

                    if (choice >= 1 && choice <= 6) {
                        break;
                    }

                    System.out.println("Invalid choice. Select 1 to 6.");
                } else {
                    System.out.println("Invalid input. Enter a number from 1 to 6.");
                    input.next();
                }
            }

            // The switch statement chooses the operation
            switch (choice) {
                case 1:
                    car1.displayCarDetails();
                    break;

                case 2:
                    System.out.print("Enter new mileage (km): ");

                    // Validate the new mileage.
                    while (!input.hasNextInt()) {
                        System.out.println("Invalid input. Enter a whole number.");
                        input.next();
                        System.out.print("Enter new mileage (km): ");
                    }

                    int newMileage = input.nextInt();

                    if (newMileage >= 0) {
                        car1.setMileage(newMileage);
                        System.out.println("Mileage updated to "
                                + car1.getMileage() + " km.");
                    } else {
                        System.out.println(
                                "Invalid mileage. It cannot be negative.");
                    }
                    break;

                case 3:
                    System.out.printf("Estimated resale value: RM %.2f%n",
                            car1.calculateEstimatedResaleValue());
                    break;

                case 4:
                    if (car1.needsService()) {
                        System.out.println(
                                "Service check recommended (10,000 km threshold).");
                    } else {
                        System.out.println(
                                "Mileage is below the example 10,000 km threshold.");
                    }
                    break;

                case 5:
                    car1.setAvailable(!car1.isAvailable());
                    System.out.println("Availability changed to: "
                            + (car1.isAvailable() ? "Yes" : "No"));
                    break;

                case 6:
                    System.out.println("Program closed.");
                    break;

                default:
                    System.out.println("Invalid choice. Select 1 to 6.");
            }
        } while (choice != 6);

        input.close();
    }
}
