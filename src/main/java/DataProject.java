import POJO.Delivery;
import POJO.Matches;
import QuerySolver.*;
import FileParseService.*;
import java.util.ArrayList;

import static ConstantPackage.ConstantValues.*;

class DataProject
{
    public static void main(String[] args)
    {
       FileParsing fileParsing= new FileParsing();
        QuerySolver querySolve = new QuerySolver();
        ArrayList<Matches> objectMatch= fileParsing.FileParsingMatches(MATCHES_FILE);
        ArrayList<Delivery> objectDelivery = fileParsing.FileParsingDelivery(DELIVERIES_FILE);
        System.out.println(FIRST_QUERY);
        querySolve.matchPlayedPerYear(objectMatch).forEach((k,v)->System.out.printf("\n %-30s %s",k,v));
        System.out.println("\n\n");
        System.out.println(SECOND_QUERY);
        querySolve.matchWinIPL(objectMatch).forEach((k,v)->System.out.printf("\n %-30s %s",k,v));
        System.out.println("\n\n");
        System.out.println(THIRD_QUERY);
        querySolve.extraRunConcededPerTeam(objectDelivery,objectMatch).forEach((k,v)->System.out.printf("\n %-30s %s",k,v));
        System.out.println("\n\n");
        System.out.println(FOURTH_QUERY);
        querySolve.topEconomicalBowler2015(objectDelivery,objectMatch).forEach((k,v)->System.out.printf("\n %-30s %s",k,v));
        System.out.println("\n\n");
        System.out.println(FIFTH_QUERY);
        querySolve.winByRunIn2016(objectMatch).forEach((k,v)->System.out.printf("\n %-30s %s",k,v));
        }
    }

