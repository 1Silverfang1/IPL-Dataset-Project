package QuerySolver;

import java.util.ArrayList;
import java.util.HashMap;

import static ConstantPackage.ConstantValues.*;

public class Matches
{
    public  HashMap<String,String> winByRunIn2016(ArrayList<HashMap<String, String>> matchesListMap) {
        HashMap<String, Integer> winByRun = new HashMap<>();
        for(HashMap<String,String> curMatch : matchesListMap )
        {
            if(YEAR.equals(curMatch.get(SEASON)))
            {
                String winner= curMatch.get(WINNER);
                int run= Integer.parseInt(curMatch.get(WIN_BY_RUNS));
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
    public HashMap<String,String> matchPlayedPerYear(ArrayList<HashMap<String, String>> matchesListMap)
    {


        HashMap<String, Integer> matchPlayed = new HashMap<>();
        for(HashMap<String,String> stringStringHashMap:matchesListMap)
        {
            String year= stringStringHashMap.get(SEASON);
            if (matchPlayed.containsKey(year))
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
    public HashMap<String,String> matchWinIPL(ArrayList<HashMap<String, String>> matchesListMap)
    {

        HashMap<String, Integer> matchWinInIPL = new HashMap<>();
        for(HashMap<String,String> currentMatch :matchesListMap)
        {
            String winner= currentMatch.get(WINNER);
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
}