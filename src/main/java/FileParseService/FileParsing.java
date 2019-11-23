package FileParseService;

import POJO.Delivery;
import POJO.Matches;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FileParsing {
    public ArrayList<Matches> FileParsingMatches(String filename) throws IOException, CsvException
    {
        FileReader fileReader = new FileReader(filename);
        CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(0).build();
        List<String[]> DataRead = csvReader.readAll();
        ArrayList<Matches> matchesList= new ArrayList<>();

        for (String[] row : DataRead) {

           ArrayList<String> rowsList= new ArrayList<>();
            for (String cell : row)
            {
               rowsList.add(cell);
            }
            Matches matchesObject= new Matches(rowsList);
            matchesList.add(matchesObject);
        }
        return matchesList;
    }
    public ArrayList<Delivery> FileParsingDelivery(String filename) throws IOException, CsvException
    {
        FileReader fileReader = new FileReader(filename);
        CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(0).build();
        List<String[]> DataRead = csvReader.readAll();
        ArrayList<Delivery> deliveryArrayList= new ArrayList<>();

        for (String[] row : DataRead) {

            ArrayList<String> rowsList= new ArrayList<>();
            for (String cell : row)
            {
                rowsList.add(cell);
            }
            Delivery deliveryObject= new Delivery(rowsList);
            deliveryArrayList.add(deliveryObject);
        }
        return deliveryArrayList;
    }

}
