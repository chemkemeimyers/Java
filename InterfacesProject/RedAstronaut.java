
import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor{
    private String skill;
    private static final String[] VALID_SKILL_LEVEL = {"inexperienced", "experienced","expert"};

    public RedAstronaut(String name, int susLevel,String skill)
    {
        super(name, susLevel);
        if(!Arrays.asList(VALID_SKILL_LEVEL).contains(skill.toLowerCase()))
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
            //Find players that are not frozen
            Player mostSuspicious = null;
            Player nextMostSuspicious = null;
           

            Arrays.sort(players);
            while(mostSuspicious == null)
            {
                for(int i = players.length-1;i>=0; i--)
                {
                    if(!players[i].equals(this) && !players[i].isFrozen())
                    {
                        mostSuspicious = players[i];
                    }
                    if(mostSuspicious!=null)
                        break;
                }
            }
            while(nextMostSuspicious == null)
            {
                for(int i = players.length-1;i>=0; i--)
                {
                    if(!players[i].equals(this) && !players[i].isFrozen() && !players[i].equals(mostSuspicious))
                    {
                        nextMostSuspicious = players[i];
                    }
                    if(nextMostSuspicious!=null)
                        break;
                }
            }

            if(mostSuspicious.compareTo(nextMostSuspicious) == 0)
            {
                //     System.out.println("The most suspisious player with name " + players[0].getName()
                // + " has the susLevel " + players[0].getSusLevel() + " which is similar to the next"
                // + " most suspicious player with name " + players[1].getName() + " which has sus Level"
                // + " " + players[1].getSusLevel() + ". No action will be taken");
            }
            else if(mostSuspicious.equals(this))
            {}
            else 
            {
         
                // System.out.println("Player with name " + players[0].getName() + " has the highest sus Level"
                // + " of " + players[0].getSusLevel() + ". This player will be frozen (voted off)");
                mostSuspicious.setFrozen(true);
                
            }
        }
        gameOver();//A boolean is returned but at the moment we are not doing anything with it
    }
    @Override
    public void freeze(Player P)
    {
        if(P instanceof Impostor)
        {
            // System.out.println("Player with name " + P.getName() +" is an instance of an impostor, the player cannot be frozen");
        }
        else if(this.isFrozen() && this instanceof Impostor)
        {
            // System.out.println("This player with name  " + this.getName() +" is an instance of an impostor, that is frozen."
            // + " no action will be taken");
        }
        else if(P.isFrozen())
        {
            // System.out.println("Player with name " + P.getName() +" is already frozen, no action is taken");
        }
        else if(this.compareTo(P) < 0)
        {
            // System.out.println("This Red Astraunaut with name " + this.getName() + " has susLevel " + this.getSusLevel() + " which "
            //  + "is lower than player with name " + P.getName() + ". Player with higher susLevel will be frozen");
             P.setFrozen(true);
        }
        else
        {
            // System.out.println("This Red Astraunaut with name " + this.getName() + " has susLevel " + this.getSusLevel() + " which "
            //  + "is higher or equal to player with name " + P.getName() + ". " + this.getName() + "'s susLevel will double!");
             this.setSusLevel(this.getSusLevel()*2);
        }
        gameOver();//A boolean is returned but at the moment we are not doing anything with it
    }
    @Override
    public void sabotage(Player P)
    {
        if(P instanceof Impostor)
        {
            // System.out.println("Player with name " + P.getName() +" is an instance of an impostor, the player cannot be sabotaged");
        }
        else if(this.isFrozen() && this instanceof Impostor)
        {
            // System.out.println("This player with name  " + this.getName() +" is an instance of an impostor, that is frozen."
            // + " . They cannot perform sabotage actions.");
        }
        else if(P.isFrozen())
        {
            // System.out.println("Player with name " + P.getName() +" is already frozen, they cannot be sabotaged.");
        }
        else if(this.getSusLevel() < 20)
        {
            // System.out.println("This Red Astraunaut with name " + this.getName() + " has susLevel " + this.getSusLevel() + " which "
            //  + "is less than 20. Through shifty maneuvers and cunning words, I am able to increase the Crewmate " + P.getName() + "'s susLevel of "
            //  + P.getSusLevel() + " by 50%.");
            P.setSusLevel((int) (P.getSusLevel() * 1.5));
            // System.out.println("New susLevel for player " + P.getName() + " is " + P.getSusLevel());
        }
        else
        {
            // System.out.println("This Red Astraunaut with name " + this.getName() + " has susLevel " + this.getSusLevel() + " which "
            //  + "is more than 20. Through shifty maneuvers and cunning words, I am able to increase the Crewmate " + P.getName() + "'s susLevel by 25%.");
            P.setSusLevel((int) (P.getSusLevel() * 1.25));
            // System.out.println("New susLevel for player " + P.getName() + " is " + P.getSusLevel());
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
    @Override
    public String toString() 
    {
        String result = super.toString() + " I am an " + this.getSkill() + " player!";
        if(this.getSusLevel() > 15)
            return result.toUpperCase();
        else
            return result;
    }

    public String getSkill()
    {
        return skill;
    }

    public void setSkill(String skill)
    {
        if(Arrays.asList(VALID_SKILL_LEVEL).contains((skill.toLowerCase())))
            this.skill = skill;
        else
            System.out.println("Invalid skill level. Must be one of " + VALID_SKILL_LEVEL);
    }
}