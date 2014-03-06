package rob.stuff;

public class SwordFactory 
{
	private static final SwordFactory INSTANCE = new SwordFactory();
	
	//Singleton factory that returns swords based on a constant it gets fed. 
	//Check the main method in the test package for a use example.
	
	private SwordFactory()
	{
		
	}
	
	public static SwordFactory getInstance()
	{
		return INSTANCE;
	}
	
	public Sword makeSword(int type)
	{
		//Decorator needs the simple one to decorate first, hence this guy, 
		//who then gets decorated and returned when "makeSword" is called.
		Sword sword = new SimpleSword();
		if(type == RobConstants.Shoddy)
		{
			return new Shoddy(sword);
		}
		
		else if(type == RobConstants.Basic)
		{
			return new Basic(sword);
		}
		
		else if(type == RobConstants.Grand)
		{
			return new Grand(sword);
		}
		
		if(type == RobConstants.Block)
		{
			return new Block(sword);
		}
		
		else if(type == RobConstants.Blood)
		{
			return new Blood(sword);
		}
		
		else if(type == RobConstants.Blue_Fire)
		{
			return new BlueFire(sword);
		}
		
		if(type == RobConstants.Fire)
		{
			return new Fire(sword);
		}
		
		else if(type == RobConstants.Flared)
		{
			return new Flared(sword);
		}
		
		else if(type == RobConstants.Great)
		{
			return new Great(sword);
		}
		
		if(type == RobConstants.Holy)
		{
			return new Holy(sword);
		}
		
		else if(type == RobConstants.Ice)
		{
			return new Ice(sword);
		}
		
		else if(type == RobConstants.Knightly)
		{
			return new Knightly(sword);
		}
		
		if(type == RobConstants.Menacing)
		{
			return new Menacing(sword);
		}
		
		else if(type == RobConstants.Poison)
		{
			return new Poison(sword);
		}
		
		else if(type == RobConstants.Red_Amber)
		{
			return new RedAmber(sword);
		}
		
		if(type == RobConstants.Shadow)
		{
			return new Shadow(sword);
		}
		
		else if(type == RobConstants.Short)
		{
			return new Short(sword);
		}
		
		else if(type == RobConstants.Silver)
		{
			return new Silver(sword);
		}
		
		if(type == RobConstants.Spikey)
		{
			return new Spikey(sword);
		}
		
		else if(type == RobConstants.Wind)
		{
			return new Wind(sword);
		}
		
		else
		{
			return new Shoddy(sword);
		}
		
	}
	
}
