import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.*;
class DataProject
{
   final String matches_csv = "matches.csv";
    final String delivery_csv = "deliveries.csv";

    public static void main(String[] args) throws IOException, CsvException {
        DataProject dataProject= new DataProject();
        fileParse fileParse = new fileParse();
        matches matches= new matches();
        delivery delivery= new delivery();
        ArrayList<HashMap<String, String>> Deliveries_list_map = fileParse.FileParsing(dataProject.delivery_csv);
        ArrayList<HashMap<String, String>> Matches_list_map = fileParse.FileParsing(dataProject.matches_csv);
        optionsSwitchCase options_switch_case= new optionsSwitchCase();
        HashMap<String,Integer> choiceMap= new HashMap<>();
        HashMap<String,Float> choicesMap = new HashMap<>();
        int  choice = options_switch_case.options();
        boolean val = false;
        switch (choice) {
            case 1:
                choiceMap=matches.Match_Played_Per_Year(Matches_list_map);
                break;
            case 2:
                choiceMap=matches.Match_Win_IPL(Matches_list_map);
                break;
            case 3:
                choiceMap=delivery.Extra_run_conceded_per_team(Deliveries_list_map,Matches_list_map);
                break;
            case 4:
                choicesMap =delivery.Top_economical_bowler_2015(Deliveries_list_map, Matches_list_map);
                val=true;
                break;
            case 5:
                choiceMap=matches.Win_by_run_in_2016(Matches_list_map);
                break;
            default:
                System.out.println("You Entered a wrong choice");
        }
        if(!val)
        choiceMap.forEach((k,v)->System.out.printf("\n %-30s %d",k,v));
        else
            choicesMap.forEach((k,v)->System.out.printf("\n %-30s %.2f",k,v));
    }
}

