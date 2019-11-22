import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Delivery {
    HashMap<String, Integer> extraRunConcededPerTeam(ArrayList<HashMap<String, String>> deliveryListMap, ArrayList<HashMap<String, String>> matchesListMap) {
        HashMap<String, Integer> extraRunIn2016 = new HashMap<>();
        List<String> id = new ArrayList<>();
        for (HashMap<String, String> currentMatch : matchesListMap) {
            String season = currentMatch.get(ConstantsValues.SEASON);
            if (season.equals(ConstantsValues.YEAR)) {
                id.add(currentMatch.get(ConstantsValues.id));
            }
        }

        for (HashMap<String, String> currentMatch : deliveryListMap) {
            String curId = currentMatch.get(ConstantsValues.MATCH_ID);
            if (id.contains(curId)) {
                String bowler = currentMatch.get(ConstantsValues.BOWLING_TEAM);
                String runs = currentMatch.get(ConstantsValues.EXTRA_RUNS);
                int run = Integer.parseInt(runs);
                if (extraRunIn2016.containsKey(bowler)) {
                    extraRunIn2016.replace(bowler, extraRunIn2016.get(bowler) + run);
                }
                if (!extraRunIn2016.containsKey(bowler)) {

                    extraRunIn2016.put(bowler, run);
                }
            }
        }
        return extraRunIn2016;
    }

    HashMap<String, Float> topEconomicalBowler2015(ArrayList<HashMap<String, String>> deliveryListMap, ArrayList<HashMap<String, String>> matchesListMap) {
        List<String> matchPlayedIn2015 = new ArrayList<>();

        for (HashMap<String, String> currentMatch : matchesListMap) {
            String season = currentMatch.get(ConstantsValues.SEASON);
            if (season.equals(ConstantsValues.PRE_YEAR)) {
                matchPlayedIn2015.add(currentMatch.get(ConstantsValues.id));
            }
        }

        HashMap<String, Integer> bowlerAndRunMap = new HashMap<>();
        HashMap<String, Integer> bowlerAndDeliveryMap = new HashMap<>();
        for (HashMap<String, String> currentMatch : deliveryListMap) {
            if (matchPlayedIn2015.contains(currentMatch.get(ConstantsValues.MATCH_ID))) {
                String bowler = currentMatch.get(ConstantsValues.BOWLER);
                int run = Integer.parseInt(currentMatch.get(ConstantsValues.TOTAL_RUNS));
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
            int over = (balls.get(a++)) /ConstantsValues.OVER;
            float runs = (float) entry.getValue() / over;
            bowlerEconomicalRateMap.put(name, runs);
        }
        MapSort mapsort = new MapSort();
        return mapsort.sortByValue(bowlerEconomicalRateMap);
    }
}