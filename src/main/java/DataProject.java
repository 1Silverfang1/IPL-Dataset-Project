import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.util.*;
class DataProject
{


    public static void main(String[] args){
        fileParse fileParse = new fileParse();
        Matches matches= new Matches();
        delivery delivery= new delivery();
        optionsSwitchCase options_switch_case= new optionsSwitchCase();
        ArrayList<HashMap<String, String>> deliveriesListMap = null;
        ArrayList<HashMap<String, String>> matchesListMap =null;
        try {
            deliveriesListMap = fileParse.FileParsing(optionsSwitchCase.delivery_csv);
            matchesListMap = fileParse.FileParsing(optionsSwitchCase.matches_csv);
        } catch (IOException | CsvException e) {
            System.out.println(optionsSwitchCase.fileError);
            return;
        }


        HashMap<String,Integer> choiceMap= new HashMap<>();
        HashMap<String,Float> choicesMap = new HashMap<>();
        int  choice = options_switch_case.options();
        boolean val = false;
        switch (choice) {
            case 1:
                choiceMap=matches.matchPlayedPerYear(matchesListMap);
                break;
            case 2:
                choiceMap=matches.matchWinIPL(matchesListMap);
                break;
            case 3:
                choiceMap=delivery.Extra_run_conceded_per_team(deliveriesListMap,matchesListMap);
                break;
            case 4:
                choicesMap =delivery.Top_economical_bowler_2015(deliveriesListMap, matchesListMap);
                val=true;
                break;
            case 5:
                choiceMap=matches.winByRunIn2016(matchesListMap);
                break;
            default:
                System.out.println(optionsSwitchCase.wrongChoice);
        }
        if(!val)
        choiceMap.forEach((k,v)->System.out.printf("\n %-30s %d",k,v));
        else
            choicesMap.forEach((k,v)->System.out.printf("\n %-30s %.2f",k,v));
    }
}

//remove constants