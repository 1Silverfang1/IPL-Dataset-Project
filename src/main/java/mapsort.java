import java.util.*;

class mapsort
{
    protected HashMap<String, Float> sortByValue(HashMap<String, Float> to_be_sorted) {

        ArrayList<Map.Entry<String, Float>> list = new ArrayList<>(to_be_sorted.entrySet());
        Collections.sort(list, Comparator.comparing(Map.Entry::getValue));
        HashMap<String, Float> temp_map = new LinkedHashMap<>();
        for (Map.Entry<String, Float> aa : list) {
            temp_map.put(aa.getKey(), aa.getValue());
        }
        return temp_map;
    }
}