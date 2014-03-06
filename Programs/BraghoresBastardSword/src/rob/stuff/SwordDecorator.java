package rob.stuff;

public abstract class SwordDecorator extends Sword 
{
    protected final Sword decoratedSword;
 
    public SwordDecorator (Sword decoratedSword) 
    {
        this.decoratedSword = decoratedSword;
    }
 
    public double getCost() 
    { 
        return decoratedSword.getCost();
    }
 
    public String getQualities() 
    {
        return decoratedSword.getQualities();
    }
}
