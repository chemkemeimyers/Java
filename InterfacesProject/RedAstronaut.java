
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

}