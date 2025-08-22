package LLD.solid.ISP;


interface Shape{
   public void area();
   public void volume();
}

class Square implements Shape{
    private double side;

    public Square(double side)
    {
        this.side = side;
    }

    @Override
    public void area()
    {
        double squareArea = this.side * this.side;
        System.out.println("The Area Of Square is : "+squareArea);
    }
    @Override
    public void volume()
    {
        throw new UnsupportedOperationException("Volume is not possible in square");
    }
}

class Rectangle implements Shape{
    private double height;
    private double weight;

    public Rectangle(double height,double weight)
    {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public void area()
    {
        double recArea = this.height * this.weight;
        System.out.println("The Area Of Rectangle is : "+recArea);
    }
    @Override
    public void volume()
    {
        throw new UnsupportedOperationException("Volume is not possible in Rectangle");
    }
}

class Cube implements Shape{
    private double side;

    public Cube(double side)
    {
        this.side = side;
    }

    @Override
    public void area()
    {
        double cubeArea = 6 * this.side * this.side;
        System.out.println("The Area Of Square is : "+cubeArea);
    }
    @Override
    public void volume()
    {
       double cubeVolume = this.side * this.side * this.side;
       System.out.println("The Volume of Cube is "+cubeVolume);
    }
}

public class ISPViolated {

    public static void main(String[] args) {
        Square sq = new Square(3);
        Rectangle rec = new Rectangle(5, 7);
        Cube cb = new Cube(6);

        sq.area();
        rec.area();
        cb.area();

        try{
            // sq.volume();
            // rec.volume();

            cb.volume();
        }catch(Exception e)
        {
            System.out.println("Exception is : "+e.getMessage());
        }
    }
    
}
