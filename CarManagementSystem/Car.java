/*
 * Car.java
 * Represents one car and keeps its data and related operations together.
 * Private fields demonstrate encapsulation.
 */
public class Car {

    // Seven attributes describing a car
    private String brand;
    private String model;
    private int year;
    private double price;
    private int mileage;
    private String fuelType;
    private boolean available;

    // Constructor 1: creates a car with default values
    public Car() {
        brand = "Not set";
        model = "Not set";
        year = 0;
        price = 0.0;
        mileage = 0;
        fuelType = "Not set";
        available = false;
    }

    // Constructor 2: creates a car using the values supplied by the user
    public Car(String brand, String model, int year, double price,
               int mileage, String fuelType, boolean available) {
        this(); // start with the default values
        setBrand(brand);
        setModel(model);
        setYear(year);
        setPrice(price);
        setMileage(mileage);
        setFuelType(fuelType);
        setAvailable(available);
    }

    // Getters: provide controlled read access to private attributes
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public int getMileage() {
        return mileage;
    }

    public String getFuelType() {
        return fuelType;
    }

    public boolean isAvailable() {
        return available;
    }

    // Setters: validate values before changing private attributes
    public void setBrand(String brand) {
        if (brand != null && !brand.trim().isEmpty()) {
            this.brand = brand.trim();
        }
    }

    public void setModel(String model) {
        if (model != null && !model.trim().isEmpty()) {
            this.model = model.trim();
        }
    }

    public void setYear(int year) {
        if (year >= 1886 && year <= 2026) {
            this.year = year;
        }
    }

    public void setPrice(double price) {
        if (Double.isFinite(price) && price >= 0) {
            this.price = price;
        }
    }

    public void setMileage(int mileage) {
        if (mileage >= 0) {
            this.mileage = mileage;
        }
    }

    public void setFuelType(String fuelType) {
        if (fuelType != null && !fuelType.trim().isEmpty()) {
            this.fuelType = fuelType.trim();
        }
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Additional method 1: display the current car information
    public void displayCarDetails() {
        System.out.println("\n--- Car Details ---");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.printf("Price: RM %.2f%n", price);
        System.out.println("Mileage: " + mileage + " km");
        System.out.println("Fuel type: " + fuelType);
        System.out.println("Available: " + (available ? "Yes" : "No"));
    }

    // Additional method 2: return a simplified estimated resale value
    // Educational example only; not a real market valuation.
    public double calculateEstimatedResaleValue() {
        if (year < 1886 || year > 2026) {
            return price;
        }

        int age = 2026 - year;
        double depreciationRate = age * 0.10;

        if (depreciationRate > 0.70) {
            depreciationRate = 0.70;
        }

        return price * (1 - depreciationRate);
    }

    // Additional method 3: check the example service threshold
    public boolean needsService() {
        return mileage >= 10000;
    }
}
