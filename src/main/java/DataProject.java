import QuerySolver.*;
import FileParseService.*;
import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static ConstantPackage.ConstantValues.*;
class DataProject
{
    public static void main(String[] args){
       FileParse fileParse = new FileParse();
        Matches matches= new Matches();
        DeliveryMatches deliveryMatches = new DeliveryMatches();
        ArrayList<HashMap<String, String>> deliveriesListMap = null;
        ArrayList<HashMap<String, String>> matchesListMap =null;
        try {
            deliveriesListMap = fileParse.FileParsing(DELIVERIES_FILE);
            matchesListMap = fileParse.FileParsing(MATCHES_FILE);
        } catch (IOException | CsvException e) {
            System.out.println(FILE_ERROR);
            return;
        }
        Service[] solvedQuery = new Service[5];
        solvedQuery[0]= new Service(matches.matchPlayedPerYear(matchesListMap));
        solvedQuery[1]= new Service(matches.matchWinIPL(matchesListMap));
        solvedQuery[2]=new Service(deliveryMatches.extraRunConcededPerTeam(deliveriesListMap,matchesListMap));
        solvedQuery[3]= new Service(deliveryMatches.topEconomicalBowler2015(deliveriesListMap, matchesListMap));
        solvedQuery[4]= new Service(matches.winByRunIn2016(matchesListMap));
        System.out.println(TITLE);
        System.out.println("\n\n");
        System.out.println(FIRST_QUERY);
        solvedQuery[0].serviceSolver().forEach((k,v)->System.out.printf("\n %-30s %s",k,v));
        System.out.println("\n\n");
        System.out.println(SECOND_QUERY);
        solvedQuery[1].serviceSolver().forEach((k,v)->System.out.printf("\n %-30s %s",k,v));
        System.out.println("\n\n");
        System.out.println(THIRD_QUERY);
        solvedQuery[2].serviceSolver().forEach((k,v)->System.out.printf("\n %-30s %s",k,v));
        System.out.println("\n\n");
        System.out.println(FOURTH_QUERY);
        solvedQuery[3].serviceSolver().forEach((k,v)->System.out.printf("\n %-30s %s",k,v));
        System.out.println("\n\n");
        System.out.println(FIFTH_QUERY);
        solvedQuery[4].serviceSolver().forEach((k,v)->System.out.printf("\n %-30s %s",k,v));

    }
}
