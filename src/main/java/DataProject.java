import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import com.sun.org.apache.xpath.internal.objects.XString;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

import static java.util.Collections.max;
import static java.util.Collections.min;

class DataProject {
    public static HashMap<String, Float> sortByValue(HashMap<String, Float> hm)
    {

        List<Map.Entry<String, Float> > list =
                new LinkedList<Map.Entry<String, Float> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, Comparator.comparing(Map.Entry::getValue));

        // put data from sorted list to hashmap
        HashMap<String, Float> temp = new LinkedHashMap<String, Float>();
        for (Map.Entry<String, Float> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

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

      static void fun3(ArrayList<HashMap<String, String>> finallist2,ArrayList<HashMap<String, String>> finallist1)
      {

          List<String> id= new ArrayList<>();

            for(int i=0;i<finallist1.size();i++)
            {
                String seasons = finallist1.get(i).get("season");
                if(seasons.equals("2016"))
                {

                    id.add(finallist1.get(i).get("id"));;
                }
            }
            //System.out.println(id);
          HashMap<String, Integer> h1 = new HashMap<>();
            //int a=min(id),b=max(id);
            //System.out.println(a+" "+b);
     //    System.out.println(id);

          for (int i = 0; i <finallist2.size(); i++) {

              String id_cur = finallist2.get(i).get("match_id");
              if (id.contains(id_cur)) {
                  String looser = finallist2.get(i).get("bowling_team");
                  String runs = finallist2.get(i).get("extra_runs");
                  int c = Integer.parseInt(runs);
                  if (h1.containsKey(looser)) {
                      h1.replace(looser, h1.get(looser) + c);
                  }
                  if (!h1.containsKey(looser)) {

                      h1.put(looser, c);
                  }
              }
          }
             // h1.remove("");
              System.out.println(h1);
          }

      static void fun4(ArrayList<HashMap<String, String>> finallist2,ArrayList<HashMap<String, String>> finallist1) {
        List<String> l1 = new ArrayList<>();
         for(int i=0;i<finallist1.size();i++)
        {
            if("2015".equals(finallist1.get(i).get("season")))
            {
                l1.add(finallist1.get(i).get("id"));
            }
        }
        // System.out.println(l1);
         HashMap<String,Integer> map1= new HashMap<>();
         HashMap<String,Integer> map2= new HashMap<>();
         for(int i=0;i<finallist2.size();i++)
         {
             if(l1.contains(finallist2.get(i).get("match_id")))
             {
                 String bowler= finallist2.get(i).get("bowler");
                 int run =Integer.parseInt( finallist2.get(i).get("total_runs"));
                 if(map1.containsKey(bowler))
                 {
                     map1.replace(bowler,map1.get(bowler)+run);
                     map2.replace(bowler,map2.get(bowler)+1);
                 }
                 if(!map1.containsKey(bowler))
                 {
                     map1.put(bowler,run);
                     map2.put(bowler,1);
                 }
             }
         }
         System.out.println("Total Runs given by Bowler in 2015");
          System.out.println(map1);
          System.out.println("Total Ball delivered by Bowlers");
          System.out.println(map2);
         List<Integer> balls = new ArrayList<>();
         for( int x : map2.values())
         {
             balls.add(x);
         }
         int a=0;
         Map<String,Float> map3= new HashMap<>();
          for (Map.Entry<String,Integer> entry : map1.entrySet())
          {
              String name= entry.getKey();
             // int runs= entry.getValue();
              float r= entry.getValue();
              int over= (balls.get(a++))/6;
              r/=over;
              map3.put(name,r);
          }
          System.out.println("Economical values of bowler order in 2015");
          Map<String,Float> map4= sortByValue((HashMap<String, Float>) map3);
          System.out.println(map4);
      //   System.out.println(map2);
      }
    static  void fun5(ArrayList<HashMap<String, String>> finallist2,ArrayList<HashMap<String, String>> finallist1)
    {
        HashMap<String, Integer> h1 = new HashMap<>();
        for (int i = 0; i < finallist1.size(); i++)
        {
            if ("2016".equals(finallist1.get(i).get("season")))
            {
                String winner = finallist1.get(i).get("winner");
                //  String year = date.substring(0, 4);
                int c = Integer.parseInt(finallist1.get(i).get("win_by_runs"));
                if (h1.containsKey(winner)) {
                    h1.replace(winner, h1.get(winner) + c);
                }
                if (!h1.containsKey(winner)) {

                    h1.put(winner, c);
                }
            }
        }
        h1.remove("");
        System.out.println(h1);


    }

    public static void main(String[] args) throws IOException, CsvException {


        System.out.println("IPL DATASET PROJECT");
        System.out.println("Choose one of the Option Listed Below");
        System.out.println("1. Number of matches played per year of all the years in IPL.");
        System.out.println("2. Number of matches won of all teams over all the years of IPL.");
        System.out.println("3. For the year 2016 get the extra runs conceded per team.");
        System.out.println("4. For the year 2015 get the top economical bowlers.");
        System.out.println("5. For the year 2016, get the win by run per team");
        System.out.println("6. To exit");
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
        int y= Data1.size();
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
        for(String[] row : Data1)
        {
            int keyarg = 0;
            HashMap<String, String> hashMap = new HashMap<>();
            for (String cell : row) {
                hashMap.put(keys1[keyarg++], cell);
                // System.out.println(cell);
            }
            finallist2.add(hashMap);

        }
//System.out.println(finallist2.size());

        switch (aa1)
        {
            case 1:
                fun1(finallist1);
                break;
            case 2:
                fun2(finallist1);
                break;
            case 3:
                fun3(finallist2,finallist1);
                break;
            case 4:
                fun4(finallist2,finallist1);
                break;
            case 5:
                fun5(finallist2,finallist1);
                break;
            case  6:
                return;
            default:
                System.out.println("You Entered a wrong choice");
        }

    }




    }

