package LLD.solid.ISP;


interface Shape2D{
   public void area();
}
interface Shape3D{
   public void area();
   public void volume();
}

class Square2 implements Shape2D{
    private double side;

    public Square2(double side)
    {
        this.side = side;
    }

    @Override
    public void area()
    {
        double squareArea = this.side * this.side;
        System.out.println("The Area Of Square is : "+squareArea);
    }
}

class Rectangle2 implements Shape2D{
    private double height;
    private double weight;

    public Rectangle2(double height,double weight)
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
}

class Cube2 implements Shape3D{
    private double side;

    public Cube2(double side)
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

public class ISPFollowed{

    public static void main(String[] args) {
        Square sq = new Square(7);
        Rectangle rec = new Rectangle(2, 3);
        Cube cb = new Cube(4);

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
