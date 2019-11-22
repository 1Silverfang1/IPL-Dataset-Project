import java.util.*;

class mapSort
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
}