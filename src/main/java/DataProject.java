import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.util.*;
class DataProject
{
    public static void main(String[] args){
        FileParse fileParse = new FileParse();
        Matches matches= new Matches();
        DeliveryMatches deliveryMatches = new DeliveryMatches();
        ArrayList<HashMap<String, String>> deliveriesListMap = null;
        ArrayList<HashMap<String, String>> matchesListMap =null;
        try {
            deliveriesListMap = fileParse.FileParsing(ConstantsValues.DELIVERIES_CSV);
            matchesListMap = fileParse.FileParsing(ConstantsValues.MATCHES_CSV);
        } catch (IOException | CsvException e) {
            System.out.println(ConstantsValues.FILE_ERROR);
            return;
        }
        Service Solvedquery[]= new Service[5];
        Solvedquery[0]= new Service(matches.matchPlayedPerYear(matchesListMap));
        Solvedquery[1]= new Service(matches.matchWinIPL(matchesListMap));
        Solvedquery[2]=new Service(deliveryMatches.extraRunConcededPerTeam(deliveriesListMap,matchesListMap));
        Solvedquery[3]= new Service(deliveryMatches.topEconomicalBowler2015(deliveriesListMap, matchesListMap));
        Solvedquery[4]= new Service(matches.winByRunIn2016(matchesListMap));
        System.out.println(ConstantsValues.TITLE);
        System.out.println("\n\n");
        System.out.println(ConstantsValues.FIRST_QUERY);
        Solvedquery[0].serviceSolver().forEach((k,v)->System.out.printf("\n %-30s %s",k,v));
        System.out.println("\n\n");
        System.out.println(ConstantsValues.SECOND_QUERY);
        Solvedquery[1].serviceSolver().forEach((k,v)->System.out.printf("\n %-30s %s",k,v));
        System.out.println("\n\n");
        System.out.println(ConstantsValues.THIRD_QUERY);
        Solvedquery[2].serviceSolver().forEach((k,v)->System.out.printf("\n %-30s %s",k,v));
        System.out.println("\n\n");
        System.out.println(ConstantsValues.FOURTH_QUERY);
        Solvedquery[3].serviceSolver().forEach((k,v)->System.out.printf("\n %-30s %s",k,v));
        System.out.println("\n\n");
        System.out.println(ConstantsValues.FIFTH_QUERY);
        Solvedquery[4].serviceSolver().forEach((k,v)->System.out.printf("\n %-30s %s",k,v));
    }
}
