import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.util.*;
class DataProject
{


    public static void main(String[] args){
        FileParse fileParse = new FileParse();
        Matches matches= new Matches();
        Delivery delivery= new Delivery();
        ConstantsValues optionsSwitchCase= new ConstantsValues();
        ArrayList<HashMap<String, String>> deliveriesListMap = null;
        ArrayList<HashMap<String, String>> matchesListMap =null;
        try {
            deliveriesListMap = fileParse.FileParsing(ConstantsValues.DELIVERIES_CSV);
            matchesListMap = fileParse.FileParsing(ConstantsValues.MATCHES_CSV);
        } catch (IOException | CsvException e) {
            System.out.println(ConstantsValues.FILE_ERROR);
            return;
        }


        HashMap<String,Integer> choiceMap= new HashMap<>();
        HashMap<String,Float> choicesMap = new HashMap<>();
        int  choice = optionsSwitchCase.options();
        boolean val = false;
        switch (choice) {
            case 1:
                choiceMap=matches.matchPlayedPerYear(matchesListMap);
                break;
            case 2:
                choiceMap=matches.matchWinIPL(matchesListMap);
                break;
            case 3:
                choiceMap=delivery.extraRunConcededPerTeam(deliveriesListMap,matchesListMap);
                break;
            case 4:
                choicesMap =delivery.topEconomicalBowler2015(deliveriesListMap, matchesListMap);
                val=true;
                break;
            case 5:
                choiceMap=matches.winByRunIn2016(matchesListMap);
                break;
            default:
                System.out.println(ConstantsValues.WRONG_CHOICE);
        }
        if(!val)
        choiceMap.forEach((k,v)->System.out.printf("\n %-30s %d",k,v));
        else
            choicesMap.forEach((k,v)->System.out.printf("\n %-30s %.2f",k,v));
    }
}

//remove constants