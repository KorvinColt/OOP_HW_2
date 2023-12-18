// Абстрактный класс Vehicle
abstract class Vehicle {
    private static int idCounter = 1;

    protected int id;
    protected String brand;
    protected String model;
    protected int year;

    public Vehicle(String brand, String model, int year) {
        this.id = idCounter++;
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    abstract void startEngine();
    abstract void stopEngine();
    abstract void accelerate(int speed);
    abstract void brake();
    abstract void displayInfo();
}

// Интерфейс Flyable
interface Flyable {
    void takeOff();
    void land();
}

// Интерфейс Swimmable
interface Swimmable {
    void startSwimming();
    void stopSwimming();
}

// Класс Car
class Car extends Vehicle {
    private int fuelCapacity;
    private int currentFuelLevel;

    public Car(String brand, String model, int year, int fuelCapacity) {
        super(brand, model, year);
        this.fuelCapacity = fuelCapacity;
        this.currentFuelLevel = fuelCapacity / 2; // Начальный уровень топлива равен половине емкости
    }

    @Override
    void startEngine() {
        System.out.println("Car engine started.");
    }

    @Override
    void stopEngine() {
        System.out.println("Car engine stopped.");
    }

    @Override
    void accelerate(int speed) {
        System.out.println("Car is accelerating at speed " + speed + " km/h.");
    }

    @Override
    void brake() {
        System.out.println("Car is braking.");
    }

    void refuel(int liters) {
        currentFuelLevel += liters;
        if (currentFuelLevel > fuelCapacity) {
            currentFuelLevel = fuelCapacity;
        }
        System.out.println("Car refueled. Current fuel level: " + currentFuelLevel + " liters.");
    }

    @Override
    void displayInfo() {
        System.out.println("Car: " + brand + " " + model + " (" + year + ")");
    }
}

// Класс Aircraft
class Aircraft extends Vehicle implements Flyable {
    private int maxAltitude;
    private boolean isFlying;

    public Aircraft(String brand, String model, int year, int maxAltitude) {
        super(brand, model, year);
        this.maxAltitude = maxAltitude;
        this.isFlying = false;
    }

    @Override
    void startEngine() {
        System.out.println("Aircraft engine started.");
    }

    @Override
    void stopEngine() {
        System.out.println("Aircraft engine stopped.");
    }

    @Override
    void accelerate(int speed) {
        System.out.println("Aircraft is accelerating at speed " + speed + " km/h.");
    }

    @Override
    void brake() {
        System.out.println("Aircraft is braking.");
    }

    @Override
    void displayInfo() {
        System.out.println("Aircraft: " + brand + " " + model + " (" + year + ")");
    }

    @Override
    public void takeOff() {
        if (!isFlying) {
            System.out.println("Aircraft is taking off.");
            isFlying = true;
        } else {
            System.out.println("Aircraft is already in the air.");
        }
    }

    @Override
    public void land() {
        if (isFlying) {
            System.out.println("Aircraft is landing.");
            isFlying = false;
        } else {
            System.out.println("Aircraft is already on the ground.");
        }
    }
}

// Класс Boat
class Boat extends Vehicle implements Swimmable {
    private int maxSpeed;
    private boolean isSailing;

    public Boat(String brand, String model, int year, int maxSpeed) {
        super(brand, model, year);
        this.maxSpeed = maxSpeed;
        this.isSailing = false;
    }

    @Override
    void startEngine() {
        System.out.println("Boat engine started.");
    }

    @Override
    void stopEngine() {
        System.out.println("Boat engine stopped.");
    }

    @Override
    void accelerate(int speed) {
        System.out.println("Boat is accelerating at speed " + speed + " knots.");
    }

    @Override
    void brake() {
        System.out.println("Boat is stopping.");
    }

    @Override
    void displayInfo() {
        System.out.println("Boat: " + brand + " " + model + " (" + year + ")");
    }

    @Override
    public void startSwimming() {
        if (!isSailing) {
            System.out.println("Boat is starting to sail.");
            isSailing = true;
        } else {
            System.out.println("Boat is already sailing.");
        }
    }

    @Override
    public void stopSwimming() {
        if (isSailing) {
            System.out.println("Boat is stopping sailing.");
            isSailing = false;
        } else {
            System.out.println("Boat is already stationary.");
        }
    }
}

// Главный класс Main для проверки
class Main {
    public static void main(String[] args) {
        // Создание объектов различных транспортных средств
        Car car = new Car("Toyota", "Camry", 2022, 60);
        Aircraft aircraft = new Aircraft("Boeing", "747", 2000, 40000);
        Boat boat = new Boat("Yamaha", "242X", 2018, 40);

        // Демонстрация работы транспортных средств
        car.startEngine();
        car.accelerate(60);
        car.brake();
        car.refuel(20);
        car.displayInfo();

        System.out.println();

        aircraft.startEngine();
        aircraft.takeOff();
        aircraft.accelerate(800);
        aircraft.land();
        aircraft.stopEngine();
        aircraft.displayInfo();

        System.out.println();

        boat.startEngine();
        boat.startSwimming();
        boat.accelerate(20);
        boat.stopSwimming();
        boat.stopEngine();
        boat.displayInfo();
    }
}
