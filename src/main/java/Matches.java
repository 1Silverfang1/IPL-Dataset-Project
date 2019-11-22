import java.util.ArrayList;
import java.util.HashMap;

class Matches
{
    HashMap<String,Integer> winByRunIn2016(ArrayList<HashMap<String, String>> matchesListMap) {
        HashMap<String, Integer> winByRun = new HashMap<>();
        for(HashMap<String,String> curMatch : matchesListMap )
        {
            if(optionsSwitchCase.year.equals(curMatch.get(optionsSwitchCase.season)))
            {
                String winner= curMatch.get(optionsSwitchCase.winner);
                int run= Integer.parseInt(curMatch.get(optionsSwitchCase.winByRuns));
                if(winByRun.containsKey(winner)) {
                    winByRun.replace(winner, winByRun.get(winner) + run);
                }
                if (!winByRun.containsKey(winner)) {

                    winByRun.put(winner, run);
                }
            }
        }
        winByRun.remove("");
        return winByRun;
    }
    HashMap<String, Integer> matchPlayedPerYear(ArrayList<HashMap<String, String>> matchesListMap)
    {


        HashMap<String, Integer> Math_Played = new HashMap<>();
        for(HashMap<String,String> stringStringHashMap:matchesListMap)
        {
            String year= stringStringHashMap.get(optionsSwitchCase.season);
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
    protected HashMap<String,Integer> matchWinIPL(ArrayList<HashMap<String, String>>matchesListMap)
    {

        HashMap<String, Integer> matchWinInIPL = new HashMap<>();
        for(HashMap<String,String> currentMatch :matchesListMap)
        {
            String winner= currentMatch.get("winner");
            int c = 0;
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
        return matchWinInIPL;


    }
}