import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
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

