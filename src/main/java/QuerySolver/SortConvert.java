package QuerySolver;

import java.util.*;
class SortConvert
{
    HashMap<String, Float> sortByValue(HashMap<String, Float> toBeSorted) {

        ArrayList<Map.Entry<String, Float>> listOfMap = new ArrayList<>(toBeSorted.entrySet());
        Collections.sort(listOfMap, Comparator.comparing(Map.Entry::getValue));
        HashMap<String, Float> tempMap = new LinkedHashMap<>();
        for (Map.Entry<String, Float> aa : listOfMap) {
            tempMap.put(aa.getKey(), aa.getValue());
        }
        return tempMap;
    }
    HashMap<String,String> changeMapToStrings(HashMap<String, Float> stringIntegerHashMap)
    {
        HashMap<String,String> stringStringHashMap = new LinkedHashMap<>();
        for (Map.Entry<String,Float> entry : stringIntegerHashMap.entrySet())
        {
            stringStringHashMap.put(entry.getKey(),entry.getValue().toString());
        }
        return stringStringHashMap;
    }
    HashMap<String,String> changeMapToString(HashMap<String, Integer> stringIntegerHashMap)
    {
        HashMap<String,String> stringStringHashMap = new HashMap<>();
        for (Map.Entry<String,Integer> entry : stringIntegerHashMap.entrySet())
        {
            stringStringHashMap.put(entry.getKey(),entry.getValue().toString());
        }
        return stringStringHashMap;
    }
}