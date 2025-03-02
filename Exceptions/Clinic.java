import java.io.File;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Clinic{
    protected File patientFile;
    protected int day;

    public Clinic(File file)
    {
        patientFile = file;
    }
    public Clinic(String fileName)
    {
        File file = new File(fileName);
        this(file);
    }

    public String nextDay(File f) throws FileNotFoundException
    {
        Scanner scan = null;

        scan = new Scanner(f);

        while(scan.hasNextLine())
        {
            String line = scan.nextLine();
            String[] lineContent = line.split(",");
            String petName  = lineContent[0];
            String petKind  =  lineContent[1];
            int miceCaught = Integer.parseInt(lineContent[2]);
            String timeIn = lineContent[3];
            //System.out.println("Consultation for " + petName + " the " + petKind + " at " + timeIn + ".\nWhat is the health of " + petName+"?\n");

            Scanner input = new Scanner(System.in);
            boolean successHealth = false;
            double health = 0;

            while(!successHealth)
            {
                try{
                    System.out.println("Consultation for " + petName + " the " + petKind + " at " + timeIn + ".\nWhat is the health of " + petName+"?\n");
                    health = input.nextDouble();
                    successHealth = true;
                }
                catch(InputMismatchException e)
                {
                    System.out.println("Consultation for " + petName + " the " + petKind + " at " + timeIn + ".\nWhat is the health of " + petName+"?\n");
                }
                finally
                {
                    input.nextLine();
                }
            }

            boolean successPainLevel = false;
            int painLevel = 0;

            while(!successPainLevel)
            {
                try{
                    System.out.println("On a scale of 1 to 10, how much pain is " + petName +" in right now?\n");
                    painLevel = input.nextInt();
                    successPainLevel = true;
                }
                catch(InputMismatchException e)
                {
                    System.out.println("On a scale of 1 to 10, how much pain is " + petName +" in right now?\n");
                }
                finally
                {
                    input.nextLine();
                }
            }

            if(!petKind.equals("Cat") || !petKind.equals("Dog"))
                throw new InvalidPetException();
            
            Pet thisPet = null;

            if(petKind.equals("Cat"))
            {
                thisPet = new Cat(petName, health, painLevel, miceCaught);
            }

            if(petKind.equals("Dog"))
            {
                thisPet = new Dog(petName, health, painLevel);
            }
            
            thisPet.speak();
            
            
        }
        scan.close();
    }
}