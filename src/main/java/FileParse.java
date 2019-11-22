import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class FileParse
{
    ArrayList<HashMap<String, String>> FileParsing(String filename) throws IOException, CsvException {
        FileReader fileReader = new FileReader(filename);
        CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(0).build();
        List<String[]> DataRead = csvReader.readAll();
        ArrayList<HashMap<String, String>> parsedFileList = new ArrayList<>();
        String[] keys = DataRead.get(0);
        for (String[] row : DataRead) {
            int i = 0;
            HashMap<String, String> tempHashMap = new HashMap<>();
            for (String cell : row) {
                tempHashMap.put(keys[i++], cell);
            }
            parsedFileList.add(tempHashMap);

        }
        return parsedFileList;
    }
}