package QuerySolver;

import POJO.Delivery;
import POJO.Matches;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ConstantPackage.ConstantValues.*;

public class QuerySolver {
    public  HashMap<String,String> winByRunIn2016(ArrayList<Matches> objectMatchList) {
        HashMap<String, Integer> winByRun = new HashMap<>();
        for(Matches tempObjectMap :objectMatchList)
        {
         if(YEAR.equals(tempObjectMap.getSeason()))
         {
             String winner= tempObjectMap.getWinner();
             int run= Integer.parseInt(tempObjectMap.getWinByRuns());
             if(winByRun.containsKey(winner)) {
                 winByRun.replace(winner, winByRun.get(winner) + run);
             }
             if (!winByRun.containsKey(winner)) {

                 winByRun.put(winner, run);
             }
         }
        }

        winByRun.remove("");
        SortConvert sortConvert = new SortConvert();
        return sortConvert.changeMapToString(winByRun);
    }
    public HashMap<String,String> matchPlayedPerYear(ArrayList<Matches> objectMatchList)
    {
        HashMap<String, Integer> matchPlayed = new HashMap<>();
        for(Matches tempObjectMap :objectMatchList)
        {
           String year= tempObjectMap.getSeason();
           if(matchPlayed.containsKey(year))
           {
               matchPlayed.replace(year, matchPlayed.get(year) + 1);
           }
            if (!matchPlayed.containsKey(year))
            {

                matchPlayed.put(year, 1);
            }
        }
        matchPlayed.remove(SEASON);
        SortConvert sortConvert = new SortConvert();
        return sortConvert.changeMapToString(matchPlayed);


    }

    public HashMap<String,String> matchWinIPL(ArrayList<Matches> objectMatchList)
    {

        HashMap<String, Integer> matchWinInIPL = new HashMap<>();
        for(Matches tempObjectMap :objectMatchList)
        {
            String winner=tempObjectMap.getWinner();
            if (matchWinInIPL.containsKey(winner))
            {
                matchWinInIPL.replace(winner, matchWinInIPL.get(winner) + 1);
            }
            if (!matchWinInIPL.containsKey(winner))
            {

                matchWinInIPL.put(winner, 1);
            }
        }
        matchWinInIPL.remove("");
        SortConvert sortConvert = new SortConvert();
        return sortConvert.changeMapToString(matchWinInIPL);

    }
   public HashMap<String, String> extraRunConcededPerTeam(ArrayList<Delivery> objectDeliveryList, ArrayList<Matches> objectMatchList) {
        HashMap<String, Integer> extraRunIn2016 = new HashMap<>();
        List<String> id = new ArrayList<>();
       for(Matches tempObjectMap :objectMatchList)
       {
           String season = tempObjectMap.getSeason();
           if(season.equals(YEAR))
               id.add(tempObjectMap.getId());
       }
       for(Delivery tempObjectMap :objectDeliveryList)
       {
           String curId = tempObjectMap.getMatch_id();
           if (id.contains(curId))
           {
               String bowler = tempObjectMap.getBowling_team();
               String runs = tempObjectMap.getExtra_runs();
               int run = Integer.parseInt(runs);
               if (extraRunIn2016.containsKey(bowler)) {
                   extraRunIn2016.replace(bowler, extraRunIn2016.get(bowler) + run);
               }
               if (!extraRunIn2016.containsKey(bowler))
               {

                   extraRunIn2016.put(bowler, run);
               }
           }
       }
       SortConvert sortConvert = new SortConvert();
       return sortConvert.changeMapToString(extraRunIn2016);
    }

  public   HashMap<String, String> topEconomicalBowler2015(ArrayList<Delivery> objectDeliveryList, ArrayList<Matches> objectMatchList) {
        List<String> matchPlayedIn2015 = new ArrayList<>();
      for(Matches tempObjectMap :objectMatchList)
      {
          String season = tempObjectMap.getSeason();
          if(season.equals(PRE_YEAR))
              matchPlayedIn2015.add(tempObjectMap.getId());
      }

        HashMap<String, Integer> bowlerAndRunMap = new HashMap<>();
        HashMap<String, Integer> bowlerAndDeliveryMap = new HashMap<>();
      for(Delivery tempObjectMap :objectDeliveryList)
      {
          if (matchPlayedIn2015.contains(tempObjectMap.getMatch_id()))
          {
              String bowler = tempObjectMap.getBowler();
              int run = Integer.parseInt(tempObjectMap.getTotal_runs());
              if (bowlerAndRunMap.containsKey(bowler)) {
                  bowlerAndRunMap.replace(bowler, bowlerAndRunMap.get(bowler) + run);
                  bowlerAndDeliveryMap.replace(bowler, bowlerAndDeliveryMap.get(bowler) + 1);
              }
              if (!bowlerAndRunMap.containsKey(bowler)) {
                  bowlerAndRunMap.put(bowler, run);
                  bowlerAndDeliveryMap.put(bowler, 1);
              }
          }
      }

        List<Integer> balls = new ArrayList<>(bowlerAndDeliveryMap.values());
        int a = 0;
        HashMap<String, Float> bowlerEconomicalRateMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : bowlerAndRunMap.entrySet()) {
            String name = entry.getKey();
            int over = (balls.get(a++)) / OVER;
            float runs = (float) entry.getValue() / over;
            bowlerEconomicalRateMap.put(name, runs);
        }
        SortConvert mapsort = new SortConvert();
        return mapsort.changeMapToStrings(mapsort.sortByValue(bowlerEconomicalRateMap));
    }
}