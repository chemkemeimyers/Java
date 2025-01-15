public class Averager{
    public static void main(String[] args)
    {
        double[] weekHighs = {80, 70, 75, 69, 72, 74, 90};

        double sumTemps = 0;

        for(double dayHigh: weekHighs)
        {
            sumTemps+=dayHigh;
        }

        System.out.printf("Average weekly temperature is %.2f.\n", sumTemps/weekHighs.length);

    }
}