import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import com.sun.org.apache.xpath.internal.objects.XString;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

class DataProject {
     static void fun1(ArrayList<HashMap<String, String>> finallist1) {


          HashMap<String, Integer> h1 = new HashMap<>();
          for (int i = 0; i < finallist1.size(); i++) {
              String date = finallist1.get(i).get("season");
            //  String year = date.substring(0, 4);
              int c = 0;
              if (h1.containsKey(date)) {
                  h1.replace(date, h1.get(date) + 1);
              }
              if (!h1.containsKey(date)) {

                  h1.put(date, 1);
              }
          }
          System.out.println(h1);
      }


      static void fun2(ArrayList<HashMap<String, String>> finallist1) {

          HashMap<String, Integer> h1 = new HashMap<>();
          for (int i = 0; i < finallist1.size(); i++) {
              String winner = finallist1.get(i).get("winner");
              //  String year = date.substring(0, 4);
              int c = 0;
              if (h1.containsKey(winner)) {
                  h1.replace(winner, h1.get(winner) + 1);
              }
              if (!h1.containsKey(winner)) {

                  h1.put(winner, 1);
              }
          }
          h1.remove("");
          System.out.println(h1);
          //System.out.println(h1.values());
      }

      static void fun3(ArrayList<HashMap<String, String>> finallist2)
      {

          HashMap<String, Integer> h1 = new HashMap<>();
          for (int i = 0; i < finallist2.size(); i++) {
              String looser = finallist2.get(i).get("bowling_team");
              String runs=finallist2.get(i).get("extra_runs");
              //  String year = date.substring(0, 4);
              int c = Integer.parseInt(runs);
              if (h1.containsKey(looser)) {
                  h1.replace(looser, h1.get(looser) + c);
              }
              if (!h1.containsKey(looser)) {

                  h1.put(looser, c);
              }
          }
          h1.remove("");
          System.out.println(h1);
          //System.out.println(h1.values());


      //    System.out.println(finallist2);
      }

      static void fun4() {

      }


    public static void main(String[] args) throws IOException, CsvException {


        System.out.println("IPL DATASET PROJECT");
        System.out.println("Choose one of the Option Listed Below");
        System.out.println("1. Number of matches played per year of all the years in IPL.");
        System.out.println("2. Number of matches won of all teams over all the years of IPL.");
        System.out.println("3. For the year 2016 get the extra runs conceded per team.");
        System.out.println("4. For the year 2015 get the top economical bowlers.");
        System.out.println("5. To exit");
        int aa1;
        Scanner scanner= new Scanner(System.in);
        aa1=scanner.nextInt();
        String filename = "/root/Downloads/Compressed/matches.csv";
        FileReader fileReader = new FileReader(filename);
        String filename1 = "/root/Downloads/Compressed/deliveries.csv";
        FileReader fileReader1= new FileReader(filename1);
        CSVReader csvReader1 = new CSVReaderBuilder(fileReader1).withSkipLines(0).build();
        CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(0).build();
        List<String[]> Data = csvReader.readAll();
        List<String[]> Data1= csvReader1.readAll();
        ArrayList<HashMap<String, String>> finallist2 = new ArrayList<>();
        ArrayList<HashMap<String, String>> finallist1 = new ArrayList<>();
        int x = Data.size();
        int y= Data.size();
        int a = 1;
        String[] keys = Data.get(0);
        String[] keys1= Data1.get(0);
        while (a != x) {
            String[] row = Data.get(a);
            int keyarg = 0;
            HashMap<String, String> hashMap = new HashMap<>();
            for (String cell : row) {
                hashMap.put(keys[keyarg++], cell);
            }
            finallist1.add(hashMap);
            a++;
        }
    a=1;
        while (a != y) {
            String[] row = Data1.get(a);
            int keyarg = 0;
            HashMap<String, String> hashMap = new HashMap<>();
            for (String cell : row) {
                hashMap.put(keys1[keyarg++], cell);
            }
            finallist2.add(hashMap);
            a++;
        }

        switch (aa1)
        {
            case 1:
                fun1(finallist1);
                break;
            case 2:
                fun2(finallist1);
                break;
            case 3:
                fun3(finallist2);
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

