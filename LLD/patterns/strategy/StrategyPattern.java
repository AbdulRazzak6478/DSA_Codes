package LLD.patterns.strategy;


interface Walkable{
    public void walk();
}
interface Talkable{
    public void talk();
}
interface Flyable{
    public void fly();
}


class NormalWalk implements Walkable{

    public void walk()
    {
        System.out.println("Walking Normally...");
    }
}

class NoWalk implements Walkable{

    public void walk()
    {
        System.out.println("Cannot Walk");
    }
}

class NormalTalk implements Talkable{

    public void talk()
    {
        System.out.println("Talking Normally...");
    }
}

class NoTalk implements Talkable{

    public void talk()
    {
        System.out.println("No Talk");
    }
}

class NormalFly implements Flyable{

    public void fly()
    {
        System.out.println("Flying Normally...");
    }
}

class NoFly implements Flyable{

    public void fly()
    {
        System.out.println("No Fly");
    }
}


abstract class Robot{
    Walkable walkable;
    Talkable talkable;
    Flyable flyable;

    Robot(Walkable w, Talkable t, Flyable f)
    {
        this.walkable = w;
        this.talkable = t;
        this.flyable = f;
    }

    public void walk()
    {
        walkable.walk();
    }
    public void talk()
    {
        talkable.talk();
    }
    public void fly()
    {
        flyable.fly();
    }

    public abstract void projection();
}

class CompanionRobot extends Robot {
    CompanionRobot(Walkable w, Talkable t, Flyable f)
    {
        super(w,t,f);
    }
    public void projection()
    {
        System.out.println("Displaying friendly companion features...");
    }
}
class WorkerRobot extends Robot {
    WorkerRobot(Walkable w, Talkable t, Flyable f)
    {
        super(w,t,f);
    }
    public void projection()
    {
        System.out.println("Displaying worker efficiency stats...");
    }
}

public class StrategyPattern {
    
    public static void main(String[] args) {
        Walkable w = new NoWalk();
        Talkable t = new NormalTalk();
        Flyable f = new NoFly();

        CompanionRobot siri = new CompanionRobot(w, t, f);
        siri.talk();
        siri.fly();
        siri.walk();
    }
}
