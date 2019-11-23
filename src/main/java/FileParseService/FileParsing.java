package FileParseService;

import POJO.Delivery;
import POJO.Matches;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileParsing {
    private List<String[]> parseCsv(String filePath) {
        FileReader fileReader;
        CSVReader csvReader;
        List<String[]> dataRead = new ArrayList<>();
        try {
            fileReader = new FileReader(filePath);
            csvReader = new CSVReaderBuilder(fileReader).withSkipLines(0).build();
            dataRead = csvReader.readAll();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return dataRead;
    }
    public ArrayList<Matches> FileParsingMatches(String filename)
    {
       ArrayList<Matches> matchesList= new ArrayList<>();
        List<String[]> dataRead= parseCsv(filename);
        for (String[] row : dataRead) {
            Matches matchesObject= new Matches(row);
            matchesList.add(matchesObject);
        }
        return matchesList;
    }
    public ArrayList<Delivery> FileParsingDelivery(String filename)
    {
        List<String[]> dataRead = parseCsv(filename);
        ArrayList<Delivery> deliveryArrayList= new ArrayList<>();

        for (String[] row : dataRead) {

            Delivery deliveryObject= new Delivery(row);
            deliveryArrayList.add(deliveryObject);
        }
        return deliveryArrayList;
    }

}
