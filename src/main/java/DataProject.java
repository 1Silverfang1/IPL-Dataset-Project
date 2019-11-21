import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Mapsort
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
class Delivery {
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
        Mapsort mapsort = new Mapsort();
        return mapsort.sortByValue((HashMap<String, Float>) Bowler_economical_rate_map);
    }
}
class File_parse
{
    protected ArrayList<HashMap<String, String>> FileParsing(String filename) throws IOException, CsvException {
        FileReader fileReader = new FileReader(filename);
        CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(0).build();
        List<String[]> DataRead = csvReader.readAll();
        ArrayList<HashMap<String, String>> finallist2 = new ArrayList<>();
        String[] keys = DataRead.get(0);
        for (String[] row : DataRead) {
            int keyarg = 0;
            HashMap<String, String> hashMap = new HashMap<>();
            for (String cell : row) {
                hashMap.put(keys[keyarg++], cell);
            }
            finallist2.add(hashMap);

        }
        return finallist2;
    }
}
class options_switch_Case
{
        int choice;
        protected int optioncase()
        {
        System.out.println("IPL DATASET PROJECT");
        System.out.println("Choose one of the Option Listed Below");
        System.out.println("1. Number of matches played per year of all the years in IPL.");
        System.out.println("2. Number of matches won of all teams over all the years of IPL.");
        System.out.println("3. For the year 2016 get the extra runs conceded per team.");
        System.out.println("4. For the year 2015 get the top economical bowlers.");
        System.out.println("5. For the year 2016, get the win by run per team");
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();
        return choice;
        }

}
class DataProject
{
   final String matches_csv = "/root/Downloads/Compressed/matches.csv";
    final String delivery_csv = "/root/Downloads/Compressed/deliveries.csv";

    public static void main(String[] args) throws IOException, CsvException {
        DataProject dataProject= new DataProject();
        File_parse file_parse= new File_parse();
        Matches matches= new Matches();
        Delivery delivery= new Delivery();
        ArrayList<HashMap<String, String>> Deliveries_list_map = file_parse.FileParsing(dataProject.delivery_csv);
        ArrayList<HashMap<String, String>> Matches_list_map =file_parse.FileParsing(dataProject.matches_csv);
        options_switch_Case options_switch_case= new options_switch_Case();
        HashMap<String,Integer> Choice_map= new HashMap<>();
        HashMap<String,Float> Choices_map = new HashMap<>();
        int  choice = options_switch_case.optioncase();
        boolean val = false;
        switch (choice) {
            case 1:
                Choice_map=matches.Match_Played_Per_Year(Matches_list_map);
                break;
            case 2:
                Choice_map=matches.Match_Win_IPL(Matches_list_map);
                break;
            case 3:
                Choice_map=delivery.Extra_run_conceded_per_team(Deliveries_list_map,Matches_list_map);
                break;
            case 4:
                Choices_map =delivery.Top_economical_bowler_2015(Deliveries_list_map, Matches_list_map);
                val=true;
                break;
            case 5:
                Choice_map=matches.Win_by_run_in_2016(Matches_list_map);
                break;
            default:
                System.out.println("You Entered a wrong choice");
        }
        if(!val)
        Choice_map.forEach((k,v)->System.out.printf("\n %-30s %d",k,v));
        else
            Choices_map.forEach((k,v)->System.out.printf("\n %-30s %.2f",k,v));
    }
}

