import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.util.List;

class DataProject {
    public static void main(String[] arg) {
        try {
            System.out.println("hey");
            String filename = "/root/Downloads/Compressed/matches.csv";
            FileReader fileReader = new FileReader(filename);
            CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
            List<String[]> Data= csvReader.readAll();
            for (String[] row : Data) {
                for (String cell : row) {
                    System.out.print(cell + "\t");
                }

               System.out.println();
            }

        } catch (Exception e) {
            System.out.println("File Read error" + " " + e.getMessage());
        }

    }
}