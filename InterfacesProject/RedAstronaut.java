
import com.sun.source.tree.ParenthesizedTree;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import javax.lang.model.util.ElementScanner14;

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
            gameOver();
        }
    }

}