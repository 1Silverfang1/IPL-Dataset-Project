import java.util.ArrayList;
import java.util.HashMap;

class Matches
{
    protected HashMap<String,Integer> Win_by_run_in_2016 (ArrayList<HashMap<String, String>> Matches_list_map) {
        HashMap<String, Integer> win_by_run = new HashMap<>();
        for(HashMap<String,String> Cur_match : Matches_list_map )
        {
            if("2016".equals(Cur_match.get("season")))
            {
                String winner= Cur_match.get("winner");
                int run= Integer.parseInt(Cur_match.get("win_by_runs"));
                if(win_by_run.containsKey(winner)) {
                    win_by_run.replace(winner, win_by_run.get(winner) + run);
                }
                if (!win_by_run.containsKey(winner)) {

                    win_by_run.put(winner, run);
                }
            }
        }
        win_by_run.remove("");
        return win_by_run;
    }
    protected HashMap<String, Integer> Match_Played_Per_Year(ArrayList<HashMap<String, String>> Matches_list_map)
    {


        HashMap<String, Integer> Math_Played = new HashMap<>();
        for(HashMap<String,String> stringStringHashMap:Matches_list_map)
        {
            String year= stringStringHashMap.get("season");
            if (Math_Played.containsKey(year))
            {
                Math_Played.replace(year, Math_Played.get(year) + 1);
            }
            if (!Math_Played.containsKey(year))
            {

                Math_Played.put(year, 1);
            }
        }
        Math_Played.remove("season");
        return Math_Played;
    }
    protected HashMap<String,Integer> Match_Win_IPL(ArrayList<HashMap<String, String>>Matches_list_map)
    {

        HashMap<String, Integer> Match_win_in_IPL = new HashMap<>();
        for(HashMap<String,String> Current_match :Matches_list_map)
        {
            String winner= Current_match.get("winner");
            int c = 0;
            if (Match_win_in_IPL.containsKey(winner))
            {
                Match_win_in_IPL.replace(winner, Match_win_in_IPL.get(winner) + 1);
            }
            if (!Match_win_in_IPL.containsKey(winner))
            {

                Match_win_in_IPL.put(winner, 1);
            }
        }
        Match_win_in_IPL.remove("");
        return Match_win_in_IPL;


    }
}