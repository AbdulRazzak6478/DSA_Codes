package LLD.OOPS;

/*
  Interface : 
  1.It is a Frame or Entity class Which is used to operate by outside world.
  2.It tells 'WHAT' all it can do rather then 'HOW' it does that.
  3.It has the Characteristics and methods declaration about the entity.
  4.Interface is a abstraction of the characteristics and behaviors or methods of the Specific Entity
  4.child class will have the responsibility to provide implementation details of all the methods in the interface.
 */
/* 
 Class :
 1.It is kind of Blueprint of the Real Time Entity 
 2. It Provide implementation details of an interface/abstract class).
 3.In Class We can define the behavior of the entity or interface
 */
/*
 * Abstraction :
 1.Hide unnecessary implementation details from the client and expose only what is essential to use by the Objects
 
*/
/*
 * Encapsulation :
 1.Bundles an Objects Data its states and methods that operate on that data in single unit, and control access in inner working
 
*/

interface Car {
  void startEngine();

  void shiftGear(int gear);

  void accelerate();

  void breakSpeed();

  void stopEngine();
}

class SportCar implements Car {
  String brand;
  String model;
  Boolean isEngineOn = false;
  int currentSpeed = 0;
  int currentGear = 0;

  public SportCar(String brand, String modelName) {
    this.brand = brand;
    this.model = modelName;
  }

  @Override
  public void startEngine() {
    isEngineOn = true;
    System.out.println(brand + " " + model + " : Engine starts with a roar!");
  }

  @Override
  public void shiftGear(int gear) {
    if (!isEngineOn) {
      System.out.println("First Start the Brand :" + brand + " , Model" + model + " Engine");
      return;
    }
    currentGear = gear;
    System.out.println(brand + " " + model + " : Shifted to gear " + currentGear);
  }

  @Override
  public void accelerate() {
    currentSpeed += 20;
    System.out.println(brand + " " + model + " : Current Speed is :" + currentSpeed + "km/h");
  }

  @Override
  public void breakSpeed() {
    currentSpeed -= 20;
    if (currentSpeed < 0)
      currentSpeed = 0;
    System.out.println(brand + " " + model + " : Braking! Speed is now " + currentSpeed + " km/h");
  }

  @Override
  public void stopEngine() {
    isEngineOn = false;
    currentSpeed = 0;
    currentGear = 0;
    System.out.println(brand + " " + model + " : Engine turned off.");
  }
}

class Abstraction {

  public static void main(String[] args) {
    System.out.println("Sport Car Is Initialized");
    SportCar myCar = new SportCar("Ford", "Mustang");

    myCar.startEngine();
    myCar.shiftGear(1);
    myCar.accelerate();
    myCar.shiftGear(2);
    myCar.accelerate();
    System.out.println("Current Speed : " + myCar.currentSpeed);
    myCar.shiftGear(3);
    myCar.accelerate();
    myCar.shiftGear(4);
    myCar.accelerate();
    myCar.accelerate();
    myCar.accelerate();
    myCar.breakSpeed();
    myCar.breakSpeed();
    myCar.stopEngine();
  }

}
