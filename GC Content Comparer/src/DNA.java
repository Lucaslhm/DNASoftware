import java.util.Arrays;

public class DNA {
   private static String name;
   private static char[] basePairs = null;
   private static char[] oldPairs;
   private static double gcPercent;
   private static int gCount = 0;
   private static int aCount = 0;
   private static int cCount = 0;
   private static int tCount = 0;

    public DNA()
    {
    }

    public DNA(String rawName,String rawPairs)
    {
        name = rawName;
        basePairs = new char[rawPairs.length()];

        for(int i=0;i<=rawPairs.length();i++)
        {
            basePairs[i] = rawPairs.charAt(i);
        }

    }

    public DNA(String rawName) {
        name = rawName;
    }

    public static void ammendName(String rawName)
    {
        name = rawName;
    }

    private static void count()
    {
        gCount = 0;
        cCount = 0;
        aCount = 0;
        tCount = 0;

        for(int i=0;i<basePairs.length;i++)
        {
            if(basePairs[i] == 'A' || basePairs[i] == 'a')
            {
                aCount++;
            }
            if(basePairs[i] == 'T' || basePairs[i] == 't')
            {
                tCount++;
            }
            if(basePairs[i] == 'G' || basePairs[i] == 'g')
            {
                gCount++;
            }
            if(basePairs[i] == 'C' || basePairs[i] == 'c')
            {
                cCount++;
            }
        }
    }

    public double gcContent()
    {
        this.count();

        gcPercent = (gCount + cCount) / (basePairs.length - (basePairs.length - (aCount + tCount + cCount + gCount) ));

        return gcPercent;

    }

    public static void amendPairs(String rawPairs)
    {
        if(basePairs == null)
        {
            basePairs = new char[rawPairs.length()];
        }
        else
        {
            oldPairs = basePairs;

            basePairs = new char[(oldPairs.length + rawPairs.length())];

            for (int i=0;i<oldPairs.length;i++ )
                basePairs[i] = oldPairs[i];


            for (int i=oldPairs.length+1;i<basePairs.length;i++)
                basePairs[i] = rawPairs.charAt(i - (oldPairs.length + 1));

        }

    }

    public String GCreturn()
    {
        return (name + "\n" + this.gcContent());
    }

    public String toString() {
        return (name + "\n" +
                "BasePairs:" + (basePairs.length - (basePairs.length - (aCount + tCount + cCount + gCount))) + "\n" +
               "A:" + aCount + "\n" +
               "T:" + tCount + "\n" +
               "C:" + cCount + "\n" +
               "G:" + gCount + "\n" +
                Arrays.toString(basePairs));
    }
}
