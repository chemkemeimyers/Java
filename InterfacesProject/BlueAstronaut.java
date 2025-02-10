import java.util.Arrays;

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
        {             //find player with the highest susLevel
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
               
            }
            else 
            {
                mostSuspicious.setFrozen(true);                
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
        String result = super.toString() + " I have " + this.numTasks + " tasks left over.";
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