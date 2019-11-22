import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class delivery {
    protected HashMap<String, Integer> Extra_run_conceded_per_team(ArrayList<HashMap<String, String>> Delivery_list_map, ArrayList<HashMap<String, String>> Matches_list_map) {
        HashMap<String, Integer> Extra_run_in_2016 = new HashMap<>();
        List<String> id = new ArrayList<>();
        for (HashMap<String, String> Cur_match : Matches_list_map) {
            String season = Cur_match.get("season");
            if (season.equals("2016")) {
                id.add(Cur_match.get("id"));
            }
        }

        for (HashMap<String, String> Cur_match : Delivery_list_map) {
            String Cur_id = Cur_match.get("match_id");
            if (id.contains(Cur_id)) {
                String bowler = Cur_match.get("bowling_team");
                String runs = Cur_match.get("extra_runs");
                int run = Integer.parseInt(runs);
                if (Extra_run_in_2016.containsKey(bowler)) {
                    Extra_run_in_2016.replace(bowler, Extra_run_in_2016.get(bowler) + run);
                }
                if (!Extra_run_in_2016.containsKey(bowler)) {

                    Extra_run_in_2016.put(bowler, run);
                }
            }
        }
        return Extra_run_in_2016;
    }

    protected HashMap<String, Float> Top_economical_bowler_2015(ArrayList<HashMap<String, String>> Delivery_list_map, ArrayList<HashMap<String, String>> Matches_list_map) {
        List<String> match_played_in_2015 = new ArrayList<>();

        for (HashMap<String, String> Cur_match : Matches_list_map) {
            String season = Cur_match.get("season");
            if (season.equals("2015")) {
                match_played_in_2015.add(Cur_match.get("id"));
            }
        }

        HashMap<String, Integer> bowler_and_run_map = new HashMap<>();
        HashMap<String, Integer> bowler_and_delivery_map = new HashMap<>();
        for (HashMap<String, String> Cur_match : Delivery_list_map) {
            if (match_played_in_2015.contains(Cur_match.get("match_id"))) {
                String bowler = Cur_match.get("bowler");
                int run = Integer.parseInt(Cur_match.get("total_runs"));
                if (bowler_and_run_map.containsKey(bowler)) {
                    bowler_and_run_map.replace(bowler, bowler_and_run_map.get(bowler) + run);
                    bowler_and_delivery_map.replace(bowler, bowler_and_delivery_map.get(bowler) + 1);
                }
                if (!bowler_and_run_map.containsKey(bowler)) {
                    bowler_and_run_map.put(bowler, run);
                    bowler_and_delivery_map.put(bowler, 1);
                }
            }
        }
        List<Integer> balls = new ArrayList<>();
        for (int x : bowler_and_delivery_map.values()) {
            balls.add(x);
        }
        int a = 0;
        Map<String, Float> Bowler_economical_rate_map = new HashMap<>();
        for (Map.Entry<String, Integer> entry : bowler_and_run_map.entrySet()) {
            String name = entry.getKey();
            float r = entry.getValue();
            int over = (balls.get(a++)) / 6;
            r /= over;
            Bowler_economical_rate_map.put(name, r);
        }
        mapsort mapsort = new mapsort();
        return mapsort.sortByValue((HashMap<String, Float>) Bowler_economical_rate_map);
    }
}