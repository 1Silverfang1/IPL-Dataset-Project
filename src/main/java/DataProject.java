import POJO.Delivery;
import POJO.Matches;
import QuerySolver.*;
import FileParseService.*;
import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.util.ArrayList;

import static ConstantPackage.ConstantValues.*;

class DataProject
{
    public static void main(String[] args) throws IOException, CsvException {
       FileParsing fileParsing= new FileParsing();
        QuerySolver querySolve = new QuerySolver();
        ArrayList<Matches> objectMatches= fileParsing.FileParsingMatches(MATCHES_FILE);
        ArrayList<Delivery> objectDelivery = fileParsing.FileParsingDelivery(DELIVERIES_FILE);
        System.out.println(FIRST_QUERY);
        querySolve.matchPlayedPerYear(objectMatches).forEach((k,v)->System.out.printf("\n %-30s %s",k,v));
        System.out.println("\n\n");
        System.out.println(SECOND_QUERY);
        querySolve.matchWinIPL(objectMatches).forEach((k,v)->System.out.printf("\n %-30s %s",k,v));
        System.out.println("\n\n");
        System.out.println(THIRD_QUERY);
        querySolve.extraRunConcededPerTeam(objectDelivery,objectMatches).forEach((k,v)->System.out.printf("\n %-30s %s",k,v));
        System.out.println("\n\n");
        System.out.println(FOURTH_QUERY);
        querySolve.topEconomicalBowler2015(objectDelivery,objectMatches).forEach((k,v)->System.out.printf("\n %-30s %s",k,v));
        System.out.println("\n\n");
        System.out.println(FIFTH_QUERY);
        querySolve.winByRunIn2016(objectMatches).forEach((k,v)->System.out.printf("\n %-30s %s",k,v));
        }
    }

