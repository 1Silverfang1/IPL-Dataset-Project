import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class DataProject {
  static   void fun1()
    {
        try {
            //System.out.println("hey");
            String filename = "/root/Downloads/Compressed/matches.csv";
            FileReader fileReader = new FileReader(filename);
            CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(0).build();
            List<String[]> Data= csvReader.readAll();
            ArrayList<HashMap<String,String>> finallist1= new ArrayList<>();
            int x= Data.size();
            int a=1;
            System.out.println(x);

            String[] keys=Data.get(0);

            while(a!=x)
            {
                String[] row=Data.get(a);
                int keyarg=0;
                HashMap<String,String> hashMap= new HashMap<>();
                for(String cell : row)
                {
                    hashMap.put(keys[keyarg++],cell);
                }
                finallist1.add(hashMap);
                a++;
            }
            /*
             System.out.println(finallist1.get(0).keySet());
            System.out.println(finallist1.get(1).values());
            System.out.println(finallist1.get(2).values());
            /*
            for (String[] row : Data) {
                for (String cell : row) {
                    System.out.print(cell + "\t");
                }

                System.out.println();
            }
*/
        } catch (Exception e) {
            System.out.println("File Read error" + " " + e.getMessage());
        }
    }
    static void fun2()
    {

    }
    static void fun3()
    {

    }
    static void fun4()
    {

    }
    public static void main(String[] arg) {

        System.out.println("IPL DATASET PROJECT");
        System.out.println("Choose one of the Option Listed Below");
        System.out.println("1. Number of matches played per year of all the years in IPL.");
        System.out.println("2. Number of matches won of all teams over all the years of IPL.");
        System.out.println("3. For the year 2016 get the extra runs conceded per team.");
        System.out.println("4. For the year 2015 get the top economical bowlers.");
        System.out.println("5. To exit");
        Scanner sc = new Scanner(System.in);
        int a= sc.nextInt();
        switch (a)
        {
            case 1:
                fun1();
                break;
            case 2:
                fun2();
                break;
            case 3:
                fun3();
                break;
            case 4:
                fun4();
                break;
            case 5:
                break;
            default:
                System.out.println("You Entered a wrong choice");
        }



    }
}