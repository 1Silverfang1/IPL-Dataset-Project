package QuerySolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ConstantPackage.ConstantValues.*;

public class DeliveryMatches {
   public HashMap<String, String> extraRunConcededPerTeam(ArrayList<HashMap<String, String>> deliveryListMap, ArrayList<HashMap<String, String>> matchesListMap) {
        HashMap<String, Integer> extraRunIn2016 = new HashMap<>();
        List<String> id = new ArrayList<>();
        for (HashMap<String, String> currentMatch : matchesListMap) {
            String season = currentMatch.get(SEASON);
            if (season.equals(YEAR)) {
                id.add(currentMatch.get(ID));
            }
        }

        for (HashMap<String, String> currentMatch : deliveryListMap) {
            String curId = currentMatch.get(MATCH_ID);
            if (id.contains(curId)) {
                String bowler = currentMatch.get(BOWLING_TEAM);
                String runs = currentMatch.get(EXTRA_RUNS);
                int run = Integer.parseInt(runs);
                if (extraRunIn2016.containsKey(bowler)) {
                    extraRunIn2016.replace(bowler, extraRunIn2016.get(bowler) + run);
                }
                if (!extraRunIn2016.containsKey(bowler)) {

                    extraRunIn2016.put(bowler, run);
                }
            }
        }
        SortConvert sortConvert = new SortConvert();
        return sortConvert.changeMapToString(extraRunIn2016);

    }

  public   HashMap<String, String> topEconomicalBowler2015(ArrayList<HashMap<String, String>> deliveryListMap, ArrayList<HashMap<String, String>> matchesListMap) {
        List<String> matchPlayedIn2015 = new ArrayList<>();

        for (HashMap<String, String> currentMatch : matchesListMap) {
            String season = currentMatch.get(SEASON);
            if (season.equals(PRE_YEAR)) {
                matchPlayedIn2015.add(currentMatch.get(ID));
            }
        }

        HashMap<String, Integer> bowlerAndRunMap = new HashMap<>();
        HashMap<String, Integer> bowlerAndDeliveryMap = new HashMap<>();
        for (HashMap<String, String> currentMatch : deliveryListMap) {
            if (matchPlayedIn2015.contains(currentMatch.get(MATCH_ID))) {
                String bowler = currentMatch.get(BOWLER);
                int run = Integer.parseInt(currentMatch.get(TOTAL_RUNS));
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