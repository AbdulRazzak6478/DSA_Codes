package LLD.OOPS;

/*
Dynamic Polymorphism in real life says that 2 Objects coming from same
family will respond to same stimulus differently. Like in real world Manual
car and Electric car will respond to accelerate() differently.

To represent this in programming, we create a parent class that defines all
characters and behaviours that are generic to all child classes and are also same in
all child classes but make those methods abstract that are generic to all
child classes but all child class will behave differently. Then those child class
will provide implementation details of these abstract methods the way they want.
*/
abstract class CarWheeler {
    protected String brand;
    protected String model;
    protected boolean isEngineOn;
    protected int currentSpeed;

    public CarWheeler(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.isEngineOn = false;
        this.currentSpeed = 0;
    }

    // Common methods for all cars.
    public void startEngine() {
        isEngineOn = true;
        System.out.println(brand + " " + model + " : Engine started.");
    }

    public void stopEngine() {
        isEngineOn = false;
        currentSpeed = 0;
        System.out.println(brand + " " + model + " : Engine turned off.");
    }

    // Abstract methods for dynamic polymorphism
    public abstract void accelerate();
    public abstract void brake();
}

class Manual extends CarWheeler {
    private int currentGear;

    public Manual(String brand, String model) {
        super(brand, model);
        this.currentGear = 0;
    }

    // Specialized method for Manual Car
    public void shiftGear(int gear) {
        currentGear = gear;
        System.out.println(brand + " " + model + " : Shifted to gear " + currentGear);
    }

    // Overriding accelerate - Dynamic Polymorphism
    @Override
    public void accelerate() {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Cannot accelerate! Engine is off.");
            return;
        }
        currentSpeed += 20;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed + " km/h");
    }

    // Overriding brake - Dynamic Polymorphism
    @Override
    public void brake() {
        currentSpeed -= 20;
        if (currentSpeed < 0) currentSpeed = 0;
        System.out.println(brand + " " + model + " : Braking! Speed is now " + currentSpeed + " km/h");
    }
}

class Electric extends CarWheeler {
    private int batteryLevel;

    public Electric(String brand, String model) {
        super(brand, model);
        this.batteryLevel = 100;
    }

    // Specialized method for Electric Car
    public void chargeBattery() {
        batteryLevel = 100;
        System.out.println(brand + " " + model + " : Battery fully charged!");
    }

    // Overriding accelerate - Dynamic Polymorphism
    @Override
    public void accelerate() {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Cannot accelerate! Engine is off.");
            return;
        }
        if (batteryLevel <= 0) {
            System.out.println(brand + " " + model + " : Battery dead! Cannot accelerate.");
            return;
        }
        batteryLevel -= 10;
        currentSpeed += 15;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed
                           + " km/h. Battery at " + batteryLevel + "%.");
    }

    // Overriding brake - Dynamic Polymorphism
    @Override
    public void brake() {
        currentSpeed -= 15;
        if (currentSpeed < 0) currentSpeed = 0;
        System.out.println(brand + " " + model + " : Regenerative braking! Speed is now "
                           + currentSpeed + " km/h. Battery at " + batteryLevel + "%.");
    }
}

public class DynamicPolymorphism {
    public static void main(String[] args) {
        CarWheeler myManualCar = new Manual("Suzuki", "WagonR");
        myManualCar.startEngine();
        myManualCar.accelerate();
        myManualCar.accelerate();
        myManualCar.brake();
        myManualCar.stopEngine();

        System.out.println("----------------------");

        CarWheeler myElectricCar = new Electric("Tesla", "Model S");
        myElectricCar.startEngine();
        myElectricCar.accelerate();
        myElectricCar.accelerate();
        myElectricCar.brake();
        myElectricCar.stopEngine();
    }
}
