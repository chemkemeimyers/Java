
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;

public class RedAstronaut extends Player implements Impostor{
    private String skill;
    private static final Set<String> VALID_SKILL_LEVEL = Set.of("inexprerienced", "experienced","expert");

    public RedAstronaut(String name, int susLevel,String skill)
    {
        super(name, susLevel);
        if(!VALID_SKILL_LEVEL.contains((skill.toLowerCase())))
        {
            throw new IllegalArgumentException("Invalid skill level. Must be one of " + VALID_SKILL_LEVEL);
        }
        this.skill = skill.toLowerCase();
    }
    public RedAstronaut(String name)
    {
        super(name,15);
        this.skill = "experienced";
    }
    @Override
    public void emergencyMeeting()
    {
        if(!this.isFrozen())
        {
            //find player with the highest susLevel
            Arrays.sort(players, Comparator.comparingInt(Player::getSusLevel));
            if(players[0].compareTo(players[1]) == 0)
                return;//take no action
            else if(players[0].equals(this))
                return;
            else 
            {
                if(players[0].isFrozen())
                    return;
                else
                {
                    players[0].setFrozen(true);
                }
            }
            gameOver();//A boolean is returned but at the moment we are not doing anything with it
        }
    }
    @Override
    public void freeze(Player P)
    {
        if(P instanceof Impostor)
        {
            System.out.println("Player with name " + P.getName() +" is an instance of an impostor, the player cannot be frozen");
            return;
        }
        if(this.isFrozen() && this instanceof Impostor)
        {
            System.out.println("This player with name  " + this.getName() +" is an instance of an impostor, that is frozen."
            + " no action will be taken");
            return;
        }
        if(P.isFrozen())
        {
            System.out.println("Player with name " + P.getName() +" is already frozen, no action is taken");
            return;
        }
        if(this.compareTo(P) < 0)
        {
            System.out.println("This Red Astraunaut with name " + this.getName() + " has susLevel " + this.getSusLevel() + " which "
             + "is lower than player with name " + P.getName() + ". Player with higher susLevel will be frozen");
             P.setFrozen(true);
        }
        else
        {
            System.out.println("This Red Astraunaut with name " + this.getName() + " has susLevel " + this.getSusLevel() + " which "
             + "is higher or equal to player with name " + P.getName() + ". " + this.getName() + "'s susLevel will double!");
             this.setSusLevel(this.getSusLevel()*2);
        }
        gameOver();//A boolean is returned but at the moment we are not doing anything with it
    }
    @Override
    public void sabotage(Player P)
    {
        if(P instanceof Impostor)
        {
            System.out.println("Player with name " + P.getName() +" is an instance of an impostor, the player cannot be sabotaged");
            return;
        }
        if(this.isFrozen() && this instanceof Impostor)
        {
            System.out.println("This player with name  " + this.getName() +" is an instance of an impostor, that is frozen."
            + " . They cannot perform sabotage actions.");
            return;
        }
        if(P.isFrozen())
        {
            System.out.println("Player with name " + P.getName() +" is already frozen, they cannot be sabotaged.");
            return;
        }
        if(this.getSusLevel() < 20)
        {
            System.out.println("This Red Astraunaut with name " + this.getName() + " has susLevel " + this.getSusLevel() + " which "
             + "is less than 20. Through shifty maneuvers and cunning words, they are able to increase the Crewmate’s susLevel by 50%.");
            P.setSusLevel((int) (P.getSusLevel() * 1.5));
            System.out.println("New susLevel for player " + P.getName() + " is " + P.getSusLevel());
        }
        else
        {
            System.out.println("This Red Astraunaut with name " + this.getName() + " has susLevel " + this.getSusLevel() + " which "
             + "is more than 20. Through shifty maneuvers and cunning words, they are able to increase the Crewmate’s susLevel by 25%.");
            P.setSusLevel((int) (P.getSusLevel() * 1.25));
            System.out.println("New susLevel for player " + P.getName() + " is " + P.getSusLevel());
        }
        gameOver();//A boolean is returned but at the moment we are not doing anything with it
    }
    @Override
    public boolean equals(Object o) 
    {
    if (o instanceof RedAstronaut) {
        RedAstronaut player = (RedAstronaut) o;
        return this.getName().equals(player.getName()) && this.isFrozen() == player.isFrozen()
                && this.getSusLevel() == player.getSusLevel() && this.skill.equals(player.skill);
    }
    return false;
    }

    public String getSkill()
    {
        return skill;
    }

    public void setSkill(String skill)
    {
        if(VALID_SKILL_LEVEL.contains((skill.toLowerCase())))
            this.skill = skill;
        else
            System.out.println("Invalid skill level. Must be one of " + VALID_SKILL_LEVEL);
    }

    @Override
    public String toString() 
    {
    String result = super.toString() + " I am an " + this.getSkill() + " player!";
    if(this.getSusLevel() > 15)
        return result.toUpperCase();
    else
        return result;
    }
}