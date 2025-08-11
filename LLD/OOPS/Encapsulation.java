package LLD.OOPS;

/*
Encapsulation says 2 things:
1. An Object's Characteristics and its behavior are encapsulated together
within that Object.
2. All the characteristics or behaviors are not for everyone to access.
Object should provide data security.

We follow above 2 pointers about Object of real world in programming by:
1. Creating a class that act as a blueprint for Object creation. Class contain
all the characteristics (class variable) and behavior (class methods) in one block,
encapsulating it together.
2. We introduce access modifiers (public, private, protected, default) etc to provide data
security to the class members.
*/

class Favorite {
    String brand;
    String model;
    Boolean isEngineOn = false;
    int currentSpeed = 0;
    int currentGear = 0;

    private String tyreCompany ;


    public Favorite(String brand,String model)
    {
        this.brand = brand;
        this.model = model;
    }

    public void setCompanyTyre(String tyre)
    {
        tyreCompany = tyre;
    }

    public String getTyreCompany()
    {
        return this.tyreCompany;
    }

    public void startEngine(){
        isEngineOn = true;
        System.out.println(brand+" "+model+" : Engine Starts With A Roar");
    }

    public void shiftGear(int gear)
    {
        if(!isEngineOn)
        {
            System.out.println(brand+" "+model+" : Engine is OFF, First On The Engine");
            return;
        }
        currentGear = gear;
        System.out.println(brand+" "+model+" : Current Gear is "+ gear);
    }
    public void accelerate(int speed)
    {
        if(!isEngineOn)
        {
            System.out.println(brand+" "+model+" : Engine is OFF, First On The Engine");
            return;
        }
        currentSpeed+= speed;
        System.out.println(brand+" "+ model+" : Car Current Speed Is"+ currentSpeed+"KM/h");
    }

    public void decreaseSpeed()
    {
        currentSpeed -= 20;
        if(currentSpeed < 0)
        {
            currentSpeed = 0;
            System.out.println(brand+" "+model+" : Current speed is 0");
            return;
        }
        System.out.println(brand+" "+model+" : Current Speed Is "+currentSpeed+"KM/h");
    }

    public void stopEngine()
    {
        isEngineOn = false;
        currentGear = 0;
        currentSpeed = 0;
        System.out.println(brand+" "+model+" :Car Engine is OFF");
    }

}
public class Encapsulation {

    public static void main(String[] args) {
        Favorite dreamCar = new Favorite("Toyoto", "Crista");

        dreamCar.accelerate(20);
        dreamCar.shiftGear(2);
        dreamCar.startEngine();
        dreamCar.shiftGear(2);
        dreamCar.accelerate(30);
        dreamCar.accelerate(20);
        System.out.println("Current Speed : "+dreamCar.currentSpeed);
        System.out.println("Current Gear : "+dreamCar.currentGear);
        System.out.println("Tyre Company : "+dreamCar.getTyreCompany());
        dreamCar.setCompanyTyre("MRF");
        System.out.println("Tyre Company : "+dreamCar.getTyreCompany());
        dreamCar.shiftGear(4);

        dreamCar.decreaseSpeed();
        dreamCar.stopEngine();

    }
}
