import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Clinic{
    protected File patientFile;
    protected int day;

    public Clinic(File file)
    {
        patientFile = file;
    }
    public Clinic(String fileName)
    {
        this(new File(fileName));
    }

    public String nextDay(String fileName) throws FileNotFoundException, InvalidPetException
    {
        File file = new File(fileName);
        String result = nextDay(file);
        return result;
    }

    public String nextDay(File f) throws FileNotFoundException, InvalidPetException
    {
        Scanner scan = null;
        
        int lineCount = 0;
        try 
        {
            scan = new Scanner(f);
            
            while(scan.hasNextLine())
            {
                scan.nextLine();
                lineCount++;
            }
            scan.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        String[] treatmentRecords = new String[lineCount];
        scan = new Scanner(f);
        int index = 0;
        while(scan.hasNextLine())
        {
            String line = scan.nextLine();
            String[] lineContent = line.split(",");
            String petName  = lineContent[0];
            String petKind  =  lineContent[1];
            double miceCaughtDouble = Double.parseDouble(lineContent[2]);
            int miceCaught = (int)miceCaughtDouble;
            String timeIn = lineContent[3];

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
                catch(Exception e)
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
                catch(Exception e)
                {
                    System.out.println("On a scale of 1 to 10, how much pain is " + petName +" in right now?\n");
                }
                finally
                {
                    input.nextLine();
                }
            }
            if(!petKind.equals("Cat") && !petKind.equals("Dog"))
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

            int treatResult = thisPet.treat();

            String timeOut = addTime(timeIn, treatResult);

            this.setDay(this.getDay()+1);

            String DroolRateOrMiceCaught;
            Cat thisCat = null;
            Dog thisDog = null;

            if(thisPet instanceof Cat)
            {
                thisCat = (Cat) thisPet;
                DroolRateOrMiceCaught = Integer.toString(thisCat.getMiceCaught());
            }
            else
            {
                thisDog = (Dog) thisPet;
                DroolRateOrMiceCaught = Double.toString(thisDog.getDroolRate());
            }

            String[] treatmentRecord = {petName, petKind,DroolRateOrMiceCaught
            ,Integer.toString(this.getDay()), timeIn, timeOut, 
            Double.toString(health), Integer.toString(painLevel) };
            treatmentRecords[index] = String.join(",", treatmentRecord);
            index++;
        }
        scan.close();
            return String.join("\n", treatmentRecords);
    }
    public boolean addToFile(String patientInfo)
    {
        Scanner scan = null;
        
        int lineCount = 0;
        try 
        {
            scan = new Scanner(patientFile);
            
            while(scan.hasNextLine())
            {
                scan.nextLine();
                lineCount++;
            }
            scan.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        String[] fileEntries = new String[lineCount];
        int  index = 0;
        try 
        {
            scan = new Scanner(patientFile);
            
            while(scan.hasNextLine())
            {
                fileEntries[index] = scan.nextLine();
                index+=1;
            }
            scan.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        //split patient info entries and store them in an array
        int count = 0;
        for(String item: patientInfo.split(","))
            count ++;
        
        String[] patientInfoItems = new String[count];
        for(int i = 0; i < count; i++)
            patientInfoItems[i] = patientInfo.split(",")[i];

        boolean patientOnFile = false;

        //search for the name of a pet in  the file entries
        for(int i = 0; i< fileEntries.length; i++)//for every line entry
        {
            String[] entryParts = fileEntries[i].split(",");
            if(patientInfoItems[0].equals(entryParts[0]))
            {
                //The patient exists in the file
                patientOnFile = true;
                for(int j = 3; j< entryParts.length; j++)
                {
                    if(j==3)
                    {
                        entryParts[j] = "Day " + patientInfoItems[j];
                    }
                    else
                    {
                         entryParts[j] = patientInfoItems[j];
                    }

                   
                }
            }
            fileEntries[i] = String.join(",", entryParts);
        }

        if(!patientOnFile)
        {
            String [] fileEntriesWithNewLine = new String[lineCount+1];
            for(int i = 0; i< lineCount; i++)
            {
                fileEntriesWithNewLine[i] = fileEntries[i];
            }
            patientInfo.split(",")[3] = "Day " + patientInfo.split(",")[3];
            fileEntriesWithNewLine[lineCount] = patientInfo;

            
            try{
                PrintWriter writer = new PrintWriter(patientFile);
                {
                    for(String line: fileEntriesWithNewLine)
                        writer.println(line);
                }
                writer.close();
                return true;
            }
            catch(IOException e)
            {
                System.out.println("An error occurred when writing to file object " + e.getMessage());
            }
        }
        else
        {
            try{
                PrintWriter writer = new PrintWriter(patientFile);
                {
                    for(String line: fileEntries)
                        writer.println(line);
                }
                writer.close();
                return true;
            }
            catch(IOException e)
            {
                System.out.println("An error occurred when writing to file object " + e.getMessage());
            }
        }
        return false;

    }
    public String addTime(String timeIn, int treatmentTime)
    {        
        int timeInInt = Integer.parseInt(timeIn);

        //Extract hours and minutes from the string
        int time = Integer.parseInt(timeIn);
        int hours  = time/100;
        int minutes = time %100;

        //Add the activity time (in minutes)
        minutes+=treatmentTime;

        //Handle overflow of minutes into hours
        hours += minutes/60;
        minutes = minutes%60;

        return String.format("%02d%02d",hours,minutes);
    
    }
    public void setDay(int newDay)
    {
        day = newDay;
    }
    public int getDay()
    {
        return day;
    }
}