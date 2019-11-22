import java.util.ArrayList;
import java.util.HashMap;

class Matches
{
    HashMap<String,String> winByRunIn2016(ArrayList<HashMap<String, String>> matchesListMap) {
        HashMap<String, Integer> winByRun = new HashMap<>();
        for(HashMap<String,String> curMatch : matchesListMap )
        {
            if(ConstantsValues.YEAR.equals(curMatch.get(ConstantsValues.SEASON)))
            {
                String winner= curMatch.get(ConstantsValues.WINNER);
                int run= Integer.parseInt(curMatch.get(ConstantsValues.WIN_BY_RUNS));
                if(winByRun.containsKey(winner)) {
                    winByRun.replace(winner, winByRun.get(winner) + run);
                }
                if (!winByRun.containsKey(winner)) {

                    winByRun.put(winner, run);
                }
            }
        }
        winByRun.remove("");
        sortConvert sortConvert = new sortConvert();
        return sortConvert.changeMapToString(winByRun);
    }
    HashMap<String,String> matchPlayedPerYear(ArrayList<HashMap<String, String>> matchesListMap)
    {


        HashMap<String, Integer> matchPlayed = new HashMap<>();
        for(HashMap<String,String> stringStringHashMap:matchesListMap)
        {
            String year= stringStringHashMap.get(ConstantsValues.SEASON);
            if (matchPlayed.containsKey(year))
            {
                matchPlayed.replace(year, matchPlayed.get(year) + 1);
            }
            if (!matchPlayed.containsKey(year))
            {

                matchPlayed.put(year, 1);
            }
        }
        matchPlayed.remove(ConstantsValues.SEASON);
        sortConvert sortConvert = new sortConvert();
        return sortConvert.changeMapToString(matchPlayed);
    }
    HashMap<String,String> matchWinIPL(ArrayList<HashMap<String, String>> matchesListMap)
    {

        HashMap<String, Integer> matchWinInIPL = new HashMap<>();
        for(HashMap<String,String> currentMatch :matchesListMap)
        {
            String winner= currentMatch.get(ConstantsValues.WINNER);
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
        sortConvert sortConvert = new sortConvert();
        return sortConvert.changeMapToString(matchWinInIPL);


    }
}