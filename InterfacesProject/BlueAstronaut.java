import java.util.Arrays;
import java.util.Comparator;

public class BlueAstronaut extends Player implements Crewmate{
    private int numTasks;
    private int taskSpeed;
    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed)
    {
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }
    public BlueAstronaut(String name)
    {
        super(name, 15);
        this.numTasks = 6;
        this.taskSpeed = 10;
    }
    @Override
    public void emergencyMeeting()
    {
        if(!this.isFrozen())
        {
            //find player with the highest susLevel
            Arrays.sort(players, Comparator.comparingInt(Player::getSusLevel));
            if(players[0].compareTo(players[1]) == 0)
            {
                System.out.println("The most suspisious player with name " + players[0].getName()
                + " has the susLevel " + players[0].getSusLevel() + " which is similar to the next"
                + " most suspicious player with name " + players[1].getName() + " which has sus Level"
                + " " + players[1].getSusLevel() + ". No action will be taken");
            }
            else 
            {
                if(players[0].isFrozen())
                {
                    System.out.println("Player with name " + players[0].getName() + " has the highest sus Level"
                    + " of " + players[0].getSusLevel() + ". This is already frozen. No action will be taken");
                }
                else
                {
                    System.out.println("Player with name " + players[0].getName() + " has the highest sus Level"
                    + " of " + players[0].getSusLevel() + ". This player will be frozen (voted off)");
                    players[0].setFrozen(true);
                } 
            }  
        }
    gameOver();//A boolean is returned but at the moment we are not doing anything with it
    }
    @Override
    public void completeTask()
    {
        if(!this.isFrozen())
        {
            if(this.taskSpeed > 20 && this.numTasks > 0)
            {
                System.out.println("This player with name " + this.getName()
                + " has task speed of " + this.getTaskSpeed() + ". 2 tasks will be deducted from"
                + " " + this.numTasks);
                this.setNumTasks(this.numTasks - 2);
                if(this.getNumTasks()==0)
                {
                    System.out.println("I have completed all my tasks");
                    this.setSusLevel((int)(0.5*this.getSusLevel()));//continue from here
                }
            }
        }
    }
    @Override
    public boolean equals(Object o) 
    {
        if (o instanceof BlueAstronaut) 
        {
            BlueAstronaut player = (BlueAstronaut) o;
            return this.getName().equals(player.getName()) && this.isFrozen() == player.isFrozen()
                    && this.getSusLevel() == player.getSusLevel() && this.numTasks == player.numTasks
                    && this.taskSpeed == player.taskSpeed;
        }
        else
            return false;
    }
    @Override
    public String toString() 
    {
        String result = super.toString() + "I have " + this.numTasks + " left over.";
        if(this.getSusLevel() > 15)
            return result.toUpperCase();
        else
            return result;
    }

    public int getTaskSpeed()
    {
        return taskSpeed;
    }

    public int getNumTasks()
    {
        return numTasks;
    }
    
    public void setTaskSpeed(int taskSpeed)
    {
        if (taskSpeed >= 0) {
            this.taskSpeed = taskSpeed;
        } else {
            this.taskSpeed = 0;
        }
    }

    public void setNumTasks(int numTasks)
    {
        if (numTasks >= 0) {
            this.numTasks = numTasks;
        } else {
            this.numTasks = 0;
        }
    }

    public void setNumTasks()
    {

    }
}