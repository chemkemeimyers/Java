
public class Gameplay{
    
    public static void main(String[] args) 
    {
    BlueAstronaut Bob =  new BlueAstronaut("Bob",20,6,30);
    BlueAstronaut Heath = new BlueAstronaut("Heath",30,3,21);
    BlueAstronaut Albert = new BlueAstronaut("Albert",44,2,0);
    BlueAstronaut Angel = new BlueAstronaut("Angel",0,1,0);

    RedAstronaut Liam = new RedAstronaut("Liam",19,"experienced");
    RedAstronaut SuspiciousPerson = new RedAstronaut("Suspicious Person",100,"expert");

        System.out.println(Bob.toString());
        System.out.println(Liam.toString());
        Liam.sabotage(Bob);
        System.out.println(Bob.toString());
        
        System.out.println("\n");
        System.out.println(Liam.toString());
        System.out.println(SuspiciousPerson.toString());
        Liam.freeze(SuspiciousPerson); //Nothing happened - because Suspicious person is an impostor
        System.out.println(Liam.toString());
        System.out.println(SuspiciousPerson.toString());

        System.out.println("\n");
        System.out.println(Albert.toString());
        Liam.freeze(Albert); //nothing happened because Albert is Frozen by default
        System.out.println(Liam.toString());
        System.out.println(Albert.toString());

        System.out.println("\n");
        Albert.emergencyMeeting();//Nothing happened because Albert is Frozen
        System.out.println(SuspiciousPerson.toString());
        System.out.println(Albert.toString());

        System.out.println("\n");
        System.out.println("\n");
        System.out.println(Heath.toString());
        SuspiciousPerson.emergencyMeeting(); //Nothing happened because Bob and Heath had the same sus level
        System.out.println(Bob.toString());
        System.out.println(Heath.toString());

        System.out.println("\n");
        System.out.println(Bob.toString());
        System.out.println(SuspiciousPerson.toString());
        Bob.emergencyMeeting();
        System.out.println(Bob.toString());
        System.out.println(SuspiciousPerson.toString());

        System.out.println("\n");
        System.out.println(Heath.toString());
        Heath.completeTask();
        System.out.println(Heath.toString());
        Heath.completeTask();
        System.out.println(Heath.toString());
        Heath.completeTask();
        System.out.println(Heath.toString());

        System.out.println("\n");
        System.out.println(Liam.toString());
        System.out.println(Angel.toString());
        Liam.freeze(Angel);
        System.out.println(Liam.toString());
        System.out.println(Angel.toString());

        System.out.println("\n");
        System.out.println(Liam.toString());
        System.out.println(Bob.toString());
        Liam.sabotage(Bob);
        System.out.println(Liam.toString());
        System.out.println(Bob.toString());
        Liam.sabotage(Bob);
        System.out.println(Liam.toString());
        System.out.println(Bob.toString());

        System.out.println("\n");
        System.out.println(Liam.toString());
        System.out.println(Bob.toString());
        Liam.freeze(Bob);
        System.out.println(Liam.toString());
        System.out.println(Bob.toString());

        // System.out.println("\n");
        // System.out.println(Angel.toString());
        // System.out.println(Liam.toString());
        // Angel.emergencyMeeting();
        // System.out.println(Angel.toString());
        // System.out.println(Liam.toString());

        System.out.println("\n");
        System.out.println(Liam.toString());
        System.out.println(Heath.toString());
        Liam.sabotage(Heath);
        System.out.println(Liam.toString());
        System.out.println(Heath.toString());
        Liam.sabotage(Heath);
        System.out.println(Liam.toString());
        System.out.println(Heath.toString());
        Liam.sabotage(Heath);
        System.out.println(Liam.toString());
        System.out.println(Heath.toString());
        Liam.sabotage(Heath);
        System.out.println(Liam.toString());
        System.out.println(Heath.toString());
        Liam.sabotage(Heath);
        System.out.println(Liam.toString());
        System.out.println(Heath.toString());

        System.out.println("\n");
        System.out.println(Liam.toString());        
        System.out.println(Heath.toString()); 
        Liam.freeze(Heath);
        System.out.println(Liam.toString());        
        System.out.println(Heath.toString()); 

    }

}