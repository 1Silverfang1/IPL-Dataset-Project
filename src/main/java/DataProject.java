import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Output_Service_class{

    private static HashMap<String, Float> sortByValue(HashMap<String, Float> hm) {

        ArrayList<Map.Entry<String, Float>> list = new ArrayList<>(hm.entrySet());
        Collections.sort(list, Comparator.comparing(Map.Entry::getValue));
        HashMap<String, Float> temp = new LinkedHashMap<String, Float>();
        for (Map.Entry<String, Float> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }


   protected HashMap<String, Integer> Match_Played_Per_Year(ArrayList<HashMap<String, String>> finallist1)
    {


        HashMap<String, Integer> Math_Played = new HashMap<>();
        for (int i = 0; i < finallist1.size(); i++)
        {
            String year = finallist1.get(i).get("season");
            int c = 0;
            if (Math_Played.containsKey(year))
            {
                Math_Played.replace(year, Math_Played.get(year) + 1);
            }
            if (!Math_Played.containsKey(year))
            {

                Math_Played.put(year, 1);
            }
        }
        return Math_Played;
    }


    protected HashMap<String,Integer> Match_Win_IPL(ArrayList<HashMap<String, String>> finallist1)
    {

        HashMap<String, Integer> Match_win_in_IPL = new HashMap<>();
        for (int i = 0; i < finallist1.size(); i++)
        {
            String winner = finallist1.get(i).get("winner");
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

    protected  HashMap<String,Integer> Extra_run_conceded_per_team(ArrayList<HashMap<String, String>> finallist2, ArrayList<HashMap<String, String>> finallist1)
    {

        List<String> id = new ArrayList<>();

        for (int i = 0; i < finallist1.size(); i++)
        {
            String seasons = finallist1.get(i).get("season");
            if (seasons.equals("2016"))
            {

                id.add(finallist1.get(i).get("id"));
                ;
            }
        }
        HashMap<String, Integer> Extra_run_in_2016 = new HashMap<>();
        for (int i = 0; i < finallist2.size(); i++)
        {
            String id_cur = finallist2.get(i).get("match_id");
            if (id.contains(id_cur))
            {
                String looser = finallist2.get(i).get("bowling_team");
                String runs = finallist2.get(i).get("extra_runs");
                int c = Integer.parseInt(runs);
                if (Extra_run_in_2016.containsKey(looser))
                {
                    Extra_run_in_2016.replace(looser, Extra_run_in_2016.get(looser) + c);
                }
                if (!Extra_run_in_2016.containsKey(looser))
                {

                    Extra_run_in_2016.put(looser, c);
                }
            }
        }
        return Extra_run_in_2016;
    }

    protected  HashMap<String,Float> Top_economical_bowler_2015(ArrayList<HashMap<String, String>> finallist2, ArrayList<HashMap<String, String>> finallist1) {
        List<String> match_played_in_2015 = new ArrayList<>();
        for (int i = 0; i < finallist1.size(); i++)
        {
            if ("2015".equals(finallist1.get(i).get("season")))
            {
                match_played_in_2015.add(finallist1.get(i).get("id"));
            }
        }
        HashMap<String, Integer> bowler_and_run_map = new HashMap<>();
        HashMap<String, Integer> bowler_and_delivery_map = new HashMap<>();
        for (int i = 0; i < finallist2.size(); i++)
        {
            if (match_played_in_2015.contains(finallist2.get(i).get("match_id")))
            {
                String bowler = finallist2.get(i).get("bowler");
                int run = Integer.parseInt(finallist2.get(i).get("total_runs"));
                if (bowler_and_run_map.containsKey(bowler))
                {
                    bowler_and_run_map.replace(bowler, bowler_and_run_map.get(bowler) + run);
                    bowler_and_delivery_map.replace(bowler, bowler_and_delivery_map.get(bowler) + 1);
                }
                if (!bowler_and_run_map.containsKey(bowler))
                {
                    bowler_and_run_map.put(bowler, run);
                    bowler_and_delivery_map.put(bowler, 1);
                }
            }
        }
        List<Integer> balls = new ArrayList<>();
        for (int x : bowler_and_delivery_map.values())
        {
            balls.add(x);
        }
        int a = 0;
        Map<String, Float> Bowler_economical_rate_map = new HashMap<>();
        for (Map.Entry<String, Integer> entry : bowler_and_run_map.entrySet())
        {
            String name = entry.getKey();
            float r = entry.getValue();
            int over = (balls.get(a++)) / 6;
            r /= over;
            Bowler_economical_rate_map.put(name, r);
        }
        return sortByValue((HashMap<String, Float>) Bowler_economical_rate_map);
    }

    protected  ArrayList<HashMap<String, String>> FileParsing(String filename) throws IOException, CsvException
    {
        FileReader fileReader = new FileReader(filename);
        CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(0).build();
        List<String[]> DataRead = csvReader.readAll();
        ArrayList<HashMap<String, String>> finallist2 = new ArrayList<>();
        String[] keys = DataRead.get(0);
        for (String[] row : DataRead)
        {
            int keyarg = 0;
            HashMap<String, String> hashMap = new HashMap<>();
            for (String cell : row)
            {
                hashMap.put(keys[keyarg++], cell);
            }
            finallist2.add(hashMap);

        }
        return finallist2;
    }

    protected HashMap<String,Integer> Win_by_run_in_2016 (ArrayList<HashMap<String, String>> finallist1) {
        HashMap<String, Integer> win_by_run = new HashMap<>();
        for (int i = 0; i < finallist1.size(); i++)
        {
            if ("2016".equals(finallist1.get(i).get("season"))) {
                String winner = finallist1.get(i).get("winner");
                int c = Integer.parseInt(finallist1.get(i).get("win_by_runs"));
                if (win_by_run.containsKey(winner)) {
                    win_by_run.replace(winner, win_by_run.get(winner) + c);
                }
                if (!win_by_run.containsKey(winner)) {

                    win_by_run.put(winner, c);
                }
            }
        }
        win_by_run.remove("");
        return win_by_run;


    }




}
class DataProject
{
    public static void main(String[] args) throws IOException, CsvException {


        System.out.println("IPL DATASET PROJECT");
        System.out.println("Choose one of the Option Listed Below");
        System.out.println("1. Number of matches played per year of all the years in IPL.");
        System.out.println("2. Number of matches won of all teams over all the years of IPL.");
        System.out.println("3. For the year 2016 get the extra runs conceded per team.");
        System.out.println("4. For the year 2015 get the top economical bowlers.");
        System.out.println("5. For the year 2016, get the win by run per team");
        System.out.println("6. To exit");
        int aa1;
        Scanner scanner = new Scanner(System.in);
        aa1 = scanner.nextInt();
        String filename = "/root/Downloads/Compressed/matches.csv";
        String filename1 = "/root/Downloads/Compressed/deliveries.csv";
        Output_Service_class output_service_class = new Output_Service_class();
        ArrayList<HashMap<String, String>> Deliveries_list_map = output_service_class.FileParsing(filename1);
        ArrayList<HashMap<String, String>> Matches_list_map = output_service_class.FileParsing(filename);
        switch (aa1) {
            case 1:
                System.out.println(output_service_class.Match_Played_Per_Year(Matches_list_map));
                break;
            case 2:
                System.out.println(output_service_class.Match_Win_IPL(Matches_list_map));
                break;
            case 3:
                System.out.println(output_service_class.Extra_run_conceded_per_team(Deliveries_list_map,Matches_list_map));
                break;
            case 4:
                System.out.println(output_service_class.Top_economical_bowler_2015(Deliveries_list_map, Matches_list_map));
                break;
            case 5:
                System.out.println(output_service_class.Win_by_run_in_2016(Matches_list_map));
                break;
            case 6:
                return;
            default:
                System.out.println("You Entered a wrong choice");
        }

    }
}

